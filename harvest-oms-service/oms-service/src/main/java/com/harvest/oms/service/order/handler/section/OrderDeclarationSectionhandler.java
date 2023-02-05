package com.harvest.oms.service.order.handler.section;

import com.harvest.oms.domain.order.OrderInfoDO;
import com.harvest.oms.service.order.handler.OrderSectionHandler;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;

/**
 * @Author: Alodi
 * @Date: 2023/2/6 12:30 AM
 * @Description: TODO
 **/
@Order(OrderSectionHandler.Order.ORDER_LOGISTICS)
@Component
public class OrderDeclarationSectionhandler implements OrderSectionHandler {

    @Override
    public void fill(Long companyId, OrderInfoDO order) {
        this.batchFill(companyId, Collections.singleton(order));
    }

    @Override
    public void batchFill(Long companyId, Collection<OrderInfoDO> orders) {

    }
}
