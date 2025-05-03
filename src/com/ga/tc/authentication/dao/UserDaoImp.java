package com.ga.tc.authentication.dao;

import com.ga.tc.authentication.dto.UserInfoDto;
import com.ga.tc.common.ConnectionFactory;
import com.ga.tc.common.Qyeries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import java.util.ArrayList;

public class UserDaoImp implements UserDao {

    @Override
    public Integer save(UserInfoDto user) {
        if (user == null) {
            return -1; // Return -1 if the user object is null
        }

        // Choose the appropriate query based on whether the user ID exists (update) or not (insert)
        String query = (user.getUserId() > 0) ? Qyeries.UPDATE_USER : Qyeries.INSERT_NEW_USER;

        try (Connection conn = ConnectionFactory.createConnection();
             PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            // Set the common parameters for both insert and update
            ps.setString(1, user.getFullName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getPhones());
            ps.setString(5, user.getAddress());
            ps.setInt(6, user.getRoleId());
            ps.setInt(7, user.getActive());
            ps.setString(8, user.getLaf());

            // If updating, set the user ID parameter at index 9
            if (user.getUserId() > 0) {
                ps.setInt(9, user.getUserId());
            }

            int affectedRows = ps.executeUpdate();

            if (affectedRows == 0) {
                return -1; // No rows affected, return -1
            }

            // If inserting a new user, retrieve the generated user ID
            if (user.getUserId() <= 0) {
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        return generatedKeys.getInt(1); // Return the new user ID
                    } else {
                        return -1; // No ID generated, return -1
                    }
                }
            }

            // Return the existing user ID in case of update
            return user.getUserId();

        } catch (Exception e) {
            e.printStackTrace(); // Print the exception for debugging
            return -1;
        }
    }

    @Override
    public Boolean delete(Integer userId) {
        // Not implemented yet
        return false;
    }

    @Override
    public UserInfoDto search(Object key, Integer type) {
        // Not implemented yet
        return null;
    }

    @Override
    public List<UserInfoDto> listAll(Integer active) {
        // Not implemented yet
        return null;
    }

    @Override
    public UserInfoDto authenticateUser(String email, String password) {
        if (email == null || password == null || email.isEmpty() || password.isEmpty()) {
            return null; // Return null if email or password is invalid
        }

        try (Connection conn = ConnectionFactory.createConnection();
             PreparedStatement ps = conn.prepareStatement(Qyeries.AUTHENTICATE_USER)) {

            ps.setString(1, email);
            ps.setString(2, password);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    // If credentials match, populate and return the user object
                    UserInfoDto userInfo = new UserInfoDto();
                    userInfo.setUserId(rs.getInt("USR_ID"));
                    userInfo.setFullName(rs.getString("USR_FULL_NAME"));
                    userInfo.setPhones(rs.getString("USR_PHONE"));
                    userInfo.setAddress(rs.getString("USR_ADDRESS"));
                    userInfo.setRoleId(rs.getInt("USR_ROLE"));
                    userInfo.setLaf(rs.getString("USR_LAF"));
                    return userInfo;
                }
            }

        } catch (Exception e) {
            e.printStackTrace(); // Print the exception for debugging
        }

        return null; // Authentication failed
    }

    // Helper method to convert a ResultSet row into a UserInfoDto object
    private UserInfoDto mapResultSetToUserDto(ResultSet rs) throws Exception {
        UserInfoDto user = new UserInfoDto();
        user.setUserId(rs.getInt("USR_ID"));
        user.setFullName(rs.getString("USR_FULL_NAME"));
        user.setEmail(rs.getString("USR_EMAIL"));
        // We do not retrieve the password for security reasons
        user.setPhones(rs.getString("USR_PHONE"));
        user.setAddress(rs.getString("USR_ADDRESS"));
        user.setRoleId(rs.getInt("USR_ROLE"));
        user.setActive(rs.getInt("USR_ACTIVE"));
        user.setLaf(rs.getString("USR_LAF"));
        return user;
    }
}
