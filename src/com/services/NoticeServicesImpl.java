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
        //根据传入值新增一个公告
        int t = noticeDao.addNotice(notice);
        if (t > 0) {
            return "admin/succ";
        } else {
            return "admin/error";
        }
    }

    @Override
    public String selectAllNotice(Model model) {
        //展示所有的公告
        List<Notice> notice = noticeDao.selectAllNotice();
        model.addAttribute("Notice", notice);
        return "admin/showNotice";
    }

    @Override
    public String selectAllNotice1(Model model) {
        //展示所有的公告
        List<Notice> notice = noticeDao.selectAllNotice();
        model.addAttribute("Notice", notice);
        return "users/showNotice";
    }

    @Override
    public String selectNoticeByID(int nid, Model model) {
        //根据id筛选公告，并跳转显示公告详情
        Notice notice = noticeDao.selectNoticeByID(nid);
        model.addAttribute("Notice", notice);
        return "users/noticeDetails";
    }

    @Override
    public String deleteNoticeByID(int nid, Model model) {
        //根据id删除公告后刷新页面重新展示
        noticeDao.deleteNoticeByID(nid);
        List<Notice> notice = noticeDao.selectAllNotice();
        model.addAttribute("Notice", notice);
        return "admin/showNotice";
    }


}
