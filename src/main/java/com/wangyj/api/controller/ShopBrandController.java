package com.wangyj.api.controller;

import com.wangyj.api.model.po.ShopBrand;
import com.wangyj.api.model.vo.ResultData;
import com.wangyj.api.model.vo.ShopParamsVo;
import com.wangyj.api.service.ShopBrandService;
import com.wangyj.api.utils.Oss_fileUpload_wangyj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("api/brand/")
@CrossOrigin
public class ShopBrandController {


    @Autowired
    private ShopBrandService  shopBrandService;

    /*
     * 路径：http://192.168.1.223:8080/api/brand/queryData
     * 参数：currPage, page
     *
     * 返回值：data,code,message
     *请求方式：Get
     *
     * */
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
    /*
     * 路径：http://192.168.1.223:8080/api/brand/addBrand
     * 参数：ShopBrand  对象
     *
     * 返回值：data,code,message
     *请求方式：Post
     *
     * */
    @PostMapping("addBrand")
    public  ResultData  addBrand(ShopBrand shopBrand){

        shopBrandService.addBrand(shopBrand);

        return ResultData.success(null);

    }
    /*
     * 路径：http://192.168.1.223:8080/api/brand/updateBrand
     * 参数：ShopBrand  对象
     *
     * 返回值：data,code,message
     *请求方式：Post
     *
     * */
    @PostMapping("updateBrand")
    public ResultData  updateBrand(ShopBrand shopBrand){

        shopBrandService.updateBrand(shopBrand);

        return  ResultData.success(null);
    }
    /*
     * 路径：http://192.168.1.223:8080/api/brand/deleteBrand
     * 参数：id  必传
     *
     * 返回值：data,code,message
     *请求方式：Delete
     *
     * */
    @DeleteMapping("deleteBrand")
    public  ResultData  deleteBrand(Integer id){

        shopBrandService.deleteBrand(id);

        return  ResultData.success(null);
    }
    /*
           * 路径   http://ip:port/api/brand/uploadFile

           参数  file

           返回值  ：1、 输入流  2、 文件名

           * */
    @RequestMapping("uploadFile")
    public ResultData uploadFile(MultipartFile file) throws IOException {
        //处理新名称
        String originalFilename = file.getOriginalFilename();
        //防止中文引起的错误
        String newName= UUID.randomUUID().toString()+originalFilename.substring(originalFilename.lastIndexOf("."));
        //存储路径
        newName="imgs/"+newName;
        return ResultData.success(Oss_fileUpload_wangyj.uploadFile(file.getInputStream(),newName));
    }

}
