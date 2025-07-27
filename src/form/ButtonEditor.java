package form;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Insets;
import java.util.EventObject;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

class ButtonEditor extends DefaultCellEditor {
    
    protected JButton button;
    private int row;
    private JTable table;
    private MainFrame mainFrame;

    public ButtonEditor(JCheckBox checkBox, MainFrame mainFrame) {
        super(checkBox);
        this.mainFrame = mainFrame;
        button = new JButton();
        button.setOpaque(true);
        button.setText("Detail"); 
        button.setFocusPainted(false);
        button.setMargin(new Insets(5, 5, 5, 5)); // 5px padding
        button.setPreferredSize(new Dimension(80, 25)); // set size for button detail
        button.addActionListener(e -> {
            int modelRow = table.convertRowIndexToModel(row);
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            
            DetailCustomerDialog dialog = new DetailCustomerDialog(mainFrame, "Detail Data Nasabah", true, model, modelRow);
            dialog.setVisible(true);
            fireEditingStopped();
        });
    } 
    
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.table = table;
        this.row = row;
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        return "Detail"; // Return the button text
    }

    @Override
    public boolean isCellEditable(EventObject e) {
        return true;
    }
}
