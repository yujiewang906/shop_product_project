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


    /*
     * 路径：http://192.168.1.223:8080/api/attrValue/getData
     * 参数：currPage, page
     *
     * 返回值：data,code,message
     *请求方式：Get
     *
     * */
    @GetMapping("getData")
    public ResultData  getData(ShopParamsVo vo){

        Map data = shopAttributeValueService.getData(vo);

        return  ResultData.success(data);
    }

    /*
     * 路径：http://192.168.1.223:8080/api/attrValue/addAttributeValue
     * 参数：shopAttributeValue对象
     *
     * 返回值：data,code,message
     *请求方式：Post
     *
     * */
    @PostMapping("addAttributeValue")
    public  ResultData   addAttributeValue(ShopAttributeValue  value){

        shopAttributeValueService.addAttributeValue(value);

            return  ResultData.success(null);
    }
    /*
     * 路径：http://192.168.1.223:8080/api/attrValue/updateAttributeValue
     * 参数：shopAttributeValue对象
     *
     * 返回值：data,code,message
     *请求方式：Post
     *
     * */
    @PostMapping("updateAttributeValue")
    public  ResultData  updateAttributeValue(ShopAttributeValue  value){

        shopAttributeValueService.updateAttributeValue(value);

        return  ResultData.success(null);
    }

    /*
     * 路径：http://192.168.1.223:8080/api/attrValue/deleteAttributeValue
     * 参数：id 必传
     * 返回值：data,code,message
     *请求方式：Delete
     *
     * */
    @DeleteMapping("deleteAttributeValue")
    public ResultData  deleteAttributeValue(Integer id){

        shopAttributeValueService.deleteAttributeValue(id);
        return ResultData.success(null);
    }


    @GetMapping("queryDataByAid")
    public  ResultData  queryDataByAid(Integer aid){
        Map map = shopAttributeValueService.queryDataByAid(aid);
        return  ResultData.success(map);
    }

}
