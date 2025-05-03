package com.ga.tc.common.ui;

import com.ga.tc.authentication.dto.UserInfoDto;
import com.ga.tc.authentication.ui.CreateNewUser;

/**
 *
 * @author Mohamed Sayed
 */
public class MainFrame extends javax.swing.JFrame {
    private UserInfoDto userInfo;

    public UserInfoDto getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfoDto userInfo) {
        this.userInfo = userInfo;
    }

    /**
     * Creates new form MainFrame
     */
    public MainFrame(UserInfoDto userInfo) {
        this.userInfo = userInfo;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenu11 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenu9 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu10 = new javax.swing.JMenu();

        jMenu1.setText("jMenu1");
        jMenu2.setText("jMenu2");
        jMenu3.setText("jMenu3");
        jMenu8.setText("jMenu8");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu5.setText("Users");

        jMenuItem1.setText("all users");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem1);

        jMenuItem5.setText("create user");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem5);

        jMenuBar1.add(jMenu5);

        jMenu4.setText("Courses");
        jMenuItem2.setText("all courses");
        jMenu4.add(jMenuItem2);
        jMenuBar1.add(jMenu4);

        jMenu6.setText("Certificate");
        jMenuBar1.add(jMenu6);

        jMenu11.setText("Security");
        jMenuItem6.setText("manage rules");
        jMenu11.add(jMenuItem6);
        jMenuItem7.setText("rule access");
        jMenu11.add(jMenuItem7);
        jMenuBar1.add(jMenu11);

        jMenu7.setText("Reports");
        jMenuBar1.add(jMenu7);

        jMenu9.setText("My Account");
        jMenuItem3.setText("info");
        jMenu9.add(jMenuItem3);
        jMenuItem4.setText("change password");
        jMenu9.add(jMenuItem4);
        jMenuBar1.add(jMenu9);

        jMenu10.setText("Log out");
        jMenuBar1.add(jMenu10);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 277, Short.MAX_VALUE)
        );

        pack();
    }

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO: Handle show all users
    }

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {
        this.setContentPane(new CreateNewUser());
        this.invalidate();
        this.validate();
        this.repaint();
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            UserInfoDto dummyUser = new UserInfoDto(); // أو املأه بالبيانات المطلوبة
            new MainFrame(dummyUser).setVisible(true);
        });
    }

    // Variables declaration
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    // End of variables declaration
}
