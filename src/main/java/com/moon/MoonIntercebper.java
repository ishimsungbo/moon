package com.moon;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class MoonIntercebper implements HandlerInterceptor {

    private Logger logger = Logger.getLogger(getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        logger.info("=====[MOON API PRE HANDLE]=====");

        /* Get으로 넘길시
        logger.info("1."+request.getParameter("name"));
        if(request.getParameter("name").equals("심성보")) {
            logger.info("인터셉터에 걸렸습니다.");

            response.sendRedirect("/");
            return false;
        }
        */

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("=====[MOON API POST HANDLE]=====");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info("=====[MOON API COMPLETION]=====");
    }
}
