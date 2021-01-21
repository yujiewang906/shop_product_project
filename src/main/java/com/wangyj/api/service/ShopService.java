package com.wangyj.api.service;

import com.wangyj.api.model.po.Shop;
import com.wangyj.api.model.vo.ShopParamsVo;

import java.util.Map;

public interface ShopService {


  public   Map getData(ShopParamsVo vo);


  public   void addShop(Shop shop,String attr,String sku);

    public  void updateShop(Shop shop);
}
