package com.services;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;


import com.bean.Users;
import com.dao.UsersDao;
import com.validator.UsersValidator;

@Service("Userservices")
public class UsersServicesImpl implements UsersServices {
    @Autowired
    private UsersDao UsersDao;

    @Autowired
    private UsersValidator UsersValidator;

    @Override
    public String addUsers(Users Users, BindingResult result) {
        //首先通过validate方法验证user的合法性
        UsersValidator.validate(Users, result);
        //如果非法则跳转注册用户界面
        if (result.hasErrors()) {
            return "users/addUsers";
        }
        int t = UsersDao.addUsers(Users);
        if (t > 0) {
            return "users/succ";
        } else {
            return "users/error";
        }
    }

    @Override
    public String selectAllUsers(Model model) {
        // 显示所有的用户信息
        List<Users> Users = UsersDao.selectAllUsers();
        model.addAttribute("Users", Users);
        return "admin/showUsers";
    }

    @Override
    public String UsersLogin(Users Users, Model model, HttpSession session) {
        // 从数据库中查询输入的账号密码
        Users Users1 = UsersDao.usersLogin(Users);
        // 若匹配成功则跳转主页
        if (Users1 != null) {
            session.setAttribute("users", Users1);
            return "users/home";
        } else {
            // 若匹配失败则报错刷新登录界面
            JOptionPane.showMessageDialog(null, "账号或者密码不正确！");
            return "users/login";
        }

    }

    @Override
    public String deleteUsersByID(int uid, Model model) {
        // 根据uid删除对应用户信息
        UsersDao.deleteUsersByID(uid);
        List<Users> Users = UsersDao.selectAllUsers();
        model.addAttribute("Users", Users);
        return "admin/showUsers";
    }

    @Override
    public String updateUsersByID(Users Users, HttpSession session) {
        // 根据uid修改对应用户信息
        int t = UsersDao.updateUsersByID(Users);
        if (t > 0) {
            session.invalidate();
            return "users/succ";
        } else {
            return "users/error";
        }
    }

}
