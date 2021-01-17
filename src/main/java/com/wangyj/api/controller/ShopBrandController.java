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
