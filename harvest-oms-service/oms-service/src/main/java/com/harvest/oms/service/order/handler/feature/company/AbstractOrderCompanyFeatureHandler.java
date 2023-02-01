package com.harvest.oms.service.order.handler.feature.company;

import com.google.common.collect.Sets;
import com.harvest.oms.domain.order.OrderInfoDO;
import com.harvest.oms.service.order.handler.OrderCompanyFeatureHandler;

import java.util.Collection;
import java.util.Set;

/**
 * @Author: Alodi
 * @Date: 2023/1/28 5:54 PM
 * @Description: TODO
 **/
public abstract class AbstractOrderCompanyFeatureHandler implements OrderCompanyFeatureHandler {

    /**
     * 重点公司特性处理
     */
    protected final static Set<Long> MAIN_COMPANY_SET = Sets.newHashSet(1L, 2L);

    @Override
    public void batchFeatureFill(Long companyId, Collection<OrderInfoDO> orders) {

    }
}