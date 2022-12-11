package com.harvest.oms.repository.service;

import com.harvest.oms.repository.domain.order.OrderInfoDO;
import com.harvest.oms.repository.entity.FarmlandOmsOrderEntity;
import com.harvest.oms.repository.mapper.FarmlandOmsOrderMapper;
import com.harvest.oms.repository.service.order.OrderReadRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Alodi
 * @Date: 2022/12/11 8:03 PM
 * @Description: TODO
 **/
@Service
public class OrderReadRepositoryServiceImpl implements OrderReadRepositoryService {

    @Autowired
    private FarmlandOmsOrderMapper farmlandOmsOrderMapper;

    @Override
    public OrderInfoDO getOrderInfo(Long orderId) {
        FarmlandOmsOrderEntity farmlandOmsOrderEntity = farmlandOmsOrderMapper.selectById(orderId);
        OrderInfoDO orderInfoDO = new OrderInfoDO();
        orderInfoDO.setOrderId(farmlandOmsOrderEntity.getId());
        orderInfoDO.setOrderNo(farmlandOmsOrderEntity.getOrderNo());
        orderInfoDO.setOrderSource(farmlandOmsOrderEntity.getOrderSource());
        return orderInfoDO;
    }
}
