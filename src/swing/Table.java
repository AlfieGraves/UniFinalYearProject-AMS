
package swing;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alfiegraves
 */
public class Table extends JTable {
    
    public Table() {
        setShowHorizontalLines(true);
        setGridColor(new Color(230,230,230)); 
        setRowHeight(40);
        getTableHeader().setReorderingAllowed(false); 
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, int i, int il) {
                TableHeader Header = new TableHeader(o + "");
                
                Header.setHorizontalAlignment(JLabel.CENTER); 
                return Header;
            }
        });
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable,Object o, boolean selected, boolean bln1, int i, int il) {
                Component com = super.getTableCellRendererComponent(jtable, o, selected, bln1, i, il);
                com.setBackground(Color.WHITE);
                setBorder(noFocusBorder);
                if (selected) {
                    com.setForeground(new Color(15,89,140));
                } else {
                    com.setForeground(new Color(102,102,102));
                }
                return com;
            }
        });
    }
    
    public void addRow(Object[] row){
        DefaultTableModel model = (DefaultTableModel)getModel();
        model.addRow(row);
    }
}
