package com.harvest.basic.client.logistics;

import com.harvest.basic.client.constants.HarvestBasicApplications;
import com.harvest.core.annotation.feign.HarvestClient;
import com.harvest.core.constants.GlobalMacroDefinition;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Author: Alodi
 * @Date: 2023/2/3 2:51 PM
 * @Description: TODO
 **/
@HarvestClient(name = HarvestBasicApplications.SERVICE_NAME, path = HarvestBasicApplications.Path.LOGISTICS)
public interface BasicLogisticsClient extends GlobalMacroDefinition {

    @ApiOperation("申报提交")
    @PostMapping("/submitDeclaration")
    void submitDeclaration(long companyId);

}