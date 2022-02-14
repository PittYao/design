package com.purple_rrr.chain.action;

import com.purple_rrr.chain.domain.RequestModel;
import com.purple_rrr.chain.enums.RespStatusEnum;
import com.purple_rrr.chain.pipeline.BusinessProcess;
import com.purple_rrr.chain.pipeline.ProcessContext;
import com.purple_rrr.chain.vo.BasicResultVO;
import lombok.extern.slf4j.Slf4j;

/**
 * @author BugProvider
 * @date 2022/2/14
 * @apiNote 总经理审批
 */
@Slf4j
public class BossAction implements BusinessProcess {

    @Override
    public void process(ProcessContext context) {
        RequestModel requestModel = (RequestModel) context.getProcessModel();

        if (requestModel.getDays() > 7) {
            log.info("--总经理审批--结果:请假超过7天不予批准");
            context.setNeedBreak(true).setResponse(BasicResultVO.fail(RespStatusEnum.DAY_TOO_LONG));
        }else {
            log.info("--总经理审批--结果:请假批准");
            context.setResponse(BasicResultVO.success(RespStatusEnum.AGREE));
        }
    }
}
