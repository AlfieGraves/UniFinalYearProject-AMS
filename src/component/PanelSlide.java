
package component;

import finalyearproject.Main;
import form.Form_LogOut;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Path2D;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import model.Model_Card;
import model.Model_User;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;


public class PanelSlide extends javax.swing.JLayeredPane {
    
    public void setFrame(JFrame frame) {
        this.frame = frame;
    }
    
    private final Animator animator;
    private float animate = 1f;
    private boolean slideLeft;
    private final PanelLogin login;
    private final PanelLoading loading;
    private Thread th;
    private JFrame frame;
    
    private MigLayout layout;
    
    public PanelSlide() {
        initComponents();
        setPreferredSize(new Dimension(350, 450));
        layout = new MigLayout("inset 0", "[fill]", "[fill]");
        setLayout(layout);
        login = new PanelLogin();
        loading = new PanelLoading();
        loading.setVisible(false);
        Color color = Color.decode("#7AB2E1");
        setBackground(color);
        loading.setBackground(color);
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void begin() {
                if (slideLeft) {
                    loading.setVisible(true);
                }else {
                    login.setVisible(true);
                }
            }
            
            @Override
            public void timingEvent(float fraction) {
                double width = getWidth();
                animate = fraction;
                float a = easeOutQuint(fraction);
                int x = (int) (a * width);
                loading.setAnimate(slideLeft, fraction);
                layout.setComponentConstraints(loading, "pos " + x + " 0 100% 100%");
                revalidate();
                repaint();
            }    

            @Override
            public void end() {
                if (slideLeft) {
                    login.setVisible(false);
                }else {
                    loading.setVisible(false);
                    loading.reset();
                }
            }
            
        };
        animator = new Animator(1000, target);
        animator.setResolution(0);
        add(loading, " pos 0 0 0 0, w 0!");
        add(login);
        login.addEventLogin(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!animator.isRunning()) {
                    if(login.checkUser()){
                        showSlide(true);
                        login(login.getUserName(), login.getPassword());
                    }
                }
            }
        });
        loading.addEventContinue(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main main = new Main(loading.getData());
                main.setVisible(true);
                // close login
                frame.dispose();
                
            }     
        });
        loading.addEventBack(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!animator.isRunning()) {
                    th.interrupt();
                    showSlide(false);
                }
            }
        });
    }
    
    public void showSlide(boolean show) {
        slideLeft = show;
        animator.start();
    }
    
    private void login(String userName, String userPassword){
        th = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    
                    String url = "jdbc:postgresql://localhost:5432/AthleteManagementSystem";
                    String user = "postgres";
                    String password = "Gravyboy1";
                    
                    String query = "SELECT *\n" +
                                    "FROM users AS u\n" +
                                    "WHERE u.username ILIKE '"+userName+"' AND u.password ILIKE '"+userPassword+"';";
                    try (
                        // Establishing a connection
                        Connection conn = DriverManager.getConnection(url, user, password);
                        // Creating a statement
                        Statement stmt = conn.createStatement();
                        // Executing the query
                        ResultSet rs = stmt.executeQuery(query);
                        
                    ) {
                        if(rs.next()){
                            int Id = rs.getInt("userid");
                            String userNameSelected = rs.getString("username");
                            String passwordSelected = rs.getString("password");
                            Icon Profile;
                            if (rs.getObject("profile") != null){
                                Profile = new ImageIcon(rs.getBytes("profile"));
                            }else{
                                Profile = new ImageIcon(getClass().getResource("/icon/user.png"));
                            }
                            
                            Model_User data = new Model_User(Id,userNameSelected,Profile);
                            loading.doneLogin(data);
                        }else{
                            loading.showError("Username or Password Incorrect");
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    //TESTING
                    //loading.doneLogin(new Model_User(1,"Alfie", new ImageIcon(getClass().getResource("/icon/me.png"))));
                    //loading.showError("Username and Password Incorrect");
                } catch (InterruptedException e){
                    
                } catch(Exception e) {
                    loading.showError("Error Server");
                }
            }
        });
        
        th.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 459, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    
    @Override
    public void paint(Graphics grphcs) {
        super.paint(grphcs);
        if (slideLeft == false){
            Graphics2D g2 = (Graphics2D) grphcs.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            int width = getWidth();
            int height = getHeight();
            float x = easeOutQuint(animate) * width;
            float y = 0;
            int centerY = height / 2;
            Path2D.Float p = new Path2D.Float();
            p.moveTo(x, y);
            p.lineTo(x, height);
            p.curveTo(x, height, easeOutBounce(animate) * width, centerY, x, y);
            g2.setColor(getBackground());
            g2.fill(p);
            g2.dispose();
        }
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

    private float easeOutQuint(float x) {
        double v = 1 - Math.pow(1 - x, 5);
        if (slideLeft) {
            return (float) (1f -v);
        }else {
            return (float) v;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
