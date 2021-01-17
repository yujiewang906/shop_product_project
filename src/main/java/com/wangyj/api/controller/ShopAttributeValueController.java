package com.wangyj.api.controller;

import com.wangyj.api.model.po.ShopAttributeValue;
import com.wangyj.api.model.vo.ResultData;
import com.wangyj.api.model.vo.ShopParamsVo;
import com.wangyj.api.service.ShopAttributeValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("addAttributeValue")
    public  ResultData   addAttributeValue(ShopAttributeValue  value){

        shopAttributeValueService.addAttributeValue(value);

            return  ResultData.success(null);
    }

}
