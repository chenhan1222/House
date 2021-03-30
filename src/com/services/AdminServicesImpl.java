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
    //����Ա��¼
    public String adminLogin(Admin admin, Model model, HttpSession session) {
        // TODO Auto-generated method stub
        Admin admin1 = adminDao.adminLogin(admin);
        if (admin1 != null) {
            session.setAttribute("admin", admin1);
            //��¼�ɹ�����תhome.jspҳ��
            return "admin/home";
        } else {
            //δ�����ݿ���ɸѡ��ƥ����˺������û��򱨴���������ת��¼����
            JOptionPane.showMessageDialog(null, "�˺Ż������벻ƥ��");
            return "admin/login";
        }

    }

}
