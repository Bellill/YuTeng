package com.harvest.oms.web.controller.order;

import com.harvest.core.path.HarvestOmsPath;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Alodi
 * @Date: 2022/12/9 9:51 PM
 * @Description: 订单发货服务
 **/
@Api(value = "订单发货服务", tags = "订单发货服务")
@RestController
@RequestMapping(value = HarvestOmsPath.OrderPath.ORDER_DELIVERY_PATH)
public class OrderDeliveryController {


}
