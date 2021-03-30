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
        //����ͨ��validate������֤user�ĺϷ���
        UsersValidator.validate(Users, result);
        //����Ƿ�����תע���û�����
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
        // ��ʾ���е��û���Ϣ
        List<Users> Users = UsersDao.selectAllUsers();
        model.addAttribute("Users", Users);
        return "admin/showUsers";
    }

    @Override
    public String UsersLogin(Users Users, Model model, HttpSession session) {
        // �����ݿ��в�ѯ������˺�����
        Users Users1 = UsersDao.usersLogin(Users);
        // ��ƥ��ɹ�����ת��ҳ
        if (Users1 != null) {
            session.setAttribute("users", Users1);
            return "users/home";
        } else {
            // ��ƥ��ʧ���򱨴�ˢ�µ�¼����
            JOptionPane.showMessageDialog(null, "�˺Ż������벻��ȷ��");
            return "users/login";
        }

    }

    @Override
    public String deleteUsersByID(int uid, Model model) {
        // ����uidɾ����Ӧ�û���Ϣ
        UsersDao.deleteUsersByID(uid);
        List<Users> Users = UsersDao.selectAllUsers();
        model.addAttribute("Users", Users);
        return "admin/showUsers";
    }

    @Override
    public String updateUsersByID(Users Users, HttpSession session) {
        // ����uid�޸Ķ�Ӧ�û���Ϣ
        int t = UsersDao.updateUsersByID(Users);
        if (t > 0) {
            session.invalidate();
            return "users/succ";
        } else {
            return "users/error";
        }
    }

}
