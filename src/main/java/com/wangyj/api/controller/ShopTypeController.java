package com.wangyj.api.controller;

import com.wangyj.api.model.po.ShopType;
import com.wangyj.api.model.vo.ResultData;
import com.wangyj.api.service.ShopTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/type/")
@CrossOrigin
public class ShopTypeController {

    @Autowired
    private ShopTypeService  shopTypeService;

    /*
    * 路径   http://ip:port/api/type/getData

    get请求

    参数

    返回值   {"code":200,"message":"提示",data:[{*}]}

    * */
    @GetMapping("getData")
    public ResultData   getDate(){

        Map shopData = shopTypeService.getData();

        return ResultData.success(shopData);
    }
    /*
    *  路径   http://ip:port/api/type/getDataByPid

    get请求

    参数    Pid

    返回值   {"code":200,"message":"提示",data:[{*}]}
    * */
    @GetMapping("getDataByPid")
    public  ResultData  getDataByPid(Integer pid){

        if (pid == null){
            ResultData.error(500,"不能为空");
        }

        Map dataByPid = shopTypeService.getDataByPid(pid);

        return  ResultData.success(dataByPid);
    }

    /*路径   http://ip:port/api/type/add

   post请求

   参数    pid    name

    返回值    {code:"",message:"",data:新增的id}*/
    @PostMapping("add")
    public  ResultData  add(ShopType shopType){

        shopTypeService.add(shopType);

                                //返回新增时在数据库自增的id
        return  ResultData.success(shopType.getId());
    }


    /*
    * 路径   http://ip:port/api/type/update

        post请求

    参数   id （必传）     pid   name  isDel

    返回值     {code:"",message:""}

    * */
    @PostMapping("update")
    public  ResultData  update(ShopType shopType){
 /*       if (shopType.getId()==null){
            return ResultData.error(500,"id为空");
        }*/
        shopTypeService.update(shopType);
        return  ResultData.success(null);
    }



}
