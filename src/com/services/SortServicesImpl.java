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
        // 添加对于房型的选项
        int t = SortDao.addSort(Sort);
        if (t > 0) {
            return "admin/succ";
        } else {
            return "admin/error";
        }
    }

    @Override
    public String selectAllSort(Model model) {
        // 展示所有的房型选项
        List<Sort> Sort = SortDao.selectAllSort();
        model.addAttribute("Sort", Sort);
        return "admin/showSort";
    }

    @Override
    public String selectAllSort1(Model model) {
        // 跳转添加房型页
        List<Sort> Sort = SortDao.selectAllSort();
        model.addAttribute("Sort", Sort);
        return "admin/addHouse";
    }

    @Override
    public String selectAllSort2(Model model) {
        // 设置用户选择房型
        List<Sort> Sort = SortDao.selectAllSort();
        model.addAttribute("Sort", Sort);
        return "users/right1";
    }

    @Override
    public String deleteSortByID(int tid, Model model) {
        // 删除对应房型后刷新展示
        SortDao.deleteSortByID(tid);
        List<Sort> Sort = SortDao.selectAllSort();
        model.addAttribute("Sort", Sort);
        return "admin/showSort";
    }
}
