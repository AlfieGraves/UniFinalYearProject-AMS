
package form;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Model_Message;
import model.Model_User;
import service.Email;

public class Form_AboutUser extends javax.swing.JPanel {
    
    public String email;
    public String url;
    public String user;
    public String password;

  
    public Form_AboutUser(Model_User userData) {
        initComponents();
        
        lbName.setText(userData.getUserName());
        icon.setIcon(userData.getProfile());
        
        url = "jdbc:postgresql://localhost:5432/AthleteManagementSystem";
        user = "postgres";
        password = "Gravyboy1";
        
        String query = "SELECT u.username, u.email\n" +
                        "FROM users AS u\n" +
                        "WHERE u.email ~* '^[^@\\s]+@[^@\\s]+(\\.[^@\\s]+)+$';";
        try (
            // Establishing a connection
            Connection conn = DriverManager.getConnection(url, user, password);
            // Creating a statement
            Statement stmt = conn.createStatement();
            // Executing the query
            ResultSet rs = stmt.executeQuery(query);
        ) {
            // Processing the results
            while (rs.next()) {
                String userName = rs.getString("username");
                String email = rs.getString("email");
                
                contactList.addItem(userName);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        icon = new swing.ImageAvatar();
        jLabel2 = new javax.swing.JLabel();
        lbName = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        contactList = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cmdSend = new swing.Button();
        lbInfo = new javax.swing.JLabel();

        setBackground(new java.awt.Color(242, 240, 240));

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Your Account & Messages:");

        jLabel2.setText("Account Name:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        contactList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Contacts" }));

        jLabel4.setText("Select Contact:");

        cmdSend.setBackground(new java.awt.Color(25, 182, 247));
        cmdSend.setForeground(new java.awt.Color(255, 255, 255));
        cmdSend.setText("Send Email");
        cmdSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSendActionPerformed(evt);
            }
        });

        lbInfo.setForeground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(cmdSend, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbInfo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 306, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(contactList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(lbName))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbName)
                        .addGap(77, 77, 77)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(contactList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(cmdSend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbInfo))
                        .addGap(3, 3, 3)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSendActionPerformed
        if (contactList.getSelectedItem().equals("Contacts") && jTextArea1.getText().isEmpty()) {
            lbInfo.setText("Please select a contact and begin typing an email");
        } else if (contactList.getSelectedItem().equals("Contacts")) {
            lbInfo.setText("Please select a contact");
        } else if (jTextArea1.getText().isEmpty()) {
            lbInfo.setText("Please begin typing an email");
        } else {
            String query = "SELECT u.email\n" +
            "FROM users AS u\n" +
            "WHERE u.username ~* '"+contactList.getSelectedItem()+"';";

            try (
                // Establishing a connection
                Connection conn = DriverManager.getConnection(url, user, password);
                // Creating a statement
                Statement stmt = conn.createStatement();
                // Executing the query
                ResultSet rs = stmt.executeQuery(query);
            ) {
                // Processing the results
                while (rs.next()) {
                    email = rs.getString("email");

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            Email emailSend = new Email();
            String to = this.email;
            String from = "alfietestmail1@gmail.com";
            String subject = "AMS Message";
            String text = jTextArea1.getText();

            int k = emailSend.send(to, from, subject, text);
            
            if (k == 0){
                lbInfo.setText("Email Error");
            } else {
                revalidate();
                repaint();
                lbInfo.setText("Email Sent");
            }
        }
    }//GEN-LAST:event_cmdSendActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button cmdSend;
    private javax.swing.JComboBox<String> contactList;
    private swing.ImageAvatar icon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lbInfo;
    private javax.swing.JLabel lbName;
    // End of variables declaration//GEN-END:variables
}
