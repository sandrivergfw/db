package com.example.demo.utils;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Component  /*和@Controller 等的作用一致，当类不属于各种归类的时候使用Component进行注入*/
public class TokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler)throws  Exception{
        /**
         * 使用HttpServletRequest获取客户端的请求参数
         */
        if (request.getMethod().equals("OPTIONS")){
            /**
             * 关于options请求方式: 一般这种请求方法的主要用途是
             * 1. 获取服务器支持的HTTP请求方法
             * 2. 检查服务器性能
             * 如果实际中没有用到OPTIONS类型的请求就可以略过此判断
             */
            response.setStatus(HttpServletResponse.SC_OK); //status=200
            return true;
        }
        response.setCharacterEncoding("utf-8");
        System.out.println(request.getHeader("token"));
        String token = request.getHeader("token"); //获取单个请求头name对应的value值，即获取token的字符串
        if(token!=null){
            boolean result = TokenUtil.verify(token);
            if(result){
                System.out.println("通过拦截器");
                return true;
            }
        }
        response.setCharacterEncoding("UTF-8");//为啥要设那么多
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = null;
        //以json格式返回失败信息
        try {
            JSONObject json = new JSONObject();
            json.put("success","false");
            json.put("msg","认证失败，未通过拦截器");
            json.put("code","50000"); //自定义的失败码？）
            response.getWriter().append(json.toJSONString());//将json数据添加到response中返回给前端
            System.out.println("认证失败，未通过拦截器");
        }catch (Exception e){
            e.printStackTrace();
            response.sendError(500);
            return false;
        }
        return false;


    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
