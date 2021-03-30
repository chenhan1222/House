package com.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.bean.Users;

@Component
public class UsersValidator implements Validator {
    /*
    通过实现以下两个方法来提供Users类的验证行为
    org.springframework.validation.Validator接口的方法：
    support（Class）-此验证程序可以验证提供的Class的实例
    validate（Object，org.springframework.validation.Errors）-验证给定对象，并在验证错误的情况下，向给定Errors对象注册
     */
    @Override
    //判断传入的类是否为Users的子类
    public boolean supports(Class<?> arg0) {
        // TODO Auto-generated method stub
        return Users.class.isAssignableFrom(arg0);
    }

    @Override
    //使用Spring的Validator进行校验
    public void validate(Object arg0, Errors arg1) {
        // TODO Auto-generated method stub
        ValidationUtils.rejectIfEmpty(arg1, "uname", "uname.required");
        ValidationUtils.rejectIfEmpty(arg1, "upass", "upass.required");
        ValidationUtils.rejectIfEmpty(arg1, "username", "username.required");
        ValidationUtils.rejectIfEmpty(arg1, "telephone", "telephone.required");
    }
}
