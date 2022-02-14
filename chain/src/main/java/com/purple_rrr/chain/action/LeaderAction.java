package com.purple_rrr.chain.action;

import com.purple_rrr.chain.domain.RequestModel;
import com.purple_rrr.chain.enums.RespStatusEnum;
import com.purple_rrr.chain.pipeline.BusinessProcess;
import com.purple_rrr.chain.pipeline.ProcessContext;
import com.purple_rrr.chain.pipeline.ProcessModel;
import com.purple_rrr.chain.vo.BasicResultVO;
import lombok.extern.slf4j.Slf4j;

/**
 * @author BugProvider
 * @date 2022/2/14
 * @apiNote 部门领导审批
 */
@Slf4j
public class LeaderAction implements BusinessProcess {

    @Override
    public void process(ProcessContext context) {
        RequestModel requestModel = (RequestModel) context.getProcessModel();

            if (requestModel.getReason().contains("病假")) {
                if (requestModel.getDays() < 3) {
                    log.info("--部门领导审批--结果:请假批准");
                    context.setNeedBreak(true).setResponse(BasicResultVO.success(RespStatusEnum.AGREE));
                }else {
                    log.info("--部门领导审批--结果:大于3天 请假批准 ");
                }
            }else {
                log.info("--部门领导审批--结果:不是病假不予批准");
                context.setNeedBreak(true).setResponse(BasicResultVO.fail(RespStatusEnum.NOT_SICK_LEAVE));
            }

    }
}
