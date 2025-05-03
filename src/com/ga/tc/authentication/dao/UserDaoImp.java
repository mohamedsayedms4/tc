package com.ga.tc.authentication.dao;

import com.ga.tc.authentication.dto.UserInfoDto;
import com.ga.tc.common.ConnectionFactory;
import com.ga.tc.common.Decoder;
import com.ga.tc.common.Qyeries;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImp implements UserDao {

    @Override
   
public Integer save(UserInfoDto user) {
    if (user == null) return -1;

    String query = (user.getUserId() > 0) ? Qyeries.UPDATE_USER : Qyeries.INSERT_NEW_USER;

    try (Connection conn = ConnectionFactory.createConnection();
         PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

        ps.setString(1, user.getFullName());
        ps.setString(2, user.getEmail());
        ps.setString(3, new Decoder().encode(user.getPassword()));
        ps.setString(4, user.getPhones());
        ps.setString(5, user.getAddress());
        ps.setInt(6, 1); // ثابت أو يمكنك تغييره حسب منطقك
        ps.setInt(7, 1); // المستخدم مفعل مثلاً
        ps.setString(8, user.getLaf());

        if (user.getUserId() > 0) {
            ps.setInt(9, user.getUserId()); // تحديث
        }

        int affected = ps.executeUpdate();

        if (affected == 0) return -1;

        // لا تهمنا القيمة المولدة هنا، فقط نرجع 1 عند النجاح
        return 1;

    } catch (Exception e) {
        e.printStackTrace();
        return -1;
    }
}


    @Override
    public UserInfoDto search(Object key, Integer type) {
       
           

        return null;
    }

    @Override
    public List<UserInfoDto> listAll(Integer active) {
        String query;
        if (active == null) {
            query = Qyeries.LIST_ALL_USERS;
        } else if (active == 1) {
            query = Qyeries.LIST_ACTIVE_USERS;
        } else {
            query = Qyeries.LIST_INACTIVE_USERS;
        }

        List<UserInfoDto> users = new ArrayList<>();
        try (Connection conn = ConnectionFactory.createConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                users.add(mapResultSetToUserDto(rs));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public UserInfoDto authenticateUser(String email, String password) {
        if (email == null || password == null || email.isBlank() || password.isBlank()) {
            return null;
        }

        try (Connection conn = ConnectionFactory.createConnection();
             PreparedStatement ps = conn.prepareStatement(Qyeries.AUTHENTICATE_USER)) {

            ps.setString(1, email);
            ps.setString(2, new Decoder().encode(password));

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    UserInfoDto user = new UserInfoDto();
                    user.setUserId(rs.getInt("USR_ID"));
                    user.setFullName(rs.getString("USR_FULL_NAME"));
                    user.setPhones(rs.getString("USR_PHONE"));
                    user.setAddress(rs.getString("USR_ADDRESS"));
                    user.setRoleId(rs.getInt("USR_ROLE"));
                    user.setLaf(rs.getString("USR_LAF"));
                    return user;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private UserInfoDto mapResultSetToUserDto(ResultSet rs) throws Exception {
        UserInfoDto user = new UserInfoDto();
        user.setUserId(rs.getInt("USR_ID"));
        user.setFullName(rs.getString("USR_FULL_NAME"));
        user.setEmail(rs.getString("USR_EMAIL"));
        user.setPhones(rs.getString("USR_PHONE"));
        user.setAddress(rs.getString("USR_ADDRESS"));
        user.setRoleId(rs.getInt("USR_ROLE"));
        user.setActive(rs.getInt("USR_ACTIVE"));
        user.setLaf(rs.getString("USR_LAF"));
        return user;
    }

    @Override
    public Boolean delete(Integer userId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
