/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patient;

import ConnectionProvider.ConnectionProvider;
import Home.contactUs_Frame;
import Home.aboutUs_Frame;
import com.placeholder.PlaceHolder;
import java.awt.Color;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import java.lang.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Packiyaraj
 */
public class patientDashBoard_Frame extends javax.swing.JFrame {
    Connection con=null;
    ResultSet rs=null;
    PreparedStatement pt=null;
    Statement st=null;
    String dn,dp,dff,dll,dho,dmb,dg;
    /**
     * Creates new form patientDashBoard_Frame
     */
//    public patientDashBoard_Frame() {
//        initComponents();setExtendedState(JFrame.MAXIMIZED_BOTH);
//    }    
    PlaceHolder holder;
     public patientDashBoard_Frame( String dname,String dpass ,String fna,String lna,String ho,String mb,String g) {
        initComponents();setExtendedState(JFrame.MAXIMIZED_BOTH);
        holder=new PlaceHolder(symoom_box, "SYMPTOMS");
        holder=new PlaceHolder(description_Text, "DESCRIPTION");
        
         holder=new PlaceHolder(firstname, "FIRST NAME");
        holder=new PlaceHolder(lastname, "LAST NAME");
        holder=new PlaceHolder(address, "ADDRESS");
        holder=new PlaceHolder(mobile, "MOBILE");
         holder=new PlaceHolder(symptoms, "SYMPTOMS");
        
        
        dn=dname;dp=dpass;dff=fna;dll=lna;dho=ho;dmb=mb;dg=g;
        // NAME-------------------------------------------------
        con=ConnectionProvider.getCon();
         String sql="select * from patient where uname=? and pwd=? ";
        try{
        pt=con.prepareStatement(sql);
        pt.setString(1, dname);
        pt.setString(2, dpass);
        rs=pt.executeQuery();
        if(rs.next()){
            String fname=rs.getString(3);String lname=rs.getString(4);
            patientName.setText(fname+"  "+lname);
            
        }else {JOptionPane.showMessageDialog(null,"Invalid data");}
        
    }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
            }img();patDashB();
        
    }
     public void patDashB(){
          try {
             String sql1="select * from appoinment where uname=? and pwd=? ";
        pt=con.prepareStatement(sql1);
        pt.setString(1, dn);
        pt.setString(2, dp);
        rs=pt.executeQuery();
        if(rs.next()){docname.setText("You Have Appoinment");}
        else {docname.setText("NO Appoinment");}
         } catch (SQLException e) {}
          
           try {
             String sql111="select * from appoinment where uname=? and pwd=? ";
        pt=con.prepareStatement(sql111);
        pt.setString(1, dn);
        pt.setString(2, dp);
        rs=pt.executeQuery();
        if(rs.next()){String countofDoc=rs.getString("dateAdmit");symp1.setText(countofDoc);}
        else {symp1.setText("Not Admitted");}
         } catch (SQLException e) {}
           try {
             String sql111="select * from patient where uname=? and pwd=? ";
        pt=con.prepareStatement(sql111);
        pt.setString(1, dn);
        pt.setString(2, dp);
        rs=pt.executeQuery();
        if(rs.next()){String doNo=rs.getString("hom");docNo.setText(doNo);}
        else {docNo.setText("Not Registered");}
         } catch (SQLException e) {}
          
//         try {
//             String sql="select * from appoinment where uname=? and pwd=? ";
//              pt=con.prepareStatement(sql);
//                 rs=pt.executeQuery();
//        if(rs.next()){
//            String countofDoc=rs.getString("dateAdmit");
//            symp1.setText(countofDoc);}else {JOptionPane.showMessageDialog(null,"Something is Wrong");}
//         
//     }  catch (SQLException ex) {
//            Logger.getLogger(patientDashBoard_Frame.class.getName()).log(Level.SEVERE, null, ex);
//        }
//          try {
//             String sql="select hom from patient where uname=? and pwd=? ";
//              pt=con.prepareStatement(sql);
//                 rs=pt.executeQuery();
//        if(rs.next()){
//            String countofDoc=rs.getString("hom");
//            docNo.setText(countofDoc);}else {JOptionPane.showMessageDialog(null,"Not Registered");}
//         
//     }  catch (SQLException ex) {
//            Logger.getLogger(patientDashBoard_Frame.class.getName()).log(Level.SEVERE, null, ex);
//        }
     }
     public void img(){
         try {
             String sql333="select * from patient where uname=? and pwd=? ";
        pt=con.prepareStatement(sql333);
        pt.setString(1, dn);
        pt.setString(2, dp);
        rs=pt.executeQuery();
        if(rs.next()){String imgg=rs.getString("gen");
                    if("Male".equals(imgg)){patientPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/3.Patient/MalePatient.png")));}
                    else  if("Female".equals(imgg)){patientPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/3.Patient/FemalePatient.png")));}
                  else {patientPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/3.Patient/OthersPatient.png")));}
        
        } } catch (SQLException e) {}
     }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        patientDashBoardHeader = new javax.swing.JPanel();
        hospital = new javax.swing.JLabel();
        hospitalIcon = new javax.swing.JLabel();
        aboutUs_Label = new javax.swing.JLabel();
        contactUs_Label = new javax.swing.JLabel();
        goBack_Label = new javax.swing.JLabel();
        minimize_Label = new javax.swing.JLabel();
        close_Label = new javax.swing.JLabel();
        patientDashBoardFooter = new javax.swing.JPanel();
        patientProfile = new javax.swing.JPanel();
        appionment_Label = new javax.swing.JLabel();
        discharge_Label = new javax.swing.JLabel();
        dashboard_Label = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        patientPic = new javax.swing.JLabel();
        patientName = new javax.swing.JLabel();
        patient = new javax.swing.JLabel();
        dashBoard_TabbedPane1 = new javax.swing.JTabbedPane();
        dashBoardPaitent1 = new javax.swing.JPanel();
        doctorName_Patient1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        symp1 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        symptoms_Patient = new javax.swing.JPanel();
        docname = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        doctorNo_Patient = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        docNo = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        viewAppoinmentPatient = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        appoinmentPatient = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        bookAppoinmentPatient = new javax.swing.JPanel();
        fillAppoinment_Panel = new javax.swing.JPanel();
        description_Label = new javax.swing.JLabel();
        book_Button = new javax.swing.JButton();
        description_Text = new javax.swing.JTextField();
        description_Label1 = new javax.swing.JLabel();
        symoom_box = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        FillInner_Panel = new javax.swing.JPanel();
        firstname = new javax.swing.JTextField();
        address = new javax.swing.JTextField();
        symptoms = new javax.swing.JTextField();
        mobile = new javax.swing.JTextField();
        lastname = new javax.swing.JTextField();
        registerForm_Panel = new javax.swing.JPanel();
        registerForm_Label = new javax.swing.JLabel();
        registerPatient_Button = new javax.swing.JButton();
        registerPatient_Button2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        patientDashBoardHeader.setBackground(new java.awt.Color(0, 0, 204));

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

        javax.swing.GroupLayout patientDashBoardHeaderLayout = new javax.swing.GroupLayout(patientDashBoardHeader);
        patientDashBoardHeader.setLayout(patientDashBoardHeaderLayout);
        patientDashBoardHeaderLayout.setHorizontalGroup(
            patientDashBoardHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patientDashBoardHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(goBack_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(hospitalIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(hospital, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(680, 680, 680)
                .addComponent(aboutUs_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(contactUs_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(minimize_Label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(close_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        patientDashBoardHeaderLayout.setVerticalGroup(
            patientDashBoardHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patientDashBoardHeaderLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(goBack_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
            .addGroup(patientDashBoardHeaderLayout.createSequentialGroup()
                .addGroup(patientDashBoardHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(patientDashBoardHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(minimize_Label, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(close_Label, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(patientDashBoardHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(patientDashBoardHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(aboutUs_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(contactUs_Label))
                        .addGroup(patientDashBoardHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(hospitalIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                            .addComponent(hospital, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        patientDashBoardFooter.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout patientDashBoardFooterLayout = new javax.swing.GroupLayout(patientDashBoardFooter);
        patientDashBoardFooter.setLayout(patientDashBoardFooterLayout);
        patientDashBoardFooterLayout.setHorizontalGroup(
            patientDashBoardFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        patientDashBoardFooterLayout.setVerticalGroup(
            patientDashBoardFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 86, Short.MAX_VALUE)
        );

        patientProfile.setBackground(new java.awt.Color(0, 0, 255));

        appionment_Label.setBackground(new java.awt.Color(0, 0, 255));
        appionment_Label.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        appionment_Label.setForeground(new java.awt.Color(255, 255, 255));
        appionment_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/3.Patient/Appoinment.png"))); // NOI18N
        appionment_Label.setText("     Appoinment");
        appionment_Label.setOpaque(true);
        appionment_Label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                appionment_LabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                appionment_LabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                appionment_LabelMouseExited(evt);
            }
        });

        discharge_Label.setBackground(new java.awt.Color(0, 0, 255));
        discharge_Label.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        discharge_Label.setForeground(new java.awt.Color(255, 255, 255));
        discharge_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/3.Patient/PatProfile.png"))); // NOI18N
        discharge_Label.setText("     Profile");
        discharge_Label.setOpaque(true);
        discharge_Label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                discharge_LabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                discharge_LabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                discharge_LabelMouseExited(evt);
            }
        });

        dashboard_Label.setBackground(new java.awt.Color(0, 0, 255));
        dashboard_Label.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        dashboard_Label.setForeground(new java.awt.Color(255, 255, 255));
        dashboard_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/3.Patient/DashBoard.png"))); // NOI18N
        dashboard_Label.setText("     Dashboard");
        dashboard_Label.setOpaque(true);
        dashboard_Label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dashboard_LabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dashboard_LabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dashboard_LabelMouseExited(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 204));

        patientName.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        patientName.setForeground(new java.awt.Color(255, 255, 255));
        patientName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        patient.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        patient.setForeground(new java.awt.Color(255, 255, 255));
        patient.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patient.setText("Patient");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(patientName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(patient, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(patientPic, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(patientPic, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(patientName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(patient)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout patientProfileLayout = new javax.swing.GroupLayout(patientProfile);
        patientProfile.setLayout(patientProfileLayout);
        patientProfileLayout.setHorizontalGroup(
            patientProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(dashboard_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(appionment_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(discharge_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        patientProfileLayout.setVerticalGroup(
            patientProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patientProfileLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(dashboard_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(appionment_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(discharge_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dashBoard_TabbedPane1.setEnabled(false);
        dashBoard_TabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dashBoard_TabbedPane1MouseClicked(evt);
            }
        });

        doctorName_Patient1.setBackground(new java.awt.Color(102, 102, 0));
        doctorName_Patient1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.darkGray, java.awt.Color.darkGray));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Admit Date");

        symp1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        symp1.setForeground(new java.awt.Color(255, 255, 255));
        symp1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/3.Patient/Date.png"))); // NOI18N

        javax.swing.GroupLayout doctorName_Patient1Layout = new javax.swing.GroupLayout(doctorName_Patient1);
        doctorName_Patient1.setLayout(doctorName_Patient1Layout);
        doctorName_Patient1Layout.setHorizontalGroup(
            doctorName_Patient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(doctorName_Patient1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(doctorName_Patient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(doctorName_Patient1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                        .addGap(105, 105, 105))
                    .addGroup(doctorName_Patient1Layout.createSequentialGroup()
                        .addComponent(symp1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel26)
                        .addGap(7, 7, 7))))
        );
        doctorName_Patient1Layout.setVerticalGroup(
            doctorName_Patient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(doctorName_Patient1Layout.createSequentialGroup()
                .addGroup(doctorName_Patient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(doctorName_Patient1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(symp1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(doctorName_Patient1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel26)))
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addContainerGap())
        );

        symptoms_Patient.setBackground(new java.awt.Color(255, 0, 0));
        symptoms_Patient.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.darkGray, java.awt.Color.darkGray));

        docname.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        docname.setForeground(new java.awt.Color(255, 255, 255));
        docname.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Appoinment");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/3.Patient/AppoinmentDash.png"))); // NOI18N

        javax.swing.GroupLayout symptoms_PatientLayout = new javax.swing.GroupLayout(symptoms_Patient);
        symptoms_Patient.setLayout(symptoms_PatientLayout);
        symptoms_PatientLayout.setHorizontalGroup(
            symptoms_PatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(symptoms_PatientLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(symptoms_PatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                    .addGroup(symptoms_PatientLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(docname, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        symptoms_PatientLayout.setVerticalGroup(
            symptoms_PatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(symptoms_PatientLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(symptoms_PatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(symptoms_PatientLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(docname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addContainerGap())
        );

        doctorNo_Patient.setBackground(new java.awt.Color(153, 0, 153));
        doctorNo_Patient.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.darkGray, java.awt.Color.darkGray));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Address");

        docNo.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        docNo.setForeground(new java.awt.Color(255, 255, 255));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/3.Patient/Address.png"))); // NOI18N

        javax.swing.GroupLayout doctorNo_PatientLayout = new javax.swing.GroupLayout(doctorNo_Patient);
        doctorNo_Patient.setLayout(doctorNo_PatientLayout);
        doctorNo_PatientLayout.setHorizontalGroup(
            doctorNo_PatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(doctorNo_PatientLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(doctorNo_PatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                    .addGroup(doctorNo_PatientLayout.createSequentialGroup()
                        .addComponent(docNo, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        doctorNo_PatientLayout.setVerticalGroup(
            doctorNo_PatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(doctorNo_PatientLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(doctorNo_PatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(docNo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout dashBoardPaitent1Layout = new javax.swing.GroupLayout(dashBoardPaitent1);
        dashBoardPaitent1.setLayout(dashBoardPaitent1Layout);
        dashBoardPaitent1Layout.setHorizontalGroup(
            dashBoardPaitent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashBoardPaitent1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(symptoms_Patient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(doctorName_Patient1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(doctorNo_Patient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        dashBoardPaitent1Layout.setVerticalGroup(
            dashBoardPaitent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashBoardPaitent1Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(dashBoardPaitent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(doctorNo_Patient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(doctorName_Patient1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(symptoms_Patient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(387, Short.MAX_VALUE))
        );

        dashBoard_TabbedPane1.addTab("DashBoard", dashBoardPaitent1);

        jPanel2.setBackground(new java.awt.Color(153, 0, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.darkGray, java.awt.Color.darkGray));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel2MouseExited(evt);
            }
        });

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/3.Patient/PatientAppoinments.png"))); // NOI18N

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("View Appoinment");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(171, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );

        jPanel5.setBackground(new java.awt.Color(153, 0, 153));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.darkGray, java.awt.Color.darkGray));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel5MouseExited(evt);
            }
        });

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/3.Patient/BookAppoinment.png"))); // NOI18N

        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Book Appoinment");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(171, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel18)
                .addGap(21, 21, 21))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout viewAppoinmentPatientLayout = new javax.swing.GroupLayout(viewAppoinmentPatient);
        viewAppoinmentPatient.setLayout(viewAppoinmentPatientLayout);
        viewAppoinmentPatientLayout.setHorizontalGroup(
            viewAppoinmentPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewAppoinmentPatientLayout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(166, Short.MAX_VALUE))
        );
        viewAppoinmentPatientLayout.setVerticalGroup(
            viewAppoinmentPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewAppoinmentPatientLayout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(viewAppoinmentPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(362, Short.MAX_VALUE))
        );

        dashBoard_TabbedPane1.addTab("View Appionment", viewAppoinmentPatient);

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setRowHeight(25);
        jScrollPane1.setViewportView(jTable1);

        jButton5.setBackground(new java.awt.Color(255, 51, 51));
        jButton5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(51, 51, 51));
        jButton5.setText("Cancel Appoinment");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout appoinmentPatientLayout = new javax.swing.GroupLayout(appoinmentPatient);
        appoinmentPatient.setLayout(appoinmentPatientLayout);
        appoinmentPatientLayout.setHorizontalGroup(
            appoinmentPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(appoinmentPatientLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(appoinmentPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(144, Short.MAX_VALUE))
        );
        appoinmentPatientLayout.setVerticalGroup(
            appoinmentPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(appoinmentPatientLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(350, Short.MAX_VALUE))
        );

        dashBoard_TabbedPane1.addTab("Appoinment", appoinmentPatient);

        fillAppoinment_Panel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Book Appoinment", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18))); // NOI18N

        description_Label.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        description_Label.setText("Description");

        book_Button.setBackground(new java.awt.Color(0, 51, 255));
        book_Button.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        book_Button.setForeground(new java.awt.Color(255, 255, 255));
        book_Button.setText("Book");
        book_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                book_ButtonActionPerformed(evt);
            }
        });

        description_Text.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        description_Label1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        description_Label1.setText("Symptoms");

        symoom_box.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        javax.swing.GroupLayout fillAppoinment_PanelLayout = new javax.swing.GroupLayout(fillAppoinment_Panel);
        fillAppoinment_Panel.setLayout(fillAppoinment_PanelLayout);
        fillAppoinment_PanelLayout.setHorizontalGroup(
            fillAppoinment_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fillAppoinment_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fillAppoinment_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(description_Label1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(symoom_box, javax.swing.GroupLayout.PREFERRED_SIZE, 721, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(description_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(description_Text, javax.swing.GroupLayout.PREFERRED_SIZE, 721, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(book_Button, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        fillAppoinment_PanelLayout.setVerticalGroup(
            fillAppoinment_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fillAppoinment_PanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(description_Label1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(symoom_box, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(description_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(description_Text, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(book_Button)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout bookAppoinmentPatientLayout = new javax.swing.GroupLayout(bookAppoinmentPatient);
        bookAppoinmentPatient.setLayout(bookAppoinmentPatientLayout);
        bookAppoinmentPatientLayout.setHorizontalGroup(
            bookAppoinmentPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bookAppoinmentPatientLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(fillAppoinment_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(214, Short.MAX_VALUE))
        );
        bookAppoinmentPatientLayout.setVerticalGroup(
            bookAppoinmentPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bookAppoinmentPatientLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(fillAppoinment_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(184, Short.MAX_VALUE))
        );

        dashBoard_TabbedPane1.addTab("Book Appoinment", bookAppoinmentPatient);

        FillInner_Panel.setBackground(new java.awt.Color(255, 255, 255));

        firstname.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        firstname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                firstnameFocusGained(evt);
            }
        });
        firstname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstnameActionPerformed(evt);
            }
        });
        firstname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                firstnameKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                firstnameKeyReleased(evt);
            }
        });

        address.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressActionPerformed(evt);
            }
        });

        symptoms.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        symptoms.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                symptomsActionPerformed(evt);
            }
        });

        mobile.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        mobile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mobileActionPerformed(evt);
            }
        });

        lastname.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lastname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastnameActionPerformed(evt);
            }
        });

        registerForm_Panel.setBackground(new java.awt.Color(0, 51, 255));

        registerForm_Label.setBackground(new java.awt.Color(255, 255, 255));
        registerForm_Label.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        registerForm_Label.setForeground(new java.awt.Color(255, 255, 255));
        registerForm_Label.setText("Update Your Profile");

        javax.swing.GroupLayout registerForm_PanelLayout = new javax.swing.GroupLayout(registerForm_Panel);
        registerForm_Panel.setLayout(registerForm_PanelLayout);
        registerForm_PanelLayout.setHorizontalGroup(
            registerForm_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registerForm_PanelLayout.createSequentialGroup()
                .addGap(249, 249, 249)
                .addComponent(registerForm_Label)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        registerForm_PanelLayout.setVerticalGroup(
            registerForm_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registerForm_PanelLayout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(registerForm_Label)
                .addContainerGap())
        );

        registerPatient_Button.setBackground(new java.awt.Color(0, 0, 204));
        registerPatient_Button.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        registerPatient_Button.setForeground(new java.awt.Color(204, 255, 255));
        registerPatient_Button.setText("UPDATE");
        registerPatient_Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                registerPatient_ButtonMouseEntered(evt);
            }
        });
        registerPatient_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerPatient_ButtonActionPerformed(evt);
            }
        });

        registerPatient_Button2.setBackground(new java.awt.Color(0, 0, 204));
        registerPatient_Button2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        registerPatient_Button2.setForeground(new java.awt.Color(204, 255, 255));
        registerPatient_Button2.setText("Go Back");
        registerPatient_Button2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                registerPatient_Button2MouseEntered(evt);
            }
        });
        registerPatient_Button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerPatient_Button2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout FillInner_PanelLayout = new javax.swing.GroupLayout(FillInner_Panel);
        FillInner_Panel.setLayout(FillInner_PanelLayout);
        FillInner_PanelLayout.setHorizontalGroup(
            FillInner_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(registerForm_Panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FillInner_PanelLayout.createSequentialGroup()
                .addGroup(FillInner_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(firstname, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(address, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addGroup(FillInner_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lastname, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mobile, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58))
            .addGroup(FillInner_PanelLayout.createSequentialGroup()
                .addGroup(FillInner_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FillInner_PanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(registerPatient_Button)
                        .addGap(37, 37, 37)
                        .addComponent(registerPatient_Button2))
                    .addComponent(symptoms, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        FillInner_PanelLayout.setVerticalGroup(
            FillInner_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FillInner_PanelLayout.createSequentialGroup()
                .addComponent(registerForm_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(FillInner_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstname, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastname, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(FillInner_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(address)
                    .addComponent(mobile, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(symptoms, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(FillInner_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registerPatient_Button)
                    .addComponent(registerPatient_Button2))
                .addContainerGap(95, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addComponent(FillInner_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(220, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(FillInner_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(69, 69, 69))
        );

        dashBoard_TabbedPane1.addTab("   Update   ", jPanel3);

        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel4MouseExited(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(0, 204, 51));
        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.darkGray, java.awt.Color.darkGray));
        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel7MouseExited(evt);
            }
        });

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/3.Patient/ViewProfile.png"))); // NOI18N

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("View Profile");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(171, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );

        jPanel8.setBackground(new java.awt.Color(204, 0, 51));
        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.darkGray, java.awt.Color.darkGray));
        jPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel8MouseExited(evt);
            }
        });

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/3.Patient/Update.png"))); // NOI18N

        jLabel21.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Update Profile");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(171, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(166, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(362, Short.MAX_VALUE))
        );

        dashBoard_TabbedPane1.addTab("    Profile    ", jPanel4);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Last Name");

        jLabel4.setText("Address");

        jLabel6.setText("First Name");

        jLabel8.setText("User Name");

        jLabel10.setText("Gender");

        jLabel13.setText("Mobile");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(66, 66, 66)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(66, 66, 66)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(66, 66, 66)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(48, 48, 48))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        dashBoard_TabbedPane1.addTab("   Details   ", jPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(patientProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(dashBoard_TabbedPane1))
                        .addComponent(patientDashBoardFooter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(patientDashBoardHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(patientDashBoardHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dashBoard_TabbedPane1)
                    .addComponent(patientProfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addComponent(patientDashBoardFooter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void contactUs_LabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contactUs_LabelMouseClicked
        // TODO add your handling code here:
        new contactUs_Frame().setVisible(true);
        dispose();
    }//GEN-LAST:event_contactUs_LabelMouseClicked

    private void aboutUs_LabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutUs_LabelMouseClicked
        // TODO add your handling code here:
        new aboutUs_Frame().setVisible(true);
        dispose();
    }//GEN-LAST:event_aboutUs_LabelMouseClicked

    private void dashboard_LabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboard_LabelMouseClicked
        // TODO add your handling code here:
        dashBoard_TabbedPane1.setSelectedIndex(0);patDashB();
    }//GEN-LAST:event_dashboard_LabelMouseClicked

    private void goBack_LabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goBack_LabelMouseClicked
        // TODO add your handling code here:
        new patientLogin_Frame().setVisible(true); dispose();
    }//GEN-LAST:event_goBack_LabelMouseClicked

    private void appionment_LabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_appionment_LabelMouseClicked
        // TODO add your handling code here:
        dashBoard_TabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_appionment_LabelMouseClicked

    private void discharge_LabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_discharge_LabelMouseClicked
        // TODO add your handling code here:
        dashBoard_TabbedPane1.setSelectedIndex(5);
    }//GEN-LAST:event_discharge_LabelMouseClicked

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        // table--------------------------------------
        dashBoard_TabbedPane1.setSelectedIndex(2);
       String sql1="select uname as 'User Name',fname as 'First Name',lname as 'Last Name',hom as 'Address',mob as 'Mobile',dateAdmit as 'Date' from appoinment where uname=? and pwd=? ";
        try {
            pt=con.prepareStatement(sql1);
            pt.setString(1, dn);
            pt.setString(2, dp);
             rs=pt.executeQuery();
             jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {JOptionPane.showMessageDialog(null, "Connection Failure");}  
    }//GEN-LAST:event_jPanel2MouseClicked

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
        // TODO add your handling code here:
        setFocusable(true);
        holder=new PlaceHolder(symoom_box, "SYMPTOMS");
        holder=new PlaceHolder(description_Text, "DESCRIPTION");
        dashBoard_TabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_jPanel5MouseClicked

    private void dashboard_LabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboard_LabelMouseExited
        // TODO add your handling code here:       
        dashboard_Label.setBackground(new Color(0,0,255));
    }//GEN-LAST:event_dashboard_LabelMouseExited

    private void appionment_LabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_appionment_LabelMouseExited
        // TODO add your handling code here:       
        appionment_Label.setBackground(new Color(0,0,255));
    }//GEN-LAST:event_appionment_LabelMouseExited

    private void discharge_LabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_discharge_LabelMouseExited
        // TODO add your handling code here:       
        discharge_Label.setBackground(new Color(0,0,255));
    }//GEN-LAST:event_discharge_LabelMouseExited

    private void dashboard_LabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboard_LabelMouseEntered
        // TODO add your handling code here:
        dashboard_Label.setBackground(new Color(0,0,204));
    }//GEN-LAST:event_dashboard_LabelMouseEntered

    private void appionment_LabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_appionment_LabelMouseEntered
        // TODO add your handling code here:
        appionment_Label.setBackground(new Color(0,0,204));
    }//GEN-LAST:event_appionment_LabelMouseEntered

    private void discharge_LabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_discharge_LabelMouseEntered
        // TODO add your handling code here:
        discharge_Label.setBackground(new Color(0,0,204));
    }//GEN-LAST:event_discharge_LabelMouseEntered

    private void book_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_book_ButtonActionPerformed
        // TODO add your handling code here:
         try {
                
        pt=con.prepareStatement("insert into appoinment(uname,pwd,fname,lname,hom,mob,gen,sym,diag,med) values(?,?,?,?,?,?,?,' ',' ',' ')");
            pt.setString(1,dn );
            pt.setString(2,dp );
            pt.setString(3,dff );
            pt.setString(4,dll);
            pt.setString(5,dho );
            pt.setString(6,dmb );
            pt.setString(7,dg);
            pt.executeUpdate();
            } catch (SQLException e) {JOptionPane.showMessageDialog(null, "Connection Failure");} 

        try {
             String sql1="update appoinment set sym=? where uname=? and pwd=? ";
        pt=con.prepareStatement(sql1);
        pt.setString(1, symoom_box.getText());
        pt.setString(2, dn);
        pt.setString(3, dp);
        pt.executeUpdate(); JOptionPane.showMessageDialog(null, "Appoinment Booked");
        dashBoard_TabbedPane1.setSelectedIndex(1);
        symoom_box.setText("");description_Text.setText("");} 
        catch (SQLException e)  {JOptionPane.showMessageDialog(null, "Connection Failure");} 
    }//GEN-LAST:event_book_ButtonActionPerformed

    private void dashBoard_TabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashBoard_TabbedPane1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_dashBoard_TabbedPane1MouseClicked

    private void registerPatient_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerPatient_ButtonActionPerformed

        if(firstname.getText().isEmpty() || firstname.getText().equals("FIRST NAME")){JOptionPane.showMessageDialog(null, "Enter Valid Name");}
        else if(lastname.getText().isEmpty() || lastname.getText().equals("LAST NAME")){JOptionPane.showMessageDialog(null, "Enter Valid Name");}
        else if(address.getText().isEmpty() || address.getText().equals("ADDRESS")){JOptionPane.showMessageDialog(null, "Enter Address Name");}
        else if(mobile.getText().isEmpty() || mobile.getText().equals("MOBILE")){JOptionPane.showMessageDialog(null, "Enter Valid Mobile number");}
        else if(symptoms.getText().isEmpty() || symptoms.getText().equals("SYMPTOMS")){JOptionPane.showMessageDialog(null, "Enter Symptoms");}
        else{try{con=ConnectionProvider.getCon();

            pt=con.prepareStatement("update patient set fname=?,lname=?,hom=?,mob=?,sym=? where uname=?");
           pt.setString(1,firstname.getText() );
            pt.setString(2,lastname.getText() );
            pt.setString(3,address.getText() );
            pt.setString(4,mobile.getText() );
            pt.setString(5,symptoms.getText() );
            pt.setString(6, dn);
            pt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Updated");}
        catch(HeadlessException | SQLException e){JOptionPane.showMessageDialog(null, "Connection Failure");} }
         String sql33="select * from patient where uname=? and pwd=? ";
        try{
        pt=con.prepareStatement(sql33);
        pt.setString(1, dn);
        pt.setString(2, dp);
        rs=pt.executeQuery();
        if(rs.next()){
            String fname=rs.getString(3);String lname=rs.getString(4);
            patientName.setText(fname+"  "+lname);}
        dashBoard_TabbedPane1.setSelectedIndex(5);}
        catch(HeadlessException | SQLException e){JOptionPane.showMessageDialog(null, "Connection Failure");} 
    }//GEN-LAST:event_registerPatient_ButtonActionPerformed

    private void registerPatient_ButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerPatient_ButtonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_registerPatient_ButtonMouseEntered

    private void lastnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastnameActionPerformed

    private void mobileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mobileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mobileActionPerformed

    private void symptomsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_symptomsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_symptomsActionPerformed

    private void addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressActionPerformed

    private void firstnameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_firstnameKeyReleased

    }//GEN-LAST:event_firstnameKeyReleased

    private void firstnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_firstnameKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstnameKeyPressed

    private void firstnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstnameActionPerformed

    private void firstnameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_firstnameFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_firstnameFocusGained

    private void registerPatient_Button2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerPatient_Button2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_registerPatient_Button2MouseEntered

    private void registerPatient_Button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerPatient_Button2ActionPerformed
        // TODO add your handling code here:
     dashBoard_TabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_registerPatient_Button2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        int row=jTable1.getSelectedRow();
        String cell=jTable1.getModel().getValueAt(row, 0).toString();
        String sql="delete from appoinment where uname=?";
        try {
            pt=con.prepareStatement(sql);
            pt.setString(1, cell);
            pt.executeUpdate(); JOptionPane.showMessageDialog(null, "Appoinment Cancelled");
        } catch (SQLException e) {JOptionPane.showMessageDialog(null, "Connection Failure");} 
        String sql1="select * from appoinment where uname=? and pwd=? ";
        try {
            pt=con.prepareStatement(sql1);
            pt.setString(1, dn);
            pt.setString(2, dp);
            rs=pt.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e)  {JOptionPane.showMessageDialog(null, "Connection Failure");} 

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jPanel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseClicked
        // TODO add your handling code here:
        dashBoard_TabbedPane1.setSelectedIndex(6);
        String fl,ll,ul,hl,ml,gl;
        String sql="select fname,lname,uname,hom,mob,gen from patient where uname=?";
         try {
            pt=con.prepareStatement(sql);
        pt.setString(1, dn);
        rs=pt.executeQuery();
        if(rs.next()){
        fl=rs.getString(1);jLabel14.setText(fl);
       ll=rs.getString(2);jLabel15.setText(ll);
        ul=rs.getString(3);jLabel24.setText(ul);
        hl=rs.getString(4);jLabel23.setText(hl);
         ml=rs.getString(5);jLabel25.setText(ml);
        gl=rs.getString(6);jLabel22.setText(gl);
        }
            
        } catch (SQLException e) {JOptionPane.showMessageDialog(null, "Connection Failure");} 
    }//GEN-LAST:event_jPanel7MouseClicked

    private void jPanel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseClicked
        // TODO add your handling code here:
        dashBoard_TabbedPane1.setSelectedIndex(4);
    }//GEN-LAST:event_jPanel8MouseClicked

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

    private void jPanel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseExited
        // TODO add your handling code here:
       jPanel2.setBackground(new Color(153,0,0));
    }//GEN-LAST:event_jPanel2MouseExited

    private void jPanel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseEntered
        // TODO add your handling code here:
        jPanel2.setBackground(new Color(102,51,0));
    }//GEN-LAST:event_jPanel2MouseEntered

    private void jPanel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseExited
        // TODO add your handling code here:
        jPanel5.setBackground(new Color(153,0,153));
    }//GEN-LAST:event_jPanel5MouseExited

    private void jPanel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseEntered
        // TODO add your handling code here:
         jPanel5.setBackground(new Color(204,0,204));
    }//GEN-LAST:event_jPanel5MouseEntered

    private void jPanel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel4MouseExited

    private void jPanel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseExited
        // TODO add your handling code here:
         jPanel8.setBackground(new Color(204,0,51));
    }//GEN-LAST:event_jPanel8MouseExited

    private void jPanel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseEntered
        // TODO add your handling code here:
       jPanel8.setBackground(new Color(153,0,0));
    }//GEN-LAST:event_jPanel8MouseEntered

    private void jPanel7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseExited
        // TODO add your handling code here:
        jPanel7.setBackground(new Color(0,204,51));
    }//GEN-LAST:event_jPanel7MouseExited

    private void jPanel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseEntered
        // TODO add your handling code here:
         jPanel7.setBackground(new Color(0,153,51));
    }//GEN-LAST:event_jPanel7MouseEntered

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(patientDashBoard_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(patientDashBoard_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(patientDashBoard_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(patientDashBoard_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new patientDashBoard_Frame().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel FillInner_Panel;
    private javax.swing.JLabel aboutUs_Label;
    private javax.swing.JTextField address;
    private javax.swing.JLabel appionment_Label;
    private javax.swing.JPanel appoinmentPatient;
    private javax.swing.JPanel bookAppoinmentPatient;
    private javax.swing.JButton book_Button;
    private javax.swing.JLabel close_Label;
    private javax.swing.JLabel contactUs_Label;
    private javax.swing.JPanel dashBoardPaitent1;
    private javax.swing.JTabbedPane dashBoard_TabbedPane1;
    private javax.swing.JLabel dashboard_Label;
    private javax.swing.JLabel description_Label;
    private javax.swing.JLabel description_Label1;
    private javax.swing.JTextField description_Text;
    private javax.swing.JLabel discharge_Label;
    private javax.swing.JLabel docNo;
    private javax.swing.JLabel docname;
    private javax.swing.JPanel doctorName_Patient1;
    private javax.swing.JPanel doctorNo_Patient;
    private javax.swing.JPanel fillAppoinment_Panel;
    private javax.swing.JTextField firstname;
    private javax.swing.JLabel goBack_Label;
    private javax.swing.JLabel hospital;
    private javax.swing.JLabel hospitalIcon;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField lastname;
    private javax.swing.JLabel minimize_Label;
    private javax.swing.JTextField mobile;
    private javax.swing.JLabel patient;
    private javax.swing.JPanel patientDashBoardFooter;
    private javax.swing.JPanel patientDashBoardHeader;
    private javax.swing.JLabel patientName;
    private javax.swing.JLabel patientPic;
    private javax.swing.JPanel patientProfile;
    private javax.swing.JLabel registerForm_Label;
    private javax.swing.JPanel registerForm_Panel;
    private javax.swing.JButton registerPatient_Button;
    private javax.swing.JButton registerPatient_Button2;
    private javax.swing.JTextField symoom_box;
    private javax.swing.JLabel symp1;
    private javax.swing.JTextField symptoms;
    private javax.swing.JPanel symptoms_Patient;
    private javax.swing.JPanel viewAppoinmentPatient;
    // End of variables declaration//GEN-END:variables
}
