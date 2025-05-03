/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ga.tc.authentication.bao;

import com.ga.tc.authentication.dao.UserDao;
import com.ga.tc.authentication.dao.UserDaoImp;
import com.ga.tc.authentication.dto.UserInfoDto;
import com.ga.tc.common.Constants;
import java.util.List;

/**
 *
 * @author Mohamed Sayed
 */
public class UserBaoImp implements UserBao{
    private UserDao data = new UserDaoImp();
    @Override
    public Integer save(UserInfoDto user) {
        try{
            if(user.getPassword() == null)
            {
                user.setPassword(Constants.DEFULT_PASSWORD)  ;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return data.save(user);
    }

    @Override
    public Boolean delete(Integer userId) {
        return data.delete(userId);
    }

    @Override
    public UserInfoDto search(Object key, Integer type) {
        return data.search(key,type);
    }

    @Override
    public List<UserInfoDto> listAll(Integer active) {
        return data.listAll(active);
    }

    @Override
    public UserInfoDto authenticateUser(String email, String password) {
        
        
       
        return data.authenticateUser(email, password);
    }
    
}
