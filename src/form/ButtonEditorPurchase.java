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

class ButtonEditorPurchase extends DefaultCellEditor {
    
    protected JButton button;
    private int row;
    private JTable table;
    private MainFrame mainFrame;

    public ButtonEditorPurchase(JCheckBox checkBox, MainFrame mainFrame) {
        super(checkBox);
        this.mainFrame = mainFrame;
        button = new JButton();
        button.setOpaque(true);
        button.setText("Purchase"); 
        button.setFocusPainted(false);
        button.setMargin(new Insets(5, 5, 5, 5)); // 5px padding
        button.setPreferredSize(new Dimension(80, 25)); //set size for button detail
        button.addActionListener(e -> {
            int modelRow = table.convertRowIndexToModel(row);
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            // Get Clothing value
            int clothingId = Integer.parseInt(model.getValueAt(modelRow, 0).toString());
            String namaBaju = model.getValueAt(modelRow, 1).toString();
            String priceStr = model.getValueAt(modelRow, 2).toString().replace("Rp", "");
            double harga = Double.parseDouble(priceStr.replace(".", ""));
            
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
        return "Purchase"; // Return the button text
    }

    @Override
    public boolean isCellEditable(EventObject e) {
        return true;
    }
}
