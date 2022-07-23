// @author: Akil Sundhar
// @year: 2022
// @purpose: Minor Project

package sources;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import support.Theme;
import support.Database_Connection;

public class P03_Product_Details extends javax.swing.JFrame {

    public P03_Product_Details() {
        initComponents();
        Change_Mode.putClientProperty("Button.arc", 999);
    }
    
    public P03_Product_Details(String ID) {
        initComponents();
        Change_Mode.putClientProperty("Button.arc", 999);
        System.out.println(ID);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Change_Mode = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Employee Home");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setName("FRAME 01"); // NOI18N
        setResizable(false);
        setSize(new java.awt.Dimension(1280, 720));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Change_Mode.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Change_Mode.setText("1");
        Change_Mode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Change_ModeActionPerformed(evt);
            }
        });
        getContentPane().add(Change_Mode, new org.netbeans.lib.awtextra.AbsoluteConstraints(1214, 21, 40, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Background.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

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
            new P03_Product_Details("EMP00217").setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Change_Mode;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}