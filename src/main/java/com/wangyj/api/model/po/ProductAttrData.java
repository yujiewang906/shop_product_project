package com.wangyj.api.model.po;

public class ProductAttrData {

    private Integer id;

    private Integer proId;

    private String attrData;

    private Integer storcks;

    private Double price;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public String getAttrData() {
        return attrData;
    }

    public void setAttrData(String attrData) {
        this.attrData = attrData;
    }

    public Integer getStorcks() {
        return storcks;
    }

    public void setStorcks(Integer storcks) {
        this.storcks = storcks;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
