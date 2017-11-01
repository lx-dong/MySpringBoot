package com.china317.myspringboot.web.controller.advice;

import com.china317.myspringboot.web.controller.TestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lx-dong on 2017/11/1.
 */
@ControllerAdvice(basePackageClasses = TestController.class)

public class ExceptionAdvice extends ResponseEntityExceptionHandler{

    @ExceptionHandler(Exception.class)
    @ResponseBody
    ResponseEntity<?> handleControllerException(HttpServletRequest request, Throwable ex){
        HttpStatus status = getStatus(request);
        Map<String, Object> body = new HashMap<String, Object>();
        body.put("url", request.getRequestURL());
        body.put("status", status.value());
        body.put("msg", ex.getMessage());
        System.out.println("@ExceptionHandler --body=" + body);
        return new ResponseEntity<>(body, status);
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }

    @ModelAttribute
    public void addAttribute(Model model){
        model.addAttribute("attAdd","from @ModelAttribute");
        System.out.println("@ModelAttribute --model=" + model);
    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
        Map<String, Object> model = binder.getBindingResult().getModel();
        System.out.println("@initBinder --model=" + model);

    }
}
