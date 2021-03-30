package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import com.bean.Notice;
import com.dao.NoticeDao;

@Service("noticeServices")
public class NoticeServicesImpl implements NoticeServices {
    //	@Qualifier("noticeDao")
    @Qualifier("noticeDao")
    @Autowired
    private NoticeDao noticeDao;

    @Override
    public String addNotice(Notice notice) {
        //���ݴ���ֵ����һ������
        int t = noticeDao.addNotice(notice);
        if (t > 0) {
            return "admin/succ";
        } else {
            return "admin/error";
        }
    }

    @Override
    public String selectAllNotice(Model model) {
        //չʾ���еĹ���
        List<Notice> notice = noticeDao.selectAllNotice();
        model.addAttribute("Notice", notice);
        return "admin/showNotice";
    }

    @Override
    public String selectAllNotice1(Model model) {
        //չʾ���еĹ���
        List<Notice> notice = noticeDao.selectAllNotice();
        model.addAttribute("Notice", notice);
        return "users/showNotice";
    }

    @Override
    public String selectNoticeByID(int nid, Model model) {
        //����idɸѡ���棬����ת��ʾ��������
        Notice notice = noticeDao.selectNoticeByID(nid);
        model.addAttribute("Notice", notice);
        return "users/noticeDetails";
    }

    @Override
    public String deleteNoticeByID(int nid, Model model) {
        //����idɾ�������ˢ��ҳ������չʾ
        noticeDao.deleteNoticeByID(nid);
        List<Notice> notice = noticeDao.selectAllNotice();
        model.addAttribute("Notice", notice);
        return "admin/showNotice";
    }


}
