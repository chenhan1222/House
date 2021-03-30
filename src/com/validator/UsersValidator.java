package com.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.bean.Users;

@Component
public class UsersValidator implements Validator {
    /*
    ͨ��ʵ�����������������ṩUsers�����֤��Ϊ
    org.springframework.validation.Validator�ӿڵķ�����
    support��Class��-����֤���������֤�ṩ��Class��ʵ��
    validate��Object��org.springframework.validation.Errors��-��֤�������󣬲�����֤���������£������Errors����ע��
     */
    @Override
    //�жϴ�������Ƿ�ΪUsers������
    public boolean supports(Class<?> arg0) {
        // TODO Auto-generated method stub
        return Users.class.isAssignableFrom(arg0);
    }

    @Override
    //ʹ��Spring��Validator����У��
    public void validate(Object arg0, Errors arg1) {
        // TODO Auto-generated method stub
        ValidationUtils.rejectIfEmpty(arg1, "uname", "uname.required");
        ValidationUtils.rejectIfEmpty(arg1, "upass", "upass.required");
        ValidationUtils.rejectIfEmpty(arg1, "username", "username.required");
        ValidationUtils.rejectIfEmpty(arg1, "telephone", "telephone.required");
    }
}
