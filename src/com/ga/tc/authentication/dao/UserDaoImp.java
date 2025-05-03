package com.ga.tc.authentication.dao;

import com.ga.tc.authentication.dto.UserInfoDto;
import com.ga.tc.common.ConnectionFactory;
import com.ga.tc.common.Qyeries;
import java.util.List;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

/**
 * Implementation of the UserDao interface. Handles database operations related
 * to user information.
 *
 * Author: Mohamed Sayed
 */
public class UserDaoImp implements UserDao {

 @Override
public Integer save(UserInfoDto user) {
    try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {

        // تعيين معلومات الاتصال
        jdbcRs.setUrl(ConnectionFactory.getUrl());
        jdbcRs.setUsername(ConnectionFactory.getUser());
        jdbcRs.setPassword(ConnectionFactory.getPassword());

        // تعيين الاستعلام
        jdbcRs.setCommand(Qyeries.INSERT_NEW_USER);

        // تمرير القيم المطلوبة - 8 قيم
        jdbcRs.setString(1, user.getFullName());
        jdbcRs.setString(2, user.getEmail());
        jdbcRs.setString(3, user.getPassword());
        jdbcRs.setString(4, user.getPhones());
        jdbcRs.setString(5, user.getAddress());
        jdbcRs.setInt(6, user.getRoleId());
        jdbcRs.setInt(7, user.getActive());
        jdbcRs.setString(8, user.getLaf());

        // تنفيذ الإدخال
        jdbcRs.execute();

        // في حالة النجاح نعيد 1
        return 1;

    } catch (Exception e) {
        e.printStackTrace();
    }

    // في حالة الفشل
    return -1;
}


    @Override
    public Boolean delete(Integer userId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public UserInfoDto search(Object key, Integer type) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<UserInfoDto> listAll(Integer active) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    // ⚠ تأكد أن هذا التعريف موجود في الواجهة UserDao
    @Override
    public UserInfoDto authenticatUser(String email, String password) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
