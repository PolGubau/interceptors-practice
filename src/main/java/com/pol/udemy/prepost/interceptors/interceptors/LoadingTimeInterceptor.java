package com.pol.udemy.prepost.interceptors.interceptors;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("timeInterceptor")
public class LoadingTimeInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(LoadingTimeInterceptor.class);

    @SuppressWarnings("null")
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        HandlerMethod controller = ((HandlerMethod) handler);

        logger.info(
                "PRE:" + controller.getMethod().getName() + " -> Request URL: " + request.getRequestURL().toString());

        long startTime = System.currentTimeMillis();

        request.setAttribute("startTime", startTime);

        return true;

    }

    @Override
    @SuppressWarnings("null")
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        HandlerMethod controller = ((HandlerMethod) handler);

        long startTime = (Long) request.getAttribute("startTime");

        long endTime = System.currentTimeMillis();

        long loadingTime = endTime - startTime;

        logger.info(
                "POST:" + controller.getMethod().getName() + " -> URL: " + request.getRequestURL().toString()
                        + " -> Loading Time: " + loadingTime + " ms");

    }

}
