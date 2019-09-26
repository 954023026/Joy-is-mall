package com.leshang.order.interceptors;

import com.leshang.common.pojo.UserInfo;
import com.leshang.common.utils.CookieUtils;
import com.leshang.common.utils.JwtUtils;
import com.leshang.order.config.JwtProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 描述:
 *
 * @author 愿你活的通透拎得清轻重辩得明是非
 * @create 2019-09-18 15:36
 */
@Slf4j
public class UserInterceptor implements HandlerInterceptor {

    private JwtProperties prop;

    private static final ThreadLocal<UserInfo> tl = new ThreadLocal<>();

    public UserInterceptor(JwtProperties prop) {
        this.prop = prop;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取cookie
        try {

            String token = CookieUtils.getCookieValue(request, prop.getCookieName());
            //解析token
            UserInfo user = JwtUtils.getInfoFromToken(token, prop.getPublicKey());
            //传递user
           tl.set(user);

            //放行
            return true;
        } catch (Exception e) {
            log.error("[购物车服务] 解析用户身份失败",e);
            return false;
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //用完数据，进行清空
        tl.remove();
    }

    public static UserInfo getUser(){
        return tl.get();
    }
}
