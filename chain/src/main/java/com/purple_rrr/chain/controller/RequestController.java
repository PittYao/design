package com.purple_rrr.chain.controller;

import com.purple_rrr.chain.domain.RequestModel;
import com.purple_rrr.chain.domain.SendRequest;
import com.purple_rrr.chain.domain.SendResponse;
import com.purple_rrr.chain.pipeline.ProcessContext;
import com.purple_rrr.chain.pipeline.ProcessController;
import com.purple_rrr.chain.vo.BasicResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author BugProvider
 * @date 2022/2/14
 * @apiNote
 */
@RestController
public class RequestController {

    @Autowired
    private ProcessController processController;

    /**
     * 发送消息接口
     * 入参完整示例：
     * ###
     * POST http://localhost:8080/send
     * Content-Type: application/json
     *
     * {
     * "code": "request",
     * "name": "fanyao",
     * "days": 8,
     * "reason": "病假"
     * }
     * @return
     */
    @PostMapping("/send")
    public SendResponse send(@RequestBody SendRequest sendRequest) {

        RequestModel requestModel = RequestModel.builder()
                .name(sendRequest.getName())
                .days(sendRequest.getDays())
                .reason(sendRequest.getReason())
                .build();

        ProcessContext context = ProcessContext.builder()
                .code(sendRequest.getCode())
                .processModel(requestModel)
                .needBreak(false)
                .response(BasicResultVO.success()).build();

        ProcessContext process = processController.process(context);

        return new SendResponse(process.getResponse().getStatus(), process.getResponse().getMsg());
    }
}
