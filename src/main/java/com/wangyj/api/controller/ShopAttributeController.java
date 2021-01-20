package com.wangyj.api.controller;


import com.wangyj.api.model.po.ShopAttribute;
import com.wangyj.api.model.vo.ResultData;
import com.wangyj.api.model.vo.ShopParamsVo;
import com.wangyj.api.service.ShopAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    /*
    * 路径：http://192.168.1.223:8080/api/attribute/addAttribute
    * 参数：name,color,nameCH,typeId,type,isSKU,isDel,author
    *
    * 返回值：data,code,message
    *请求方式：post
    *
    * */

    @PostMapping("addAttribute")
    public  ResultData  addAttribute(ShopAttribute shopAttribute){

        shopAttributeService.addAttribute(shopAttribute);

        return ResultData.success(null);
    }


    /*
     * 路径：http://192.168.1.223:8080/api/attribute/updateAttribute
     * 参数：id:必传  name,color,nameCH,typeId,type,isSKU,isDel,author
     *
     *返回值：data,code,message
     *请求方式：post
     *
     * */
    @PostMapping("updateAttribute")
    public ResultData  updateAttribute(ShopAttribute shopAttribute){

        if (shopAttribute.getId()==null){
            return ResultData.error(500,"没有依赖id");
        }
        shopAttributeService.updateAttribute(shopAttribute);

        return  ResultData.success(null);
    }

    /*
     * 路径：http://192.168.1.223:8080/api/attribute/deleteAttribute
     * 参数：id:必传
     *  逻辑删除  isDel=1为不展示
     *返回值：data,code,message
     *请求方式：delete
     *
     * */
    @DeleteMapping("deleteAttribute")
    public ResultData  deleteAttribute(Integer id){

        shopAttributeService.deleteAttribute(id);

        return ResultData.success(null);
    }

    @GetMapping("getDataByTypeId")
    public  ResultData  getDataByTypeId(Integer pid){

        Map dataByPid = shopAttributeService.getDataByPid(pid);

        return ResultData.success(dataByPid);
    }

}

