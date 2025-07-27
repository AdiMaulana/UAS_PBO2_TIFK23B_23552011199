package form;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import service.impl.CustomerServiceImpl;
import javax.swing.text.*;

public class AddCustomerDialog extends JDialog {

    private JTextField namaField;
    private JRadioButton rbLaki;
    private JRadioButton rbPerempuan;
    private JTextField umurField;
    private DefaultTableModel tableModel;
    private final CustomerServiceImpl customerService;

    public AddCustomerDialog(MainFrame parent, String title, boolean modal, DefaultTableModel tableModel) {
        super(parent, title, modal);
        this.tableModel = tableModel;
        this.customerService = new CustomerServiceImpl();
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(400, 280));

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS)); // vertical layout
        contentPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        namaField = new JTextField(20);
        umurField = new JTextField(20);
        // Batasi umurField hanya angka
        umurField.setDocument(new NumberOnlyDocument());

        // Panel Gender dengan Radio button
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        JLabel genderLabel = new JLabel("Jenis Kelamin:");
        genderLabel.setPreferredSize(new Dimension(120, 25));

        rbLaki = new JRadioButton("Laki-laki");
        rbPerempuan = new JRadioButton("Perempuan");
        rbLaki.setSelected(true); // default selected

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(rbLaki);
        genderGroup.add(rbPerempuan);

        genderPanel.add(genderLabel);
        genderPanel.add(rbLaki);
        genderPanel.add(rbPerempuan);

        contentPanel.add(createFieldPanel("Nama Peserta:", namaField));
        contentPanel.add(genderPanel);
        contentPanel.add(createFieldPanel("Umur:", umurField));

        add(new JScrollPane(contentPanel), BorderLayout.CENTER);

        // Button Panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton simpanButton = new JButton("Simpan");
        JButton batalButton = new JButton("Batal");
        simpanButton.setBackground(new Color(0, 102, 102));
        simpanButton.setForeground(Color.WHITE);
        batalButton.setBackground(new Color(220, 53, 69));
        batalButton.setForeground(Color.WHITE);
        buttonPanel.add(simpanButton);
        buttonPanel.add(batalButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // Action listener simpan
        simpanButton.addActionListener(e -> {
            try {
                String nama = namaField.getText().trim();
                String gender = rbLaki.isSelected() ? "Laki-laki" : "Perempuan";
                String umurText = umurField.getText().trim();

                if (nama.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Nama Peserta tidak boleh kosong.");
                    return;
                }
                if (umurText.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Umur tidak boleh kosong.");
                    return;
                }

                int umur = Integer.parseInt(umurText);
                if (umur <= 0) {
                    JOptionPane.showMessageDialog(this, "Umur harus lebih dari 0.");
                    return;
                }

                // Simpan ke database
                customerService.addCustomer(nama, gender, umur);

                // Update tabel model (asumsi kolom: No, Nama, Gender, Umur)
                int rowNumber = tableModel.getRowCount() + 1;
                Object[] newRow = {rowNumber, nama, gender, umur};
                tableModel.addRow(newRow);

                JOptionPane.showMessageDialog(this, "Data nasabah berhasil ditambahkan.");
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Umur harus berupa angka valid.");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error menyimpan data: " + ex.getMessage());
            }
        });

        // Action listener batal
        batalButton.addActionListener(e -> dispose());

        pack();
        setLocationRelativeTo(getParent());
    }

    private JPanel createFieldPanel(String labelText, JTextField textField) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        JLabel label = new JLabel(labelText);
        label.setPreferredSize(new Dimension(120, 25));
        textField.setPreferredSize(new Dimension(130, 25));
        panel.add(label);
        panel.add(textField);
        return panel;
    }

    // Dokumen filter khusus agar hanya bisa input angka
    private static class NumberOnlyDocument extends PlainDocument {
        @Override
        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
            if (str == null) return;
            if (str.matches("[0-9]+")) {
                super.insertString(offs, str, a);
            }
        }
    }
}
