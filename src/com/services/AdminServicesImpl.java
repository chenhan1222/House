package com.services;

import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.bean.Admin;
import com.dao.AdminDao;

@Service("adminServices")
public class AdminServicesImpl implements AdminServices {
    @Autowired
    private AdminDao adminDao;

    @Override
    //管理员登录
    public String adminLogin(Admin admin, Model model, HttpSession session) {
        // TODO Auto-generated method stub
        Admin admin1 = adminDao.adminLogin(admin);
        if (admin1 != null) {
            session.setAttribute("admin", admin1);
            //登录成功则跳转home.jsp页面
            return "admin/home";
        } else {
            //未从数据库中筛选到匹配的账号密码用户则报错，并重新跳转登录界面
            JOptionPane.showMessageDialog(null, "账号或者密码不匹配");
            return "admin/login";
        }

    }

}
