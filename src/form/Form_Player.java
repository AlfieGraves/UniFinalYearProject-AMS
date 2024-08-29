package form;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author alfiegraves
 */
public class Form_Player extends javax.swing.JPanel {

    /**
     * Creates new form Form_Player
     */
    public Form_Player() {
        initComponents();
        String url = "jdbc:postgresql://localhost:5432/AthleteManagementSystem";
        String user = "postgres";
        String password = "Gravyboy1";
        
        String query = "SELECT a.firstname,a.lastname,p.positionname,a.height,a.weight,a.squad\n" +
                        "FROM athletes AS a\n" +
                        "JOIN positions AS p ON a.positionid = p.positionid\n" +
                        "ORDER BY a.positionid DESC;";
         try (
            // Establishing a connection
            Connection conn = DriverManager.getConnection(url, user, password);
            // Creating a statement
            Statement stmt = conn.createStatement();
            // Executing the query
            ResultSet rs = stmt.executeQuery(query);
        )  {
             while (rs.next()) {
                String firstName = rs.getString("firstname");
                String lastName = rs.getString("lastname");
                String posName = rs.getString("positionname");
                String height = rs.getString("height");
                String weight = rs.getString("weight");
                String squad = rs.getString("squad");
                
               table1.addRow(new Object[]{firstName, lastName, posName, height, weight, squad});
            }
          
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table1 = new swing.Table();

        setBackground(new java.awt.Color(242, 240, 240));

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Current Players:");

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "First Name", "Last Name", "Position", "Height", "Weigth", "Squad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(table1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private swing.Table table1;
    // End of variables declaration//GEN-END:variables
}