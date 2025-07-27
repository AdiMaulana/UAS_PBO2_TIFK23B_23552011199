package form;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.text.NumberFormat;
import java.util.Locale;
import model.AsuransiJiwa;
import model.AsuransiKesehatan;

public class HitungPremiDialog extends JDialog {

    private JComboBox<String> jenisAsuransiCombo;
    private JLabel biayaLabel;
    private JTextField biayaField;
    private JLabel premiLabel;
    private JButton hitungButton, tutupButton;

    public HitungPremiDialog(Frame parent) {
        super(parent, "Hitung Premi Asuransi", true);
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(400, 250));
        setResizable(false);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        // Panel pilih jenis asuransi
        JPanel panelJenis = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel labelJenis = new JLabel("Jenis Asuransi:");
        labelJenis.setPreferredSize(new Dimension(130, 25));
        jenisAsuransiCombo = new JComboBox<>(new String[]{constant.Constant.AS_KESEHATAN, constant.Constant.AS_JIWA});
        jenisAsuransiCombo.setPreferredSize(new Dimension(200, 25));
        panelJenis.add(labelJenis);
        panelJenis.add(jenisAsuransiCombo);
        mainPanel.add(panelJenis);

        // Panel input biaya dasar / nilai pertanggungan
        JPanel panelBiaya = new JPanel(new FlowLayout(FlowLayout.LEFT));
        biayaLabel = new JLabel("Biaya Dasar:");
        biayaLabel.setPreferredSize(new Dimension(130, 25));
        biayaField = new JTextField();
        biayaField.setPreferredSize(new Dimension(200, 25));
        panelBiaya.add(biayaLabel);
        panelBiaya.add(biayaField);
        mainPanel.add(panelBiaya);

        // Panel hasil perhitungan premi
        JPanel panelPremi = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel labelPremi = new JLabel("Premi yang harus dibayar:");
        labelPremi.setPreferredSize(new Dimension(180, 25));
        premiLabel = new JLabel("-");
        premiLabel.setForeground(new Color(0, 128, 0)); // warna hijau
        panelPremi.add(labelPremi);
        panelPremi.add(premiLabel);
        mainPanel.add(panelPremi);

        add(mainPanel, BorderLayout.CENTER);

        // Panel tombol hitung dan tutup
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        buttonPanel.setBackground(Color.WHITE);  // jika AddCustomerDialog pakai putih, sesuaikan

        hitungButton = new JButton("Hitung");
        hitungButton.setBackground(new Color(0, 128, 128)); 
        hitungButton.setForeground(Color.WHITE);
        hitungButton.setFocusPainted(false);
        hitungButton.setPreferredSize(new Dimension(100, 30)); 

        tutupButton = new JButton("Tutup");
        tutupButton.setBackground(new Color(220, 53, 69));  
        tutupButton.setForeground(Color.WHITE);
        tutupButton.setFocusPainted(false);
        tutupButton.setPreferredSize(new Dimension(100, 30)); 

        buttonPanel.add(hitungButton);
        buttonPanel.add(tutupButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Event ketika jenis asuransi diubah: ubah label input biaya
        jenisAsuransiCombo.addActionListener(e -> {
            String jenis = (String) jenisAsuransiCombo.getSelectedItem();
            if ("Kesehatan".equalsIgnoreCase(jenis)) {
                biayaLabel.setText("Biaya Dasar:");
            } else {
                biayaLabel.setText("Nilai Pertanggungan:");
            }
            premiLabel.setText("-");
            biayaField.setText("");
        });

        // Event tombol hitung perhitungan premi
        hitungButton.addActionListener(e -> {
            String jenis = (String) jenisAsuransiCombo.getSelectedItem();
            String biayaText = biayaField.getText().trim();

            if (biayaText.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Mohon isi biaya dasar / nilai pertanggungan terlebih dahulu.",
                        "Input Kosong", JOptionPane.WARNING_MESSAGE);
                return;
            }

            double biaya;
            try {
                biaya = Double.parseDouble(biayaText);
                if (biaya <= 0) {
                    premiLabel.setText("Biaya harus > 0.");
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                        "Input biaya harus berupa angka positif.",
                        "Input Tidak Valid", JOptionPane.ERROR_MESSAGE);
                return;
            }

            double premi;

            if (constant.Constant.AS_KESEHATAN.equalsIgnoreCase(jenis)) {
                AsuransiKesehatan kesehatan = new AsuransiKesehatan(biaya);
                premi = kesehatan.hitungPremi();
            } else if (constant.Constant.AS_JIWA.equalsIgnoreCase(jenis)) {
                AsuransiJiwa jiwa = new AsuransiJiwa(biaya);
                premi = jiwa.hitungPremi();
            } else {
                premiLabel.setText("Jenis asuransi tidak valid!");
                return;
            }
            Locale localeID = new Locale("in", "ID");
            NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(localeID);
            currencyFormat.setMaximumFractionDigits(0);  // tanpa desimal
            premiLabel.setText(currencyFormat.format(premi));
        });

        // Event tombol tutup dialog
        tutupButton.addActionListener(e -> dispose());

        pack();
        setLocationRelativeTo(getParent());
    }
}
