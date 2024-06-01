package com.example.Middleware_Es2.Interceptors;

import com.example.Middleware_Es2.Entities.Month;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class MonthInterceptor implements HandlerInterceptor {

    public static List<Month> months = new ArrayList<>(Arrays.asList(
        new Month(1,"January","Gennaio","Januar"),
        new Month(2,"February","Febbraio","Februar"),
        new Month(3,"March","Marzo","Marsch"),
        new Month(4,"April","Aprile","April"),
        new Month(5,"May","Maggio","Mai"),
        new Month(6,"June","Giugno","Juni")
    ));

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String month = request.getHeader("monthNumber");
        System.out.println(month);
        if(month.isEmpty() || month == null){
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid monthNumber header");
            return false;
        }
        int monthInt = Integer.parseInt(month);

        Month foundMonth = months.stream()
                .filter(m -> m.getMonthNumber() == monthInt).findFirst()
                .orElse(new Month(0,"nope","nope","nope"));

        request.setAttribute("foundMonth", foundMonth);
        response.setStatus(HttpServletResponse.SC_OK);
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }
}
