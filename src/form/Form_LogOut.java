package form;

import finalyearproject.Login;
import javax.swing.JFrame;


public class Form_LogOut extends javax.swing.JPanel {

    private final JFrame frame;
    
    public Form_LogOut(JFrame frame) {
        this.frame = frame;
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdLogOut = new swing.Button();

        setBackground(new java.awt.Color(242, 240, 240));

        cmdLogOut.setBackground(new java.awt.Color(25, 182, 247));
        cmdLogOut.setForeground(new java.awt.Color(255, 255, 255));
        cmdLogOut.setText("Click Here To Logout");
        cmdLogOut.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        cmdLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdLogOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(cmdLogOut, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(193, 193, 193)
                .addComponent(cmdLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(236, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdLogOutActionPerformed
        frame.dispose();
        Login login = new Login();
        login.setVisible(true);
        
    }//GEN-LAST:event_cmdLogOutActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button cmdLogOut;
    // End of variables declaration//GEN-END:variables
}
