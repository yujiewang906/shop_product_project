package com.wangyj.api.model.vo;



public class ShopParamsVo {

    private  Integer  id;

    private  Integer  currPage;//每页显示数量

    private  Integer  page;//当前页


    private  String    name;  //品牌名


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCurrPage() {
        return currPage;
    }

    public void setCurrPage(Integer currPage) {
        this.currPage = currPage;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
