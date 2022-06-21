// @author: Akil Sundhar
// @year: 2022
// @purpose: Minor Project

package sources;

import support.Theme;
import javax.swing.UIManager;
import com.formdev.flatlaf.*;
import support.Database_Connection;
import javax.swing.UnsupportedLookAndFeelException;

public class P03_Manager_Home extends javax.swing.JFrame {

    public P03_Manager_Home() {
        initComponents();
        Change_Mode.putClientProperty("Button.arc", 999);
    }
    
    public P03_Manager_Home(String ID) {
        initComponents();
        Change_Mode.putClientProperty("Button.arc", 999);
        System.out.println(ID);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Change_Mode = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Manager Home");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setName("FRAME 01"); // NOI18N

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
                .addContainerGap(1214, Short.MAX_VALUE)
                .addComponent(Change_Mode, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(Change_Mode, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(659, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    boolean theme = true;
    Theme T=new Theme();
    Database_Connection DB = new Database_Connection();

    private void Change_ModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Change_ModeActionPerformed
        if (theme) {
            T.Change_Theme(this,theme);
            theme = false;
        } else {
            T.Change_Theme(this,theme);
            theme = true;
        }
    }//GEN-LAST:event_Change_ModeActionPerformed
    
    public static void main(String args[]) {
        
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
            UIManager.put("TextComponent.arc", 15);
            UIManager.put("Button.arc", 100);
        } catch (UnsupportedLookAndFeelException ex) {
            System.out.println("Failed to initialize LaF");
        }

        java.awt.EventQueue.invokeLater(() -> {
            new P02_Employee_Home("MAN00324").setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Change_Mode;
    // End of variables declaration//GEN-END:variables
}