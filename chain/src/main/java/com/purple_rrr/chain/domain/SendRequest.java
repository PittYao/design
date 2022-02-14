package com.purple_rrr.chain.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 发送接口的参数
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SendRequest {

    /**
     * 执行业务类型(请假流程=request)
     */
    private String code;
    /**
     * 请假人姓名
     */
    private String name;
    /**
     * 请假天数
     */
    private Integer days;
    /**
     * 请假理由
     */
    private String reason;


}
