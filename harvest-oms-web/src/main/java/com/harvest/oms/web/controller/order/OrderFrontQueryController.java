package com.harvest.oms.web.controller.order;

import com.harvest.core.constants.GlobalMacroDefinition;
import com.harvest.core.domain.Page;
import com.harvest.core.domain.ResponseResult;
import com.harvest.core.path.HarvestOmsPath;
import com.harvest.oms.client.order.OrderFrontQueryClient;
import com.harvest.oms.repository.query.order.PageOrderConditionQuery;
import com.harvest.oms.vo.order.OrderInfoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Alodi
 * @Date: 2022/12/9 9:51 PM
 * @Description: 订单前端调用服务
 **/
@Api(value = "订前端查询", tags = "订单前端查询")
@RestController
@RequestMapping(value = HarvestOmsPath.OrderPath.ORDER_FRONT_PATH)
public class OrderFrontQueryController implements GlobalMacroDefinition {

    @Autowired
    private OrderFrontQueryClient orderFrontQueryClient;

    @ApiOperation("分页查询")
    @PostMapping(value = "/page/query")
    public ResponseResult<Page<OrderInfoVO>> frontPageQueryOrder(@RequestBody PageOrderConditionQuery condition) {
        Page<OrderInfoVO> page = orderFrontQueryClient.frontPageQueryOrder(8510380986999420205L, condition);
        return ResponseResult.success(page);
    }

}