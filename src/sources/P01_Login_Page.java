// @author: Akil Sundhar
// @year: 2022
// @purpose: Minor Project

package sources;

import support.Theme;
import java.sql.ResultSet;
import javax.swing.UIManager;
import com.formdev.flatlaf.*;
import java.sql.SQLException;
import support.Database_Connection;
import javax.swing.UnsupportedLookAndFeelException;

public class P01_Login_Page extends javax.swing.JFrame {

    public P01_Login_Page() {
        initComponents();
        Change_Mode.putClientProperty("Button.arc", 999);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jButton2 = new javax.swing.JButton();
        Change_Mode = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("User Login");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setName("FRAME 01"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 170, 400, 40));
        getContentPane().add(jPasswordField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 240, 400, 40));

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton2.setText("SIGN IN");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 300, 400, 40));

        Change_Mode.setText("1");
        Change_Mode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Change_ModeActionPerformed(evt);
            }
        });
        getContentPane().add(Change_Mode, new org.netbeans.lib.awtextra.AbsoluteConstraints(1214, 21, 40, 40));

        jLabel1.setText("Username");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 150, 400, -1));

        jLabel2.setText("Password");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 220, 400, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    boolean theme = true;
    String user, password;
    Theme T = new Theme();
    Database_Connection DB = new Database_Connection();

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            user = jTextField2.getText().trim();
            password = new String(jPasswordField2.getPassword()).trim();
            if (check()) {
                String query = "SELECT * FROM login WHERE USER_ID= '" + user + "'";
                ResultSet rs = DB.DB_Select(query);
                if (rs.next()) {
                    if (rs.getString("Password").equals(password) && rs.getInt("Status") == 1) {
                        String ID = rs.getString("Employee_ID");
                        String temp = ID.substring(0, 3);
                        if (temp.equals("EMP")) {
                            new P02_Employee_Home(ID).setVisible(true);
                            this.dispose();
                        } else if (temp.equals("MAN")) {
                            new P23_Manager_Home(ID).setVisible(true);
                            this.dispose();
                        }
                    }
                }
            }
        } catch (SQLException e) {
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void Change_ModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Change_ModeActionPerformed
        if (theme) {
            T.Change_Theme(this, theme);
            theme = false;
        } else {
            T.Change_Theme(this, theme);
            theme = true;
        }
    }//GEN-LAST:event_Change_ModeActionPerformed

    public Boolean check() {
        boolean temp = false;
        if (user.equalsIgnoreCase("")) {
            return temp;
        }
        if (password.equalsIgnoreCase("")) {
            return temp;
        }
        temp = true;
        return temp;
    }

    public static void main(String args[]) {

        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
            UIManager.put("TextComponent.arc", 15);
            UIManager.put("Button.arc", 100);
        } catch (UnsupportedLookAndFeelException ex) {
            System.out.println("Failed to initialize LaF");
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new P01_Login_Page().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Change_Mode;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
