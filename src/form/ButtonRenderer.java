package form;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

class ButtonRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JButton button = null;
        try {
            if (value instanceof JButton) {
                button = (JButton) value;
                if (button != null) {
                    button.setMargin(new Insets(5, 5, 5, 5)); // Top, Left, Bottom, Right (5px padding)
                    button.setPreferredSize(new Dimension(80, 25)); //set size for button detail
                    button.setFocusPainted(false);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return button;
    }
}
