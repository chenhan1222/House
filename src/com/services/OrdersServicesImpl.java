package com.services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.bean.OrderDetail;
import com.bean.Orders;

import com.bean.Orders;

import com.bean.Users;
import com.dao.OrderDetailDao;
import com.dao.OrdersDao;
import com.pojo.Orderss;


@Service("OrdersServices")
public class OrdersServicesImpl implements OrdersServices {
    @Qualifier("ordersDao")
    @Autowired
    private OrdersDao ordersDao;
    @Autowired
    private OrderDetailDao orderDetailDao;

    @Override
    public String selectOrdersByUid(Model model, HttpSession session) {
        //若未登录则跳转到用户登录界面
        Users Users = (Users) session.getAttribute("users");
        if (Users == null) {
            return "users/needLogin";
        } else {
            //展示该uid对应的订单
            List<Orderss> orders = ordersDao.selectOrdersByUid(Users.getUid());
            model.addAttribute("orders", orders);
            return "users/showOrders";
        }
    }

    @Override
    public String deleteOrdersByID(int oid, Model model, HttpSession session) {
        // 删除对应oid下的订单
        ordersDao.deleteOrdersByID(oid);
        Users Users = (Users) session.getAttribute("users");
        if (Users == null) {
            return "users/needLogin";
        } else {
            //删除之后重新刷新
            List<Orderss> orders = ordersDao.selectOrdersByUid(Users.getUid());
            model.addAttribute("orders", orders);
            return "users/showOrders";
        }
    }

    @Override
    public String addOrders(Orders Orders, HttpSession session, OrderDetail OrderDetail) {
        // TODO Auto-generated method stub
        Users Users = (Users) session.getAttribute("users");
        if (Users == null) {
            return "users/needLogin";
        } else {
            //计算订单总价
            Orders.setTotal(Orders.getNums() * Orders.getPrice());
            //设置orderdetail中的订单总价
            OrderDetail.setTotal(Orders.getNums() * Orders.getPrice());
            Date d = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //写入订单时间
            Orders.setWj(sdf.format(d) + "");
            //写入用户id
            Orders.setUid(Users.getUid());
            //写入订单时间
            OrderDetail.setWj(sdf.format(d) + "");
            //写入用户id
            OrderDetail.setUid(Users.getUid());
            //写入数据库
            orderDetailDao.addOrderDetail(OrderDetail);
            //判断是否写入成功
            int t = ordersDao.addOrders(Orders);
            if (t > 0) {
                return "users/succ";
            } else {
                return "users/error";
            }
        }
    }
}
	

