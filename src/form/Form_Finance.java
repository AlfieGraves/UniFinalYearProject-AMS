package form;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import swing.Player;


public class Form_Finance extends javax.swing.JPanel {
    
    private int overall;
    private int transfer;
    private int wageBudget;
    private int wageBill;
    private int scout;
    private int expenditureMonth;
    private int incomeMonth;
    private String url;
    private String user;
    private String password;
    
    public Form_Finance() {
        initComponents();
        setData();
        
    }
    
    public void setData() {
        overall = 268472226;
        transfer = 30600000;
        wageBudget = 4661173;
        wageBill = 0;
        scout = 390000;
        expenditureMonth = 82075;
        incomeMonth = 0;
        
        url = "jdbc:postgresql://localhost:5432/AthleteManagementSystem";
        user = "postgres";
        password = "Gravyboy1";
        
        String query = "SELECT ath.salary\n" +
                        "FROM athletes AS ath\n" +
                        "UNION\n" +
                        "SELECT coa.salary\n" +
                        "FROM coaches AS coa;";
        try (
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
        )  {
             while (rs.next()) {
                String salary = rs.getString("salary");
                if (salary == "" || salary == null){
                    
                }else{
                    double salaryValue = Double.parseDouble(salary);
                    wageBill = (int) (salaryValue + wageBill);
                }
                   
            }
            wageBudget = wageBudget-wageBill;
            budWage.setText("£"+wageBudget);
            wagelb.setText("Currently Spending: £"+wageBill);
            budTransfer.setText("£"+transfer);
            transferLb.setText("The Transfer Window is currently closed");
            budScout.setText("£"+scout);
            
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        ffp = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        budTransfer = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        budWage = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        budScout = new javax.swing.JLabel();
        transferLb = new javax.swing.JLabel();
        wagelb = new javax.swing.JLabel();
        scoutLb = new javax.swing.JLabel();
        income = new javax.swing.JPanel();
        expenditure = new javax.swing.JPanel();
        Balance = new javax.swing.JPanel();

        setBackground(new java.awt.Color(242, 240, 240));

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Finances:");

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel2.setText("Budgets");

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel3.setText("Transfer Budget");

        budTransfer.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        budTransfer.setText("£");

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel5.setText("Wage Budget");

        budWage.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        budWage.setText("£");

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel7.setText("Scouting Budget");

        budScout.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        budScout.setText("£");

        transferLb.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        transferLb.setForeground(new java.awt.Color(102, 102, 102));

        wagelb.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        wagelb.setForeground(new java.awt.Color(102, 102, 102));

        scoutLb.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        scoutLb.setForeground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout ffpLayout = new javax.swing.GroupLayout(ffp);
        ffp.setLayout(ffpLayout);
        ffpLayout.setHorizontalGroup(
            ffpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(ffpLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ffpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator3)
                    .addGroup(ffpLayout.createSequentialGroup()
                        .addGroup(ffpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(budTransfer)
                            .addComponent(jLabel5)
                            .addComponent(budWage)
                            .addComponent(jLabel7)
                            .addComponent(budScout)
                            .addComponent(transferLb)
                            .addComponent(wagelb)
                            .addComponent(scoutLb))
                        .addGap(0, 103, Short.MAX_VALUE)))
                .addContainerGap())
        );
        ffpLayout.setVerticalGroup(
            ffpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ffpLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel2)
                .addGap(5, 5, 5)
                .addComponent(jLabel3)
                .addGap(5, 5, 5)
                .addComponent(budTransfer)
                .addGap(5, 5, 5)
                .addComponent(transferLb)
                .addGap(5, 5, 5)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel5)
                .addGap(5, 5, 5)
                .addComponent(budWage)
                .addGap(5, 5, 5)
                .addComponent(wagelb)
                .addGap(5, 5, 5)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel7)
                .addGap(5, 5, 5)
                .addComponent(budScout)
                .addGap(5, 5, 5)
                .addComponent(scoutLb)
                .addGap(5, 5, 5)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(183, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout incomeLayout = new javax.swing.GroupLayout(income);
        income.setLayout(incomeLayout);
        incomeLayout.setHorizontalGroup(
            incomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );
        incomeLayout.setVerticalGroup(
            incomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout expenditureLayout = new javax.swing.GroupLayout(expenditure);
        expenditure.setLayout(expenditureLayout);
        expenditureLayout.setHorizontalGroup(
            expenditureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );
        expenditureLayout.setVerticalGroup(
            expenditureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout BalanceLayout = new javax.swing.GroupLayout(Balance);
        Balance.setLayout(BalanceLayout);
        BalanceLayout.setHorizontalGroup(
            BalanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        BalanceLayout.setVerticalGroup(
            BalanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(income, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(expenditure, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(Balance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(8, 8, 8)
                .addComponent(ffp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(income, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(expenditure, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Balance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(ffp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Balance;
    private javax.swing.JPanel Overall1;
    private javax.swing.JPanel Overall2;
    private javax.swing.JPanel Overall3;
    private javax.swing.JPanel Overall4;
    private javax.swing.JPanel Overall5;
    private javax.swing.JPanel Overall6;
    private javax.swing.JPanel Overall7;
    private javax.swing.JPanel Overall8;
    private javax.swing.JLabel budScout;
    private javax.swing.JLabel budTransfer;
    private javax.swing.JLabel budWage;
    private javax.swing.JPanel expenditure;
    private javax.swing.JPanel ffp;
    private javax.swing.JPanel income;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel scoutLb;
    private javax.swing.JLabel transferLb;
    private javax.swing.JLabel wagelb;
    // End of variables declaration//GEN-END:variables
}
