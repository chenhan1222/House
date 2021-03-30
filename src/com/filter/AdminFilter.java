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
    //����ͨ��filterʱִ��doFilter����
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // TODO Auto-generated method stub
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
        Admin admin = (Admin) session.getAttribute("admin");
        if (admin != null) {
            chain.doFilter(request, response);//����
        } else {
            String path = req.getServletPath();
            if (path.endsWith("login.jsp") || path.endsWith("login")) {
                chain.doFilter(request, response);
            } else {
                JOptionPane.showMessageDialog(null, "���ȵ�¼��");
                req.getRequestDispatcher("login.jsp").forward(request, response);
            }
        }
    }

    @Override
    //������ֹͣʱ������ destroy ����
    public void destroy() {
        // TODO Auto-generated method stub
    }

    @Override
    //�ڷ���������ʱ��filter����������ʼ����ִ��init()����
    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub
    }
}
