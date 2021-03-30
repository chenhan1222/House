package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import com.bean.Sort;
import com.dao.SortDao;

@Service("Sortservices")
public class SortServicesImpl implements SortServices {
    @Autowired
    private SortDao SortDao;

    @Override
    public String addSort(Sort Sort) {
        // ��Ӷ��ڷ��͵�ѡ��
        int t = SortDao.addSort(Sort);
        if (t > 0) {
            return "admin/succ";
        } else {
            return "admin/error";
        }
    }

    @Override
    public String selectAllSort(Model model) {
        // չʾ���еķ���ѡ��
        List<Sort> Sort = SortDao.selectAllSort();
        model.addAttribute("Sort", Sort);
        return "admin/showSort";
    }

    @Override
    public String selectAllSort1(Model model) {
        // ��ת��ӷ���ҳ
        List<Sort> Sort = SortDao.selectAllSort();
        model.addAttribute("Sort", Sort);
        return "admin/addHouse";
    }

    @Override
    public String selectAllSort2(Model model) {
        // �����û�ѡ����
        List<Sort> Sort = SortDao.selectAllSort();
        model.addAttribute("Sort", Sort);
        return "users/right1";
    }

    @Override
    public String deleteSortByID(int tid, Model model) {
        // ɾ����Ӧ���ͺ�ˢ��չʾ
        SortDao.deleteSortByID(tid);
        List<Sort> Sort = SortDao.selectAllSort();
        model.addAttribute("Sort", Sort);
        return "admin/showSort";
    }
}
