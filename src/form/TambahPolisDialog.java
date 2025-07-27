package form;

import model.Customer;
import model.Polis;
import model.AsuransiJiwa;
import model.AsuransiKesehatan;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.PolisServiceInterface;
import service.impl.PolisServiceImpl;

public class TambahPolisDialog extends JDialog {

    private List<Customer> nasabahList;
    private JComboBox<Customer> nasabahCombo;
    private JComboBox<String> jenisCombo;
    private JTextField biayaField;
    private JLabel labelBiaya;
    private JLabel premiLabel;
    private JButton hitungButton;
    private JButton simpanButton;
    private JButton batalButton;

    private double premi;
    private Polis polisBaru;
    private boolean succeeded;
    
    private PolisServiceInterface polisService;

    public TambahPolisDialog(Frame parent, String title, boolean modal, List<Customer> nasabahList) {
        super(parent, title, modal);
        this.nasabahList = nasabahList;
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(420, 320));
        setResizable(false);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(new EmptyBorder(10,10,10,10));

        // Panel Nasabah
        JPanel panelNasabah = new JPanel(new FlowLayout(FlowLayout.LEADING));
        JLabel labelNasabah = new JLabel("Pilih Nasabah:");
        labelNasabah.setPreferredSize(new Dimension(150, 25));
        nasabahCombo = new JComboBox<>();
        for (Customer c : nasabahList) {
            nasabahCombo.addItem(c);
        }
        // Renderer supaya menampilkan nama saja
        nasabahCombo.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list,
                                                          Object value, int index,
                                                          boolean isSelected,
                                                          boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Customer) {
                    setText(((Customer) value).getName());
                }
                return this;
            }
        });
        nasabahCombo.setPreferredSize(new Dimension(220, 25));
        panelNasabah.add(labelNasabah);
        panelNasabah.add(nasabahCombo);
        mainPanel.add(panelNasabah);

        // Panel Jenis Asuransi
        JPanel panelJenis = new JPanel(new FlowLayout(FlowLayout.LEADING));
        JLabel labelJenis = new JLabel("Jenis Asuransi:");
        labelJenis.setPreferredSize(new Dimension(150, 25));
        jenisCombo = new JComboBox<>(new String[]{"kesehatan", "jiwa"});
        jenisCombo.setPreferredSize(new Dimension(220, 25));
        panelJenis.add(labelJenis);
        panelJenis.add(jenisCombo);
        mainPanel.add(panelJenis);

        // Panel Biaya Dasar / Nilai Pertanggungan
        JPanel panelBiaya = new JPanel(new FlowLayout(FlowLayout.LEADING));
        labelBiaya = new JLabel("Masukkan Biaya Dasar:");
        labelBiaya.setPreferredSize(new Dimension(150, 25));
        biayaField = new JTextField(15);
        biayaField.setDocument(new NumberOnlyDocument());
        panelBiaya.add(labelBiaya);
        panelBiaya.add(biayaField);
        mainPanel.add(panelBiaya);

        // Label Premi hasil hitungan
        premiLabel = new JLabel("Premi: -");
        premiLabel.setFont(new Font("Arial", Font.BOLD, 14));
        premiLabel.setForeground(new Color(0, 102, 102));
        premiLabel.setPreferredSize(new Dimension(350, 25));
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(premiLabel);

        add(mainPanel, BorderLayout.CENTER);

        // Panel tombol
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10,10));

        hitungButton = new JButton("Hitung Premi");
        simpanButton = new JButton("Simpan");
        batalButton = new JButton("Batal");

        // Styling tombol
        Color btnSimColor = new Color(0, 102, 102);
        Color btnBtlColor = new Color(220, 53, 69);
        Color btnHitColor = new Color(0, 128, 128);

        hitungButton.setBackground(btnHitColor);
        hitungButton.setForeground(Color.WHITE);
        simpanButton.setBackground(btnSimColor);
        simpanButton.setForeground(Color.WHITE);
        batalButton.setBackground(btnBtlColor);
        batalButton.setForeground(Color.WHITE);

        Dimension btnSize = new Dimension(110, 30);
        hitungButton.setPreferredSize(btnSize);
        simpanButton.setPreferredSize(btnSize);
        batalButton.setPreferredSize(btnSize);

        buttonPanel.add(hitungButton);
        buttonPanel.add(simpanButton);
        buttonPanel.add(batalButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Disable simpan sampai premi dihitung
        simpanButton.setEnabled(false);

        // Listener ganti label biaya sesuai jenis asuransi
        jenisCombo.addActionListener(e -> {
            String jenis = (String) jenisCombo.getSelectedItem();
            if ("kesehatan".equalsIgnoreCase(jenis)) {
                labelBiaya.setText("Masukkan Biaya Dasar:");
            } else {
                labelBiaya.setText("Masukkan Nilai Pertanggungan:");
            }
            premiLabel.setText("Premi: -");
            simpanButton.setEnabled(false);
        });

        // Tombol Hitung Premi
        hitungButton.addActionListener(e -> {
            try {
                String jenis = (String) jenisCombo.getSelectedItem();
                String biayaTxt = biayaField.getText().trim();
                if (biayaTxt.isEmpty()) {
                    premiLabel.setText("Masukkan biaya terlebih dahulu.");
                    simpanButton.setEnabled(false);
                    return;
                }
                double biaya = Double.parseDouble(biayaTxt);

                if (biaya <= 0) {
                    premiLabel.setText("Biaya harus > 0.");
                    simpanButton.setEnabled(false);
                    return;
                }

                if (constant.Constant.AS_KESEHATAN.equalsIgnoreCase(jenis)) {
                    AsuransiKesehatan kesehatan = new AsuransiKesehatan(biaya);
                    premi = kesehatan.hitungPremi();
                } else if (constant.Constant.AS_JIWA.equalsIgnoreCase(jenis)) {
                    AsuransiJiwa jiwa = new AsuransiJiwa(biaya);
                    premi = jiwa.hitungPremi();
                } else {
                    premiLabel.setText("Jenis asuransi tidak valid!");
                    simpanButton.setEnabled(false);
                    return;
                }

                premiLabel.setText("Premi: " + formatPremi(premi));
                simpanButton.setEnabled(true);

            } catch (NumberFormatException ex) {
                premiLabel.setText("Masukkan biaya yang valid (angka).");
                simpanButton.setEnabled(false);
            }
        });

        simpanButton.addActionListener(e -> {
            Customer selectedCustomer = (Customer) nasabahCombo.getSelectedItem();
            if (selectedCustomer == null) {
                JOptionPane.showMessageDialog(this, "Pilih nasabah terlebih dahulu.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int nasabahId = selectedCustomer.getId();
            String jenis = (String) jenisCombo.getSelectedItem();

            polisBaru = new Polis();
            polisBaru.setNasabahId(nasabahId);
            polisBaru.setJenis(jenis);
            polisBaru.setPremi(premi);
            
            polisService = new PolisServiceImpl();
            try {
                polisService.buatPolis(polisBaru);
            } catch (Exception ex) {
                Logger.getLogger(TambahPolisDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            succeeded = true;
            dispose();
        });

        // Tombol Batal
        batalButton.addActionListener(e -> {
            succeeded = false;
            dispose();
        });

        pack();
        setLocationRelativeTo(getParent());
    }

    public boolean isSucceeded() {
        return succeeded;
    }

    public Polis getPolisBaru() {
        return polisBaru;
    }

    private String formatPremi(double premi) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator('.');
        symbols.setDecimalSeparator(',');

        DecimalFormat df = new DecimalFormat("#,###", symbols);
        df.setGroupingUsed(true);
        df.setMaximumFractionDigits(0);
        return df.format(premi);
    }

    // Filter hanya angka di input biaya
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
