package com.purple_rrr.chain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public enum BusinessCode {

    /** 请假流程 */
    REQUEST("request", "普通发送"),

    ;


    /** code 关联着责任链的模板 */
    private String code;

    /** 类型说明 */
    private String description;


}
