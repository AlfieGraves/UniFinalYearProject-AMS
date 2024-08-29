
package component;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import java.awt.geom.Path2D;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import model.Model_User;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;


public class PanelLoading extends javax.swing.JLayeredPane {
    
    public Model_User getData() {
        return data;
    }

    private final Animator animator;
    private boolean isMessage;
    private boolean slideLeft;
    private float animate;
    private Model_User data;
    
    public PanelLoading() {
        initComponents();
        loading.setVisible(true);
        profile.setVisible(false);
        message.setVisible(false);
        TimingTarget target = new TimingTargetAdapter(){
            @Override
            public void begin() {
                if (isMessage) {
                    message.setVisible(true);
                } else {
                    profile.setVisible(true);
                }
            }

            @Override
            public void timingEvent(float fraction) {
                if (isMessage) {
                    message.setAlpha(fraction);
                    loading.setAlpha(1f - fraction);
                } else {
                    profile.setAlpha(fraction);
                    loading.setAlpha(1f - fraction);
                }
                repaint();
            }
            
            
        };
        animator = new Animator(500, target);
        animator.setResolution(0);
    }

    public void setAnimate(boolean slideLeft, float animate){
        this.slideLeft = slideLeft;
        this.animate = animate;
    }
    
    public void addEventBack(ActionListener event){
        cmdCancel.addActionListener(event);
        cmdCancel1.addActionListener(event);
        cmdCancel2.addActionListener(event);
    }
    
    public void addEventContinue(ActionListener event){
        cmdContinue.addActionListener(event);
    }
    
    public void doneLogin(Model_User data) {
        isMessage = false;
        this.data = data;
        user.setIcon(data.getProfile());
        cmdContinue.setText("Contiune with "+ data.getUserName());
        animator.start();
    }
    
    public void showError(String ms) {
        lbMsg.setText(ms);
        isMessage = true;
        animator.start();
    }
    
    public void reset() {
        loading.setAlpha(1f);
        loading.setVisible(true);
        profile.setVisible(false);
        message.setVisible(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        profile = new swing.PanelTransparent();
        cmdCancel1 = new swing.Button();
        user = new swing.ImageAvatar();
        cmdEdit = new swing.EditButton();
        cmdContinue = new swing.Button();
        loading = new swing.PanelTransparent();
        cmdCancel = new swing.Button();
        jLabel1 = new javax.swing.JLabel();
        message = new swing.PanelTransparent();
        cmdCancel2 = new swing.Button();
        lbMsg = new javax.swing.JLabel();

        setLayout(new java.awt.CardLayout());

        cmdCancel1.setBackground(new java.awt.Color(122, 178, 225));
        cmdCancel1.setForeground(new java.awt.Color(255, 255, 255));
        cmdCancel1.setText("Cancel Login");
        cmdCancel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCancel1ActionPerformed(evt);
            }
        });

        user.setBackground(new java.awt.Color(122, 178, 225));
        user.setForeground(new java.awt.Color(188, 188, 188));
        user.setBorderSize(3);
        user.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/user.png"))); // NOI18N
        user.setOpaque(true);

        cmdEdit.setBackground(new java.awt.Color(65, 65, 65));
        cmdEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/edit.png"))); // NOI18N
        cmdEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdEditActionPerformed(evt);
            }
        });
        user.add(cmdEdit);
        cmdEdit.setBounds(100, 100, 50, 50);

        cmdContinue.setBackground(new java.awt.Color(133, 191, 240));
        cmdContinue.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        cmdContinue.setForeground(new java.awt.Color(255, 255, 255));
        cmdContinue.setText("Continue");
        cmdContinue.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N

        javax.swing.GroupLayout profileLayout = new javax.swing.GroupLayout(profile);
        profile.setLayout(profileLayout);
        profileLayout.setHorizontalGroup(
            profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profileLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, profileLayout.createSequentialGroup()
                        .addComponent(cmdCancel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(125, 125, 125))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, profileLayout.createSequentialGroup()
                        .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100))))
            .addGroup(profileLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(cmdContinue, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        profileLayout.setVerticalGroup(
            profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, profileLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(cmdContinue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addComponent(cmdCancel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        add(profile, "card2");

        cmdCancel.setBackground(new java.awt.Color(122, 178, 225));
        cmdCancel.setForeground(new java.awt.Color(255, 255, 255));
        cmdCancel.setText("Cancel Login");
        cmdCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCancelActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/loading.gif"))); // NOI18N

        javax.swing.GroupLayout loadingLayout = new javax.swing.GroupLayout(loading);
        loading.setLayout(loadingLayout);
        loadingLayout.setHorizontalGroup(
            loadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loadingLayout.createSequentialGroup()
                .addGroup(loadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loadingLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(loadingLayout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(cmdCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );
        loadingLayout.setVerticalGroup(
            loadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loadingLayout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addComponent(cmdCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );

        add(loading, "card2");

        cmdCancel2.setBackground(new java.awt.Color(122, 178, 225));
        cmdCancel2.setForeground(new java.awt.Color(255, 255, 255));
        cmdCancel2.setText("Cancel Login");
        cmdCancel2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCancel2ActionPerformed(evt);
            }
        });

        lbMsg.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        lbMsg.setForeground(new java.awt.Color(227, 70, 70));
        lbMsg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMsg.setText("Message");

        javax.swing.GroupLayout messageLayout = new javax.swing.GroupLayout(message);
        message.setLayout(messageLayout);
        messageLayout.setHorizontalGroup(
            messageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(messageLayout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(cmdCancel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(125, 125, 125))
            .addGroup(messageLayout.createSequentialGroup()
                .addComponent(lbMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        messageLayout.setVerticalGroup(
            messageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, messageLayout.createSequentialGroup()
                .addContainerGap(185, Short.MAX_VALUE)
                .addComponent(lbMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(138, 138, 138)
                .addComponent(cmdCancel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        add(message, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void cmdCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCancelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdCancelActionPerformed

    private void cmdCancel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCancel1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdCancel1ActionPerformed

    private void cmdCancel2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCancel2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdCancel2ActionPerformed

    private void cmdEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdEditActionPerformed
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
            user.setIcon(icon);
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
                        p.setInt(2, data.getUserID()); 
                        p.execute();
                        data.setProfile(icon);
                    } catch (IOException | SQLException e) {
                        System.err.println(e);
                    }
        }
    }//GEN-LAST:event_cmdEditActionPerformed

    @Override
    public void paint(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.decode("#7AB2E1"));
        int width = getWidth();
        int height = getHeight();
        int x = 0;
        int y = 0;
        if (slideLeft) {
            int centerY = height / 2;
            Path2D.Float p = new Path2D.Float();
            p.moveTo(x, y);
            p.lineTo(width, y);
            p.lineTo(width, height);
            p.lineTo(x, height);
            p.curveTo(x, height, easeOutBounce(animate) * width, centerY, x, y);
            g2.fill(p);
        } else {
            g2.fillRect(x, y, width, height);
        }
        g2.dispose();
        super.paint(grphcs);
    }
    
    private float easeOutBounce(float x) {
        float n1 = 7.5625f;
        float d1 = 2.75f;
        double v;
        if (x < 1 / d1) {
            v = n1 * x * x;
        } else if (x < 2 / d1) {
            v = n1 * (x -= 1.5 / d1) * x + 0.75;
        } else if (x < 2.5 / d1) {
            v = n1 * (x -= 2.25 / d1) * x + 0.9375;
        } else {
            v = n1 * (x -= 2.625 / d1) * x + 0.984375;
        }
        if (slideLeft) {
            return (float) (1f -v);
        }else {
            return (float) v;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button cmdCancel;
    private swing.Button cmdCancel1;
    private swing.Button cmdCancel2;
    private swing.Button cmdContinue;
    private swing.EditButton cmdEdit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbMsg;
    private swing.PanelTransparent loading;
    private swing.PanelTransparent message;
    private swing.PanelTransparent profile;
    private swing.ImageAvatar user;
    // End of variables declaration//GEN-END:variables
}
