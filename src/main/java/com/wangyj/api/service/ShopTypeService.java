package com.wangyj.api.service;


import com.wangyj.api.model.po.ShopType;

import java.util.Map;

public interface ShopTypeService {


    public void add(ShopType shopType);

    public  Map  getData();


    public Map getDataByPid(Integer pid);

    void update(ShopType shopType);


}
