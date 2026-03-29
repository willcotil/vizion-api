package com.cognis.buildup_api.infra.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoggingInterceptor implements HandlerInterceptor {

    private static final String START_TIME = "startTime";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        request.setAttribute(START_TIME, System.currentTimeMillis());
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        long start = (long) request.getAttribute(START_TIME);
        long duration = System.currentTimeMillis() - start;

        System.out.println(
                "[HTTP] " + request.getMethod() +
                        " " + request.getRequestURI() +
                        " - " + duration + "ms"
        );
    }
}