package com.purple_rrr.chain.domain;

import com.purple_rrr.chain.pipeline.ProcessModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author BugProvider
 * @date 2022/2/14
 * @apiNote 请假模型
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestModel implements ProcessModel {
    /** 姓名  */
    private String name;
    /** 请假天数  */
    private Integer days;
    /** 请假理由  */
    private String reason;
}
