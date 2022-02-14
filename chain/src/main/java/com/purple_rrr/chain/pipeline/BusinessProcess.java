package com.purple_rrr.chain.pipeline;

/**
 * 业务执行器
 */
public interface BusinessProcess {

    /**
     * 真正处理逻辑
     * @param context
     */
    void process(ProcessContext context);
}
