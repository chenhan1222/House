package com.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bean.Users;
import com.services.UsersServices;

@Controller
public class UsersController {
    @Autowired
    private UsersServices UsersServices;

    @RequestMapping("/addUsers")
    public String addUsers(@Valid @ModelAttribute Users Users, BindingResult result) {

        return UsersServices.addUsers(Users, result);
    }

    @RequestMapping("/selectAllUsers")
    public String selectAllUsers(Model model) {

        return UsersServices.selectAllUsers(model);
    }

    @RequestMapping("/deleteUsersByID")
    public String deleteUsersByID(int uid, Model model) {
        UsersServices.deleteUsersByID(uid, model);

        return UsersServices.selectAllUsers(model);
    }

    @RequestMapping("/usersLogin")
    public String login(Users Users, Model model, HttpSession session) {
        return UsersServices.UsersLogin(Users, model, session);

    }

    @RequestMapping("/updateUsers")
    public String updateUsers(Model model, HttpSession session) {
        Users Users = (Users) session.getAttribute("users");
        if (Users == null) {
            return "users/needLogin";
        }
        return "users/updateUsers";
    }

    @RequestMapping("/updateUsers1")
    public String updateUsers1(Users Users, HttpSession session) {
        return UsersServices.updateUsersByID(Users, session);
    }

    @RequestMapping("/tuichu")
    public String sessionclear(Model model, HttpSession session) {
        session.invalidate();
        return "users/succ";
    }

    @RequestMapping("/i18n")
    public String i18n() {
        return "users/home";
    }

    @RequestMapping("/addUsers1")
    public String ToReg(@ModelAttribute Users Users) {
        return "users/addUsers";
    }
}
