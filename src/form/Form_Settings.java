/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package form;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import model.Model_User;


public class Form_Settings extends javax.swing.JPanel {

    private Model_User userSet;
    private int userid;
    public String email;
    public String url;
    public String user;
    public String password;
    public String oldUserName;
    public String oldPass;
    
    public Form_Settings(Model_User userData) {
        initComponents();
        userid = userData.getUserID();
        userSet = userData;
        imageAvatar1.setIcon(userData.getProfile());
        userUpdated.setText("");
        passUpdated.setText("");
        iconUpdated.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        changeUserName = new swing.TextField();
        changePass = new swing.TextField();
        imageAvatar1 = new swing.ImageAvatar();
        btnUser = new swing.Button();
        btnPass = new swing.Button();
        btnIcon = new swing.Button();
        userUpdated = new javax.swing.JLabel();
        passUpdated = new javax.swing.JLabel();
        iconUpdated = new javax.swing.JLabel();

        setBackground(new java.awt.Color(242, 240, 240));

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("User Settings:");

        changeUserName.setLabelText("Reset Username");
        changeUserName.setName(""); // NOI18N
        changeUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeUserNameActionPerformed(evt);
            }
        });

        changePass.setLabelText("Reset Password");

        imageAvatar1.setBackground(new java.awt.Color(153, 153, 153));
        imageAvatar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/user.png"))); // NOI18N
        imageAvatar1.setOpaque(true);

        btnUser.setText("Reset Username");
        btnUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserActionPerformed(evt);
            }
        });

        btnPass.setText("Reset Password");
        btnPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPassActionPerformed(evt);
            }
        });

        btnIcon.setText("Reset Icon");
        btnIcon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIconActionPerformed(evt);
            }
        });

        userUpdated.setForeground(new java.awt.Color(255, 0, 0));

        passUpdated.setForeground(new java.awt.Color(255, 0, 0));

        iconUpdated.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(imageAvatar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(changePass, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                    .addComponent(changeUserName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUser, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userUpdated)
                    .addComponent(passUpdated)
                    .addComponent(iconUpdated))
                .addContainerGap(93, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(changeUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userUpdated))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(changePass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passUpdated))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(iconUpdated)
                        .addContainerGap(114, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(imageAvatar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void changeUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeUserNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_changeUserNameActionPerformed

    private void btnUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserActionPerformed
        url = "jdbc:postgresql://localhost:5432/AthleteManagementSystem";
        user = "postgres";
        password = "Gravyboy1";
        oldUserName = changeUserName.getText().trim();
        
        String query = "UPDATE users \n" +
                        "SET username = '"+oldUserName+"'\n" +
                        "WHERE userID = "+userid+";";
        
        try (Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement p = conn.prepareStatement(query)) {
            p.execute();
            userUpdated.setText("Updated username");
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnUserActionPerformed

    private void btnPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPassActionPerformed
        url = "jdbc:postgresql://localhost:5432/AthleteManagementSystem";
        user = "postgres";
        password = "Gravyboy1";
        oldPass = changePass.getText();
        
        String query = "UPDATE users \n" +
                        "SET password = '"+oldPass+"'\n" +
                        "WHERE userID = "+userid+";";
        
        try (Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement p = conn.prepareStatement(query)) {
            p.execute();
            passUpdated.setText("Updated Password");                
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnPassActionPerformed

    private void btnIconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIconActionPerformed
        JFileChooser ch = new JFileChooser();
        ch.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File file) {
                String name = file.getName().toLowerCase();
                return file.isDirectory() || name.endsWith(".png") || name.endsWith(".jpg");
            }

            @Override
            public String getDescription() {
                return "Image File";
            }
            
        });
        int option = ch.showOpenDialog(this);     
        if (option == JFileChooser.APPROVE_OPTION){
            File file = ch.getSelectedFile();
            ImageIcon icon = new ImageIcon(file.getAbsolutePath());
            imageAvatar1.setIcon(icon);
            repaint();
            
            String url = "jdbc:postgresql://localhost:5432/AthleteManagementSystem";
            String user = "postgres";
            String password = "Gravyboy1";
            
            String query = "UPDATE users SET profile =? WHERE userID =?;";
                    try (Connection conn = DriverManager.getConnection(url, user, password);
                        PreparedStatement p = conn.prepareStatement(query)) {
                        // Set the binary stream for the profile image
                        p.setBinaryStream(1, Files.newInputStream(file.toPath()), file.length());
                        // Set the user ID for the WHERE clause
                        p.setInt(2, userid); 
                        p.execute();
                        userSet.setProfile(icon);
                        iconUpdated.setText("Updated Icon");
                    } catch (IOException | SQLException e) {
                        System.err.println(e);
                    }
        }                                       
    }//GEN-LAST:event_btnIconActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button btnIcon;
    private swing.Button btnPass;
    private swing.Button btnUser;
    private swing.TextField changePass;
    private swing.TextField changeUserName;
    private javax.swing.JLabel iconUpdated;
    private swing.ImageAvatar imageAvatar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel passUpdated;
    private javax.swing.JLabel userUpdated;
    // End of variables declaration//GEN-END:variables
}
