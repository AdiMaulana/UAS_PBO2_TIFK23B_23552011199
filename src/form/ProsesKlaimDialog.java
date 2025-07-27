package form;

import model.Klaim;
import model.Polis;
import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Date;
import java.util.List;

public class ProsesKlaimDialog extends JDialog {

    private JComboBox<Polis> polisCombo;
    private JXDatePicker tanggalPengajuanPicker;  // Pakai JXDatePicker
    private JComboBox<String> statusCombo;
    private JButton simpanButton, batalButton;

    private Klaim klaimBaru;
    private boolean succeeded;

    // Terima list polis untuk dropdown
    public ProsesKlaimDialog(Frame parent, String title, boolean modal, List<Polis> polisList) {
        super(parent, title, modal);
        initComponents(polisList);
    }

    private void initComponents(List<Polis> polisList) {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(420, 230));
        setResizable(false);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Dropdown Polis
        JPanel panelPolis = new JPanel(new FlowLayout(FlowLayout.LEADING));
        JLabel labelPolis = new JLabel("Pilih Polis:");
        labelPolis.setPreferredSize(new Dimension(120, 25));
        polisCombo = new JComboBox<>();
        for (Polis p : polisList) {
            polisCombo.addItem(p);
        }
        polisCombo.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value,
                                                          int index, boolean isSelected,
                                                          boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Polis) {
                    Polis p = (Polis) value;
                    setText("ID: " + p.getId() + " - " + p.getNamaNasabah());
                }
                return this;
            }
        });
        polisCombo.setPreferredSize(new Dimension(250, 25));
        panelPolis.add(labelPolis);
        panelPolis.add(polisCombo);
        mainPanel.add(panelPolis);

        // Panel tanggal pengajuan dengan JXDatePicker (datepicker kalender)
        JPanel panelTanggal = new JPanel(new FlowLayout(FlowLayout.LEADING));
        JLabel labelTanggal = new JLabel("Tanggal Pengajuan:");
        labelTanggal.setPreferredSize(new Dimension(120, 25));
        tanggalPengajuanPicker = new JXDatePicker();
        tanggalPengajuanPicker.setFormats("dd-MM-yyyy");
        tanggalPengajuanPicker.setDate(new Date());  // default hari ini
        tanggalPengajuanPicker.setPreferredSize(new Dimension(150, 25));
        panelTanggal.add(labelTanggal);
        panelTanggal.add(tanggalPengajuanPicker);
        mainPanel.add(panelTanggal);

        // Status Dropdown
        JPanel panelStatus = new JPanel(new FlowLayout(FlowLayout.LEADING));
        JLabel labelStatus = new JLabel("Status:");
        labelStatus.setPreferredSize(new Dimension(120, 25));
        statusCombo = new JComboBox<>(new String[]{"pending", "approved", "reject"});
        statusCombo.setPreferredSize(new Dimension(200, 25));
        panelStatus.add(labelStatus);
        panelStatus.add(statusCombo);
        mainPanel.add(panelStatus);

        add(mainPanel, BorderLayout.CENTER);

        // Panel tombol simpan dan batal
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        simpanButton = new JButton("Simpan");
        simpanButton.setBackground(new Color(0, 102, 102));
        simpanButton.setForeground(Color.WHITE);
        batalButton = new JButton("Batal");
        batalButton.setBackground(new Color(220, 53, 69));
        batalButton.setForeground(Color.WHITE);
        buttonPanel.add(simpanButton);
        buttonPanel.add(batalButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Listener Tombol Simpan
        simpanButton.addActionListener(e -> {
            Polis selectedPolis = (Polis) polisCombo.getSelectedItem();
            if (selectedPolis == null) {
                JOptionPane.showMessageDialog(this, "Pilih polis terlebih dahulu.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Date utilDate = tanggalPengajuanPicker.getDate();
            if (utilDate == null) {
                JOptionPane.showMessageDialog(this, "Tanggal pengajuan harus diisi.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String status = (String) statusCombo.getSelectedItem();
            if (status == null || status.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Status harus dipilih.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Konversi ke java.sql.Date, sesuai model Anda
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

            klaimBaru = new Klaim();
            klaimBaru.setPolisId(selectedPolis.getId());
            klaimBaru.setTanggal(sqlDate);
            klaimBaru.setStatus(status);

            succeeded = true;
            dispose();
        });

        // Listener Tombol Batal
        batalButton.addActionListener(e -> {
            succeeded = false;
            dispose();
        });

        pack();
        setLocationRelativeTo(getParent());
    }

    // Getter klaim baru
    public Klaim getKlaimBaru() {
        return klaimBaru;
    }

    public boolean isSucceeded() {
        return succeeded;
    }
}

