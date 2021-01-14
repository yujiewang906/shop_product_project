package com.wangyj.api.controller;

import com.wangyj.api.model.po.ShopBrand;
import com.wangyj.api.model.vo.ResultData;
import com.wangyj.api.model.vo.ShopParamsVo;
import com.wangyj.api.service.ShopBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/brand/")
@CrossOrigin
public class ShopBrandController {


    @Autowired
    private ShopBrandService  shopBrandService;


    @GetMapping("queryData")
    public ResultData  queryData(ShopParamsVo vo){
        if (vo.getCurrPage()==null){
            ResultData.error(500,"非正常错误");
        }
        if (vo.getPage()==null){
            ResultData.error(500,"非正常错误");
        }
        Map map = shopBrandService.queryData(vo);

        return  ResultData.success(map);
    }

    @PostMapping("addBrand")
    public  ResultData  addBrand(ShopBrand shopBrand){

        shopBrandService.addBrand(shopBrand);

        return ResultData.success(null);

    }

    @PostMapping("updateBrand")
    public ResultData  updateBrand(ShopBrand shopBrand){

        shopBrandService.updateBrand(shopBrand);

        return  ResultData.success(null);
    }

    @DeleteMapping("deleteBrand")
    public  ResultData  deleteBrand(Integer id){

        shopBrandService.deleteBrand(id);

        return  ResultData.success(null);
    }

}
