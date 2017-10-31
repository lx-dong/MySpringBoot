package com.china317.myspringboot.controller;

import org.springframework.boot.autoconfigure.web.BasicErrorController;
import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by lx-dong on 2017/10/31.
 */
@Controller
@RequestMapping("${server.error.path:${error.path:/error}}")
public class MyErrorController extends BasicErrorController{
    public MyErrorController(){
        super(new DefaultErrorAttributes(),new ErrorProperties());
    }
    public MyErrorController(ErrorAttributes errorAttributes, ErrorProperties errorProperties){
        super(errorAttributes, errorProperties);
    }

    @RequestMapping(produces = com.china317.myspringboot.util.MediaType.JSON_UTF_8)
    public ModelAndView errorHtml(HttpServletRequest request,
                                  HttpServletResponse response) {
        response.setStatus(getStatus(request).value());
        Map<String, Object> model = getErrorAttributes(request,
                isIncludeStackTrace(request, MediaType.TEXT_HTML));
        return new ModelAndView("error", model);
    }
}
