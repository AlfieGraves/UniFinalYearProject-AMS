package form;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.ImageIcon;
import model.Model_Card;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Model_User;



/**
 *
 * @author alfiegraves
 */
public class Form_Home extends javax.swing.JPanel {

    public Form_Home(Model_User userData) {
        initComponents();
        String url = "jdbc:postgresql://localhost:5432/AthleteManagementSystem";
        String user = "postgres";
        String password = "Gravyboy1";
        
        String query = "SELECT *\n" +
                       "FROM Fixtures\n" +
                       "WHERE FixtureDate >= '2044-02-08'\n" +
                       "ORDER BY FixtureDate\n" +
                       "LIMIT 1;";
        
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
                String opponent = rs.getString("opponent");
                String date = rs.getString("fixturedate");
                Boolean atHome = rs.getBoolean("athome");
                String comp = rs.getString("fixturecomp");
                
                if (atHome.equals(true)){
                    card1.setData(new Model_Card(new ImageIcon(getClass().getResource("/icon/3.png")),"Upcoming Game",opponent + " (" + comp + ")",
                "The game is at home on the "+ date.substring(5,date.length())));
                } else if (atHome.equals(false)){
                    card1.setData(new Model_Card(new ImageIcon(getClass().getResource("/icon/3.png")),"Upcoming Game",opponent + " (" + comp + ")",
                "The game is at away on the "+ date.substring(5,date.length())));
                } else {
                    card1.setData(new Model_Card(new ImageIcon(getClass().getResource("/icon/3.png")),"Upcoming Game",opponent + " (" + comp + ")",
                "The game location is unknown on the "+ date.substring(5,date.length())));
                }     
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        card2.setData(new Model_Card(new ImageIcon(getClass().getResource("/icon/10.png")),"Messages","Bit of latest message", "from who"));
        card3.setData(new Model_Card(new ImageIcon(getClass().getResource("/icon/8.png")),"Account",userData.getUserName(), "Welcome Back!!"));

        // SQL query
        query = "SELECT a.FirstName,\n" +
                       "       a.LastName,\n" +
                       "       jt.JobTypeName,\n" +
                       "       a.Salary,\n" +
                       "       a.Squad\n" +
                       "FROM Athletes AS a\n" +
                       "JOIN JobType AS jt ON jt.JobTypeID = a.JobTypeID\n" +
                       "\n" +
                       "UNION ALL\n" +
                       "\n" +
                       "SELECT c.FirstName,\n" +
                       "       c.LastName,\n" +
                       "       jt.JobTypeName,\n" +
                       "       c.Salary,\n" +
                       "       c.Squad\n" +
                       "FROM Coaches AS c\n" +
                       "JOIN JobType AS jt ON jt.JobTypeID = c.JobTypeID\n" +
                       "ORDER By squad;";
        
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
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
                String jobType = rs.getString("JobTypeName");
                String salary = rs.getString("Salary");
                String squad = rs.getString("Squad");
                
                TableDash.addRow(new Object[]{firstName, lastName, jobType, "£"+salary,squad});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        
        
      
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel = new javax.swing.JLayeredPane();
        card1 = new component.Card();
        card2 = new component.Card();
        card3 = new component.Card();
        panelBorder2 = new component.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableDash = new swing.Table();

        setBackground(new java.awt.Color(242, 240, 240));

        Panel.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        card1.setColour1(new java.awt.Color(142, 142, 250));
        card1.setColour2(new java.awt.Color(123, 123, 245));
        Panel.add(card1);

        card2.setColour1(new java.awt.Color(186, 123, 247));
        card2.setColour2(new java.awt.Color(167, 94, 236));
        Panel.add(card2);

        card3.setColour1(new java.awt.Color(241, 208, 62));
        card3.setColour2(new java.awt.Color(211, 184, 61));
        Panel.add(card3);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(127, 127, 127));
        jLabel1.setText("All Staff/Players");

        jScrollPane1.setBorder(null);

        TableDash.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "First Name", "Last Name", "Job Type", "Salary", "Squad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TableDash);

        javax.swing.GroupLayout panelBorder2Layout = new javax.swing.GroupLayout(panelBorder2);
        panelBorder2.setLayout(panelBorder2Layout);
        panelBorder2Layout.setHorizontalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 745, Short.MAX_VALUE)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelBorder2Layout.setVerticalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelBorder2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(panelBorder2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane Panel;
    private swing.Table TableDash;
    private component.Card card1;
    private component.Card card2;
    private component.Card card3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private component.PanelBorder panelBorder2;
    // End of variables declaration//GEN-END:variables
}
