package com.purple_rrr.chain.pipeline;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

/**
 * @author BugProvider
 * @date 2022/2/14
 * @apiNote 业务执行链
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProcessTemplate {
    private List<BusinessProcess> processList;

    // 动态添加流程
    public void addProcess(BusinessProcess businessProcess) {
        processList.add(businessProcess);
    }
}
