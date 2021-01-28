package com.wangyj.api.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wangyj.api.dao.ShopAttrSkuDataDao;
import com.wangyj.api.dao.ShopDao;
import com.wangyj.api.model.po.ProductAttrData;
import com.wangyj.api.model.po.Shop;
import com.wangyj.api.model.po.ShopAttribute;
import com.wangyj.api.model.vo.ShopParamsVo;
import com.wangyj.api.service.ShopService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShopServiceImpl implements ShopService {

    @Resource
    private ShopDao shopDao;
    @Resource
    private ShopAttrSkuDataDao shopAttrSkuDataDao;

    @Override
    public Map getData(ShopParamsVo vo) {

        Map map = new HashMap();

        List<Shop> data = shopDao.getData(vo);
        map.put("data",data);

        Integer shopCount = shopDao.getShopCount(vo);
        map.put("count",shopCount);


        return map;
    }

    @Override
    @Transactional  //加上事务   什么是事务
    public void addShop(Shop shop,String attr,String sku) {
        //添加商品
        shopDao.addShop(shop);
        //声明属性数据对象
        List<ProductAttrData> arrlist = new ArrayList<>();
        //转换json字符串
        JSONArray objects = JSONObject.parseArray(attr);
        for (int i = 0; i <objects.size() ; i++) {
            //属性数据对象
            ProductAttrData productAttrData = new ProductAttrData();
            //与商品对应得id
            productAttrData.setId(shop.getId());
            productAttrData.setAttrData(objects.get(i).toString());
            //放入list集合
            arrlist.add(productAttrData);
        }
        //转换sku对象
        JSONArray skuObject = JSONObject.parseArray(sku);
        for (int i = 0; i < skuObject.size(); i++) {
            //具体json对象
            JSONObject skuJson = (JSONObject) skuObject.get(i);
            //构建属性数据对象
            ProductAttrData productAttrData = new ProductAttrData();
            //设置对应商品得id
            productAttrData.setId(shop.getId());
            productAttrData.setPrice(skuJson.getDouble("pricess"));
            productAttrData.setStorcks(skuJson.getInteger("storcks"));
            skuJson.remove("price");
            skuJson.remove("storck");
            productAttrData.setAttrData(skuObject.get(i).toString());

            arrlist.add(productAttrData);

        }
        shopAttrSkuDataDao.adds(arrlist);
    }

    @Override
    public void updateShop(Shop shop) {
        shopDao.updateShop(shop);
    }
}
