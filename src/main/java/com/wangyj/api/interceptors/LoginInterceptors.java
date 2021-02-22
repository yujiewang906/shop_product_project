package com.wangyj.api.interceptors;

import com.alibaba.fastjson.JSONObject;
import com.wangyj.api.utils.JWT;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LoginInterceptors implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {

        //获取传来的token
        String token = request.getParameter("token");
        //判断请求有没有带token认证信息
        if (token==null){
            Map rs = new HashMap();
            rs.put("code",400);
            rs.put("data","缺少认证信息");
            //转换成json字符串
            response.getWriter().write(JSONObject.toJSONString(rs));
            return false;
        }
        Map unsign = JWT.unsign(token, Map.class);
        if (unsign==null){
            Map rs = new HashMap();
            rs.put("code",500);
            rs.put("data","error");
            //响应请求  转换json串返回
            response.getWriter().write(JSONObject.toJSONString(rs));
            return false;
        }


        return true;
    }
}
