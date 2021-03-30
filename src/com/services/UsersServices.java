package com.services;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.bean.Users;

public interface UsersServices {

    public String addUsers(Users Users, BindingResult result);

    public String selectAllUsers(Model model);

    public String deleteUsersByID(int uid, Model model);

    public String UsersLogin(Users Users, Model model, HttpSession session);

    public String updateUsersByID(Users Users, HttpSession session);

}
