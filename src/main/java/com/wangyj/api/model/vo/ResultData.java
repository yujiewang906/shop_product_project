package com.wangyj.api.model.vo;


//统一规范接口返回值
public class ResultData {

    private  Integer  code;

    private  String   message;

    private  Object   data;


    /*将构造方法私有化  为了安全*/
    private  ResultData(){

    }
    /*提供一个公共的访问  成功*/
    public  static   ResultData  success(Object  data){

        ResultData rd = new ResultData();
        rd.setCode(200);
        rd.setData(data);
        rd.setMessage("success");

        return  rd;
    }

    /*提供一个公共的访问  失败  直接调用*/
    public  static  ResultData  error(Integer code,String message){

        ResultData rd = new ResultData();

        rd.setMessage(message);
        rd.setCode(code);

        return  rd;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
