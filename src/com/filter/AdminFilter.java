package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.bean.Admin;


public class AdminFilter implements Filter {

    @Override
    //请求通过filter时执行doFilter方法
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // TODO Auto-generated method stub
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
        Admin admin = (Admin) session.getAttribute("admin");
        if (admin != null) {
            chain.doFilter(request, response);//放行
        } else {
            String path = req.getServletPath();
            if (path.endsWith("login.jsp") || path.endsWith("login")) {
                chain.doFilter(request, response);
            } else {
                JOptionPane.showMessageDialog(null, "请先登录！");
                req.getRequestDispatcher("login.jsp").forward(request, response);
            }
        }
    }

    @Override
    //服务器停止时，调用 destroy 方法
    public void destroy() {
        // TODO Auto-generated method stub
    }

    @Override
    //在服务器启动时，filter被创建并初始化，执行init()方法
    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub
    }
}
