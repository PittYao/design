package com.purple_rrr.chain.config;

import com.purple_rrr.chain.action.BossAction;
import com.purple_rrr.chain.action.LeaderAction;
import com.purple_rrr.chain.enums.BusinessCode;
import com.purple_rrr.chain.pipeline.BusinessProcess;
import com.purple_rrr.chain.pipeline.ProcessController;
import com.purple_rrr.chain.pipeline.ProcessTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * api层的pipeline配置类
 */
@Configuration
public class PipelineConfig {


    /**
     * 请假流程
     * 1. 部门领导审批
     * 2. 总经理审批
     * @return
     */
    @Bean("commonSendTemplate")
    public ProcessTemplate commonSendTemplate() {
        ProcessTemplate processTemplate = new ProcessTemplate();
        ArrayList<BusinessProcess> processList = new ArrayList<>();

        processList.add(leaderAction());
        processList.add(bossAction());

        processTemplate.setProcessList(processList);
        return processTemplate;
    }

    /**
     * pipeline流程控制器
     * 请假流程
     *
     * @return
     */
    @Bean
    public ProcessController processController() {
        ProcessController processController = new ProcessController();
        Map<String, ProcessTemplate> templateConfig = new HashMap<>(4);
        templateConfig.put(BusinessCode.REQUEST.getCode(), commonSendTemplate());
        processController.setTemplateConfig(templateConfig);
        return processController;
    }


    /**
     * 部门领导审批 Action
     *
     * @return
     */
    @Bean
    public LeaderAction leaderAction() {
        return new LeaderAction();
    }

    /**
     * 总经理审批 Action
     *
     * @return
     */
    @Bean
    public BossAction bossAction() {
        return new BossAction();
    }


}
