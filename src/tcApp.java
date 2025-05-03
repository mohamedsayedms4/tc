
import com.ga.tc.authentication.dao.UserDao;
import com.ga.tc.authentication.dao.UserDaoImp;
import com.ga.tc.authentication.dto.UserInfoDto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Mohamed Sayed
 */
public class tcApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        // TODO code application logic here
//         // TODO code application logic here
        UserInfoDto user = new UserInfoDto();
        user.setFullName("Ahmed Ali");
        user.setEmail("ahmed.ali@example.com");
        user.setPassword("123456");  // تأكد من التشفير في حالة التطبيق الحقيقي
        user.setPhones("0123456789");
        user.setAddress("Alexandria");
        user.setRoleId(1);  // تأكد من وجود هذا الدور في TC_ROLE
        user.setActive(1);
        user.setLaf("com.jtattoo.plaf.luna.LunaLookAndFeel");

        // إنشاء DAO وتنفيذ الحفظ
        UserDao userDao = new UserDaoImp();
        Integer newUserId = userDao.save(user);

        // طباعة النتيجة
//        if (newUserId != null && newUserId != -1) {
//            System.out.println("yes " + newUserId);
//        } else {
//            System.out.println("no.");
//        }

    }
}
    
        
                
    
    
    

