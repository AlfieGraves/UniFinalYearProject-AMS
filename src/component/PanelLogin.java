
package component;

import java.awt.event.ActionListener;

public class PanelLogin extends javax.swing.JPanel {

    
    public PanelLogin() {
        initComponents();
        setOpaque(false);
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtUser = new swing.TextField();
        jLabel1 = new javax.swing.JLabel();
        txtPass = new swing.PasswordField();
        cmd = new swing.Button();

        txtUser.setLabelText("User Name");
        txtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(74, 74, 74));
        jLabel1.setText("Sign In");

        txtPass.setLabelText("Password");

        cmd.setBackground(new java.awt.Color(25, 182, 247));
        cmd.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        cmd.setForeground(new java.awt.Color(255, 255, 255));
        cmd.setText("Login");
        cmd.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(txtUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmd, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1)
                .addGap(50, 50, 50)
                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(cmd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    public void addEventLogin(ActionListener event){
        cmd.addActionListener(event);
    }
    
    public boolean checkUser(){
        return !(txtUser.getText().trim().equals("") || String.valueOf(txtPass.getPassword()).trim().equals(""));
    }
    
    public String getUserName(){
        return txtUser.getText().trim();  
    }
    
    public String getPassword(){
        return String.valueOf(txtPass.getPassword());
    }
    
    private void txtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button cmd;
    private javax.swing.JLabel jLabel1;
    private swing.PasswordField txtPass;
    private swing.TextField txtUser;
    // End of variables declaration//GEN-END:variables
}
