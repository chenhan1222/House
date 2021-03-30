package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import com.bean.OrderDetail;
import com.dao.HouseDao;
import com.dao.OrderDetailDao;
import com.dao.OrdersDao;
import com.pojo.OrderDetails;

@Service("OrderDetailservices")
public class OrderDetailServicesImpl implements OrderDetailServices {
    @Autowired
    private OrderDetailDao OrderDetailDao;
    @Qualifier("ordersDao")
    @Autowired
    private OrdersDao ordersDao;
    @Autowired
    private HouseDao houseDao;

    @Override
    public String selectAllOrderDetail(Model model) {
        // չʾ״̬Ϊ��δͬ�����ޡ��ķ�Դ
        List<OrderDetails> OrderDetail = OrderDetailDao.selectAllOrderDetail();
        model.addAttribute("OrderDetail", OrderDetail);
        return "admin/showOrderDetail";
    }

    @Override
    public String selectAllOrderDetail1(Model model) {
        // չʾ״̬Ϊ��ͬ�����ޡ��ķ�Դ
        List<OrderDetails> OrderDetail = OrderDetailDao.selectAllOrderDetail1();
        model.addAttribute("OrderDetail", OrderDetail);
        return "admin/showOrderDetail1";
    }

    @Override
    public String deleteOrderDetailByID(int oid, Model model) {
        // ɾ���ö���������ͬ��ö�������Դȡ������������չʾ
        OrderDetailDao.deleteOrderDetailByID(oid);
        List<OrderDetails> OrderDetail = OrderDetailDao.selectAllOrderDetail1();
        model.addAttribute("OrderDetail", OrderDetail);
        return "admin/showOrderDetail1";
    }

    @Override
    public String updateOrderDetail(String wj, Model model, int hid) {
        // ������״̬����Ϊ��ͬ�����ޡ�
        OrderDetailDao.updateOrderDetail(wj);
        ordersDao.UpdateOrders(wj);
        houseDao.updateHouseByID1(hid);
        return "admin/succ";
    }


}
