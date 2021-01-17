package com.wangyj.api.controller;

import com.wangyj.api.model.vo.ResultData;
import com.wangyj.api.model.vo.ShopParamsVo;
import com.wangyj.api.service.ShopAttributeValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("api/attrValue")
@CrossOrigin
public class ShopAttributeValueController {

    @Autowired
    private ShopAttributeValueService shopAttributeValueService;

    @GetMapping("getData")
    public ResultData  getData(ShopParamsVo vo){

        Map data = shopAttributeValueService.getData(vo);

        return  ResultData.success(data);
    }

}
