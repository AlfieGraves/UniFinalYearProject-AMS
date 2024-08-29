
package component;

import component.CalendarCustom;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JLabel;
import swing.Cell;
import swing.ToDay;


public class PanelDate extends javax.swing.JLayeredPane {
    
    private int month;
    private int year;
    private CalendarCustom calendarCustom; // Declare a reference to CalendarCustom

    public PanelDate(int month, int year, CalendarCustom calendarCustom) {
        initComponents();
        this.month = month;
        this.year = year;
        this.calendarCustom = calendarCustom; // Set the reference to CalendarCustom
        init();
    }

    
    private void init() {
        
        mon.asTitle();
        tue.asTitle();
        wed.asTitle();
        thu.asTitle();
        fri.asTitle();
        sat.asTitle();
        sun.asTitle();
        setDate();
        addActionListenersToDataCells();
    }
    
    private void setDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2044);
        calendar.set(Calendar.MONTH, month - 1);  
        calendar.set(Calendar.DATE, 1);
        int startDay = calendar.get(Calendar.DAY_OF_WEEK) - 1; 
        calendar.add(Calendar.DATE, -startDay);
        ToDay toDay = getToDay();
        for (Component com : getComponents()) {
            Cell cell = (Cell) com;
            if (!cell.isTitle()) {
                cell.setText(calendar.get(Calendar.DATE) + "");
                cell.setDate(calendar.getTime());
                cell.currentMonth(calendar.get(Calendar.MONTH) == month - 1);
                if (toDay.isToDay(new ToDay(calendar.get(Calendar.DATE), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.YEAR)))) {
                    cell.setAsToDay();
                }
                calendar.add(Calendar.DATE, 1); //  up 1 day
            }
        }
    }
    
private Cell previousClickedCell = null;

private void addActionListenersToDataCells() {
    for (Component com : getComponents()) {
        Cell cell = (Cell) com;
        if (!cell.isTitle()) {
            cell.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    displayFixtures(cell);
                }
            });
        }
    }
}

private void displayFixtures(Cell clickedCell) {
    SimpleDateFormat sdf = new SimpleDateFormat("d");
    Date date = null;
    try {
        // Parse the day text from the cell
        int day = Integer.parseInt(clickedCell.getText());
        // Create a Calendar instance to set the correct month and year
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2044); // Set the year to 2044
        cal.set(Calendar.MONTH, month - 1); // Set the month based on the current panel's month
        cal.set(Calendar.DAY_OF_MONTH, day); 

        // Get the Date object from the Calendar instance
        date = cal.getTime();

        String url = "jdbc:postgresql://localhost:5432/AthleteManagementSystem";
        String user = "postgres";
        String password = "Gravyboy1";
        
        String query = "SELECT f.opponent, f.athome, f.fixturecomp\n" +
                        "FROM fixtures as f\n" +
                        "WHERE f.fixturedate = '"+date+"';";
        
        try (
            // Establishing a connection
            Connection conn = DriverManager.getConnection(url, user, password);
            // Creating a statement
            Statement stmt = conn.createStatement();
            // Executing the query
            ResultSet rs = stmt.executeQuery(query);
             
         ){
            boolean hasEvents = false; // Flag to check if there are events for this day
            while (rs.next()) {
                hasEvents = true; // There are events for this day
                String opponentName = rs.getString("opponent");
                String atHome = rs.getString("athome");
                String fixtureComp = rs.getString("fixturecomp");
                
                if (!opponentName.isBlank() && !atHome.isBlank() && !fixtureComp.isBlank()){
                    if(atHome.equals("f")){
                        atHome = "Away";
                    } else {
                        atHome = "Home";
                    }
                    calendarCustom.eventLb.setText("<html>" + opponentName + "<br/>In a " + atHome + " fixture<br/>In the "+ fixtureComp + "</html>");
    
                }
            }
            
            // If there are no events for this day, display "No Events on this day"
            if (!hasEvents) {
                calendarCustom.eventLb.setText("No Events On This Day");
            } else {
                // Set the text of lbDate with the formatted date obtained from the clicked cell
                SimpleDateFormat df = new SimpleDateFormat("EEEE, dd/MM-yyyy");
                String formattedDate = df.format(date);
                calendarCustom.lbDate.setText(formattedDate);
            }
            
            // Store the reference to the clicked cell in previousClickedCell
            previousClickedCell = clickedCell;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    } catch (NumberFormatException ex) {
        ex.printStackTrace();
    }
}

 
    private ToDay getToDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        return new ToDay(calendar.get(Calendar.DATE), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.YEAR));
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sun = new swing.Cell();
        mon = new swing.Cell();
        tue = new swing.Cell();
        wed = new swing.Cell();
        thu = new swing.Cell();
        fri = new swing.Cell();
        sat = new swing.Cell();
        cell8 = new swing.Cell();
        cell9 = new swing.Cell();
        cell10 = new swing.Cell();
        cell11 = new swing.Cell();
        cell12 = new swing.Cell();
        cell13 = new swing.Cell();
        cell14 = new swing.Cell();
        cell15 = new swing.Cell();
        cell16 = new swing.Cell();
        cell17 = new swing.Cell();
        cell18 = new swing.Cell();
        cell19 = new swing.Cell();
        cell20 = new swing.Cell();
        cell21 = new swing.Cell();
        cell22 = new swing.Cell();
        cell23 = new swing.Cell();
        cell24 = new swing.Cell();
        cell25 = new swing.Cell();
        cell26 = new swing.Cell();
        cell27 = new swing.Cell();
        cell28 = new swing.Cell();
        cell29 = new swing.Cell();
        cell30 = new swing.Cell();
        cell31 = new swing.Cell();
        cell32 = new swing.Cell();
        cell33 = new swing.Cell();
        cell34 = new swing.Cell();
        cell35 = new swing.Cell();
        cell36 = new swing.Cell();
        cell37 = new swing.Cell();
        cell38 = new swing.Cell();
        cell39 = new swing.Cell();
        cell40 = new swing.Cell();
        cell41 = new swing.Cell();
        cell42 = new swing.Cell();
        cell43 = new swing.Cell();
        cell44 = new swing.Cell();
        cell45 = new swing.Cell();
        cell46 = new swing.Cell();
        cell47 = new swing.Cell();
        cell48 = new swing.Cell();
        cell49 = new swing.Cell();

        setLayout(new java.awt.GridLayout(7, 7));

        sun.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        sun.setForeground(new java.awt.Color(255, 51, 51));
        sun.setText("Sun");
        sun.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        sun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sunActionPerformed(evt);
            }
        });
        add(sun);

        mon.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        mon.setText("Mon");
        mon.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        mon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monActionPerformed(evt);
            }
        });
        add(mon);

        tue.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tue.setText("Tue");
        tue.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        add(tue);

        wed.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        wed.setText("Wed");
        wed.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        add(wed);

        thu.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        thu.setText("Thu");
        thu.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        add(thu);

        fri.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        fri.setText("Fri");
        fri.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        add(fri);

        sat.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        sat.setText("Sat");
        sat.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        add(sat);

        cell8.setBackground(new java.awt.Color(140, 197, 255));
        cell8.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cell8.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        add(cell8);

        cell9.setBackground(new java.awt.Color(140, 197, 255));
        cell9.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cell9.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        add(cell9);

        cell10.setBackground(new java.awt.Color(140, 197, 255));
        cell10.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cell10.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        add(cell10);

        cell11.setBackground(new java.awt.Color(140, 197, 255));
        cell11.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cell11.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        add(cell11);

        cell12.setBackground(new java.awt.Color(140, 197, 255));
        cell12.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cell12.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        add(cell12);

        cell13.setBackground(new java.awt.Color(140, 197, 255));
        cell13.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cell13.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        add(cell13);

        cell14.setBackground(new java.awt.Color(140, 197, 255));
        cell14.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cell14.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        add(cell14);

        cell15.setBackground(new java.awt.Color(140, 197, 255));
        cell15.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cell15.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        add(cell15);

        cell16.setBackground(new java.awt.Color(140, 197, 255));
        cell16.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cell16.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        cell16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cell16ActionPerformed(evt);
            }
        });
        add(cell16);

        cell17.setBackground(new java.awt.Color(140, 197, 255));
        cell17.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cell17.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        add(cell17);

        cell18.setBackground(new java.awt.Color(140, 197, 255));
        cell18.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cell18.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        add(cell18);

        cell19.setBackground(new java.awt.Color(140, 197, 255));
        cell19.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cell19.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        add(cell19);

        cell20.setBackground(new java.awt.Color(140, 197, 255));
        cell20.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cell20.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        add(cell20);

        cell21.setBackground(new java.awt.Color(140, 197, 255));
        cell21.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cell21.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        add(cell21);

        cell22.setBackground(new java.awt.Color(140, 197, 255));
        cell22.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cell22.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        add(cell22);

        cell23.setBackground(new java.awt.Color(140, 197, 255));
        cell23.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cell23.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        add(cell23);

        cell24.setBackground(new java.awt.Color(140, 197, 255));
        cell24.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cell24.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        add(cell24);

        cell25.setBackground(new java.awt.Color(140, 197, 255));
        cell25.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cell25.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        add(cell25);

        cell26.setBackground(new java.awt.Color(140, 197, 255));
        cell26.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cell26.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        add(cell26);

        cell27.setBackground(new java.awt.Color(140, 197, 255));
        cell27.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cell27.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        add(cell27);

        cell28.setBackground(new java.awt.Color(140, 197, 255));
        cell28.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cell28.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        add(cell28);

        cell29.setBackground(new java.awt.Color(140, 197, 255));
        cell29.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cell29.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        add(cell29);

        cell30.setBackground(new java.awt.Color(140, 197, 255));
        cell30.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cell30.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        add(cell30);

        cell31.setBackground(new java.awt.Color(140, 197, 255));
        cell31.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cell31.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        add(cell31);

        cell32.setBackground(new java.awt.Color(140, 197, 255));
        cell32.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cell32.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        add(cell32);

        cell33.setBackground(new java.awt.Color(140, 197, 255));
        cell33.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cell33.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        add(cell33);

        cell34.setBackground(new java.awt.Color(140, 197, 255));
        cell34.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cell34.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        add(cell34);

        cell35.setBackground(new java.awt.Color(140, 197, 255));
        cell35.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cell35.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        add(cell35);

        cell36.setBackground(new java.awt.Color(140, 197, 255));
        cell36.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cell36.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        add(cell36);

        cell37.setBackground(new java.awt.Color(140, 197, 255));
        cell37.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cell37.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        add(cell37);

        cell38.setBackground(new java.awt.Color(140, 197, 255));
        cell38.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cell38.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        add(cell38);

        cell39.setBackground(new java.awt.Color(140, 197, 255));
        cell39.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cell39.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        add(cell39);

        cell40.setBackground(new java.awt.Color(140, 197, 255));
        cell40.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cell40.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        add(cell40);

        cell41.setBackground(new java.awt.Color(140, 197, 255));
        cell41.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cell41.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        add(cell41);

        cell42.setBackground(new java.awt.Color(140, 197, 255));
        cell42.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cell42.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        add(cell42);

        cell43.setBackground(new java.awt.Color(140, 197, 255));
        cell43.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cell43.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        add(cell43);

        cell44.setBackground(new java.awt.Color(140, 197, 255));
        cell44.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cell44.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        add(cell44);

        cell45.setBackground(new java.awt.Color(140, 197, 255));
        cell45.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cell45.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        add(cell45);

        cell46.setBackground(new java.awt.Color(140, 197, 255));
        cell46.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cell46.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        add(cell46);

        cell47.setBackground(new java.awt.Color(140, 197, 255));
        cell47.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cell47.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        add(cell47);

        cell48.setBackground(new java.awt.Color(140, 197, 255));
        cell48.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cell48.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        add(cell48);

        cell49.setBackground(new java.awt.Color(140, 197, 255));
        cell49.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cell49.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        add(cell49);
    }// </editor-fold>//GEN-END:initComponents

    private void monActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monActionPerformed
       
    }//GEN-LAST:event_monActionPerformed

    private void sunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sunActionPerformed
        
    }//GEN-LAST:event_sunActionPerformed

    private void cell16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cell16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cell16ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Cell cell10;
    private swing.Cell cell11;
    private swing.Cell cell12;
    private swing.Cell cell13;
    private swing.Cell cell14;
    private swing.Cell cell15;
    private swing.Cell cell16;
    private swing.Cell cell17;
    private swing.Cell cell18;
    private swing.Cell cell19;
    private swing.Cell cell20;
    private swing.Cell cell21;
    private swing.Cell cell22;
    private swing.Cell cell23;
    private swing.Cell cell24;
    private swing.Cell cell25;
    private swing.Cell cell26;
    private swing.Cell cell27;
    private swing.Cell cell28;
    private swing.Cell cell29;
    private swing.Cell cell30;
    private swing.Cell cell31;
    private swing.Cell cell32;
    private swing.Cell cell33;
    private swing.Cell cell34;
    private swing.Cell cell35;
    private swing.Cell cell36;
    private swing.Cell cell37;
    private swing.Cell cell38;
    private swing.Cell cell39;
    private swing.Cell cell40;
    private swing.Cell cell41;
    private swing.Cell cell42;
    private swing.Cell cell43;
    private swing.Cell cell44;
    private swing.Cell cell45;
    private swing.Cell cell46;
    private swing.Cell cell47;
    private swing.Cell cell48;
    private swing.Cell cell49;
    private swing.Cell cell8;
    private swing.Cell cell9;
    private swing.Cell fri;
    private swing.Cell mon;
    private swing.Cell sat;
    private swing.Cell sun;
    private swing.Cell thu;
    private swing.Cell tue;
    private swing.Cell wed;
    // End of variables declaration//GEN-END:variables
}
