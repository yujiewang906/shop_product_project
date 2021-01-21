package com.wangyj.api.controller;


import com.wangyj.api.model.po.Shop;
import com.wangyj.api.model.vo.ResultData;
import com.wangyj.api.model.vo.ShopParamsVo;
import com.wangyj.api.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/shop")
@CrossOrigin
public class ShopController {

    @Autowired
    private ShopService shopService;

    /*
    * 路径   http://ip:port/api/shop/getData

    get请求

    参数  currPage  page

    返回值   {"code": 200,"message": "success","data": {"data": [],"count":""}}

    * */
    @GetMapping("getData")
    public ResultData  getData(ShopParamsVo vo){

        if (vo.getCurrPage() == null){
            return ResultData.error(500,"非法请求");
        }
        if (vo.getPage() == null){
            return ResultData.error(500,"非法请求");
        }

        Map data = shopService.getData(vo);

        return  ResultData.success(data);
    }

    /*
       * 路径   http://ip:port/api/shop/addShop

       post请求

       参数  Shop对象

       返回值   {"code": 200,"message": "success","data": {}}

       * */
    @PostMapping("addShop")
    public  ResultData  addShop(Shop shop,String attr,String sku){

        shopService.addShop(shop,attr,sku);

        return  ResultData.success("新增成功");
    }
    /*
           * 路径   http://ip:port/api/shop/updateShop

           post请求

           参数  Shop对象

           返回值   {"code": 200,"message": "success","data": {}}

           * */
    @PostMapping("updateShop")
    public  ResultData  updateShop(Shop shop){

        shopService.updateShop(shop);

        return  ResultData.success("修改成功");
    }




}
