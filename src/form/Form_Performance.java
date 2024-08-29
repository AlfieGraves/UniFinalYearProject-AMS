
package form;

import java.awt.List;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import swing.Player;


public class Form_Performance extends javax.swing.JPanel {

    private ArrayList<Player> playerList; // Use ArrayList from java.util
    private String url;
    private String user;
    private String password;
    private int count = 0;
    private double sumPerres = 0;
    private double highestPerres = Double.MIN_VALUE;
    private double lowestPerres = Double.MAX_VALUE;

    public Form_Performance() {
        initComponents();
        
        playerList = new ArrayList<>(); 
        
        url = "jdbc:postgresql://localhost:5432/AthleteManagementSystem";
        user = "postgres";
        password = "Gravyboy1";
        
        
        String query = "SELECT a.athleteid,a.firstname, a.lastname\n" +
                        "FROM athletes AS a;";
        try (
            // Establishing a connection
            Connection conn = DriverManager.getConnection(url, user, password);
            // Creating a statement
            Statement stmt = conn.createStatement();
            // Executing the query
            ResultSet rs = stmt.executeQuery(query);
        )  {
             while (rs.next()) {
                String id = rs.getString("athleteid");
                String firstName = rs.getString("firstname");
                String lastName = rs.getString("lastname");
                
                dropPlayer.addItem(firstName+" "+lastName);
                Player player = new Player(id, firstName, lastName);
                playerList.add(player);
                }
          
        } catch (SQLException e) {
            e.printStackTrace();
        }
        dropPlayer.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                appearences.setText("0");
                averageRating.setText("0");
                maxRating.setText("0");
                minRating.setText("0");
                count = 0;
                sumPerres = 0;
                highestPerres = Double.MIN_VALUE;
                lowestPerres = Double.MAX_VALUE;
                DefaultTableModel dtm = (DefaultTableModel) table1.getModel();
                dtm.setRowCount(0);
                if (e.getStateChange() == ItemEvent.SELECTED && !dropPlayer.getSelectedItem().equals("Players")) {
                    String selectedItem = (String) dropPlayer.getSelectedItem();
                    String firstName = selectedItem.substring(0, selectedItem.indexOf(" "));
                    String lastName = selectedItem.substring(selectedItem.indexOf(" ") + 1);

                    Player player = getPlayerByName(firstName, lastName);
                    String id = player.getId();

                    String query = "SELECT per.opponent, pos.positionname, per.performanceresult, per.competition\n" +
                                   "FROM performances AS per \n" +
                                   "JOIN athletes AS ath ON per.athleteid = ath.athleteid\n" +
                                   "JOIN positions AS pos ON ath.positionid = pos.positionid\n" +
                                   "WHERE per.athleteid = '" + id + "'\n" +
                                   "ORDER BY per.performancedate;";

                    try (
                        // Establishing a connection
                        Connection conn = DriverManager.getConnection(url, user, password);
                        // Creating a statement
                        Statement stmt = conn.createStatement();
                        // Executing the query
                        ResultSet rs = stmt.executeQuery(query);
                    ) {

                        while (rs.next()) {
                            String opponent = rs.getString("opponent");
                            String posname = rs.getString("positionname");
                            String perres = rs.getString("performanceresult");
                            String comp = rs.getString("competition");

                            // Convert performanceresult to double for numerical operations
                            double perresDouble = Double.parseDouble(perres);

                            // Update count
                            count++;

                            // Update sum of performanceresult
                            sumPerres += perresDouble;

                            // Update highest and lowest performanceresult
                            if (perresDouble > highestPerres) {
                                highestPerres = perresDouble;
                            }
                            if (perresDouble < lowestPerres) {
                                lowestPerres = perresDouble;
                            }

                            // Add row to the table
                            table1.addRow(new Object[]{opponent, comp, posname, perres});
                        }

                        // Calculate average performanceresult
                        double averagePerres = sumPerres / count;
                        
                        appearences.setText(count+"");
                        averageRating.setText(averagePerres+"");
                        maxRating.setText(highestPerres+"");
                        minRating.setText(lowestPerres+"");

                    } catch (SQLException a) {
                        a.printStackTrace();
                    }
                }
            }
        });
    }

    public Player getPlayerByName(String firstName, String lastName) {
    for (Player player : playerList) {
        if (player.getFirstName().equals(firstName) && player.getLastName().equals(lastName)) {
            return player;
        }
    }
    return null; 
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        dropPlayer = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new swing.Table();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        appearences = new javax.swing.JLabel();
        maxRating = new javax.swing.JLabel();
        minRating = new javax.swing.JLabel();
        averageRating = new javax.swing.JLabel();

        setBackground(new java.awt.Color(242, 240, 240));

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Performance Reports:");

        dropPlayer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Players" }));

        jLabel2.setText("Select Player:");

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Opponent", "Competition", "Position", "Rating"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table1);

        jLabel3.setText("Appearances:");

        jLabel4.setText("Max Rating:");

        jLabel5.setText("Min Rating:");

        jLabel6.setText("Average Rating:");

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel7.setText("Match Statisics:");

        appearences.setText("0");

        maxRating.setText("0");

        minRating.setText("0");

        averageRating.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(appearences))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(maxRating))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(minRating))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(averageRating))
                            .addComponent(jLabel7))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dropPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(71, 71, 71))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(dropPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(appearences))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(maxRating))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(minRating))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(averageRating))
                        .addGap(0, 174, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel appearences;
    private javax.swing.JLabel averageRating;
    private javax.swing.JComboBox<String> dropPlayer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel maxRating;
    private javax.swing.JLabel minRating;
    private swing.Table table1;
    // End of variables declaration//GEN-END:variables
}
