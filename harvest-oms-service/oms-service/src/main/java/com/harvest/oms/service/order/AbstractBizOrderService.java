package com.harvest.oms.service.order;

import com.harvest.core.batch.BatchExecuteResult;
import com.harvest.core.batch.BatchId;
import com.harvest.core.utils.ActuatorUtils;
import com.harvest.oms.client.order.OrderReadClient;
import com.harvest.oms.domain.order.OrderInfoDO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * @Author: Alodi
 * @Date: 2023/2/9 2:34 PM
 * @Description: TODO
 **/
public abstract class AbstractBizOrderService {

    @Autowired
    protected OrderReadClient orderReadClient;

    /**
     * 订单加锁异步批量处理器
     *
     * @param companyId 公司ID
     * @param orderIds  订单Id集合
     * @param consumer  处理器
     * @return 处理结果
     */
    protected BatchExecuteResult<String> SyncOrderParallelFailAllowBatchExecute(Long companyId, Collection<Long> orderIds, Consumer<OrderInfoDO> consumer) {
        Map<Long, String> orderMap = new ConcurrentHashMap<>(2);
        return ActuatorUtils.parallelFailAllowBatchExecute(orderIds.stream().map(orderId -> {
            BatchId batchId = new BatchId();
            batchId.setId(orderId);
            return batchId;
        }).collect(Collectors.toList()), batchResultId -> {
            OrderInfoDO order = orderReadClient.get(companyId, batchResultId.getId());
            orderMap.put(batchResultId.getId(), order.getOrderNo());
            consumer.accept(order);
        }, batchResultId -> orderMap.get(batchResultId.getId()));
    }

}
