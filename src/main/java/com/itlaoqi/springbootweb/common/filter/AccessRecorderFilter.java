package com.itlaoqi.springbootweb.common.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;

/**
 * @Author Kent Lee
 * 2018/8/7
 */

public class AccessRecorderFilter implements Filter {
    private Logger logger = LoggerFactory.getLogger(AccessRecorderFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        String uri = request.getRequestURI();
        if (uri.endsWith(".css") || uri.endsWith(".js") || uri.endsWith(".woff") || uri.endsWith(".ico") || uri.endsWith(".map") || uri.endsWith(".jpg") || uri.endsWith(".png")){
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        String ua = request.getHeader("user-agent");
        String ip = request.getRemoteAddr();

        Long st = System.currentTimeMillis();
        // 请求后向后发送到controller进行处理
        filterChain.doFilter(servletRequest, servletResponse);
        Long et = System.currentTimeMillis();
        logger.info("uri:{},ip:{},time:{}ms,ua{}", uri, ip, (et-st), ua);
    }

    @Override
    public void destroy() {

    }
}
