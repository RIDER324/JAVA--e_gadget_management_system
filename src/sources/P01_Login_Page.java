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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FRAME1");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("FRAME 01"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1280, 720));

        jTextField2.setText("jTextField2");

        jPasswordField2.setText("jPasswordField2");

        jButton2.setText("jButton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        Change_Mode.setText("1");
        Change_Mode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Change_ModeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(753, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(127, 127, 127))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Change_Mode, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(Change_Mode, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(417, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    boolean theme = true;
    String user, password;
    Theme T=new Theme();
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
                        //System.out.print(rs.getInt("Employee_ID")+"\n"+rs.getString("User_ID")+"\n"+rs.getString("Password")+"\n"+rs.getString("Status"));
                        //Go to next page
                    }
                }
            }
        } catch (SQLException e) {
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void Change_ModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Change_ModeActionPerformed
        if (theme) {
            T.Change_Theme(this,theme);
            theme = false;
        } else {
            T.Change_Theme(this,theme);
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
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}