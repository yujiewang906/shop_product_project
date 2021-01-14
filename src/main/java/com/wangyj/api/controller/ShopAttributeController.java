package com.wangyj.api.controller;


import com.wangyj.api.model.vo.ResultData;
import com.wangyj.api.model.vo.ShopParamsVo;
import com.wangyj.api.service.ShopAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping("api/attribute")
@CrossOrigin
public class ShopAttributeController {

    @Autowired
    private ShopAttributeService shopAttributeService;

    @GetMapping("getData")
    public ResultData  getData(ShopParamsVo vo){
        if (vo.getCurrPage()==null){
            return ResultData.error(500,"非法请求");
        }
        if (vo.getPage()==null){
            return ResultData.error(500,"非法请求");
        }

        Map data = shopAttributeService.getData(vo);

        return ResultData.success(data);
    }




}

