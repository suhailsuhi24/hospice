/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

import ConnectionProvider.ConnectionProvider;
import Home.contactUs_Frame;
import Home.aboutUs_Frame;
import com.placeholder.PlaceHolder;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Packiyaraj
 */
public class adminDashBoard_Frame extends javax.swing.JFrame {
     Connection con=null;
    ResultSet rs=null;
    PreparedStatement pt=null;
    Statement sst=null;
    String dn,dp;
    String ss,k;
    String fname1,lname1,ads,mol;
    String u,p,f,l,h,m,s,g,d,me,da;
    String ue,fe,le,hm,mi,dg,dm;
   // String firstname1,lastname1,mobile1,address1;
    
    /**
     * Creates new form adminDashBoard_Frame
     */
//    public adminDashBoard_Frame() {
//        initComponents();
//        setExtendedState(JFrame.MAXIMIZED_BOTH);
//        
//        con=ConnectionProvider.getCon();
//    }
     PlaceHolder holder;
      public adminDashBoard_Frame(String dashname,String dashpass) {
         dn=dashname;dp=dashpass;
         con=ConnectionProvider.getCon();
         setExtendedState(JFrame.MAXIMIZED_BOTH);
        initComponents();
     
         holder=new PlaceHolder(firstname, "FIRST NAME");
        holder=new PlaceHolder(lastname, "LAST NAME");
        holder=new PlaceHolder(username, "USER NAME");
        holder=new PlaceHolder(password, "PASSWORD");
        holder=new PlaceHolder(address, "ADDRESS");
        holder=new PlaceHolder(mobile, "MOBILE");
        
         holder=new PlaceHolder(firstname1, "FIRST NAME");
        holder=new PlaceHolder(lastname1, "LAST NAME");
        holder=new PlaceHolder(address1, "ADDRESS");
        holder=new PlaceHolder(mobile1, "MOBILE");
        
         holder=new PlaceHolder(firstname3, "FIRST NAME");
        holder=new PlaceHolder(lastname3, "LAST NAME");
        holder=new PlaceHolder(username2, "USER NAME");
        holder=new PlaceHolder(password2, "PASSWORD");
        holder=new PlaceHolder(address3, "ADDRESS");
        holder=new PlaceHolder(mobile3, "MOBILE");
        
        holder=new PlaceHolder(firstname4, "FIRST NAME");
        holder=new PlaceHolder(lastname4, "LAST NAME");
        holder=new PlaceHolder(address4, "ADDRESS");
        holder=new PlaceHolder(mobile4, "MOBILE");
        
        holder=new PlaceHolder(firstname2, "FIRST NAME");
        holder=new PlaceHolder(lastname2, "LAST NAME");
        holder=new PlaceHolder(username1, "USER NAME");
        holder=new PlaceHolder(password1, "PASSWORD");
        holder=new PlaceHolder(address2, "ADDRESS");
        holder=new PlaceHolder(mobile2, "MOBILE");
        holder=new PlaceHolder(symptoms, "SYMPTOMS");
        
          img();
       dash();
        
         String sql="select * from admin where uname=? and pwd=? ";
        try{
        pt=con.prepareStatement(sql);
        pt.setString(1, dn);
        pt.setString(2, dp);
        rs=pt.executeQuery();
        if(rs.next()){
            String fname=rs.getString(3);String lname=rs.getString(4);
            admintName.setText(fname+"  "+lname);
            
        }else {JOptionPane.showMessageDialog(null,"Invalid data");}
//                        String sql1="select img FROM admin WHERE uname=? and pwd=? ";
//                        try{ pt=con.prepareStatement(sql);
//                        pt=con.prepareStatement(sql1);
//                        pt.setString(1, dn);
//                        pt.setString(2, dp);
//                        rs=pt.executeQuery();
//                         if(rs.next()){
//                                 byte[] img=rs.getBytes("img");
//                                 ImageIcon image=new ImageIcon(img);
//                                 Image im=image.getImage();
//                                   Image imk=im.getScaledInstance(adminPic.getWidth(),adminPic.getHeight(),Image.SCALE_SMOOTH);
//                             }}catch(SQLException e){JOptionPane.showConfirmDialog(null, e);}
        
    }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
            }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
       public void dash(){
        try{
            String sql22="select count(uname) from doc ";
        pt=con.prepareStatement(sql22);
        rs=pt.executeQuery();
        if(rs.next()){
            String countofDoc=rs.getString("count(uname)");
            totDoc2.setText(countofDoc);}else {JOptionPane.showMessageDialog(null,"Invalid data");}
        }catch(HeadlessException | SQLException e){JOptionPane.showMessageDialog(null, e);}
        
        try{
            String sql22="select count(uname) from oldpatient ";
        pt=con.prepareStatement(sql22);
        rs=pt.executeQuery();
        if(rs.next()){
            String countofDoc=rs.getString("count(uname)");
            totPat.setText(countofDoc);}else {JOptionPane.showMessageDialog(null,"Invalid data");}
        }catch(HeadlessException | SQLException e){JOptionPane.showMessageDialog(null, e);}
        
        try{
            String sql22="select count(uname) from appoinment ";
        pt=con.prepareStatement(sql22);
        rs=pt.executeQuery();
        if(rs.next()){
            String countofDoc=rs.getString("count(uname)");
            totApp.setText(countofDoc);}else {JOptionPane.showMessageDialog(null,"Invalid data");}
        }catch(HeadlessException | SQLException e){JOptionPane.showMessageDialog(null, e);}}
    @SuppressWarnings("unchecked")
    public void tabledate(){
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd/MM/yyyy     HH:mm:ss");
        LocalDateTime now=LocalDateTime.now();
        jtabledate.setText(dtf.format(now));
    }
     public void dischargeDate(){
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now=LocalDateTime.now();
        jLabel34.setText(dtf.format(now));
    }
     public void total(){
         int room=Integer.parseInt(jTextField10.getText()),dr=Integer.parseInt(jTextField7.getText()),medi=Integer.parseInt(jTextField9.getText()),others=Integer.parseInt(jTextField8.getText());
         int tot=room+dr+medi+others;String totali=String.valueOf(tot);
         jTextField11.setText(totali);
     }
      public void img(){
         try {
             String sql333="select * from admin where uname=? and pwd=? ";
        pt=con.prepareStatement(sql333);
        pt.setString(1, dn);
        pt.setString(2, dp);
        rs=pt.executeQuery();
        if(rs.next()){String imgg=rs.getString("gen");
                    if("Male".equals(imgg)){adminPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/5.Admin/AdminPic.png")));}
                    else  if("Female".equals(imgg)){adminPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/5.Admin/AdminPic.png")));}
                  else {adminPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/5.Admin/AdminPic.png")));}
        
        } } catch (SQLException e) {}
     }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        adminProfile = new javax.swing.JPanel();
        appionment_Label = new javax.swing.JLabel();
        PatientAdmin_Label = new javax.swing.JLabel();
        dashboardAdmin_Label = new javax.swing.JLabel();
        doctorAdmin_Label = new javax.swing.JLabel();
        adminProFile_Panel = new javax.swing.JPanel();
        adminPic = new javax.swing.JLabel();
        admintName = new javax.swing.JLabel();
        admin = new javax.swing.JLabel();
        doctorAdmin_Label2 = new javax.swing.JLabel();
        adminDashBoardHeader = new javax.swing.JPanel();
        hospital = new javax.swing.JLabel();
        hospitalIcon = new javax.swing.JLabel();
        goBack_Label = new javax.swing.JLabel();
        aboutUs_Label = new javax.swing.JLabel();
        contactUs_Label = new javax.swing.JLabel();
        minimize_Label = new javax.swing.JLabel();
        close_Label = new javax.swing.JLabel();
        dashBoardAdmin_Tabbed = new javax.swing.JTabbedPane();
        dashBoardAdmin_Panel = new javax.swing.JPanel();
        totalDoctor = new javax.swing.JPanel();
        totDoc_Icon = new javax.swing.JLabel();
        totDOC = new javax.swing.JLabel();
        totDoc2 = new javax.swing.JLabel();
        totalPatient = new javax.swing.JPanel();
        totPat_Icon = new javax.swing.JLabel();
        totPAT = new javax.swing.JLabel();
        totPat = new javax.swing.JLabel();
        totalAppoinment = new javax.swing.JPanel();
        totApp_Icon = new javax.swing.JLabel();
        totAPP = new javax.swing.JLabel();
        totApp = new javax.swing.JLabel();
        doctorAdmin_Panel = new javax.swing.JPanel();
        docRecord = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        docApprove = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        docSpec = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        docApprove1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        approveDoctor_Panel = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        doctorSpecialisation_Panel = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        department3 = new javax.swing.JComboBox<>();
        patientAdmin_Panel = new javax.swing.JPanel();
        patrecord1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        patrecord2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        patrecord3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        dischargePatientAdmin_Panel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton8 = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        viewaAppoinmentAmin_Panel = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        jButton9 = new javax.swing.JButton();
        jtabledate = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        registerForm_Label1 = new javax.swing.JLabel();
        firstname1 = new javax.swing.JTextField();
        lastname1 = new javax.swing.JTextField();
        department2 = new javax.swing.JComboBox<>();
        address1 = new javax.swing.JTextField();
        registerPatient_Button1 = new javax.swing.JButton();
        mobile1 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        registerPatient_Button2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        registerForm_Label = new javax.swing.JLabel();
        firstname = new javax.swing.JTextField();
        lastname = new javax.swing.JTextField();
        username = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        gender = new javax.swing.JComboBox<>();
        department1 = new javax.swing.JComboBox<>();
        address = new javax.swing.JTextField();
        registerPatient_Button = new javax.swing.JButton();
        mobile = new javax.swing.JTextField();
        registerPatient_Button3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        FillInner_Panel = new javax.swing.JPanel();
        firstname2 = new javax.swing.JTextField();
        address2 = new javax.swing.JTextField();
        symptoms = new javax.swing.JTextField();
        username1 = new javax.swing.JTextField();
        mobile2 = new javax.swing.JTextField();
        lastname2 = new javax.swing.JTextField();
        password1 = new javax.swing.JPasswordField();
        gender1 = new javax.swing.JComboBox<>();
        registerForm_Panel = new javax.swing.JPanel();
        registerForm_Label2 = new javax.swing.JLabel();
        registerPatient_Button4 = new javax.swing.JButton();
        registerPatient_Button5 = new javax.swing.JButton();
        doctorRecord_Panel = new javax.swing.JPanel();
        jTextField3 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        patientRecordAdmin_Panel = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jLabel24 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        FillInner_Panel1 = new javax.swing.JPanel();
        firstname3 = new javax.swing.JTextField();
        address3 = new javax.swing.JTextField();
        username2 = new javax.swing.JTextField();
        mobile3 = new javax.swing.JTextField();
        lastname3 = new javax.swing.JTextField();
        password2 = new javax.swing.JPasswordField();
        registerForm_Panel1 = new javax.swing.JPanel();
        registerForm_Label3 = new javax.swing.JLabel();
        registerPatient_Button6 = new javax.swing.JButton();
        registerPatient_Button8 = new javax.swing.JButton();
        gender2 = new javax.swing.JComboBox<>();
        jPanel9 = new javax.swing.JPanel();
        patrecord4 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        patrecord5 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        FillInner_Panel2 = new javax.swing.JPanel();
        firstname4 = new javax.swing.JTextField();
        address4 = new javax.swing.JTextField();
        mobile4 = new javax.swing.JTextField();
        lastname4 = new javax.swing.JTextField();
        registerForm_Panel2 = new javax.swing.JPanel();
        registerForm_Label4 = new javax.swing.JLabel();
        registerPatient_Button7 = new javax.swing.JButton();
        registerPatient_Button9 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        FillInner_Panel3 = new javax.swing.JPanel();
        firstname5 = new javax.swing.JTextField();
        address5 = new javax.swing.JTextField();
        symptoms1 = new javax.swing.JTextField();
        mobile5 = new javax.swing.JTextField();
        lastname5 = new javax.swing.JTextField();
        registerForm_Panel3 = new javax.swing.JPanel();
        registerForm_Label5 = new javax.swing.JLabel();
        registerPatient_Button10 = new javax.swing.JButton();
        registerPatient_Button11 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        printdis = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton14 = new javax.swing.JButton();
        adminDashBoardFooter = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        adminProfile.setBackground(new java.awt.Color(0, 0, 255));

        appionment_Label.setBackground(new java.awt.Color(0, 0, 255));
        appionment_Label.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        appionment_Label.setForeground(new java.awt.Color(255, 255, 255));
        appionment_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/5.Admin/Appoinment.png"))); // NOI18N
        appionment_Label.setText("     Appoinments");
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

        PatientAdmin_Label.setBackground(new java.awt.Color(0, 0, 255));
        PatientAdmin_Label.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        PatientAdmin_Label.setForeground(new java.awt.Color(255, 255, 255));
        PatientAdmin_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/5.Admin/Patient.png"))); // NOI18N
        PatientAdmin_Label.setText("     Patient");
        PatientAdmin_Label.setOpaque(true);
        PatientAdmin_Label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PatientAdmin_LabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PatientAdmin_LabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PatientAdmin_LabelMouseExited(evt);
            }
        });

        dashboardAdmin_Label.setBackground(new java.awt.Color(0, 0, 255));
        dashboardAdmin_Label.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        dashboardAdmin_Label.setForeground(new java.awt.Color(255, 255, 255));
        dashboardAdmin_Label.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        dashboardAdmin_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/5.Admin/DashBoard.png"))); // NOI18N
        dashboardAdmin_Label.setText("     Dashboard");
        dashboardAdmin_Label.setOpaque(true);
        dashboardAdmin_Label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dashboardAdmin_LabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dashboardAdmin_LabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dashboardAdmin_LabelMouseExited(evt);
            }
        });
        dashboardAdmin_Label.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dashboardAdmin_LabelKeyPressed(evt);
            }
        });

        doctorAdmin_Label.setBackground(new java.awt.Color(0, 0, 255));
        doctorAdmin_Label.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        doctorAdmin_Label.setForeground(new java.awt.Color(255, 255, 255));
        doctorAdmin_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/5.Admin/Doctor.png"))); // NOI18N
        doctorAdmin_Label.setText("     Doctor");
        doctorAdmin_Label.setOpaque(true);
        doctorAdmin_Label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                doctorAdmin_LabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                doctorAdmin_LabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                doctorAdmin_LabelMouseExited(evt);
            }
        });
        doctorAdmin_Label.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                doctorAdmin_LabelKeyPressed(evt);
            }
        });

        adminProFile_Panel.setBackground(new java.awt.Color(0, 0, 205));

        admintName.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        admintName.setForeground(new java.awt.Color(255, 255, 255));
        admintName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        admin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        admin.setForeground(new java.awt.Color(255, 255, 255));
        admin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admin.setText("Admin");

        javax.swing.GroupLayout adminProFile_PanelLayout = new javax.swing.GroupLayout(adminProFile_Panel);
        adminProFile_Panel.setLayout(adminProFile_PanelLayout);
        adminProFile_PanelLayout.setHorizontalGroup(
            adminProFile_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(admintName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(adminProFile_PanelLayout.createSequentialGroup()
                .addGroup(adminProFile_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(adminProFile_PanelLayout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(admin, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(adminProFile_PanelLayout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(adminPic, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        adminProFile_PanelLayout.setVerticalGroup(
            adminProFile_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminProFile_PanelLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(adminPic, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(admintName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(admin)
                .addGap(24, 24, 24))
        );

        doctorAdmin_Label2.setBackground(new java.awt.Color(0, 0, 255));
        doctorAdmin_Label2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        doctorAdmin_Label2.setForeground(new java.awt.Color(255, 255, 255));
        doctorAdmin_Label2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/5.Admin/Admin.png"))); // NOI18N
        doctorAdmin_Label2.setText("     Admin");
        doctorAdmin_Label2.setOpaque(true);
        doctorAdmin_Label2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                doctorAdmin_Label2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                doctorAdmin_Label2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                doctorAdmin_Label2MouseExited(evt);
            }
        });
        doctorAdmin_Label2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                doctorAdmin_Label2KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout adminProfileLayout = new javax.swing.GroupLayout(adminProfile);
        adminProfile.setLayout(adminProfileLayout);
        adminProfileLayout.setHorizontalGroup(
            adminProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(appionment_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PatientAdmin_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(dashboardAdmin_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(doctorAdmin_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(adminProFile_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(doctorAdmin_Label2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        adminProfileLayout.setVerticalGroup(
            adminProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, adminProfileLayout.createSequentialGroup()
                .addComponent(adminProFile_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(dashboardAdmin_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(doctorAdmin_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PatientAdmin_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(appionment_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(doctorAdmin_Label2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        adminDashBoardHeader.setBackground(new java.awt.Color(0, 0, 204));

        hospital.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        hospital.setForeground(new java.awt.Color(255, 255, 255));
        hospital.setText("HOSPITAL");

        hospitalIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/2.Home/HospitalIcon.png"))); // NOI18N

        goBack_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/2.Home/Go Back.png"))); // NOI18N
        goBack_Label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                goBack_LabelMouseClicked(evt);
            }
        });

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

        javax.swing.GroupLayout adminDashBoardHeaderLayout = new javax.swing.GroupLayout(adminDashBoardHeader);
        adminDashBoardHeader.setLayout(adminDashBoardHeaderLayout);
        adminDashBoardHeaderLayout.setHorizontalGroup(
            adminDashBoardHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminDashBoardHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(goBack_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(hospitalIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(hospital, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 661, Short.MAX_VALUE)
                .addComponent(aboutUs_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(contactUs_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(minimize_Label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(close_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        adminDashBoardHeaderLayout.setVerticalGroup(
            adminDashBoardHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminDashBoardHeaderLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(goBack_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(adminDashBoardHeaderLayout.createSequentialGroup()
                .addGroup(adminDashBoardHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(adminDashBoardHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(minimize_Label, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(close_Label, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(adminDashBoardHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(hospitalIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, adminDashBoardHeaderLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(adminDashBoardHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(hospital)
                                .addComponent(contactUs_Label)
                                .addComponent(aboutUs_Label))
                            .addGap(11, 11, 11))))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        dashBoardAdmin_Tabbed.setEnabled(false);
        dashBoardAdmin_Tabbed.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N

        totalDoctor.setBackground(new java.awt.Color(255, 0, 0));
        totalDoctor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.black, java.awt.Color.black));

        totDoc_Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/5.Admin/TotalDoctors.png"))); // NOI18N

        totDOC.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        totDOC.setForeground(new java.awt.Color(255, 255, 255));
        totDOC.setText("Total Doctor");

        totDoc2.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        totDoc2.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout totalDoctorLayout = new javax.swing.GroupLayout(totalDoctor);
        totalDoctor.setLayout(totalDoctorLayout);
        totalDoctorLayout.setHorizontalGroup(
            totalDoctorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalDoctorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(totalDoctorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(totalDoctorLayout.createSequentialGroup()
                        .addComponent(totDOC, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 66, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, totalDoctorLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(totDoc2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totDoc_Icon, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );
        totalDoctorLayout.setVerticalGroup(
            totalDoctorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalDoctorLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(totDoc2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(totDOC, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, totalDoctorLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(totDoc_Icon, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        totalPatient.setBackground(new java.awt.Color(102, 51, 0));
        totalPatient.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.black, java.awt.Color.black));

        totPat_Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/5.Admin/TotalPatient.png"))); // NOI18N

        totPAT.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        totPAT.setForeground(new java.awt.Color(255, 255, 255));
        totPAT.setText("Total Patient");

        totPat.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        totPat.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout totalPatientLayout = new javax.swing.GroupLayout(totalPatient);
        totalPatient.setLayout(totalPatientLayout);
        totalPatientLayout.setHorizontalGroup(
            totalPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalPatientLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(totalPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(totalPatientLayout.createSequentialGroup()
                        .addComponent(totPAT, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 65, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, totalPatientLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(totPat, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totPat_Icon, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        totalPatientLayout.setVerticalGroup(
            totalPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalPatientLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(totPat, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(totPAT, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, totalPatientLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(totPat_Icon, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        totalAppoinment.setBackground(new java.awt.Color(51, 0, 204));
        totalAppoinment.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.black, java.awt.Color.black));

        totApp_Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/5.Admin/TotalAppoinment.png"))); // NOI18N

        totAPP.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        totAPP.setForeground(new java.awt.Color(255, 255, 255));
        totAPP.setText("Total Appoinment");

        totApp.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        totApp.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout totalAppoinmentLayout = new javax.swing.GroupLayout(totalAppoinment);
        totalAppoinment.setLayout(totalAppoinmentLayout);
        totalAppoinmentLayout.setHorizontalGroup(
            totalAppoinmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalAppoinmentLayout.createSequentialGroup()
                .addGroup(totalAppoinmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(totalAppoinmentLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(totAPP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(totalAppoinmentLayout.createSequentialGroup()
                        .addContainerGap(36, Short.MAX_VALUE)
                        .addComponent(totApp, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)))
                .addComponent(totApp_Icon, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        totalAppoinmentLayout.setVerticalGroup(
            totalAppoinmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalAppoinmentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(totApp, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(totAPP, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, totalAppoinmentLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(totApp_Icon, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout dashBoardAdmin_PanelLayout = new javax.swing.GroupLayout(dashBoardAdmin_Panel);
        dashBoardAdmin_Panel.setLayout(dashBoardAdmin_PanelLayout);
        dashBoardAdmin_PanelLayout.setHorizontalGroup(
            dashBoardAdmin_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashBoardAdmin_PanelLayout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(totalDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(totalPatient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(totalAppoinment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(92, Short.MAX_VALUE))
        );
        dashBoardAdmin_PanelLayout.setVerticalGroup(
            dashBoardAdmin_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dashBoardAdmin_PanelLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(dashBoardAdmin_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(totalDoctor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(totalPatient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(totalAppoinment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(396, Short.MAX_VALUE))
        );

        dashBoardAdmin_Tabbed.addTab("DashBoard", dashBoardAdmin_Panel);

        docRecord.setBackground(new java.awt.Color(255, 102, 0));
        docRecord.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.black, java.awt.Color.black));
        docRecord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                docRecordMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                docRecordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                docRecordMouseExited(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Doctor Record");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/5.Admin/DoctorRecord.png"))); // NOI18N

        javax.swing.GroupLayout docRecordLayout = new javax.swing.GroupLayout(docRecord);
        docRecord.setLayout(docRecordLayout);
        docRecordLayout.setHorizontalGroup(
            docRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, docRecordLayout.createSequentialGroup()
                .addGap(0, 113, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(docRecordLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        docRecordLayout.setVerticalGroup(
            docRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(docRecordLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        docApprove.setBackground(new java.awt.Color(153, 0, 0));
        docApprove.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.black, java.awt.Color.black));
        docApprove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                docApproveMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                docApproveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                docApproveMouseExited(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Register Doctor");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/5.Admin/RegisterDoctor.png"))); // NOI18N

        javax.swing.GroupLayout docApproveLayout = new javax.swing.GroupLayout(docApprove);
        docApprove.setLayout(docApproveLayout);
        docApproveLayout.setHorizontalGroup(
            docApproveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, docApproveLayout.createSequentialGroup()
                .addContainerGap(103, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
            .addGroup(docApproveLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        docApproveLayout.setVerticalGroup(
            docApproveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(docApproveLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        docSpec.setBackground(new java.awt.Color(153, 0, 153));
        docSpec.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.black, java.awt.Color.black));
        docSpec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                docSpecMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                docSpecMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                docSpecMouseExited(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Doctor Specialisation");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/5.Admin/Specialization.png"))); // NOI18N

        javax.swing.GroupLayout docSpecLayout = new javax.swing.GroupLayout(docSpec);
        docSpec.setLayout(docSpecLayout);
        docSpecLayout.setHorizontalGroup(
            docSpecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, docSpecLayout.createSequentialGroup()
                .addContainerGap(69, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
            .addGroup(docSpecLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        docSpecLayout.setVerticalGroup(
            docSpecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(docSpecLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        docApprove1.setBackground(new java.awt.Color(0, 204, 0));
        docApprove1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.black, java.awt.Color.black));
        docApprove1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                docApprove1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                docApprove1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                docApprove1MouseExited(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Approve Doctor");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/5.Admin/ApproveDoctor.png"))); // NOI18N
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel9MouseExited(evt);
            }
        });

        javax.swing.GroupLayout docApprove1Layout = new javax.swing.GroupLayout(docApprove1);
        docApprove1.setLayout(docApprove1Layout);
        docApprove1Layout.setHorizontalGroup(
            docApprove1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, docApprove1Layout.createSequentialGroup()
                .addContainerGap(96, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addContainerGap())
            .addGroup(docApprove1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        docApprove1Layout.setVerticalGroup(
            docApprove1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(docApprove1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout doctorAdmin_PanelLayout = new javax.swing.GroupLayout(doctorAdmin_Panel);
        doctorAdmin_Panel.setLayout(doctorAdmin_PanelLayout);
        doctorAdmin_PanelLayout.setHorizontalGroup(
            doctorAdmin_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(doctorAdmin_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(docRecord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(docSpec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(docApprove1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(docApprove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );
        doctorAdmin_PanelLayout.setVerticalGroup(
            doctorAdmin_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(doctorAdmin_PanelLayout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addGroup(doctorAdmin_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(docApprove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(docSpec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(docRecord, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(docApprove1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(353, Short.MAX_VALUE))
        );

        dashBoardAdmin_Tabbed.addTab("Doctor", doctorAdmin_Panel);

        jTable4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10", "Title 11"
            }
        ));
        jTable4.setRowHeight(25);
        jScrollPane4.setViewportView(jTable4);

        jButton6.setBackground(new java.awt.Color(0, 255, 0));
        jButton6.setForeground(new java.awt.Color(51, 51, 51));
        jButton6.setText("Approve");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(255, 51, 51));
        jButton7.setForeground(new java.awt.Color(51, 51, 51));
        jButton7.setText("Reject");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout approveDoctor_PanelLayout = new javax.swing.GroupLayout(approveDoctor_Panel);
        approveDoctor_Panel.setLayout(approveDoctor_PanelLayout);
        approveDoctor_PanelLayout.setHorizontalGroup(
            approveDoctor_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(approveDoctor_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(approveDoctor_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(approveDoctor_PanelLayout.createSequentialGroup()
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1026, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        approveDoctor_PanelLayout.setVerticalGroup(
            approveDoctor_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(approveDoctor_PanelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(approveDoctor_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        dashBoardAdmin_Tabbed.addTab("Approval", approveDoctor_Panel);

        jTable5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable5.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable5.setRowHeight(25);
        jScrollPane5.setViewportView(jTable5);

        department3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        department3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "General", "Cardiologist", "Neurologist", "Orthopaedic", "Psychiatrists", "Pulmonologist", "Radiologist", "Oncologist", "Paediatrician", "Gynaecologist", "Endocrinologist", " ", " " }));
        department3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                department3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout doctorSpecialisation_PanelLayout = new javax.swing.GroupLayout(doctorSpecialisation_Panel);
        doctorSpecialisation_Panel.setLayout(doctorSpecialisation_PanelLayout);
        doctorSpecialisation_PanelLayout.setHorizontalGroup(
            doctorSpecialisation_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(doctorSpecialisation_PanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(doctorSpecialisation_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(department3, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 917, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(142, Short.MAX_VALUE))
        );
        doctorSpecialisation_PanelLayout.setVerticalGroup(
            doctorSpecialisation_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(doctorSpecialisation_PanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(department3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
        );

        dashBoardAdmin_Tabbed.addTab("Specialization", doctorSpecialisation_Panel);

        patrecord1.setBackground(new java.awt.Color(255, 153, 0));
        patrecord1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.black, java.awt.Color.black));
        patrecord1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                patrecord1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                patrecord1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                patrecord1MouseExited(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Patient Record");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/5.Admin/PatientRecords.png"))); // NOI18N

        javax.swing.GroupLayout patrecord1Layout = new javax.swing.GroupLayout(patrecord1);
        patrecord1.setLayout(patrecord1Layout);
        patrecord1Layout.setHorizontalGroup(
            patrecord1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patrecord1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(150, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, patrecord1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        patrecord1Layout.setVerticalGroup(
            patrecord1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patrecord1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        patrecord2.setBackground(new java.awt.Color(153, 0, 153));
        patrecord2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.black, java.awt.Color.black));
        patrecord2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                patrecord2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                patrecord2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                patrecord2MouseExited(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Discharge Patient");

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/5.Admin/Discharge.png"))); // NOI18N

        javax.swing.GroupLayout patrecord2Layout = new javax.swing.GroupLayout(patrecord2);
        patrecord2.setLayout(patrecord2Layout);
        patrecord2Layout.setHorizontalGroup(
            patrecord2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patrecord2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(151, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, patrecord2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        patrecord2Layout.setVerticalGroup(
            patrecord2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patrecord2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        patrecord3.setBackground(new java.awt.Color(0, 51, 204));
        patrecord3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.black, java.awt.Color.black));
        patrecord3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                patrecord3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                patrecord3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                patrecord3MouseExited(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Book Appoinment ");

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/5.Admin/BookAppoinment.png"))); // NOI18N

        javax.swing.GroupLayout patrecord3Layout = new javax.swing.GroupLayout(patrecord3);
        patrecord3.setLayout(patrecord3Layout);
        patrecord3Layout.setHorizontalGroup(
            patrecord3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patrecord3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(127, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, patrecord3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        patrecord3Layout.setVerticalGroup(
            patrecord3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patrecord3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout patientAdmin_PanelLayout = new javax.swing.GroupLayout(patientAdmin_Panel);
        patientAdmin_Panel.setLayout(patientAdmin_PanelLayout);
        patientAdmin_PanelLayout.setHorizontalGroup(
            patientAdmin_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patientAdmin_PanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(patrecord1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(patrecord2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(patrecord3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        patientAdmin_PanelLayout.setVerticalGroup(
            patientAdmin_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patientAdmin_PanelLayout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addGroup(patientAdmin_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(patrecord1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(patrecord2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(patrecord3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(329, Short.MAX_VALUE))
        );

        dashBoardAdmin_Tabbed.addTab("Patient", patientAdmin_Panel);

        jTable2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable2.setRowHeight(25);
        jScrollPane2.setViewportView(jTable2);

        jButton8.setBackground(new java.awt.Color(255, 204, 0));
        jButton8.setForeground(new java.awt.Color(51, 51, 51));
        jButton8.setText("Discharge");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel27.setText("Details");

        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField6KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout dischargePatientAdmin_PanelLayout = new javax.swing.GroupLayout(dischargePatientAdmin_Panel);
        dischargePatientAdmin_Panel.setLayout(dischargePatientAdmin_PanelLayout);
        dischargePatientAdmin_PanelLayout.setHorizontalGroup(
            dischargePatientAdmin_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dischargePatientAdmin_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dischargePatientAdmin_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1036, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(dischargePatientAdmin_PanelLayout.createSequentialGroup()
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        dischargePatientAdmin_PanelLayout.setVerticalGroup(
            dischargePatientAdmin_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dischargePatientAdmin_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dischargePatientAdmin_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField6)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8))
                .addGap(25, 25, 25)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84))
        );

        dashBoardAdmin_Tabbed.addTab("Discharge", dischargePatientAdmin_Panel);

        jTable7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable7.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable7.setRowHeight(25);
        jScrollPane7.setViewportView(jTable7);

        jButton9.setBackground(new java.awt.Color(255, 0, 0));
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("Delete Appoinment");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jtabledate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButton1.setBackground(new java.awt.Color(0, 255, 51));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/5.Admin/Printer.png"))); // NOI18N
        jButton1.setText("   Print All Appoinments");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel26.setText("Details");

        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField5KeyReleased(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel28.setText("Medicines");

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel29.setText("Diagnosis");

        jButton2.setBackground(new java.awt.Color(0, 0, 204));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("UPDATE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextField1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jTextField2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29)
                .addGap(35, 35, 35)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout viewaAppoinmentAmin_PanelLayout = new javax.swing.GroupLayout(viewaAppoinmentAmin_Panel);
        viewaAppoinmentAmin_Panel.setLayout(viewaAppoinmentAmin_PanelLayout);
        viewaAppoinmentAmin_PanelLayout.setHorizontalGroup(
            viewaAppoinmentAmin_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewaAppoinmentAmin_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(viewaAppoinmentAmin_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(viewaAppoinmentAmin_PanelLayout.createSequentialGroup()
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(165, 165, 165)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtabledate, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 1028, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        viewaAppoinmentAmin_PanelLayout.setVerticalGroup(
            viewaAppoinmentAmin_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewaAppoinmentAmin_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(viewaAppoinmentAmin_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtabledate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, viewaAppoinmentAmin_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField5)
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(viewaAppoinmentAmin_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton9)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(214, 214, 214))
        );

        dashBoardAdmin_Tabbed.addTab("Appoinment", viewaAppoinmentAmin_Panel);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(0, 0, 204));

        registerForm_Label1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        registerForm_Label1.setForeground(new java.awt.Color(255, 255, 255));
        registerForm_Label1.setText("Update Doctor");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(231, 231, 231)
                .addComponent(registerForm_Label1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(registerForm_Label1)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        firstname1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                firstname1FocusLost(evt);
            }
        });
        firstname1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstname1ActionPerformed(evt);
            }
        });

        lastname1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lastname1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastname1ActionPerformed(evt);
            }
        });

        department2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        department2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "General", "Cardiologist", "Neurologist", "Orthopaedic", "Psychiatrists", "Pulmonologist", "Radiologist", "Oncologist", "Paediatrician", "Gynaecologist", "Endocrinologist", " ", " " }));

        address1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        address1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                address1ActionPerformed(evt);
            }
        });

        registerPatient_Button1.setBackground(new java.awt.Color(0, 0, 204));
        registerPatient_Button1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        registerPatient_Button1.setForeground(new java.awt.Color(204, 255, 255));
        registerPatient_Button1.setText("Update");
        registerPatient_Button1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                registerPatient_Button1MouseEntered(evt);
            }
        });
        registerPatient_Button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerPatient_Button1ActionPerformed(evt);
            }
        });

        mobile1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        mobile1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mobile1ActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(registerPatient_Button1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(registerPatient_Button2)
                        .addGap(25, 25, 25))
                    .addComponent(firstname1, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                    .addComponent(address1)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(58, 58, 58)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mobile1, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                    .addComponent(lastname1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(department2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstname1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastname1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(address1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mobile1))
                .addGap(44, 44, 44)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(department2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registerPatient_Button1)
                    .addComponent(registerPatient_Button2))
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(253, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(234, 234, 234))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(107, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(108, 108, 108))
        );

        dashBoardAdmin_Tabbed.addTab("UpdateDoctor", jPanel1);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(0, 51, 255));

        registerForm_Label.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        registerForm_Label.setForeground(new java.awt.Color(255, 255, 255));
        registerForm_Label.setText("Register to Hospital");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(235, 235, 235)
                .addComponent(registerForm_Label)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(registerForm_Label)
                .addContainerGap())
        );

        firstname.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        firstname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                firstnameFocusLost(evt);
            }
        });
        firstname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstnameActionPerformed(evt);
            }
        });

        lastname.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lastname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastnameActionPerformed(evt);
            }
        });

        username.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });

        gender.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", "Others" }));

        department1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        department1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "General", "Cardiologist", "Neurologist", "Orthopaedic", "Psychiatrists", "Pulmonologist", "Radiologist", "Oncologist", "Paediatrician", "Gynaecologist", "Endocrinologist", " ", " " }));

        address.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressActionPerformed(evt);
            }
        });

        registerPatient_Button.setBackground(new java.awt.Color(0, 0, 204));
        registerPatient_Button.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        registerPatient_Button.setForeground(new java.awt.Color(204, 255, 255));
        registerPatient_Button.setText("Register");
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

        mobile.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        mobile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mobileActionPerformed(evt);
            }
        });

        registerPatient_Button3.setBackground(new java.awt.Color(0, 0, 204));
        registerPatient_Button3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        registerPatient_Button3.setForeground(new java.awt.Color(204, 255, 255));
        registerPatient_Button3.setText("Go Back");
        registerPatient_Button3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                registerPatient_Button3MouseEntered(evt);
            }
        });
        registerPatient_Button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerPatient_Button3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(gender, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(firstname, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                    .addComponent(username, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(address))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(mobile)
                    .addComponent(lastname, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(password, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(department1, javax.swing.GroupLayout.Alignment.TRAILING, 0, 268, Short.MAX_VALUE)))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(registerPatient_Button)
                .addGap(53, 53, 53)
                .addComponent(registerPatient_Button3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(department1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mobile))
                .addGap(61, 61, 61)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registerPatient_Button3)
                    .addComponent(registerPatient_Button))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(236, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(222, 222, 222))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(85, Short.MAX_VALUE))
        );

        dashBoardAdmin_Tabbed.addTab("RegisterDoctor", jPanel2);

        FillInner_Panel.setBackground(new java.awt.Color(255, 255, 255));

        firstname2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        firstname2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                firstname2FocusGained(evt);
            }
        });
        firstname2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstname2ActionPerformed(evt);
            }
        });
        firstname2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                firstname2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                firstname2KeyReleased(evt);
            }
        });

        address2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        address2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                address2ActionPerformed(evt);
            }
        });

        symptoms.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        symptoms.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                symptomsActionPerformed(evt);
            }
        });

        username1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        username1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                username1FocusLost(evt);
            }
        });
        username1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                username1ActionPerformed(evt);
            }
        });

        mobile2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        mobile2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mobile2ActionPerformed(evt);
            }
        });

        lastname2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lastname2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastname2ActionPerformed(evt);
            }
        });

        password1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                password1ActionPerformed(evt);
            }
        });

        gender1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        gender1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", "Others" }));

        registerForm_Panel.setBackground(new java.awt.Color(0, 51, 204));

        registerForm_Label2.setBackground(new java.awt.Color(255, 255, 255));
        registerForm_Label2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        registerForm_Label2.setForeground(new java.awt.Color(255, 255, 255));
        registerForm_Label2.setText("Register to Hospital");

        javax.swing.GroupLayout registerForm_PanelLayout = new javax.swing.GroupLayout(registerForm_Panel);
        registerForm_Panel.setLayout(registerForm_PanelLayout);
        registerForm_PanelLayout.setHorizontalGroup(
            registerForm_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registerForm_PanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(registerForm_Label2)
                .addGap(244, 244, 244))
        );
        registerForm_PanelLayout.setVerticalGroup(
            registerForm_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registerForm_PanelLayout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(registerForm_Label2)
                .addGap(21, 21, 21))
        );

        registerPatient_Button4.setBackground(new java.awt.Color(0, 0, 204));
        registerPatient_Button4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        registerPatient_Button4.setForeground(new java.awt.Color(204, 255, 255));
        registerPatient_Button4.setText("Register");
        registerPatient_Button4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                registerPatient_Button4MouseEntered(evt);
            }
        });
        registerPatient_Button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerPatient_Button4ActionPerformed(evt);
            }
        });

        registerPatient_Button5.setBackground(new java.awt.Color(0, 0, 204));
        registerPatient_Button5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        registerPatient_Button5.setForeground(new java.awt.Color(204, 255, 255));
        registerPatient_Button5.setText("Go Back");
        registerPatient_Button5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                registerPatient_Button5MouseEntered(evt);
            }
        });
        registerPatient_Button5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerPatient_Button5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout FillInner_PanelLayout = new javax.swing.GroupLayout(FillInner_Panel);
        FillInner_Panel.setLayout(FillInner_PanelLayout);
        FillInner_PanelLayout.setHorizontalGroup(
            FillInner_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(registerForm_Panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(FillInner_PanelLayout.createSequentialGroup()
                .addGroup(FillInner_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(FillInner_PanelLayout.createSequentialGroup()
                        .addComponent(registerPatient_Button4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(registerPatient_Button5))
                    .addComponent(symptoms)
                    .addComponent(username1)
                    .addComponent(firstname2)
                    .addComponent(address2, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                .addGroup(FillInner_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(password1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastname2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gender1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mobile2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        FillInner_PanelLayout.setVerticalGroup(
            FillInner_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FillInner_PanelLayout.createSequentialGroup()
                .addComponent(registerForm_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(FillInner_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FillInner_PanelLayout.createSequentialGroup()
                        .addComponent(firstname2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(username1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(address2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(symptoms, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(FillInner_PanelLayout.createSequentialGroup()
                        .addComponent(lastname2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(password1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(mobile2)
                        .addGap(29, 29, 29)
                        .addComponent(gender1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(FillInner_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registerPatient_Button4)
                    .addComponent(registerPatient_Button5))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1080, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(225, 225, 225)
                    .addComponent(FillInner_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(206, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 595, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(96, 96, 96)
                    .addComponent(FillInner_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(96, 96, 96)))
        );

        dashBoardAdmin_Tabbed.addTab("BookAppoinment", jPanel3);

        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField3KeyReleased(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Details");

        jButton4.setBackground(new java.awt.Color(51, 255, 51));
        jButton4.setForeground(new java.awt.Color(51, 51, 51));
        jButton4.setText("Update Doctor");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 51, 51));
        jButton5.setForeground(new java.awt.Color(51, 51, 51));
        jButton5.setText("Delete");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout doctorRecord_PanelLayout = new javax.swing.GroupLayout(doctorRecord_Panel);
        doctorRecord_Panel.setLayout(doctorRecord_PanelLayout);
        doctorRecord_PanelLayout.setHorizontalGroup(
            doctorRecord_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(doctorRecord_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1058, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
            .addGroup(doctorRecord_PanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );
        doctorRecord_PanelLayout.setVerticalGroup(
            doctorRecord_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, doctorRecord_PanelLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(doctorRecord_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(doctorRecord_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField3)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(doctorRecord_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton4)
                        .addComponent(jButton5)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
        );

        dashBoardAdmin_Tabbed.addTab("DoctorRecord", doctorRecord_Panel);

        jTable6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        jTable6.setRowHeight(25);
        jScrollPane6.setViewportView(jTable6);

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setText("Details");

        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField4KeyReleased(evt);
            }
        });

        jButton12.setBackground(new java.awt.Color(51, 255, 51));
        jButton12.setForeground(new java.awt.Color(51, 51, 51));
        jButton12.setText("Update Patient");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setBackground(new java.awt.Color(255, 51, 51));
        jButton13.setForeground(new java.awt.Color(51, 51, 51));
        jButton13.setText("Delete");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout patientRecordAdmin_PanelLayout = new javax.swing.GroupLayout(patientRecordAdmin_Panel);
        patientRecordAdmin_Panel.setLayout(patientRecordAdmin_PanelLayout);
        patientRecordAdmin_PanelLayout.setHorizontalGroup(
            patientRecordAdmin_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patientRecordAdmin_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(patientRecordAdmin_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 1042, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(patientRecordAdmin_PanelLayout.createSequentialGroup()
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(314, 314, 314)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        patientRecordAdmin_PanelLayout.setVerticalGroup(
            patientRecordAdmin_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patientRecordAdmin_PanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(patientRecordAdmin_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(patientRecordAdmin_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField4)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(patientRecordAdmin_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton12)
                        .addComponent(jButton13)))
                .addGap(19, 19, 19)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        dashBoardAdmin_Tabbed.addTab("PatientRecord", patientRecordAdmin_Panel);

        FillInner_Panel1.setBackground(new java.awt.Color(255, 255, 255));

        firstname3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        firstname3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                firstname3FocusGained(evt);
            }
        });
        firstname3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstname3ActionPerformed(evt);
            }
        });
        firstname3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                firstname3KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                firstname3KeyReleased(evt);
            }
        });

        address3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        address3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                address3ActionPerformed(evt);
            }
        });

        username2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        username2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                username2FocusLost(evt);
            }
        });
        username2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                username2ActionPerformed(evt);
            }
        });

        mobile3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        mobile3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mobile3ActionPerformed(evt);
            }
        });

        lastname3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lastname3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastname3ActionPerformed(evt);
            }
        });

        password2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                password2ActionPerformed(evt);
            }
        });

        registerForm_Panel1.setBackground(new java.awt.Color(0, 51, 204));

        registerForm_Label3.setBackground(new java.awt.Color(255, 255, 255));
        registerForm_Label3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        registerForm_Label3.setForeground(new java.awt.Color(255, 255, 255));
        registerForm_Label3.setText("ADD NEW ADMIN");

        javax.swing.GroupLayout registerForm_Panel1Layout = new javax.swing.GroupLayout(registerForm_Panel1);
        registerForm_Panel1.setLayout(registerForm_Panel1Layout);
        registerForm_Panel1Layout.setHorizontalGroup(
            registerForm_Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registerForm_Panel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(registerForm_Label3)
                .addGap(243, 243, 243))
        );
        registerForm_Panel1Layout.setVerticalGroup(
            registerForm_Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registerForm_Panel1Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(registerForm_Label3)
                .addGap(19, 19, 19))
        );

        registerPatient_Button6.setBackground(new java.awt.Color(0, 0, 204));
        registerPatient_Button6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        registerPatient_Button6.setForeground(new java.awt.Color(204, 255, 255));
        registerPatient_Button6.setText("Register");
        registerPatient_Button6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                registerPatient_Button6MouseEntered(evt);
            }
        });
        registerPatient_Button6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerPatient_Button6ActionPerformed(evt);
            }
        });

        registerPatient_Button8.setBackground(new java.awt.Color(0, 0, 204));
        registerPatient_Button8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        registerPatient_Button8.setForeground(new java.awt.Color(204, 255, 255));
        registerPatient_Button8.setText("Go Back");
        registerPatient_Button8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                registerPatient_Button8MouseEntered(evt);
            }
        });
        registerPatient_Button8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerPatient_Button8ActionPerformed(evt);
            }
        });

        gender2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        gender2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", "Others" }));

        javax.swing.GroupLayout FillInner_Panel1Layout = new javax.swing.GroupLayout(FillInner_Panel1);
        FillInner_Panel1.setLayout(FillInner_Panel1Layout);
        FillInner_Panel1Layout.setHorizontalGroup(
            FillInner_Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(registerForm_Panel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(FillInner_Panel1Layout.createSequentialGroup()
                .addGroup(FillInner_Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(FillInner_Panel1Layout.createSequentialGroup()
                        .addComponent(registerPatient_Button6)
                        .addGap(73, 73, 73)
                        .addComponent(registerPatient_Button8))
                    .addGroup(FillInner_Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(username2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(firstname3, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(address3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                        .addComponent(gender2, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                .addGroup(FillInner_Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(password2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastname3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mobile3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );
        FillInner_Panel1Layout.setVerticalGroup(
            FillInner_Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FillInner_Panel1Layout.createSequentialGroup()
                .addComponent(registerForm_Panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(FillInner_Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FillInner_Panel1Layout.createSequentialGroup()
                        .addComponent(firstname3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(username2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(address3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(FillInner_Panel1Layout.createSequentialGroup()
                        .addComponent(lastname3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(password2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(mobile3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gender2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(FillInner_Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registerPatient_Button6)
                    .addComponent(registerPatient_Button8))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(201, 201, 201)
                .addComponent(FillInner_Panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(230, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(FillInner_Panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(96, 96, 96))
        );

        dashBoardAdmin_Tabbed.addTab("NewAdmin", jPanel8);

        patrecord4.setBackground(new java.awt.Color(0, 51, 204));
        patrecord4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.black, java.awt.Color.black));
        patrecord4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                patrecord4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                patrecord4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                patrecord4MouseExited(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Update Profile");

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/5.Admin/AdminProfile.png"))); // NOI18N

        javax.swing.GroupLayout patrecord4Layout = new javax.swing.GroupLayout(patrecord4);
        patrecord4.setLayout(patrecord4Layout);
        patrecord4Layout.setHorizontalGroup(
            patrecord4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patrecord4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(169, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, patrecord4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        patrecord4Layout.setVerticalGroup(
            patrecord4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patrecord4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );

        patrecord5.setBackground(new java.awt.Color(255, 0, 51));
        patrecord5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.black, java.awt.Color.black));
        patrecord5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                patrecord5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                patrecord5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                patrecord5MouseExited(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("New Admin");

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/5.Admin/NewAdmin.png"))); // NOI18N

        javax.swing.GroupLayout patrecord5Layout = new javax.swing.GroupLayout(patrecord5);
        patrecord5.setLayout(patrecord5Layout);
        patrecord5Layout.setHorizontalGroup(
            patrecord5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patrecord5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(172, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, patrecord5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        patrecord5Layout.setVerticalGroup(
            patrecord5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patrecord5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(patrecord4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(patrecord5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(240, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(patrecord4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(patrecord5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(372, Short.MAX_VALUE))
        );

        dashBoardAdmin_Tabbed.addTab("Admin", jPanel9);

        FillInner_Panel2.setBackground(new java.awt.Color(255, 255, 255));

        firstname4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        firstname4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                firstname4FocusGained(evt);
            }
        });
        firstname4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstname4ActionPerformed(evt);
            }
        });
        firstname4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                firstname4KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                firstname4KeyReleased(evt);
            }
        });

        address4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        address4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                address4ActionPerformed(evt);
            }
        });

        mobile4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        mobile4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mobile4ActionPerformed(evt);
            }
        });

        lastname4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lastname4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastname4ActionPerformed(evt);
            }
        });

        registerForm_Panel2.setBackground(new java.awt.Color(0, 51, 204));

        registerForm_Label4.setBackground(new java.awt.Color(255, 255, 255));
        registerForm_Label4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        registerForm_Label4.setForeground(new java.awt.Color(255, 255, 255));
        registerForm_Label4.setText("UPDATE PROFILE");

        javax.swing.GroupLayout registerForm_Panel2Layout = new javax.swing.GroupLayout(registerForm_Panel2);
        registerForm_Panel2.setLayout(registerForm_Panel2Layout);
        registerForm_Panel2Layout.setHorizontalGroup(
            registerForm_Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registerForm_Panel2Layout.createSequentialGroup()
                .addGap(225, 225, 225)
                .addComponent(registerForm_Label4)
                .addContainerGap(251, Short.MAX_VALUE))
        );
        registerForm_Panel2Layout.setVerticalGroup(
            registerForm_Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registerForm_Panel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(registerForm_Label4)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        registerPatient_Button7.setBackground(new java.awt.Color(0, 0, 204));
        registerPatient_Button7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        registerPatient_Button7.setForeground(new java.awt.Color(204, 255, 255));
        registerPatient_Button7.setText("Update");
        registerPatient_Button7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                registerPatient_Button7MouseEntered(evt);
            }
        });
        registerPatient_Button7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerPatient_Button7ActionPerformed(evt);
            }
        });

        registerPatient_Button9.setBackground(new java.awt.Color(0, 0, 204));
        registerPatient_Button9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        registerPatient_Button9.setForeground(new java.awt.Color(204, 255, 255));
        registerPatient_Button9.setText("Go Back");
        registerPatient_Button9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                registerPatient_Button9MouseEntered(evt);
            }
        });
        registerPatient_Button9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerPatient_Button9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout FillInner_Panel2Layout = new javax.swing.GroupLayout(FillInner_Panel2);
        FillInner_Panel2.setLayout(FillInner_Panel2Layout);
        FillInner_Panel2Layout.setHorizontalGroup(
            FillInner_Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(registerForm_Panel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FillInner_Panel2Layout.createSequentialGroup()
                .addGroup(FillInner_Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(firstname4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(address4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(FillInner_Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lastname4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mobile4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(FillInner_Panel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(registerPatient_Button7)
                .addGap(64, 64, 64)
                .addComponent(registerPatient_Button9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        FillInner_Panel2Layout.setVerticalGroup(
            FillInner_Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FillInner_Panel2Layout.createSequentialGroup()
                .addComponent(registerForm_Panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addGroup(FillInner_Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstname4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastname4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addGroup(FillInner_Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(address4, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(mobile4))
                .addGap(87, 87, 87)
                .addGroup(FillInner_Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registerPatient_Button7)
                    .addComponent(registerPatient_Button9))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(209, 209, 209)
                .addComponent(FillInner_Panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(244, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(FillInner_Panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(139, 139, 139))
        );

        dashBoardAdmin_Tabbed.addTab("Profile", jPanel10);

        FillInner_Panel3.setBackground(new java.awt.Color(255, 255, 255));

        firstname5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        firstname5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                firstname5FocusGained(evt);
            }
        });
        firstname5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstname5ActionPerformed(evt);
            }
        });
        firstname5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                firstname5KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                firstname5KeyReleased(evt);
            }
        });

        address5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        address5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                address5ActionPerformed(evt);
            }
        });

        symptoms1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        symptoms1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                symptoms1ActionPerformed(evt);
            }
        });

        mobile5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        mobile5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mobile5ActionPerformed(evt);
            }
        });

        lastname5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lastname5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastname5ActionPerformed(evt);
            }
        });

        registerForm_Panel3.setBackground(new java.awt.Color(0, 0, 204));

        registerForm_Label5.setBackground(new java.awt.Color(255, 255, 255));
        registerForm_Label5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        registerForm_Label5.setForeground(new java.awt.Color(255, 255, 255));
        registerForm_Label5.setText("Update Patient");

        javax.swing.GroupLayout registerForm_Panel3Layout = new javax.swing.GroupLayout(registerForm_Panel3);
        registerForm_Panel3.setLayout(registerForm_Panel3Layout);
        registerForm_Panel3Layout.setHorizontalGroup(
            registerForm_Panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registerForm_Panel3Layout.createSequentialGroup()
                .addContainerGap(279, Short.MAX_VALUE)
                .addComponent(registerForm_Label5)
                .addGap(263, 263, 263))
        );
        registerForm_Panel3Layout.setVerticalGroup(
            registerForm_Panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registerForm_Panel3Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(registerForm_Label5)
                .addGap(20, 20, 20))
        );

        registerPatient_Button10.setBackground(new java.awt.Color(0, 0, 204));
        registerPatient_Button10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        registerPatient_Button10.setForeground(new java.awt.Color(204, 255, 255));
        registerPatient_Button10.setText("UPDATE");
        registerPatient_Button10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                registerPatient_Button10MouseEntered(evt);
            }
        });
        registerPatient_Button10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerPatient_Button10ActionPerformed(evt);
            }
        });

        registerPatient_Button11.setBackground(new java.awt.Color(0, 0, 204));
        registerPatient_Button11.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        registerPatient_Button11.setForeground(new java.awt.Color(204, 255, 255));
        registerPatient_Button11.setText("Go Back");
        registerPatient_Button11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                registerPatient_Button11MouseEntered(evt);
            }
        });
        registerPatient_Button11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerPatient_Button11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout FillInner_Panel3Layout = new javax.swing.GroupLayout(FillInner_Panel3);
        FillInner_Panel3.setLayout(FillInner_Panel3Layout);
        FillInner_Panel3Layout.setHorizontalGroup(
            FillInner_Panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(registerForm_Panel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(FillInner_Panel3Layout.createSequentialGroup()
                .addGroup(FillInner_Panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FillInner_Panel3Layout.createSequentialGroup()
                        .addGroup(FillInner_Panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(symptoms1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(firstname5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(address5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(FillInner_Panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lastname5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mobile5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(FillInner_Panel3Layout.createSequentialGroup()
                        .addComponent(registerPatient_Button10)
                        .addGap(81, 81, 81)
                        .addComponent(registerPatient_Button11)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        FillInner_Panel3Layout.setVerticalGroup(
            FillInner_Panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FillInner_Panel3Layout.createSequentialGroup()
                .addComponent(registerForm_Panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(FillInner_Panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstname5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastname5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(FillInner_Panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(address5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mobile5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addComponent(symptoms1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(FillInner_Panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registerPatient_Button10)
                    .addComponent(registerPatient_Button11))
                .addGap(46, 46, 46))
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(193, 193, 193)
                .addComponent(FillInner_Panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(238, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(FillInner_Panel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(81, 81, 81))
        );

        dashBoardAdmin_Tabbed.addTab("UpdatePatient", jPanel11);

        printdis.setBackground(new java.awt.Color(255, 255, 255));

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel30.setText("HOSPITAL ");

        jLabel32.setText("Admit Date       :");

        jLabel33.setText("Discharge Date :");

        jLabel35.setText("221B, Baker Street,Tirunelveli - 627001");
        jLabel35.setOpaque(true);

        jLabel36.setText("Patient Name      : ");

        jLabel37.setIcon(new javax.swing.ImageIcon("C:\\Users\\Packiyaraj\\Pictures\\ProjectImages\\5.Admin\\Print_ICON.png")); // NOI18N

        jLabel38.setText("Patient Mobile     :");

        jLabel39.setText("Patient Address  :");

        jLabel40.setText("Patient ID           :");

        jLabel45.setText("Disease");
        jLabel45.setOpaque(true);

        jLabel47.setText("Invoice");
        jLabel47.setOpaque(true);

        jLabel48.setText("Room Charges");

        jLabel50.setText("Doctor Fee");

        jLabel52.setText("Medcine Cost");

        jLabel54.setText("Other Charges");

        jLabel61.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel61.setText("TOTAL:");

        jTextField7.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jTextField8.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });
        jTextField8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField8KeyReleased(evt);
            }
        });

        jTextField9.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jTextField10.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jTextField11.setBackground(new java.awt.Color(240, 240, 240));
        jTextField11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField11.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel1.setOpaque(true);

        javax.swing.GroupLayout printdisLayout = new javax.swing.GroupLayout(printdis);
        printdis.setLayout(printdisLayout);
        printdisLayout.setHorizontalGroup(
            printdisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(printdisLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(printdisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(printdisLayout.createSequentialGroup()
                        .addGroup(printdisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, printdisLayout.createSequentialGroup()
                                .addGroup(printdisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(printdisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, printdisLayout.createSequentialGroup()
                                            .addComponent(jLabel50)
                                            .addGap(325, 325, 325)
                                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, printdisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(printdisLayout.createSequentialGroup()
                                                .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(printdisLayout.createSequentialGroup()
                                                .addComponent(jLabel54)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 306, Short.MAX_VALUE)
                                                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, printdisLayout.createSequentialGroup()
                                                .addComponent(jLabel52)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(printdisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, printdisLayout.createSequentialGroup()
                                            .addComponent(jLabel48)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel47, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(printdisLayout.createSequentialGroup()
                        .addGroup(printdisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(printdisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel38, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel39, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(printdisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(printdisLayout.createSequentialGroup()
                                .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(printdisLayout.createSequentialGroup()
                                .addGroup(printdisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel43, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
                                    .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(48, 48, 48))))
                    .addGroup(printdisLayout.createSequentialGroup()
                        .addGroup(printdisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(printdisLayout.createSequentialGroup()
                                .addComponent(jLabel36)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, printdisLayout.createSequentialGroup()
                        .addGroup(printdisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(printdisLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(printdisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(printdisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(printdisLayout.createSequentialGroup()
                                .addGroup(printdisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, printdisLayout.createSequentialGroup()
                                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(10, 10, 10)))
                        .addGap(43, 43, 43))))
        );
        printdisLayout.setVerticalGroup(
            printdisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, printdisLayout.createSequentialGroup()
                .addGroup(printdisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(printdisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel32)
                    .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(printdisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(printdisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel36)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(printdisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel38)
                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(printdisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(printdisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel40)
                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(printdisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(printdisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(printdisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(printdisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel54))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(printdisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(115, Short.MAX_VALUE))
        );

        jButton14.setBackground(new java.awt.Color(0, 0, 204));
        jButton14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton14.setForeground(new java.awt.Color(255, 255, 255));
        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/5.Admin/Printer.png"))); // NOI18N
        jButton14.setText("Print");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jButton14)
                .addGap(229, 229, 229)
                .addComponent(printdis, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(227, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(printdis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jButton14)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        dashBoardAdmin_Tabbed.addTab("Print", jPanel12);

        adminDashBoardFooter.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout adminDashBoardFooterLayout = new javax.swing.GroupLayout(adminDashBoardFooter);
        adminDashBoardFooter.setLayout(adminDashBoardFooterLayout);
        adminDashBoardFooterLayout.setHorizontalGroup(
            adminDashBoardFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        adminDashBoardFooterLayout.setVerticalGroup(
            adminDashBoardFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 64, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(adminProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(dashBoardAdmin_Tabbed, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(adminDashBoardHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(adminDashBoardFooter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(adminDashBoardHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(adminProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dashBoardAdmin_Tabbed, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(adminDashBoardFooter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dashboardAdmin_LabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardAdmin_LabelMouseClicked
        // TODO add your handling code here:
        dashBoardAdmin_Tabbed.setSelectedIndex(0); dash();
    }//GEN-LAST:event_dashboardAdmin_LabelMouseClicked

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

    private void goBack_LabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goBack_LabelMouseClicked
        // TODO add your handling code here:
        new adminLogin_Frame().setVisible(true); dispose();
    }//GEN-LAST:event_goBack_LabelMouseClicked

    private void doctorAdmin_LabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doctorAdmin_LabelMouseClicked
        // TODO add your handling code here:
        dashBoardAdmin_Tabbed.setSelectedIndex(1);
    }//GEN-LAST:event_doctorAdmin_LabelMouseClicked

    private void PatientAdmin_LabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PatientAdmin_LabelMouseClicked
        // TODO add your handling code here:
        dashBoardAdmin_Tabbed.setSelectedIndex(4);
    }//GEN-LAST:event_PatientAdmin_LabelMouseClicked

    private void appionment_LabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_appionment_LabelMouseClicked
        // TODO add your handling code here:
        dashBoardAdmin_Tabbed.setSelectedIndex(6);tabledate();
        
         String sql1="select uname as 'User Name',fname as 'First Name',lname as 'Last Name',sym as 'Symptoms',diag as 'Diagnosis',med as 'Medicine' from appoinment ";
        try {
            pt=con.prepareStatement(sql1);
             rs=pt.executeQuery();
             jTable7.setModel(DbUtils.resultSetToTableModel(rs));
             
        } catch (SQLException e) {JOptionPane.showMessageDialog(null, "Connection Failure !");} 
    }//GEN-LAST:event_appionment_LabelMouseClicked

    private void docRecordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_docRecordMouseClicked
        // Doctor Record
        dashBoardAdmin_Tabbed.setSelectedIndex(10);
         String sql1="select uname as 'User Name',fname as 'First Name',lname as 'Last Name',hom as 'Address',mob as 'Mobile',dep as 'Department',gen as 'Gender',dateAdmit as 'Join Date' from doc ";
        try {
            pt=con.prepareStatement(sql1);
             rs=pt.executeQuery();
             jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e)  {JOptionPane.showMessageDialog(null, "Connection Failure !");}
        
        
    }//GEN-LAST:event_docRecordMouseClicked

    private void docApproveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_docApproveMouseClicked
        // TODO add your handling code here:
        dashBoardAdmin_Tabbed.setSelectedIndex(8);
    }//GEN-LAST:event_docApproveMouseClicked

    private void docSpecMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_docSpecMouseClicked
        // TODO add your handling code here:
        dashBoardAdmin_Tabbed.setSelectedIndex(3);
        String sql1="select dep as 'Department',uname as 'User Name',fname as 'First Name',lname as 'Last Name',hom as 'Address',mob as 'Mobile',gen as 'Gender',dateAdmit as 'Join Date' from doc ";
        try {
            pt=con.prepareStatement(sql1);
             rs=pt.executeQuery();
             jTable5.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e)  {JOptionPane.showMessageDialog(null, "Connection Failure !");}
    }//GEN-LAST:event_docSpecMouseClicked

    private void patrecord1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patrecord1MouseClicked
        // TODO add your handling code here:
        dashBoardAdmin_Tabbed.setSelectedIndex(11);
        String sql2="select uname as 'User Name',fname as 'First Name',lname as 'Last Name',hom as 'Address',mob as 'Mobile',sym as 'Symptoms',gen as 'Gender',diag as 'Diagnosis',med as 'Medicine',dateAdmit as 'Date' from oldpatient ";
        try {
            pt=con.prepareStatement(sql2);
             rs=pt.executeQuery();
             jTable6.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {JOptionPane.showMessageDialog(null, "Connection Failure !");}
    }//GEN-LAST:event_patrecord1MouseClicked

    private void patrecord2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patrecord2MouseClicked
        // TODO add your handling code here:
        dashBoardAdmin_Tabbed.setSelectedIndex(5);
        String sql2="select uname as 'User Name',fname as 'First Name',lname as 'Last Name',hom as 'Address',mob as 'Mobile',sym as 'Symptoms',gen as 'Gender',diag as 'Diagnosis',med as 'Medicine' from discharge ";
        try {
            pt=con.prepareStatement(sql2);
             rs=pt.executeQuery();
             jTable2.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {JOptionPane.showMessageDialog(null, "Connection Failure !");}
        
    }//GEN-LAST:event_patrecord2MouseClicked

    private void dashboardAdmin_LabelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dashboardAdmin_LabelKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_dashboardAdmin_LabelKeyPressed

    private void doctorAdmin_LabelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_doctorAdmin_LabelKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_doctorAdmin_LabelKeyPressed

    private void dashboardAdmin_LabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardAdmin_LabelMouseEntered
        // TODO add your handling code here:
        dashboardAdmin_Label.setBackground(new Color(0,0,204));
    }//GEN-LAST:event_dashboardAdmin_LabelMouseEntered

    private void doctorAdmin_LabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doctorAdmin_LabelMouseEntered
        // TODO add your handling code here:
        doctorAdmin_Label.setBackground(new Color(0,0,204));
    }//GEN-LAST:event_doctorAdmin_LabelMouseEntered

    private void PatientAdmin_LabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PatientAdmin_LabelMouseEntered
        // TODO add your handling code here:
        PatientAdmin_Label.setBackground(new Color(0,0,204));
    }//GEN-LAST:event_PatientAdmin_LabelMouseEntered

    private void appionment_LabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_appionment_LabelMouseExited
        // TODO add your handling code here:        
        appionment_Label.setBackground(new Color(0,0,255));

    }//GEN-LAST:event_appionment_LabelMouseExited

    private void appionment_LabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_appionment_LabelMouseEntered
        // TODO add your handling code here:
        appionment_Label.setBackground(new Color(0,0,204));

    }//GEN-LAST:event_appionment_LabelMouseEntered

    private void PatientAdmin_LabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PatientAdmin_LabelMouseExited
        // TODO add your handling code here:       
        PatientAdmin_Label.setBackground(new Color(0,0,255));
    }//GEN-LAST:event_PatientAdmin_LabelMouseExited

    private void doctorAdmin_LabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doctorAdmin_LabelMouseExited
        // TODO add your handling code here:       
        doctorAdmin_Label.setBackground(new Color(0,0,255));
    }//GEN-LAST:event_doctorAdmin_LabelMouseExited

    private void dashboardAdmin_LabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardAdmin_LabelMouseExited
        // TODO add your handling code here:       
        dashboardAdmin_Label.setBackground(new Color(0,0,255));
    }//GEN-LAST:event_dashboardAdmin_LabelMouseExited

    private void docApprove1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_docApprove1MouseClicked
        // TODO add your handling code here:
        dashBoardAdmin_Tabbed.setSelectedIndex(2);
        String sql1="select uname as 'User Name',fname as 'First Name',lname as 'Last Name',hom as 'Address',mob as 'Mobile',dep as 'Department',gen as 'Gender',dateAdmit as 'Registered Date' from hold ";
        try {
            pt=con.prepareStatement(sql1);
             rs=pt.executeQuery();
             jTable4.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {JOptionPane.showMessageDialog(null, e);} 
    }//GEN-LAST:event_docApprove1MouseClicked

    private void patrecord3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patrecord3MouseClicked
        // TODO add your handling code here:
        dashBoardAdmin_Tabbed.setSelectedIndex(9);
    }//GEN-LAST:event_patrecord3MouseClicked

    private void firstnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_firstnameFocusLost

    }//GEN-LAST:event_firstnameFocusLost

    private void firstnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstnameActionPerformed

    private void lastnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastnameActionPerformed

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    private void addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressActionPerformed

    private void registerPatient_ButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerPatient_ButtonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_registerPatient_ButtonMouseEntered

    private void registerPatient_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerPatient_ButtonActionPerformed
        // TODO add your handling code here:
        if(firstname.getText().isEmpty() || firstname.getText().equals("FIRST NAME")){JOptionPane.showMessageDialog(null, "Enter Valid Name");}
        else if(lastname.getText().isEmpty() || lastname.getText().equals("LAST NAME")){JOptionPane.showMessageDialog(null, "Enter Valid Name");}
        else if(username.getText().isEmpty() || username.getText().equals("USER NAME")){JOptionPane.showMessageDialog(null, "Enter User Name");}
        else if(password.getText().isEmpty() || password.getText().equals("PASSWORD")){JOptionPane.showMessageDialog(null, "Enter Password");}
        else if(address.getText().isEmpty() || address.getText().equals("ADDRESS")){JOptionPane.showMessageDialog(null, "Enter Address Name");}
        else if(mobile.getText().isEmpty() || mobile.getText().equals("MOBILE")){JOptionPane.showMessageDialog(null, "Enter Valid Mobile number");}
        else{try{con=ConnectionProvider.getCon();
            pt=con.prepareStatement("insert into doc(uname,pwd,fname,lname,hom,mob,gen,dep) values(?,?,?,?,?,?,?,?)");
            pt.setString(1,username.getText() );
            pt.setString(2,password.getText() );
            pt.setString(3,firstname.getText() );
            pt.setString(4,lastname.getText() );
            pt.setString(5,address.getText() );
            pt.setString(6,mobile.getText() );
            pt.setString(7,(String)gender.getSelectedItem());
            pt.setString(8,(String)department1.getSelectedItem());
            pt.executeUpdate();
            
           }
        catch(SQLException e){JOptionPane.showMessageDialog(null, "Connection Failure !");}}
         try {
              String sqlll="create table Dr_"+username.getText()+"_Patients("+"uname varchar(20),"+"pwd varchar(20),"+"fname varchar(20),"+"lname varchar(20),"+"hom varchar(100),"+"mob varchar(10),"+"sym varchar(100),"+"gen varchar(10),"+"diag varchar(50),"+"med varchar(100),"+"dateAdmit varchar(20)"+");";
              Statement st=con.createStatement();
             st.execute(sqlll); JOptionPane.showMessageDialog(null, "Registered ");
          } catch (SQLException e) {JOptionPane.showMessageDialog(null, "Connection Failure !");
          } dashBoardAdmin_Tabbed.setSelectedIndex(1);
       
    }//GEN-LAST:event_registerPatient_ButtonActionPerformed

    private void mobileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mobileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mobileActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
       
         int row=jTable1.getSelectedRow();String i;
        String cell=jTable1.getModel().getValueAt(row, 0).toString();k=cell;
        String sql="select fname,lname,hom,mob,gen from doc where uname=?";
         try {
            pt=con.prepareStatement(sql);
        pt.setString(1, cell);
        rs=pt.executeQuery();
        if(rs.next()){
        fname1=rs.getString(1);firstname1.setText(fname1);
       lname1=rs.getString(2);lastname1.setText(lname1);
        ads=rs.getString(3);address1.setText(ads);
        mol=rs.getString(4);mobile1.setText(mol);
        }
            
        } catch (SQLException e) {JOptionPane.showMessageDialog(null, e);
        }
        dashBoardAdmin_Tabbed.setSelectedIndex(7);
         setFocusable(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        int row=jTable1.getSelectedRow();
        String cell=jTable1.getModel().getValueAt(row, 0).toString();
        String sql="delete from doc where uname=?";
         try {
            pt=con.prepareStatement(sql);
           pt.setString(1, cell);
            pt.executeUpdate();
        } catch (SQLException e) {JOptionPane.showMessageDialog(null, e);
        }
         
          try {
              String sqlll="drop table dr_"+cell+"_patients";
              Statement st=con.createStatement();
             st.execute(sqlll);
          } catch (SQLException e) {
          }
         
          String sql1="select uname as 'User Name',fname as 'First Name',lname as 'Last Name',hom as 'Address',mob as 'Mobile',dep as 'Department',gen as 'Gender',dateAdmit as 'Join Date' from doc ";
        try {
            pt=con.prepareStatement(sql1);
            rs=pt.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));jTextField3.setText("");
        } catch (SQLException e) {JOptionPane.showMessageDialog(null, e);}
         
    
       
    }//GEN-LAST:event_jButton5ActionPerformed

    private void firstname1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_firstname1FocusLost

    }//GEN-LAST:event_firstname1FocusLost

    private void firstname1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstname1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstname1ActionPerformed

    private void lastname1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastname1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastname1ActionPerformed

    private void address1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_address1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_address1ActionPerformed

    private void registerPatient_Button1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerPatient_Button1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_registerPatient_Button1MouseEntered

    private void registerPatient_Button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerPatient_Button1ActionPerformed
        // TODO add your handling code here:
       
        String sql="update doc set fname=?,lname=?,hom=?,mob=?,dep=? where uname=?";
        try {
           pt=con.prepareStatement(sql);
           pt.setString(1,firstname1.getText());
           pt.setString(2, lastname1.getText());
           pt.setString(3,address1.getText());
           pt.setString(4, mobile1.getText());
           pt.setString(5,(String)department2.getSelectedItem());
           pt.setString(6, k);
           pt.executeUpdate(); {JOptionPane.showMessageDialog(null, "Updated");}} catch (HeadlessException | SQLException e) {JOptionPane.showMessageDialog(null, "Something went wrong \n Unable to Update : (");
        }
        String sql1="select uname as 'User Name',fname as 'First Name',lname as 'Last Name',hom as 'Address',mob as 'Mobile',dep as 'Department',gen as 'Gender',dateAdmit as 'Join Date' from doc ";
        try {
            pt=con.prepareStatement(sql1);
            rs=pt.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));jTextField3.setText("");dashBoardAdmin_Tabbed.setSelectedIndex(10);
        } catch (SQLException e) {JOptionPane.showMessageDialog(null, e);}
        
    }//GEN-LAST:event_registerPatient_Button1ActionPerformed

    private void mobile1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mobile1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mobile1ActionPerformed

    private void registerPatient_Button2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerPatient_Button2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_registerPatient_Button2MouseEntered

    private void registerPatient_Button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerPatient_Button2ActionPerformed
        // TODO add your handling code here:
        dashBoardAdmin_Tabbed.setSelectedIndex(10);
    }//GEN-LAST:event_registerPatient_Button2ActionPerformed

    private void registerPatient_Button3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerPatient_Button3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_registerPatient_Button3MouseEntered

    private void registerPatient_Button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerPatient_Button3ActionPerformed
        // TODO add your handling code here:
         dashBoardAdmin_Tabbed.setSelectedIndex(1);
    }//GEN-LAST:event_registerPatient_Button3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        int row=jTable4.getSelectedRow();
        String cell=jTable4.getModel().getValueAt(row, 0).toString();
        String sql="select uname,pwd,fname,lname,hom,mob,dep,gen,dateAdmit from hold where uname=?";
         try {
            pt=con.prepareStatement(sql);
        pt.setString(1, cell);
        rs=pt.executeQuery();
        if(rs.next()){u=rs.getString(1);p=rs.getString(2);
        f=rs.getString(3);
       l=rs.getString(4);h=rs.getString(5);m=rs.getString(6);
        ss=rs.getString(7);g=rs.getString(8);d=rs.getString(9);     
        }else{JOptionPane.showMessageDialog(null, "1. Connection Failure !");}
            
       
       try{         
        pt=con.prepareStatement("insert into doc(uname,pwd,fname,lname,hom,mob,dep,gen,dateAdmit) values(?,?,?,?,?,?,?,?,?)");
            pt.setString(1,u ); 
            pt.setString(2,p);
            pt.setString(3,f );
            pt.setString(4,l );
            pt.setString(5,h );
            pt.setString(6,m );
            pt.setString(7,ss);
            pt.setString(8,g );
            pt.setString(9,d );
            pt.executeUpdate();} catch(SQLException e){JOptionPane.showMessageDialog(null, "2.Connection Failure !");}
          
         try {
            pt=con.prepareStatement("delete from hold where uname=?");
           pt.setString(1, cell);
            pt.executeUpdate();
        } catch (SQLException e) {JOptionPane.showMessageDialog(null, "Connection Failure !");}
        
          
          try {
              String sqlll="create table dr_"+cell+"_patients("+"uname varchar(20),"+"pwd varchar(20),"+"fname varchar(20),"+"lname varchar(20),"+"hom varchar(100),"+"mob varchar(10),"+"sym varchar(100),"+"gen varchar(10),"+"diag varchar(50),"+"med varchar(100),"+"dateAdmit varchar(20)"+");";
              Statement st=con.createStatement();
             st.execute(sqlll); JOptionPane.showMessageDialog(null, "Approved !");
          } catch (SQLException e) {
          }
            } catch (HeadlessException | SQLException e) {JOptionPane.showMessageDialog(null, "Connection Failure !");}
            
         //Reload Data
        dashBoardAdmin_Tabbed.setSelectedIndex(2);
        String sql1="select uname as 'User Name',fname as 'First Name',lname as 'Last Name',hom as 'Address',mob as 'Mobile',dep as 'Department',gen as 'Gender',dateAdmit as 'Registered Date' from hold ";
        try {
            pt=con.prepareStatement(sql1);
             rs=pt.executeQuery();
             jTable4.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {JOptionPane.showMessageDialog(null, "Connection Failure !");} 
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        int row=jTable4.getSelectedRow();
        String cell=jTable4.getModel().getValueAt(row, 0).toString();
         try {
            pt=con.prepareStatement("delete from hold where uname=?");
           pt.setString(1, cell);pt.executeUpdate();JOptionPane.showMessageDialog(null, "Rejected ");
        } catch (SQLException e) {JOptionPane.showMessageDialog(null, "Connection Failure !");}
        
           String sql1="select uname as 'User Name',fname as 'First Name',lname as 'Last Name',hom as 'Address',mob as 'Mobile',dep as 'Department',gen as 'Gender',dateAdmit as 'Registered Date' from hold ";
        try {
            pt=con.prepareStatement(sql1);
             rs=pt.executeQuery();
             jTable4.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {JOptionPane.showMessageDialog(null, "Connection Failure !");} 
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
         int row=jTable2.getSelectedRow();
        String cell=jTable2.getModel().getValueAt(row, 0).toString();
        String sql="select uname,fname,lname,hom,mob,diag,dateAdmit from discharge where uname=?";
        try {
            pt=con.prepareStatement(sql);
        pt.setString(1, cell);
        rs=pt.executeQuery();
        if(rs.next()){ue=rs.getString(1);fe=rs.getString(2);
        le=rs.getString(3);
       hm=rs.getString(4);mi=rs.getString(5);dg=rs.getString(6);
        dm=rs.getString(7);}
         }catch (SQLException e)  {JOptionPane.showMessageDialog(null, "Connection Failure !");}
        jLabel44.setText(ue);jLabel41.setText(fe+" "+le);jLabel43.setText(hm);jLabel42.setText(mi);jLabel46.setText(dg);jLabel31.setText(dm);
        dashBoardAdmin_Tabbed.setSelectedIndex(16);
        dischargeDate();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        int row=jTable7.getSelectedRow();
        String cell=jTable7.getModel().getValueAt(row, 0).toString();
        String sql="select uname,pwd,fname,lname,hom,mob,sym,gen,diag,med,dateAdmit from appoinment where uname=?";
         try {
            pt=con.prepareStatement(sql);
        pt.setString(1, cell);
        rs=pt.executeQuery();
        if(rs.next()){u=rs.getString(1);p=rs.getString(2);
        f=rs.getString(3);
       l=rs.getString(4);h=rs.getString(5);m=rs.getString(6);
        ss=rs.getString(7);g=rs.getString(8);d=rs.getString(9);me=rs.getString(10);da=rs.getString(11);        
        }
            
        pt=con.prepareStatement("insert into discharge(uname,pwd,fname,lname,hom,mob,sym,gen,diag,med,dateAdmit) values(?,?,?,?,?,?,?,?,?,?,?)");
            pt.setString(1,u ); 
            pt.setString(2,p);
            pt.setString(3,f );
            pt.setString(4,l );
            pt.setString(5,h );
            pt.setString(6,m );
            pt.setString(7,ss);
            pt.setString(8,g );
            pt.setString(9,d );
            pt.setString(10,me);
            pt.setString(11,da);
            pt.executeUpdate();
          
         try {
            pt=con.prepareStatement("delete from appoinment where uname=?");
           pt.setString(1, cell);
            pt.executeUpdate();
        } catch (SQLException e) {JOptionPane.showMessageDialog(null, e);
        }
            } catch (HeadlessException | SQLException e) {JOptionPane.showMessageDialog(null, e);
            }
         String sql1="select uname as 'User Name',fname as 'First Name',lname as 'Last Name',sym as 'Symptoms',diag as 'Diagnosis',med as 'Medicine' from appoinment ";
        try {
            pt=con.prepareStatement(sql1);
             rs=pt.executeQuery();
             jTable7.setModel(DbUtils.resultSetToTableModel(rs));
             
        } catch (SQLException e) {JOptionPane.showMessageDialog(null, e);} dashBoardAdmin_Tabbed.setSelectedIndex(6); 
    }//GEN-LAST:event_jButton9ActionPerformed

    private void department3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_department3ActionPerformed
        // TODO add your handling code here:
        String dep=(String) department3.getSelectedItem();
 //        String sql1="select dep as 'Department',uname as 'User Name',fname as 'First Name',lname as 'Last Name',hom as 'Address',mob as 'Mobile',gen as 'Gender',dateAdmit as 'Join Date' from doc ";
         try {
//            pt=con.prepareStatement(sql1);
//            rs=pt.executeQuery();
//            while(rs.next()){
//                department3.addItem(rs.getString("dep"));
                 Statement st=con.createStatement();
            rs=st.executeQuery("select dep as 'Department',fname as 'First Name',lname as 'Last Name',uname as 'User Name',hom as 'Address',mob as 'Mobile',gen as 'Gender',dateAdmit as 'Join Date' from doc where dep='"+dep+"'");
            jTable5.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (SQLException e) {
        }
    }//GEN-LAST:event_department3ActionPerformed

    private void firstname2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_firstname2FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_firstname2FocusGained

    private void firstname2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstname2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstname2ActionPerformed

    private void firstname2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_firstname2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstname2KeyPressed

    private void firstname2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_firstname2KeyReleased

    }//GEN-LAST:event_firstname2KeyReleased

    private void address2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_address2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_address2ActionPerformed

    private void symptomsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_symptomsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_symptomsActionPerformed

    private void username1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_username1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_username1FocusLost

    private void username1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_username1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_username1ActionPerformed

    private void mobile2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mobile2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mobile2ActionPerformed

    private void lastname2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastname2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastname2ActionPerformed

    private void password1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_password1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_password1ActionPerformed

    private void registerPatient_Button4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerPatient_Button4MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_registerPatient_Button4MouseEntered

    private void registerPatient_Button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerPatient_Button4ActionPerformed

        if(firstname2.getText().isEmpty() || firstname2.getText().equals("FIRST NAME")){JOptionPane.showMessageDialog(null, "Enter Valid Name");}
        else if(lastname2.getText().isEmpty() || lastname2.getText().equals("LAST NAME")){JOptionPane.showMessageDialog(null, "Enter Valid Name");}
        else if(username1.getText().isEmpty() || username1.getText().equals("USER NAME")){JOptionPane.showMessageDialog(null, "Enter User Name");}
        else if(password1.getText().isEmpty() || password1.getText().equals("PASSWORD")){JOptionPane.showMessageDialog(null, "Enter Password");}
        else if(address2.getText().isEmpty() || address2.getText().equals("ADDRESS")){JOptionPane.showMessageDialog(null, "Enter Address Name");}
        else if(mobile2.getText().isEmpty() || mobile2.getText().equals("MOBILE")){JOptionPane.showMessageDialog(null, "Enter Valid Mobile number");}
        else if(symptoms.getText().isEmpty() || symptoms.getText().equals("SYMPTOMS")){JOptionPane.showMessageDialog(null, "Enter Symptoms");}
        else{try{con=ConnectionProvider.getCon();

            pt=con.prepareStatement("insert into patient(uname,pwd,fname,lname,hom,mob,gen,sym) values(?,?,?,?,?,?,?,?)");
            pt.setString(1,username1.getText() );
            pt.setString(2,password1.getText() );
            pt.setString(3,firstname2.getText() );
            pt.setString(4,lastname2.getText() );
            pt.setString(5,address2.getText() );
            pt.setString(6,mobile2.getText() );
            pt.setString(7,(String)gender1.getSelectedItem());
            pt.setString(8,symptoms.getText() );
            pt.executeUpdate();
            try {

                pt=con.prepareStatement("insert into appoinment(uname,pwd,fname,lname,hom,mob,gen,sym,diag,med) values(?,?,?,?,?,?,?,?,?,?)");
                pt.setString(1,username1.getText() );
                pt.setString(2,password1.getText() );
                pt.setString(3,firstname2.getText() );
                pt.setString(4,lastname2.getText() );
                pt.setString(5,address2.getText() );
                pt.setString(6,mobile2.getText() );
                pt.setString(7,(String)gender1.getSelectedItem());
                pt.setString(8,symptoms.getText() );
                pt.setString(9,d );
                pt.setString(10,m );
                pt.executeUpdate();JOptionPane.showMessageDialog(null, "Registered :)");
            } catch (SQLException e) {JOptionPane.showMessageDialog(null, "Connection Failure !");}
           }
        catch(HeadlessException | SQLException e) {JOptionPane.showMessageDialog(null, "Connection Failure !");}}
            dashBoardAdmin_Tabbed.setSelectedIndex(4);
    }//GEN-LAST:event_registerPatient_Button4ActionPerformed

    private void registerPatient_Button5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerPatient_Button5MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_registerPatient_Button5MouseEntered

    private void registerPatient_Button5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerPatient_Button5ActionPerformed
        // TODO add your handling code here
        dashBoardAdmin_Tabbed.setSelectedIndex(4);
    }//GEN-LAST:event_registerPatient_Button5ActionPerformed

    private void firstname3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_firstname3FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_firstname3FocusGained

    private void firstname3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstname3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstname3ActionPerformed

    private void firstname3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_firstname3KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstname3KeyPressed

    private void firstname3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_firstname3KeyReleased

    }//GEN-LAST:event_firstname3KeyReleased

    private void address3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_address3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_address3ActionPerformed

    private void username2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_username2FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_username2FocusLost

    private void username2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_username2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_username2ActionPerformed

    private void mobile3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mobile3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mobile3ActionPerformed

    private void lastname3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastname3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastname3ActionPerformed

    private void password2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_password2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_password2ActionPerformed

    private void registerPatient_Button6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerPatient_Button6MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_registerPatient_Button6MouseEntered

    private void registerPatient_Button6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerPatient_Button6ActionPerformed

        if(firstname3.getText().isEmpty() || firstname3.getText().equals("FIRST NAME")){JOptionPane.showMessageDialog(null, "Enter Valid Name");}
        else if(lastname3.getText().isEmpty() || lastname3.getText().equals("LAST NAME")){JOptionPane.showMessageDialog(null, "Enter Valid Name");}
        else if(username2.getText().isEmpty() || username2.getText().equals("USER NAME")){JOptionPane.showMessageDialog(null, "Enter User Name");}
        else if(password2.getText().isEmpty() || password2.getText().equals("PASSWORD")){JOptionPane.showMessageDialog(null, "Enter Password");}
        else if(address3.getText().isEmpty() || address3.getText().equals("ADDRESS")){JOptionPane.showMessageDialog(null, "Enter Address Name");}
        else if(mobile3.getText().isEmpty() || mobile3.getText().equals("MOBILE")){JOptionPane.showMessageDialog(null, "Enter Valid Mobile number");}
       
        else{
            try{con=ConnectionProvider.getCon();

            pt=con.prepareStatement("insert into admin(uname,pwd,fname,lname,hom,mob,gen) values(?,?,?,?,?,?,?)");
            pt.setString(1,username2.getText() );
            pt.setString(2,password2.getText() );
            pt.setString(3,firstname3.getText() );
            pt.setString(4,lastname3.getText() );
            pt.setString(5,address3.getText() );
            pt.setString(6,mobile3.getText() );
            pt.setString(7,(String)gender2.getSelectedItem());
            pt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registered");

            }
        
        catch(HeadlessException | SQLException e){JOptionPane.showMessageDialog(null, e);}}
        dashBoardAdmin_Tabbed.setSelectedIndex(13);
    }//GEN-LAST:event_registerPatient_Button6ActionPerformed

    private void doctorAdmin_Label2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doctorAdmin_Label2MouseClicked
        // TODO add your handling code here:
        dashBoardAdmin_Tabbed.setSelectedIndex(13);
    }//GEN-LAST:event_doctorAdmin_Label2MouseClicked

    private void doctorAdmin_Label2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doctorAdmin_Label2MouseEntered
        // TODO add your handling code here:
         doctorAdmin_Label2.setBackground(new Color(0,0,204));
    }//GEN-LAST:event_doctorAdmin_Label2MouseEntered

    private void doctorAdmin_Label2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doctorAdmin_Label2MouseExited
        // TODO add your handling code here:
        doctorAdmin_Label2.setBackground(new Color(0,0,255));
    }//GEN-LAST:event_doctorAdmin_Label2MouseExited

    private void doctorAdmin_Label2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_doctorAdmin_Label2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_doctorAdmin_Label2KeyPressed

    private void patrecord4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patrecord4MouseClicked
        // TODO add your handling code here:
        dashBoardAdmin_Tabbed.setSelectedIndex(14);jPanel10.setFocusable(true);
    }//GEN-LAST:event_patrecord4MouseClicked

    private void patrecord5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patrecord5MouseClicked
        // TODO add your handling code here:
        dashBoardAdmin_Tabbed.setSelectedIndex(12);
    }//GEN-LAST:event_patrecord5MouseClicked

    private void firstname4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_firstname4FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_firstname4FocusGained

    private void firstname4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstname4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstname4ActionPerformed

    private void firstname4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_firstname4KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstname4KeyPressed

    private void firstname4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_firstname4KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_firstname4KeyReleased

    private void address4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_address4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_address4ActionPerformed

    private void mobile4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mobile4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mobile4ActionPerformed

    private void lastname4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastname4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastname4ActionPerformed

    private void registerPatient_Button7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerPatient_Button7MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_registerPatient_Button7MouseEntered

    private void registerPatient_Button7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerPatient_Button7ActionPerformed
        // TODO add your handling code here:
        String sql="update admin set fname=?,lname=?,hom=?,mob=? where uname=?";
        try {
           pt=con.prepareStatement(sql);
           pt.setString(1,firstname4.getText());
           pt.setString(2, lastname4.getText());
           pt.setString(3,address4.getText());
           pt.setString(4, mobile4.getText());
           pt.setString(5, dn);
           pt.executeUpdate();} catch (HeadlessException | SQLException e) {JOptionPane.showMessageDialog(null, "Connection Failure !");}
             String sql33="select * from admin where uname=? and pwd=? ";
        try{
        pt=con.prepareStatement(sql33);
        pt.setString(1, dn);
        pt.setString(2, dp);
        rs=pt.executeQuery();
        if(rs.next()){
            String fname=rs.getString(3);String lname=rs.getString(4);
            admintName.setText(fname+"  "+lname);} {JOptionPane.showMessageDialog(null, "Updated");}
        dashBoardAdmin_Tabbed.setSelectedIndex(13);}
        catch(HeadlessException | SQLException e) {JOptionPane.showMessageDialog(null, "Connection Failure !");}
    }//GEN-LAST:event_registerPatient_Button7ActionPerformed

    private void registerPatient_Button8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerPatient_Button8MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_registerPatient_Button8MouseEntered

    private void registerPatient_Button8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerPatient_Button8ActionPerformed
        // TODO add your handling code here:
        dashBoardAdmin_Tabbed.setSelectedIndex(13);
    }//GEN-LAST:event_registerPatient_Button8ActionPerformed

    private void registerPatient_Button9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerPatient_Button9MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_registerPatient_Button9MouseEntered

    private void registerPatient_Button9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerPatient_Button9ActionPerformed
        // TODO add your handling code here:
        dashBoardAdmin_Tabbed.setSelectedIndex(13);
    }//GEN-LAST:event_registerPatient_Button9ActionPerformed

    private void firstname5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_firstname5FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_firstname5FocusGained

    private void firstname5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstname5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstname5ActionPerformed

    private void firstname5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_firstname5KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstname5KeyPressed

    private void firstname5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_firstname5KeyReleased

    }//GEN-LAST:event_firstname5KeyReleased

    private void address5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_address5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_address5ActionPerformed

    private void symptoms1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_symptoms1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_symptoms1ActionPerformed

    private void mobile5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mobile5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mobile5ActionPerformed

    private void lastname5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastname5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastname5ActionPerformed

    private void registerPatient_Button10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerPatient_Button10MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_registerPatient_Button10MouseEntered

    private void registerPatient_Button10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerPatient_Button10ActionPerformed

        if(firstname5.getText().isEmpty() || firstname5.getText().equals("FIRST NAME")){JOptionPane.showMessageDialog(null, "Enter Valid Name");}
        else if(lastname5.getText().isEmpty() || lastname5.getText().equals("LAST NAME")){JOptionPane.showMessageDialog(null, "Enter Valid Name");}
        else if(address5.getText().isEmpty() || address5.getText().equals("ADDRESS")){JOptionPane.showMessageDialog(null, "Enter Address Name");}
        else if(mobile5.getText().isEmpty() || mobile5.getText().equals("MOBILE")){JOptionPane.showMessageDialog(null, "Enter Valid Mobile number");}
        else if(symptoms1.getText().isEmpty() || symptoms1.getText().equals("SYMPTOMS")){JOptionPane.showMessageDialog(null, "Enter Symptoms");}
        else{try{con=ConnectionProvider.getCon();

            pt=con.prepareStatement("update patient set fname=?,lname=?,hom=?,mob=?,sym=? where uname=?");
            pt.setString(1,firstname5.getText() );
            pt.setString(2,lastname5.getText() );
            pt.setString(3,address5.getText() );
            pt.setString(4,mobile5.getText() );
            pt.setString(5,symptoms1.getText() );
            pt.setString(6, k);
            pt.executeUpdate();
            
            pt=con.prepareStatement("update oldpatient set fname=?,lname=?,hom=?,mob=?,sym=? where uname=?");
            pt.setString(1,firstname5.getText() );
            pt.setString(2,lastname5.getText() );
            pt.setString(3,address5.getText() );
            pt.setString(4,mobile5.getText() );
            pt.setString(5,symptoms1.getText() );
            pt.setString(6, k);
            pt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Updated");}
        catch(HeadlessException | SQLException e){JOptionPane.showMessageDialog(null, e);}}
         dashBoardAdmin_Tabbed.setSelectedIndex(11);
        String sql2="select uname as 'User Name',fname as 'First Name',lname as 'Last Name',hom as 'Address',mob as 'Mobile',sym as 'Symptoms',gen as 'Gender',diag as 'Diagnosis',med as 'Medicine',dateAdmit as 'Date' from oldpatient ";
        try {
            pt=con.prepareStatement(sql2);
             rs=pt.executeQuery();
             jTable6.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {JOptionPane.showMessageDialog(null, e);}  
        
    }//GEN-LAST:event_registerPatient_Button10ActionPerformed

    private void registerPatient_Button11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerPatient_Button11MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_registerPatient_Button11MouseEntered

    private void registerPatient_Button11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerPatient_Button11ActionPerformed
        // TODO add your handling code here:
        dashBoardAdmin_Tabbed.setSelectedIndex(4);
    }//GEN-LAST:event_registerPatient_Button11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
          int row=jTable6.getSelectedRow();String i;
        String cell=jTable6.getModel().getValueAt(row, 0).toString();k=cell;
        String sql="select fname,lname,hom,mob,sym from oldpatient where uname=?";
         try {
            pt=con.prepareStatement(sql);
        pt.setString(1, cell);
        rs=pt.executeQuery();
        if(rs.next()){
       String fna=rs.getString(1);firstname5.setText(fna);
       String lna=rs.getString(2);lastname5.setText(lna);
       String adss=rs.getString(3);address5.setText(adss);
       String mo=rs.getString(4);mobile5.setText(mo);
       String sy=rs.getString(5);symptoms1.setText(sy);}  
        } catch (SQLException e) {JOptionPane.showMessageDialog(null, "Connection Failure !");}
        dashBoardAdmin_Tabbed.setSelectedIndex(15);jPanel11.setFocusable(true);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        int row=jTable6.getSelectedRow();
        String cell=jTable6.getModel().getValueAt(row, 0).toString();
        String sql="delete from oldpatient where uname=?";
         try {
            pt=con.prepareStatement(sql);
           pt.setString(1, cell);
            pt.executeUpdate();
        } catch (SQLException e)  {JOptionPane.showMessageDialog(null, "Connection Failure !");}
         String sql2="delete from patient where uname=?";
         try {
            pt=con.prepareStatement(sql2);
           pt.setString(1, cell);
            pt.executeUpdate();
        } catch (SQLException e) {JOptionPane.showMessageDialog(null, "Connection Failure !");}
         String sql1="select uname as 'User Name',fname as 'First Name',lname as 'Last Name',hom as 'Address',mob as 'Mobile',sym as 'Symptoms',gen as 'Gender',diag as 'Diagnosis',med as 'Medicine',dateAdmit as 'Date' from oldpatient";
        try {       
            pt=con.prepareStatement(sql1);
            rs=pt.executeQuery();
            jTable6.setModel(DbUtils.resultSetToTableModel(rs));jTextField4.setText("");
        } catch (SQLException e) {JOptionPane.showMessageDialog(null, "Connection Failure !");}
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        MessageFormat header=new MessageFormat("HOSPITAL APPOINMENTS");MessageFormat footer=new MessageFormat("");
        try {
            jTable7.print(JTable.PrintMode.FIT_WIDTH,header,footer);
        } catch (PrinterException e)  {JOptionPane.showMessageDialog(null, "Something went wrong !");}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        PrinterJob job = PrinterJob.getPrinterJob();
            job.setJobName("Print Data");
            
            job.setPrintable(new Printable(){
            public int print(Graphics pg,PageFormat pf, int pageNum){
                    pf.setOrientation(PageFormat.LANDSCAPE);
                 if(pageNum > 0){
                    return Printable.NO_SUCH_PAGE;
                }
                
                Graphics2D g2 = (Graphics2D)pg;
                g2.translate(pf.getImageableX(), pf.getImageableY());
                g2.scale(1.109,1.53);
                
                printdis.print(g2);
         
               
                return Printable.PAGE_EXISTS;
                         
                
            }
    });
            boolean ok = job.printDialog();
        if(ok){
        try{
            
        job.print();
        }
        catch (PrinterException ex){
	ex.printStackTrace();
}
        }
        
        
         int row=jTable2.getSelectedRow();
        String cell=jTable2.getModel().getValueAt(row, 0).toString();
        String sql="select uname,pwd,fname,lname,hom,mob,sym,gen,diag,med,dateAdmit from discharge where uname=?";
        try {
             pt=con.prepareStatement("delete from oldpatient where uname=?");
           pt.setString(1, cell);
            pt.executeUpdate();
        } catch (SQLException e) {JOptionPane.showMessageDialog(null, "Connection Failure !");}
         try {
            pt=con.prepareStatement(sql);
        pt.setString(1, cell);
        rs=pt.executeQuery();
        if(rs.next()){u=rs.getString(1);p=rs.getString(2);
        f=rs.getString(3);
       l=rs.getString(4);h=rs.getString(5);m=rs.getString(6);
        ss=rs.getString(7);g=rs.getString(8);d=rs.getString(9);me=rs.getString(10);da=rs.getString(11);        
        }
                  
        pt=con.prepareStatement("insert into oldpatient(uname,pwd,fname,lname,hom,mob,sym,gen,diag,med) values(?,?,?,?,?,?,?,?,?,?)");
            pt.setString(1,u ); 
            pt.setString(2,p);
            pt.setString(3,f );
            pt.setString(4,l );
            pt.setString(5,h );
            pt.setString(6,m );
            pt.setString(7,ss);
            pt.setString(8,g );
            pt.setString(9,d );
            pt.setString(10,me);
         //   pt.setString(11,da);
            pt.executeUpdate();
          
         try {
            pt=con.prepareStatement("delete from discharge where uname=?");
           pt.setString(1, cell);
            pt.executeUpdate(); JOptionPane.showMessageDialog(null, "Discharged");
        } catch (SQLException e)  {JOptionPane.showMessageDialog(null, "Connection Failure !");}
            } catch (HeadlessException | SQLException e)  {JOptionPane.showMessageDialog(null, "Connection Failure !");}
         
        String sql2="select uname as 'User Name',fname as 'First Name',lname as 'Last Name',hom as 'Address',mob as 'Mobile',sym as 'Symptoms',gen as 'Gender',diag as 'Diagnosis',med as 'Medicine' from discharge ";
        try {
            pt=con.prepareStatement(sql2);
             rs=pt.executeQuery();
             jTable2.setModel(DbUtils.resultSetToTableModel(rs));dashBoardAdmin_Tabbed.setSelectedIndex(5);
        } catch (SQLException e)  {JOptionPane.showMessageDialog(null, "Connection Failure !");}
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jTextField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyReleased
        // TODO add your handling code here:
        DefaultTableModel table=(DefaultTableModel)jTable1.getModel();
        String search=jTextField3.getText().toLowerCase();
        TableRowSorter<DefaultTableModel> tr=new TableRowSorter<DefaultTableModel>(table);
        jTable1.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_jTextField3KeyReleased

    private void jTextField4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyReleased
        // TODO add your handling code here:
         DefaultTableModel table=(DefaultTableModel)jTable6.getModel();
        String search=jTextField4.getText().toLowerCase();
        TableRowSorter<DefaultTableModel> tr=new TableRowSorter<DefaultTableModel>(table);
        jTable6.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_jTextField4KeyReleased

    private void jTextField5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyReleased
        // TODO add your handling code here:
         DefaultTableModel table=(DefaultTableModel)jTable2.getModel();
        String search=jTextField6.getText().toLowerCase();
        TableRowSorter<DefaultTableModel> tr=new TableRowSorter<DefaultTableModel>(table);
        jTable2.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_jTextField5KeyReleased

    private void jTextField6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6KeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int row=jTable7.getSelectedRow();String i;
        String cell=jTable7.getModel().getValueAt(row, 0).toString();
        String sql="update appoinment set diag=?,med=? where uname=?";
        try {
            pt=con.prepareStatement(sql);
            pt.setString(1,jTextField1.getText());
            pt.setString(2, jTextField2.getText());
            pt.setString(3, cell);
            pt.executeUpdate();
        } catch (SQLException e) {JOptionPane.showMessageDialog(null, e);
        }

        String sql1="select uname as 'User Name',fname as 'First Name',lname as 'Last Name',sym as 'Symptoms',diag as 'Diagnosis',med as 'Medicine' from appoinment ";
        try {jTextField1.setText("");jTextField2.setText("");
            pt=con.prepareStatement(sql1);
            rs=pt.executeQuery();
            jTable7.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {JOptionPane.showMessageDialog(null, e);}
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
       // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jTextField8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyReleased
        // TODO add your handling code here:
               total(); 
    }//GEN-LAST:event_jTextField8KeyReleased

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

    private void docRecordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_docRecordMouseEntered
        // TODO add your handling code here:
        docRecord.setBackground(new Color(255,153,0));
    }//GEN-LAST:event_docRecordMouseEntered

    private void docRecordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_docRecordMouseExited
        // TODO add your handling code here:
         docRecord.setBackground(new Color(255,102,0));
    }//GEN-LAST:event_docRecordMouseExited

    private void docSpecMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_docSpecMouseExited
        // TODO add your handling code here:
       docSpec.setBackground(new Color(153,0,153)); 
    }//GEN-LAST:event_docSpecMouseExited

    private void docSpecMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_docSpecMouseEntered
        // TODO add your handling code here:
        docSpec.setBackground(new Color(102,0,102)); 
    }//GEN-LAST:event_docSpecMouseEntered

    private void docApprove1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_docApprove1MouseExited
        // TODO add your handling code here:
        docApprove1.setBackground(new Color(0,204,0)); 
    }//GEN-LAST:event_docApprove1MouseExited

    private void jLabel9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseExited
        // TODO add your handling code here
    }//GEN-LAST:event_jLabel9MouseExited

    private void docApprove1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_docApprove1MouseEntered
        // TODO add your handling code here:
         docApprove1.setBackground(new Color(0,153,0)); 
    }//GEN-LAST:event_docApprove1MouseEntered

    private void docApproveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_docApproveMouseExited
        // TODO add your handling code here:
         docApprove.setBackground(new Color(153,0,0)); 
    }//GEN-LAST:event_docApproveMouseExited

    private void docApproveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_docApproveMouseEntered
        // TODO add your handling code here:
        docApprove.setBackground(new Color(204,0,0)); 
    }//GEN-LAST:event_docApproveMouseEntered

    private void patrecord1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patrecord1MouseExited
        // TODO add your handling code here:
        patrecord1.setBackground(new Color(255,153,0)); 
    }//GEN-LAST:event_patrecord1MouseExited

    private void patrecord1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patrecord1MouseEntered
        // TODO add your handling code here:
        patrecord1.setBackground(new Color(255,204,51));
    }//GEN-LAST:event_patrecord1MouseEntered

    private void patrecord2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patrecord2MouseExited
        // TODO add your handling code here:
        patrecord2.setBackground(new Color(153,0,153));
    }//GEN-LAST:event_patrecord2MouseExited

    private void patrecord2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patrecord2MouseEntered
        // TODO add your handling code here:
         patrecord2.setBackground(new Color(204,0,204));
    }//GEN-LAST:event_patrecord2MouseEntered

    private void patrecord3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patrecord3MouseExited
        // TODO add your handling code here:
         patrecord3.setBackground(new Color(0,51,204));
    }//GEN-LAST:event_patrecord3MouseExited

    private void patrecord3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patrecord3MouseEntered
        // TODO add your handling code here:
        patrecord3.setBackground(new Color(0,51,153));
    }//GEN-LAST:event_patrecord3MouseEntered

    private void patrecord4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patrecord4MouseExited
        // TODO add your handling code here:
        patrecord4.setBackground(new Color(0,51,204));
    }//GEN-LAST:event_patrecord4MouseExited

    private void patrecord4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patrecord4MouseEntered
        // TODO add your handling code here:
        patrecord4.setBackground(new Color(0,51,153));
    }//GEN-LAST:event_patrecord4MouseEntered

    private void patrecord5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patrecord5MouseExited
        // TODO add your handling code here:
        patrecord5.setBackground(new Color(255,0,51));
    }//GEN-LAST:event_patrecord5MouseExited

    private void patrecord5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patrecord5MouseEntered
        // TODO add your handling code here:
         patrecord5.setBackground(new Color(153,0,0));
    }//GEN-LAST:event_patrecord5MouseEntered

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
//            java.util.logging.Logger.getLogger(adminDashBoard_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(adminDashBoard_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(adminDashBoard_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(adminDashBoard_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new adminDashBoard_Frame().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel FillInner_Panel;
    private javax.swing.JPanel FillInner_Panel1;
    private javax.swing.JPanel FillInner_Panel2;
    private javax.swing.JPanel FillInner_Panel3;
    private javax.swing.JLabel PatientAdmin_Label;
    private javax.swing.JLabel aboutUs_Label;
    private javax.swing.JTextField address;
    private javax.swing.JTextField address1;
    private javax.swing.JTextField address2;
    private javax.swing.JTextField address3;
    private javax.swing.JTextField address4;
    private javax.swing.JTextField address5;
    private javax.swing.JLabel admin;
    private javax.swing.JPanel adminDashBoardFooter;
    private javax.swing.JPanel adminDashBoardHeader;
    private javax.swing.JLabel adminPic;
    private javax.swing.JPanel adminProFile_Panel;
    private javax.swing.JPanel adminProfile;
    private javax.swing.JLabel admintName;
    private javax.swing.JLabel appionment_Label;
    private javax.swing.JPanel approveDoctor_Panel;
    private javax.swing.JLabel close_Label;
    private javax.swing.JLabel contactUs_Label;
    private javax.swing.JPanel dashBoardAdmin_Panel;
    private javax.swing.JTabbedPane dashBoardAdmin_Tabbed;
    private javax.swing.JLabel dashboardAdmin_Label;
    private javax.swing.JComboBox<String> department1;
    private javax.swing.JComboBox<String> department2;
    private javax.swing.JComboBox<String> department3;
    private javax.swing.JPanel dischargePatientAdmin_Panel;
    private javax.swing.JPanel docApprove;
    private javax.swing.JPanel docApprove1;
    private javax.swing.JPanel docRecord;
    private javax.swing.JPanel docSpec;
    private javax.swing.JLabel doctorAdmin_Label;
    private javax.swing.JLabel doctorAdmin_Label2;
    private javax.swing.JPanel doctorAdmin_Panel;
    private javax.swing.JPanel doctorRecord_Panel;
    private javax.swing.JPanel doctorSpecialisation_Panel;
    private javax.swing.JTextField firstname;
    private javax.swing.JTextField firstname1;
    private javax.swing.JTextField firstname2;
    private javax.swing.JTextField firstname3;
    private javax.swing.JTextField firstname4;
    private javax.swing.JTextField firstname5;
    private javax.swing.JComboBox<String> gender;
    private javax.swing.JComboBox<String> gender1;
    private javax.swing.JComboBox<String> gender2;
    private javax.swing.JLabel goBack_Label;
    private javax.swing.JLabel hospital;
    private javax.swing.JLabel hospitalIcon;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
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
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTable jTable7;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JLabel jtabledate;
    private javax.swing.JTextField lastname;
    private javax.swing.JTextField lastname1;
    private javax.swing.JTextField lastname2;
    private javax.swing.JTextField lastname3;
    private javax.swing.JTextField lastname4;
    private javax.swing.JTextField lastname5;
    private javax.swing.JLabel minimize_Label;
    private javax.swing.JTextField mobile;
    private javax.swing.JTextField mobile1;
    private javax.swing.JTextField mobile2;
    private javax.swing.JTextField mobile3;
    private javax.swing.JTextField mobile4;
    private javax.swing.JTextField mobile5;
    private javax.swing.JPasswordField password;
    private javax.swing.JPasswordField password1;
    private javax.swing.JPasswordField password2;
    private javax.swing.JPanel patientAdmin_Panel;
    private javax.swing.JPanel patientRecordAdmin_Panel;
    private javax.swing.JPanel patrecord1;
    private javax.swing.JPanel patrecord2;
    private javax.swing.JPanel patrecord3;
    private javax.swing.JPanel patrecord4;
    private javax.swing.JPanel patrecord5;
    private javax.swing.JPanel printdis;
    private javax.swing.JLabel registerForm_Label;
    private javax.swing.JLabel registerForm_Label1;
    private javax.swing.JLabel registerForm_Label2;
    private javax.swing.JLabel registerForm_Label3;
    private javax.swing.JLabel registerForm_Label4;
    private javax.swing.JLabel registerForm_Label5;
    private javax.swing.JPanel registerForm_Panel;
    private javax.swing.JPanel registerForm_Panel1;
    private javax.swing.JPanel registerForm_Panel2;
    private javax.swing.JPanel registerForm_Panel3;
    private javax.swing.JButton registerPatient_Button;
    private javax.swing.JButton registerPatient_Button1;
    private javax.swing.JButton registerPatient_Button10;
    private javax.swing.JButton registerPatient_Button11;
    private javax.swing.JButton registerPatient_Button2;
    private javax.swing.JButton registerPatient_Button3;
    private javax.swing.JButton registerPatient_Button4;
    private javax.swing.JButton registerPatient_Button5;
    private javax.swing.JButton registerPatient_Button6;
    private javax.swing.JButton registerPatient_Button7;
    private javax.swing.JButton registerPatient_Button8;
    private javax.swing.JButton registerPatient_Button9;
    private javax.swing.JTextField symptoms;
    private javax.swing.JTextField symptoms1;
    private javax.swing.JLabel totAPP;
    private javax.swing.JLabel totApp;
    private javax.swing.JLabel totApp_Icon;
    private javax.swing.JLabel totDOC;
    private javax.swing.JLabel totDoc2;
    private javax.swing.JLabel totDoc_Icon;
    private javax.swing.JLabel totPAT;
    private javax.swing.JLabel totPat;
    private javax.swing.JLabel totPat_Icon;
    private javax.swing.JPanel totalAppoinment;
    private javax.swing.JPanel totalDoctor;
    private javax.swing.JPanel totalPatient;
    private javax.swing.JTextField username;
    private javax.swing.JTextField username1;
    private javax.swing.JTextField username2;
    private javax.swing.JPanel viewaAppoinmentAmin_Panel;
    // End of variables declaration//GEN-END:variables
}
