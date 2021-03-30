package com.services;

import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import com.bean.House;
import com.bean.Sort;
import com.dao.HouseDao;
import com.dao.SortDao;


@Service("HouseServices")
public class HouseServicesImpl implements HouseServices {
    @Autowired
    private HouseDao houseDao;
    @Autowired
    private SortDao sortDao;

    @Override
    //��ӷ���
    public String addHouse(House House, HttpServletRequest request, MultipartFile file) {
        // TODO Auto-generated method stub
        //����ͼƬ�ϴ�
        if (!file.isEmpty()) {
            String photo = uploadOneFile(file, request);
            House.setPhoto(photo);
        } else {
            //���Ϊ������ת����ҳ��
            return "admin/error";
        }
        int t = houseDao.addHouse(House);
        //���ݿ�����ɹ�����ת�ɹ�ҳ�棬��֮��תerror����
        if (t > 0) {
            return "admin/succ";
        } else {
            return "admin/error";
        }
    }

    //�ϴ�ͼƬ�Ĺ��߷���
    private String uploadOneFile(MultipartFile myfile, HttpServletRequest request) {
        // TODO Auto-generated method stub
        String realpath = request.getServletContext().
                getRealPath("images");
        File pathfile = new File(realpath);
        if (!pathfile.exists()) {
            pathfile.mkdirs();
        }
        String filename = myfile.getOriginalFilename();
        String suffixList = "jpg,gif,png,ico,bmp,jpeg";//��ʶ���ͼƬ��ʽ
        String type = filename.substring
                (filename.lastIndexOf(".") + 1, filename.length());
        if (suffixList.contains(type.toLowerCase())) {
            //******************************************//
            File tagrgetFile = new File(realpath, filename);
            try {
                myfile.transferTo(tagrgetFile);
            } catch (IllegalStateException | IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return filename;
        } else {
            return null;
        }
    }

    @Override
    public String selectAllHouse(Model model) {
        // TODO Auto-generated method stub
        List<House> House = houseDao.selectAllHouse();
        model.addAttribute("House", House);
        return "admin/showHouse";
    }

    @Override
    public String deleteHouseByID(int cid, Model model) {
        // TODO Auto-generated method stub
        int t = houseDao.deleteHouseByID(cid);
        if (t > 0) {
            //ɾ���ɹ���ˢ�½���
            List<House> House = houseDao.selectAllHouse();
            model.addAttribute("House", House);
            return "admin/showHouse";
        } else {
            return "admin/error";
        }
    }

    @Override
    public String selectAllHouse1(Model model) {
        // TODO Auto-generated method stub
        List<House> House = houseDao.selectAllHouse();
        model.addAttribute("House", House);
        return "admin/showHouse1";
    }

    @Override
    public String selectAllHouse2(Model model) {
        // TODO Auto-generated method stub
        //չʾ״̬Ϊ��δ���⡱�ķ���
        List<House> House = houseDao.selectAllHouse1();
        model.addAttribute("House", House);
        return "users/right";
    }

    @Override
    public String selectHouseByID(int hid, Model model) {
        // TODO Auto-generated method stub
        House House = houseDao.selectHouseByID(hid);
        model.addAttribute("House", House);
        List<Sort> sort = sortDao.selectAllSort();
        model.addAttribute("Sort", sort);
        return "admin/updateHouse";
    }

    @Override
    public String selectHouseByID1(int hid, Model model) {
        //����id��ѯ��Դ
        House House = houseDao.selectHouseByID(hid);
        model.addAttribute("House", House);
        return "users/houseDetails";
    }


    @Override
    public String updateHouseByID(House House) {
        // ���ݴ�����ֵ�޸ķ�Դ��Ϣ
        int t = houseDao.updateHouseByID(House);
        if (t > 0) {
            return "admin/succ";
        } else {
            return "admin/error";
        }
    }

    @Override
    public String selectHouseBySname(String sname, Model model) {
        //���ݷ��Ͳ�ѯ״̬Ϊ��δ���⡱�ķ�Դ
        List<House> House = houseDao.selectHouseBySname(sname);
        model.addAttribute("House", House);
        return "users/showHouse";
    }

    @Override
    public String selectHouseByHname(String hname, Model model) {
        //��������ģ����ѯ״̬Ϊ��δ���⡱�ķ�Դ
        List<House> House = houseDao.selectHouseByHname(hname);
        model.addAttribute("House", House);
        return "users/showHouse";
    }

    @Override
    public String selectHouseByPosition(String hname, Model model) {
        //���ݵ�ַģ����ѯ״̬Ϊ��δ���⡱�ķ�Դ
        List<House> House = houseDao.selectHouseByPosition(hname);
        model.addAttribute("House", House);
        return "users/showHouse";
    }

    @Override
    public String selectHouseByPrice(int low, int high, Model model) {
        //�������ɸѡ״̬Ϊ��δ���⡱�ķ�Դ
        List<House> House = houseDao.selectHouseByPrice(low, high);
        model.addAttribute("House", House);
        return "users/showHouse";
    }

    @Override
    public String selectAllHouse3(Model model) {
        //��ѯ״̬Ϊ���ѳ��⡱�ķ�Դ
        List<House> House = houseDao.selectAllHouse2();
        model.addAttribute("House", House);
        return "admin/showHouse2";
    }

    @Override
    public String updateHouseByID2(House House, Model model) {
        //���÷�Դ״̬Ϊ��δ���⡰
        int t = houseDao.updateHouseByID2(House.getHid());
        if (t > 0) {
            //ˢ��չʾ״̬Ϊ���ѳ��⡰�ķ�Դ
            List<House> House1 = houseDao.selectAllHouse2();
            model.addAttribute("House", House1);
            return "admin/showHouse2";
        } else {
            return "admin/error";
        }
    }


}
