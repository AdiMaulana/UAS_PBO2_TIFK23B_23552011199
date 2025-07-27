package form;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.sql.SQLException;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import service.impl.CustomerServiceImpl;
import javax.swing.text.*;

public class DetailCustomerDialog extends JDialog {

    private DefaultTableModel model;
    private int modelRow;

    private JTextField nomorField;
    private JTextField namaField;
    private JRadioButton rbLaki;
    private JRadioButton rbPerempuan;
    private JTextField umurField;

    private final CustomerServiceImpl customerService;

    public DetailCustomerDialog(MainFrame parent, String title, boolean modal, DefaultTableModel model, int modelRow) {
        super(parent, title, modal);
        this.model = model;
        this.modelRow = modelRow;
        this.customerService = new CustomerServiceImpl();
        initComponents();
        loadCustomerData();
    }

    private void initComponents() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(400, 320));

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        nomorField = new JTextField(20);
        nomorField.setEditable(false); // nomor / ID tidak boleh diedit

        namaField = new JTextField(20);
        umurField = new JTextField(20);
        umurField.setDocument(new NumberOnlyDocument()); // Batasi agar umur hanya angka

        // Gender panel & radio buttons
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        JLabel genderLabel = new JLabel("Jenis Kelamin:");
        genderLabel.setPreferredSize(new Dimension(120, 25));

        rbLaki = new JRadioButton("Laki-laki");
        rbPerempuan = new JRadioButton("Perempuan");

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(rbLaki);
        genderGroup.add(rbPerempuan);

        genderPanel.add(genderLabel);
        genderPanel.add(rbLaki);
        genderPanel.add(rbPerempuan);

        contentPanel.add(createFieldPanel("Nomor Peserta:", nomorField));
        contentPanel.add(createFieldPanel("Nama Peserta:", namaField));
        contentPanel.add(genderPanel);
        contentPanel.add(createFieldPanel("Umur:", umurField));

        add(new JScrollPane(contentPanel), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton updateButton = new JButton("Perbarui");
        JButton deleteButton = new JButton("Hapus");
        updateButton.setBackground(new Color(0, 102, 102));
        updateButton.setForeground(Color.WHITE);
        deleteButton.setBackground(new Color(220, 53, 69));
        deleteButton.setForeground(Color.WHITE);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // Action untuk tombol Perbarui
        updateButton.addActionListener(e -> {
            try {
                int id = Integer.parseInt(nomorField.getText());
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

                // Update data nasabah ke database
                customerService.updateCustomer(id, nama, gender, umur);

                // Update data di tabel model UI
                model.setValueAt(id, modelRow, 0);
                model.setValueAt(nama, modelRow, 1);
                model.setValueAt(gender, modelRow, 2);
                model.setValueAt(umur, modelRow, 3);

                JOptionPane.showMessageDialog(this, "Data customer berhasil diperbarui.");
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Umur harus berupa angka valid.");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error menyimpan data: " + ex.getMessage());
            }
        });

        // Action untuk tombol Hapus
        deleteButton.addActionListener(e -> {
            int dialogResult = JOptionPane.showConfirmDialog(this, 
                    "Apakah Anda yakin akan menghapus data nasabah ini?", 
                    "Konfirmasi Hapus Data", JOptionPane.YES_NO_OPTION);

            if (dialogResult == JOptionPane.YES_OPTION) {
                try {
                    int id = Integer.parseInt(nomorField.getText());

                    // Hapus data nasabah dari database
                    customerService.deleteCustomer(id);

                    // Hapus baris dari tabel model UI
                    model.removeRow(modelRow);

                    JOptionPane.showMessageDialog(this, "Data nasabah berhasil dihapus.");
                    dispose();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Nomor tidak valid.");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Error menghapus data: " + ex.getMessage());
                }
            }
        });

        pack();
        setLocationRelativeTo(getParent());
    }

    // Load data dari model ke form sesuai baris yang diklik
    private void loadCustomerData() {
        nomorField.setText(model.getValueAt(modelRow, 0).toString());
        namaField.setText(model.getValueAt(modelRow, 1).toString());

        Object genderObj = model.getValueAt(modelRow, 2);
        String gender = (genderObj != null) ? genderObj.toString() : "";
        if (gender.equalsIgnoreCase("Laki-laki")) {
            rbLaki.setSelected(true);
        } else {
            rbPerempuan.setSelected(true);
        }

        Object umurObj = model.getValueAt(modelRow, 3);
        umurField.setText(umurObj != null ? umurObj.toString() : "");
    }


    private JPanel createFieldPanel(String labelText, JTextField textField) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        JLabel label = new JLabel(labelText);
        label.setPreferredSize(new Dimension(120, 25)); 
        textField.setPreferredSize(new Dimension(150, 25));
        panel.add(label);
        panel.add(textField);
        return panel;
    }

    // Document filter agar hanya angka di input umur
    private static class NumberOnlyDocument extends PlainDocument {
        @Override
        public void insertString(int offs, String str, javax.swing.text.AttributeSet a) throws javax.swing.text.BadLocationException {
            if (str == null) return;
            if (str.matches("[0-9]+")) {
                super.insertString(offs, str, a);
            }
        }
    }
}
