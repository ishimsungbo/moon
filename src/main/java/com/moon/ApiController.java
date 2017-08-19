package com.moon;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Moon Entry Controller")
@RestController
public class ApiController {

    @Value("${appname}")
    String appName;

    private Logger logger = Logger.getLogger(getClass());

    @ApiOperation(value = "API Test Method",notes = "Boot API Test")
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String api(){
        return appName;
    }

}
