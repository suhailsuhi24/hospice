/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doctor;

import ConnectionProvider.ConnectionProvider;
import Home.contactUs_Frame;
import Home.aboutUs_Frame;
import com.placeholder.PlaceHolder;
import java.awt.*;
import java.sql.Connection;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Packiyaraj
 */
public class doctorLogin_Frame extends javax.swing.JFrame {
    Connection con=null;
    ResultSet rs=null;
    PreparedStatement pt=null;                  /**/ Statement st;  String dashname; String dashpass;
    /**
     * Creates new form doctorLogin_Frame
     */
    PlaceHolder holder;
    public doctorLogin_Frame() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);  
        setFocusable(true);
        holder=new PlaceHolder(userLogin, "USER NAME");
        holder=new PlaceHolder(passwordLogin, "PASSWORD");
        
        con=ConnectionProvider.getCon();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        footer = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        hospital = new javax.swing.JLabel();
        hospitalIcon = new javax.swing.JLabel();
        aboutUs_Label = new javax.swing.JLabel();
        contactUs_Label = new javax.swing.JLabel();
        goBack_Label = new javax.swing.JLabel();
        minimize_Label = new javax.swing.JLabel();
        close_Label = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        fillDoctorLogin_Panel = new javax.swing.JPanel();
        userLogin = new javax.swing.JTextField();
        passwordLogin = new javax.swing.JPasswordField();
        login_Patient_Button = new javax.swing.JButton();
        doUHaveAcc_Label = new javax.swing.JLabel();
        signUpHere_Label = new javax.swing.JLabel();
        doctorRegister_Panel = new javax.swing.JPanel();
        loginForm_Label1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));
        setUndecorated(true);

        footer.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout footerLayout = new javax.swing.GroupLayout(footer);
        footer.setLayout(footerLayout);
        footerLayout.setHorizontalGroup(
            footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        footerLayout.setVerticalGroup(
            footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 77, Short.MAX_VALUE)
        );

        header.setBackground(new java.awt.Color(0, 0, 204));

        hospital.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        hospital.setForeground(new java.awt.Color(255, 255, 255));
        hospital.setText("HOSPITAL");

        hospitalIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/2.Home/HospitalIcon.png"))); // NOI18N

        aboutUs_Label.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        aboutUs_Label.setForeground(new java.awt.Color(255, 255, 255));
        aboutUs_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/2.Home/AboutUs.png"))); // NOI18N
        aboutUs_Label.setText("About Us");
        aboutUs_Label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aboutUs_LabelMouseClicked(evt);
            }
        });

        contactUs_Label.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        contactUs_Label.setForeground(new java.awt.Color(255, 255, 255));
        contactUs_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/2.Home/ContactUs.png"))); // NOI18N
        contactUs_Label.setText("Contact Us");
        contactUs_Label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                contactUs_LabelMouseClicked(evt);
            }
        });

        goBack_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/2.Home/Go Back.png"))); // NOI18N
        goBack_Label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                goBack_LabelMouseClicked(evt);
            }
        });

        minimize_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/2.Home/MinimizeWindow.png"))); // NOI18N
        minimize_Label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimize_LabelMouseClicked(evt);
            }
        });

        close_Label.setBackground(new java.awt.Color(0, 0, 204));
        close_Label.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        close_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/2.Home/Close.png"))); // NOI18N
        close_Label.setOpaque(true);
        close_Label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                close_LabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                close_LabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                close_LabelMouseExited(evt);
            }
        });

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(goBack_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(hospitalIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hospital, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(680, 680, 680)
                .addComponent(aboutUs_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contactUs_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(minimize_Label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(close_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hospitalIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(minimize_Label, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(close_Label, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, headerLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(goBack_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(headerLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(contactUs_Label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(aboutUs_Label, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                                .addComponent(hospital, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        fillDoctorLogin_Panel.setBackground(new java.awt.Color(255, 255, 255));

        userLogin.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        login_Patient_Button.setBackground(new java.awt.Color(0, 0, 204));
        login_Patient_Button.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        login_Patient_Button.setForeground(new java.awt.Color(204, 255, 255));
        login_Patient_Button.setText("Login");
        login_Patient_Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                login_Patient_ButtonMouseEntered(evt);
            }
        });
        login_Patient_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_Patient_ButtonActionPerformed(evt);
            }
        });

        doUHaveAcc_Label.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        doUHaveAcc_Label.setText("Do not have Account  ?");

        signUpHere_Label.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        signUpHere_Label.setForeground(new java.awt.Color(0, 0, 204));
        signUpHere_Label.setText("SignUp here");
        signUpHere_Label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signUpHere_LabelMouseClicked(evt);
            }
        });

        doctorRegister_Panel.setBackground(new java.awt.Color(255, 255, 255));

        loginForm_Label1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        loginForm_Label1.setText("Doctor Login Page");

        javax.swing.GroupLayout doctorRegister_PanelLayout = new javax.swing.GroupLayout(doctorRegister_Panel);
        doctorRegister_Panel.setLayout(doctorRegister_PanelLayout);
        doctorRegister_PanelLayout.setHorizontalGroup(
            doctorRegister_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(doctorRegister_PanelLayout.createSequentialGroup()
                .addGap(216, 216, 216)
                .addComponent(loginForm_Label1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        doctorRegister_PanelLayout.setVerticalGroup(
            doctorRegister_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(doctorRegister_PanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(loginForm_Label1)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout fillDoctorLogin_PanelLayout = new javax.swing.GroupLayout(fillDoctorLogin_Panel);
        fillDoctorLogin_Panel.setLayout(fillDoctorLogin_PanelLayout);
        fillDoctorLogin_PanelLayout.setHorizontalGroup(
            fillDoctorLogin_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(doctorRegister_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(fillDoctorLogin_PanelLayout.createSequentialGroup()
                .addGroup(fillDoctorLogin_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fillDoctorLogin_PanelLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(fillDoctorLogin_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(login_Patient_Button)))
                    .addGroup(fillDoctorLogin_PanelLayout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(doUHaveAcc_Label)
                        .addGap(65, 65, 65)
                        .addComponent(signUpHere_Label)))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        fillDoctorLogin_PanelLayout.setVerticalGroup(
            fillDoctorLogin_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fillDoctorLogin_PanelLayout.createSequentialGroup()
                .addComponent(doctorRegister_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(userLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(passwordLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(login_Patient_Button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(fillDoctorLogin_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(doUHaveAcc_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(signUpHere_Label))
                .addGap(44, 44, 44))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/4.Doctor/Doctor Login.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fillDoctorLogin_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(315, 315, 315))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(68, Short.MAX_VALUE)
                .addComponent(fillDoctorLogin_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(footer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(header, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(footer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aboutUs_LabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutUs_LabelMouseClicked
        // TODO add your handling code here:
        new aboutUs_Frame().setVisible(true); dispose();
    }//GEN-LAST:event_aboutUs_LabelMouseClicked

    private void contactUs_LabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contactUs_LabelMouseClicked
        // TODO add your handling code here:
        new contactUs_Frame().setVisible(true); dispose();
    }//GEN-LAST:event_contactUs_LabelMouseClicked

    private void goBack_LabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goBack_LabelMouseClicked
        // TODO add your handling code here:
        new doctorView().setVisible(true); dispose();
    }//GEN-LAST:event_goBack_LabelMouseClicked

    private void login_Patient_ButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_login_Patient_ButtonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_login_Patient_ButtonMouseEntered

    private void login_Patient_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_Patient_ButtonActionPerformed
        String sqll="select * from hold where uname=? and pwd=? ";
        try{
        pt=con.prepareStatement(sqll);
        pt.setString(1, userLogin.getText());
        pt.setString(2, passwordLogin.getText());
        rs=pt.executeQuery();
        if(rs.next()){
            JOptionPane.showMessageDialog(null, "Your Proposal has been ARCHIVED \n The Management will give you response ASAP \n  Thank You for your Patience ;) ");
        }else{
             String sql="select * from doc where uname=? and pwd=? ";
        try{
        pt=con.prepareStatement(sql);
        pt.setString(1, userLogin.getText());
        pt.setString(2, passwordLogin.getText());
        rs=pt.executeQuery();
        if(rs.next()){
            String dname=userLogin.getText(),dpass=passwordLogin.getText();
            new doctorDashBoard_Frame(dname,dpass).setVisible(true); dispose();
        }else {JOptionPane.showMessageDialog(null,"Invalid data");}
    }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
    }catch(HeadlessException | SQLException e){
             {JOptionPane.showMessageDialog(null, "Connection Failure !");}
            }

       
    }//GEN-LAST:event_login_Patient_ButtonActionPerformed

    private void signUpHere_LabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signUpHere_LabelMouseClicked
        // TODO add your handling code here:
        new doctorRegister_Frame().setVisible(true);dispose();
    }//GEN-LAST:event_signUpHere_LabelMouseClicked

    private void minimize_LabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimize_LabelMouseClicked
        // TODO add your handling code here:
        setState(JFrame.ICONIFIED);

    }//GEN-LAST:event_minimize_LabelMouseClicked

    private void close_LabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close_LabelMouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_close_LabelMouseClicked

    private void close_LabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close_LabelMouseEntered
        // TODO add your handling code here:
        close_Label.setBackground(new Color(255,102,102));
    }//GEN-LAST:event_close_LabelMouseEntered

    private void close_LabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close_LabelMouseExited
        // TODO add your handling code here:
        close_Label.setBackground(new Color(0,0,204));
    }//GEN-LAST:event_close_LabelMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(doctorLogin_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(doctorLogin_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(doctorLogin_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(doctorLogin_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new doctorLogin_Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel aboutUs_Label;
    private javax.swing.JLabel close_Label;
    private javax.swing.JLabel contactUs_Label;
    private javax.swing.JLabel doUHaveAcc_Label;
    private javax.swing.JPanel doctorRegister_Panel;
    private javax.swing.JPanel fillDoctorLogin_Panel;
    private javax.swing.JPanel footer;
    private javax.swing.JLabel goBack_Label;
    private javax.swing.JPanel header;
    private javax.swing.JLabel hospital;
    private javax.swing.JLabel hospitalIcon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel loginForm_Label1;
    private javax.swing.JButton login_Patient_Button;
    private javax.swing.JLabel minimize_Label;
    private javax.swing.JPasswordField passwordLogin;
    private javax.swing.JLabel signUpHere_Label;
    private javax.swing.JTextField userLogin;
    // End of variables declaration//GEN-END:variables
}