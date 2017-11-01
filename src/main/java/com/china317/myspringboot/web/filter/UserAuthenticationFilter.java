package com.china317.myspringboot.web.filter;

import com.china317.myspringboot.entity.User;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Created by lx-dong on 2017/11/1.
 */
public class UserAuthenticationFilter extends AccessControlFilter {

    private Logger log = LoggerFactory.getLogger(UserAuthenticationFilter.class);

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        HttpServletRequest req = (HttpServletRequest) request;
        if ("OPTIONS".equals(req.getMethod().toUpperCase())) {        //ajax跨域请求，直接通过
            return true;
        }
        String session = req.getHeader("session");
        String source = req.getHeader("source");
        if(StringUtils.isNotEmpty(session) && isAccess(session,source)){          //判断header中session是否有效
            return true;
        }else{
            return onCheckSessionFailed(response);
        }
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        return false;
    }

    /**
     * 请求失败后执行
     * @param response
     * @return
     * @throws Exception
     */
    protected boolean onCheckSessionFailed(ServletResponse response) throws Exception {
        HttpServletResponse resp = (HttpServletResponse) response;
        resp.setHeader("Pragma", "No-cache");
        resp.setHeader("Cache-Control", "no-cache");
        resp.setDateHeader("Expires", 0);
        response.setContentType("application/json; charset=utf-8");
        try {
            response.getWriter().write("{\"status\":\"ok\", \"result\":{\"result_status\":\"login_expired\"}}");
            response.getWriter().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    protected boolean isAccess(String token,String source){
        User user =  new User();//userCache.getuser(token);
        if(source!=null&&source.equals("app")){
            if (user != null
                    && user.getAccessTokenExpireTime()!=null
                    && user.getAccessTokenExpireTime().after(new Date())){     //用户存在，且token没有超过过期时间
                return true;
            }
        }else {
            if (user != null
                    && user.getAccessTokenExpireTime()!=null
                    && user.getAccessTokenExpireTime().after(new Date())){     //用户存在，且token没有超过过期时间
                return true;
            }
        }

        return false;
    }
}
