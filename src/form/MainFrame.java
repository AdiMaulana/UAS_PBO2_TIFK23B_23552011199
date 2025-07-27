package form;

import constant.SessionManager;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import model.Customer;
import model.Klaim;
import model.Polis;
import service.LayananAsuransi;
import service.PolisServiceInterface;
import service.impl.CustomerServiceImpl;
import service.impl.LayananAsuransiServiceImpl;
import service.impl.PolisServiceImpl;

public class MainFrame extends javax.swing.JFrame {

    public MainFrame() {
        initComponents();
        addHeaderComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanelCustomer = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanelPremi = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanelPolis = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanelClaim = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        labelUsername = new javax.swing.JLabel();
        labelCustomerName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1010, 700));
        setPreferredSize(new java.awt.Dimension(1010, 625));
        setResizable(false);
        setSize(new java.awt.Dimension(1010, 700));

        jPanel1.setMinimumSize(new java.awt.Dimension(1000, 625));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 625));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(54, 70, 78));
        jPanel2.setMinimumSize(new java.awt.Dimension(210, 57));
        jPanel2.setPreferredSize(new java.awt.Dimension(210, 60));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(54, 70, 78));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/menu.png"))); // NOI18N
        jLabel2.setOpaque(true);
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel2MouseExited(evt);
            }
        });
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 40, 47));

        jPanelCustomer.setBackground(new java.awt.Color(54, 70, 78));
        jPanelCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelCustomerMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelCustomerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelCustomerMouseExited(evt);
            }
        });
        jPanelCustomer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(new java.awt.Color(54, 70, 78));
        jLabel4.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Data Customer");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel4MouseEntered(evt);
            }
        });
        jPanelCustomer.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 150, 45));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/home.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanelCustomer.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 6, 40, 45));

        jPanel2.add(jPanelCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 210, 50));

        jPanel6.setBackground(new java.awt.Color(54, 70, 78));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel6MouseExited(evt);
            }
        });
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setBackground(new java.awt.Color(54, 70, 78));
        jLabel7.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Dashboard");
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 6, 146, 45));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/home.png"))); // NOI18N
        jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 6, 40, 45));

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 210, 50));

        jPanelPremi.setBackground(new java.awt.Color(54, 70, 78));
        jPanelPremi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelPremiMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelPremiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelPremiMouseExited(evt);
            }
        });
        jPanelPremi.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setBackground(new java.awt.Color(54, 70, 78));
        jLabel9.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Premi Asuransi");
        jPanelPremi.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 146, 45));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/produk-catalog.png"))); // NOI18N
        jPanelPremi.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 6, 40, 45));

        jPanel2.add(jPanelPremi, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 210, 50));

        jPanelPolis.setBackground(new java.awt.Color(54, 70, 78));
        jPanelPolis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelPolisMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelPolisMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelPolisMouseExited(evt);
            }
        });
        jPanelPolis.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setBackground(new java.awt.Color(54, 70, 78));
        jLabel11.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Polis Asuransi");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        jPanelPolis.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 140, 45));

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/id-card.png"))); // NOI18N
        jPanelPolis.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 6, 40, 45));

        jPanel2.add(jPanelPolis, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 210, 50));

        jPanelClaim.setBackground(new java.awt.Color(54, 70, 78));
        jPanelClaim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelClaimMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelClaimMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelClaimMouseExited(evt);
            }
        });
        jPanelClaim.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setBackground(new java.awt.Color(54, 70, 78));
        jLabel13.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Klaim Asuransi");
        jPanelClaim.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 146, 45));

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/report.png"))); // NOI18N
        jPanelClaim.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 45));

        jPanel2.add(jPanelClaim, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 210, 50));

        jPanel10.setBackground(new java.awt.Color(54, 70, 78));
        jPanel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel10MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel10MouseExited(evt);
            }
        });
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setBackground(new java.awt.Color(54, 70, 78));
        jLabel15.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Logout");
        jPanel10.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 6, 146, 45));

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logout.png"))); // NOI18N
        jPanel10.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 45));

        jPanel2.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 210, 50));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 650));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 800, 580));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/menu.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel3MouseExited(evt);
            }
        });
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 12, 40, 40));

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(245, 245, 245));
        jLabel5.setText("Wellcome To Insurance Care");

        jLabel17.setFont(new java.awt.Font("Calibri", 1, 28)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(245, 245, 245));
        jLabel17.setText("Sistem Pelayanan Asuransi");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/profile.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        labelUsername.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        labelUsername.setForeground(new java.awt.Color(245, 245, 245));
        labelUsername.setText("Username");

        labelCustomerName.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        labelCustomerName.setForeground(new java.awt.Color(245, 245, 245));
        labelCustomerName.setText("Customer Name");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 249, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelUsername, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelCustomerName, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCustomerName))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 800, 70));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1011, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    int x = 210;
    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        if (x == 210) {
            jPanel2.setSize(210, 625);
            Thread th = new Thread() {
                @Override
                public void run() {
                    try {
                        for (int i = 210; i >= 0; i--) {
                            Thread.sleep(1);
                            jPanel2.setSize(i, 625);
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                }
            };
            th.start();
            x = 0;
        }
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        if (x == 0) {
            jPanel2.show();
            jPanel2.setSize(x, 625);
            Thread th = new Thread() {
                @Override
                public void run() {
                    try {
                        for (int i = 0; i <= 210; i++) {
                            Thread.sleep(1);
                            jPanel2.setSize(i, 625);
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                }
            };
            th.start();
            x = 210;
        }
    }//GEN-LAST:event_jLabel3MouseClicked

    private void panelColor(JPanel panel) {
        panel.setBackground(new java.awt.Color(53, 162, 107));
    }

    private void resetPanelColor(JPanel panel) {
        panel.setBackground(new java.awt.Color(54, 70, 78));
    }

    private void labelColor(JLabel label) {
        label.setBackground(new java.awt.Color(53, 162, 107));
    }

    private void resetLabelColor(JLabel label) {
        label.setBackground(new java.awt.Color(54, 70, 78));
    }

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        // TODO add your handling code here:
        labelColor(jLabel2);
    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited
        resetLabelColor(jLabel2);
    }//GEN-LAST:event_jLabel2MouseExited

    private void jPanelCustomerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelCustomerMouseEntered
        panelColor(jPanelCustomer);
    }//GEN-LAST:event_jPanelCustomerMouseEntered

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jPanelCustomerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelCustomerMouseExited
        resetPanelColor(jPanelCustomer);
    }//GEN-LAST:event_jPanelCustomerMouseExited

    private void jPanel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseEntered
        panelColor(jPanel6);
    }//GEN-LAST:event_jPanel6MouseEntered

    private void jPanel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseExited
        resetPanelColor(jPanel6);
    }//GEN-LAST:event_jPanel6MouseExited

    private void jPanelPremiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelPremiMouseEntered
        panelColor(jPanelPremi);
    }//GEN-LAST:event_jPanelPremiMouseEntered

    private void jPanelPremiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelPremiMouseExited
        resetPanelColor(jPanelPremi);
    }//GEN-LAST:event_jPanelPremiMouseExited

    private void jPanelPolisMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelPolisMouseEntered
        panelColor(jPanelPolis);
    }//GEN-LAST:event_jPanelPolisMouseEntered

    private void jPanelPolisMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelPolisMouseExited
        resetPanelColor(jPanelPolis);
    }//GEN-LAST:event_jPanelPolisMouseExited

    private void jPanelClaimMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelClaimMouseEntered
        panelColor(jPanelClaim);
    }//GEN-LAST:event_jPanelClaimMouseEntered

    private void jPanelClaimMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelClaimMouseExited
        resetPanelColor(jPanelClaim);
    }//GEN-LAST:event_jPanelClaimMouseExited

    private void jPanel10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseEntered
        panelColor(jPanel10);
    }//GEN-LAST:event_jPanel10MouseEntered

    private void jPanel10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseExited
        resetPanelColor(jPanel10);
    }//GEN-LAST:event_jPanel10MouseExited

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
        labelColor(jLabel3);
    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
        resetLabelColor(jLabel3);
    }//GEN-LAST:event_jLabel3MouseExited

    private void jPanel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseClicked
        int choice = JOptionPane.showConfirmDialog(MainFrame.this,
                "Anda yakin ingin logout?",
                "Logout Confirmation",
                JOptionPane.YES_NO_OPTION);

        if (choice == JOptionPane.YES_OPTION) {
            MainFrame.this.dispose();
            // clear session login
            final int CLEAR_SESSION = 0;
            final String CLEAR_SESSION_USER = "";
            SessionManager.setUserId(CLEAR_SESSION);
            SessionManager.setRoleId(CLEAR_SESSION);
            SessionManager.setName(CLEAR_SESSION_USER);
            SessionManager.setUserName(CLEAR_SESSION_USER);
            // redirect to login page
            LoginFrame loginPage = new LoginFrame();
            loginPage.setLocationRelativeTo(null);
            loginPage.setVisible(true);
        }
    }//GEN-LAST:event_jPanel10MouseClicked

    // Service Polis
    private static PolisServiceInterface polisService = new PolisServiceImpl();

    // Service LayananAsuransi (untuk proses klaim)
    private static LayananAsuransi layananAsuransi = new LayananAsuransiServiceImpl();

    private void jPanelPolisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelPolisMouseClicked
        try {
            List<Polis> polist = polisService.semuaPolis();
            String[] columnNames = {"ID", "Nomor Peserta", "Nama Peserta", "Jenis Asuransi", "Premi"};
            Object[][] data = new Object[polist.size()][5];

            for (int i = 0; i < polist.size(); i++) {
                Polis polis = polist.get(i);
                data[i] = new Object[]{polis.getId(), polis.getNasabahId(), polis.getNamaNasabah(), polis.getJenis(), polis.getPremiFormatted()};
            }

            CustomerServiceImpl customerService = new CustomerServiceImpl();
            List<Customer> customerList = customerService.getAllCustomer();

            setPolisData(data, columnNames, customerList);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error fetching polis data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jPanelPolisMouseClicked

    private void jPanelPremiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelPremiMouseClicked

        HitungPremiDialog dialog = new HitungPremiDialog(this); // this = JFrame induk
        dialog.setVisible(true);
    }//GEN-LAST:event_jPanelPremiMouseClicked

    private void jPanelCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelCustomerMouseClicked

        CustomerServiceImpl customerService = new CustomerServiceImpl();
        try {
            Locale localeID = new Locale("in", "ID");
            NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(localeID);
            currencyFormatter.setMaximumFractionDigits(0); // Remove decimal places

            List<Customer> clotheList = customerService.getAllCustomer();
            String[] columnNames = {"ID", "Nama Peserta", "Jenis Kelamin", "Umur"};
            Object[][] data = new Object[clotheList.size()][4];
            for (int i = 0; i < clotheList.size(); i++) {
                Customer customer = clotheList.get(i);
                data[i][0] = customer.getId();
                data[i][1] = customer.getName();
                data[i][2] = customer.getGender();
                data[i][3] = customer.getAge();
            }
            setCustomerData(data, columnNames);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error fetching customer data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_jPanelCustomerMouseClicked

    private void jPanelClaimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelClaimMouseClicked
        try {
            Locale localeID = new Locale("in", "ID");
            NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(localeID);
            currencyFormatter.setMaximumFractionDigits(0); // Remove decimal places

            List<Klaim> list = layananAsuransi.semuaKlaim();
            String[] columnNames = {"ID", "No Polis", "Nama Peserta", "Umur", "Tanggal Pengajuan", "Status"};
            Object[][] data = new Object[list.size()][6];
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
            for (int i = 0; i < list.size(); i++) {
                Klaim klaim = list.get(i);
                String tanggalPengajuan = dateFormat.format(klaim.getTanggal());
                data[i] = new Object[]{
                    klaim.getId(), // ID klaim
                    klaim.getPolisId(), // Nomor polis
                    klaim.getNamaPeserta() != null ? klaim.getNamaPeserta() : "Guest",
                    klaim.getUmur(), // Umur peserta
                    tanggalPengajuan, // Tanggal pengajuan klaim
                    klaim.getStatus() // Status klaim
                };
            }

            setKlaimData(data, columnNames);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error fetching claim insurance data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jPanelClaimMouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanelClaim;
    private javax.swing.JPanel jPanelCustomer;
    private javax.swing.JPanel jPanelPolis;
    private javax.swing.JPanel jPanelPremi;
    private javax.swing.JLabel labelCustomerName;
    private javax.swing.JLabel labelUsername;
    // End of variables declaration//GEN-END:variables

    public void setCustomerData(Object[][] data, String[] columnNames) {
        jPanel3.removeAll();
        jPanel3.setLayout(new BorderLayout());

        // Dashboard Theme Colors
        Color backgroundColor = new Color(245, 245, 245); // Light gray/off-white
        Color textColor = new Color(51, 51, 51); // Dark gray
        Color accentColor = new Color(0, 128, 128); // Teal
        jPanel3.setBackground(backgroundColor);

        // Title Panel (hanya label judul tanpa tombol)
        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setBackground(backgroundColor);
        titlePanel.setBorder(new EmptyBorder(20, 30, 10, 30));

        JLabel titleLabel = new JLabel("Data Customer :", SwingConstants.LEFT);
        Font labelFont = new Font("Arial", Font.BOLD, 18);
        titleLabel.setFont(labelFont);
        Color labelColor = new Color(0x36464E);
        titleLabel.setForeground(labelColor);
        titlePanel.add(titleLabel, BorderLayout.WEST);

        jPanel3.add(titlePanel, BorderLayout.NORTH);

        // Table Model
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == getColumnCount() - 1;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == getColumnCount() - 1) {
                    return JButton.class;
                }
                return Object.class;
            }
        };

        // Tambah kolom Action di model
        tableModel.addColumn("Action");

        // Table
        JTable table = new JTable(tableModel);
        table.setBackground(backgroundColor);
        table.setForeground(textColor);
        table.setFont(new Font("SansSerif", Font.PLAIN, 14));
        table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 14));
        table.getTableHeader().setBackground(accentColor);
        table.getTableHeader().setForeground(Color.WHITE);

        // Set lebar kolom
        if (table.getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setPreferredWidth(20);  // Nomor
            if (table.getColumnCount() > 1) {
                table.getColumnModel().getColumn(1).setPreferredWidth(230); // Nama Baju
            }
            if (table.getColumnCount() > 2) {
                table.getColumnModel().getColumn(2).setPreferredWidth(80);  // Stok
            }
            if (table.getColumnCount() > 3) {
                table.getColumnModel().getColumn(3).setPreferredWidth(80);  // Harga
            }
            if (table.getColumnCount() > 4) {
                table.getColumnModel().getColumn(4).setPreferredWidth(100); // Action
            }
        }

        // Cell Renderer
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(SwingConstants.LEFT);
        table.setDefaultRenderer(Object.class, cellRenderer);

        // Tambah tombol "Detail" di kolom aksi
        for (int i = 0; i < table.getRowCount(); i++) {
            tableModel.setValueAt(new JButton("Detail"), i, columnNames.length); // Add button ke setiap baris
        }

        // Renderer dan editor untuk kolom Action
        ButtonRenderer buttonRenderer = new ButtonRenderer();
        ButtonEditor buttonEditor = new ButtonEditor(new JCheckBox(), MainFrame.this);
        TableColumn actionColumn = table.getColumnModel().getColumn(columnNames.length);
        actionColumn.setCellRenderer(buttonRenderer);
        actionColumn.setCellEditor(buttonEditor);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(new EmptyBorder(10, 30, 30, 30));
        scrollPane.getViewport().setBackground(backgroundColor);
        jPanel3.add(scrollPane, BorderLayout.CENTER);

        // Panel bawah untuk tombol "Tambah Nasabah Baru", posisinya kanan bawah seperti tombol "Proses Klaim Asuransi"
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 40, 10));  // FlowLayout.RIGHT dan margin horizontal 40
        bottomPanel.setBackground(backgroundColor);
        bottomPanel.setBorder(new EmptyBorder(0, 0, 0, 30));  // Margin kanan 60px agar agak renggang

        JButton addButton = new JButton("Tambah Peserta Baru");
        addButton.setBackground(accentColor);
        addButton.setForeground(Color.WHITE);

        // Perbesar ukuran tombol agar teks tidak terpotong
        Dimension buttonSize = new Dimension(200, 30);
        addButton.setMinimumSize(buttonSize);
        addButton.setPreferredSize(buttonSize);
        addButton.setMaximumSize(buttonSize);

        bottomPanel.add(addButton);
        jPanel3.add(bottomPanel, BorderLayout.SOUTH);

        // Action listener tombol tambah nasabah
        MainFrame mainFrame = MainFrame.this;
        addButton.addActionListener(e -> {
            AddCustomerDialog dialog = new AddCustomerDialog(mainFrame, "Tambah Data Customer", true, tableModel);
            dialog.setVisible(true);
        });

        // Revalidate dan repaint panel setelah semua komponen ditambahkan
        jPanel3.revalidate();
        jPanel3.repaint();
    }

    public void setPolisData(Object[][] data, String[] columnNames, List<Customer> nasabahList) {
        jPanel3.removeAll();
        jPanel3.setLayout(new BorderLayout());

        Color backgroundColor = new Color(245, 245, 245);
        Color textColor = new Color(51, 51, 51);
        Color accentColor = new Color(0, 128, 128);
        jPanel3.setBackground(backgroundColor);

        // Title panel hanya berisi label judul tanpa tombol
        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setBackground(backgroundColor);
        titlePanel.setBorder(new EmptyBorder(20, 30, 10, 30));

        JLabel titleLabel = new JLabel("Data Polis Asuransi: ", SwingConstants.LEFT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(new Color(0x36464E));
        titlePanel.add(titleLabel, BorderLayout.WEST);

        jPanel3.add(titlePanel, BorderLayout.NORTH);

        // Table
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JTable table = new JTable(tableModel);
        table.setBackground(backgroundColor);
        table.setForeground(textColor);
        table.setFont(new Font("SansSerif", Font.PLAIN, 14));
        table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 14));
        table.getTableHeader().setBackground(accentColor);
        table.getTableHeader().setForeground(Color.WHITE);

        // Set column widths (sesuaikan jika perlu)
        table.getColumnModel().getColumn(0).setPreferredWidth(50);
        table.getColumnModel().getColumn(1).setPreferredWidth(120);
        table.getColumnModel().getColumn(2).setPreferredWidth(200);
        table.getColumnModel().getColumn(3).setPreferredWidth(200);
        table.getColumnModel().getColumn(4).setPreferredWidth(150);

        // Left align all cell content
        DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
        leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(leftRenderer);
        }

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(new EmptyBorder(10, 30, 30, 30));
        scrollPane.getViewport().setBackground(backgroundColor);
        jPanel3.add(scrollPane, BorderLayout.CENTER);

        // Panel bawah untuk tombol dengan FlowLayout.RIGHT dan margin kanan lebih renggang
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 40, 10)); // jarak horizontal 40 px
        bottomPanel.setBackground(backgroundColor);
        bottomPanel.setBorder(new EmptyBorder(0, 0, 0, 30)); // margin kanan 60 px

        JButton tambahButton = new JButton("Buat Polis Baru");
        tambahButton.setBackground(accentColor);
        tambahButton.setForeground(Color.WHITE);
        tambahButton.setFocusPainted(false);

        // Perbesar ukuran tombol agar teks tidak kepotong
        Dimension buttonSize = new Dimension(200, 30);
        tambahButton.setMinimumSize(buttonSize);
        tambahButton.setPreferredSize(buttonSize);
        tambahButton.setMaximumSize(buttonSize);

        bottomPanel.add(tambahButton);
        jPanel3.add(bottomPanel, BorderLayout.SOUTH);

        // Event handler ketika tombol tambah polis diklik
        tambahButton.addActionListener(e -> {
            Frame parentFrame = (Frame) SwingUtilities.getWindowAncestor(jPanel3);
            TambahPolisDialog dialog = new TambahPolisDialog(parentFrame, "Tambah Polis Baru", true, nasabahList);
            dialog.setVisible(true);

            if (dialog.isSucceeded()) {
                Polis newPolis = dialog.getPolisBaru();

                // Tambah ke tableModel
                Object[] rowData = {
                    newPolis.getId(),
                    newPolis.getNasabahId(),
                    newPolis.getNamaNasabah(),
                    newPolis.getJenis(),
                    newPolis.getPremiFormatted()
                };
                tableModel.addRow(rowData);
            }
        });

        jPanel3.revalidate();
        jPanel3.repaint();
    }

    public void setKlaimData(Object[][] data, String[] columnNames) {
        jPanel3.removeAll();
        jPanel3.setLayout(new BorderLayout());

        Color backgroundColor = new Color(245, 245, 245);
        Color textColor = new Color(51, 51, 51);
        Color accentColor = new Color(0, 128, 128);
        jPanel3.setBackground(backgroundColor);

        int totalKlaim = data.length;

        // Header panel hanya berisi judul dan label total klaim (tanpa tombol)
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(backgroundColor);
        headerPanel.setBorder(new EmptyBorder(10, 30, 10, 30));

        JLabel titleLabel = new JLabel("Data Klaim Asuransi: ", SwingConstants.LEFT);
        Font labelFont = new Font("Arial", Font.BOLD, 18);
        titleLabel.setFont(labelFont);
        titleLabel.setForeground(new Color(0x36464E));

        JLabel totalKlaimLabel = new JLabel("Total Klaim: " + totalKlaim, SwingConstants.RIGHT);
        totalKlaimLabel.setFont(labelFont.deriveFont(Font.BOLD, 14));
        totalKlaimLabel.setForeground(new Color(0x36464E));

        headerPanel.add(titleLabel, BorderLayout.WEST);
        headerPanel.add(totalKlaimLabel, BorderLayout.EAST);

        jPanel3.add(headerPanel, BorderLayout.NORTH);

        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JTable table = new JTable(tableModel);
        table.setBackground(backgroundColor);
        table.setForeground(textColor);
        table.setFont(new Font("SansSerif", Font.PLAIN, 14));
        table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 14));
        table.getTableHeader().setBackground(accentColor);
        table.getTableHeader().setForeground(Color.WHITE);

        // Atur lebar kolom sesuai kebutuhan
        table.getColumnModel().getColumn(0).setPreferredWidth(30);   // ID Klaim
        table.getColumnModel().getColumn(1).setPreferredWidth(30);   // No Polis (ID)
        table.getColumnModel().getColumn(2).setPreferredWidth(210);  // Nama Peserta
        table.getColumnModel().getColumn(3).setPreferredWidth(50);   // Umur
        table.getColumnModel().getColumn(4).setPreferredWidth(90);   // Tanggal Pengajuan
        table.getColumnModel().getColumn(5).setPreferredWidth(110);  // Status

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(new EmptyBorder(10, 30, 10, 30));
        scrollPane.getViewport().setBackground(backgroundColor);
        scrollPane.setPreferredSize(new Dimension(700, 450));
        jPanel3.add(scrollPane, BorderLayout.CENTER);

        // Panel bawah untuk tombol, FlowLayout aligned to RIGHT dengan margin kanan lebih besar
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 10));
        bottomPanel.setBackground(backgroundColor);
        bottomPanel.setBorder(new EmptyBorder(0, 0, 0, 30)); // margin kanan 40px

        JButton prosesKlaimButton = new JButton("Proses Klaim Asuransi");
        prosesKlaimButton.setBackground(accentColor);
        prosesKlaimButton.setForeground(Color.WHITE);
        prosesKlaimButton.setPreferredSize(new Dimension(200, 30));

        bottomPanel.add(prosesKlaimButton);
        jPanel3.add(bottomPanel, BorderLayout.SOUTH);

        jPanel3.revalidate();
        jPanel3.repaint();

        // Listener tombol proses klaim
        prosesKlaimButton.addActionListener(e -> {
            try {
                List<Polis> polisList = polisService.semuaPolis();

                Frame parentFrame = (Frame) SwingUtilities.getWindowAncestor(jPanel3);

                ProsesKlaimDialog dialog = new ProsesKlaimDialog(parentFrame, "Proses Klaim Baru", true, polisList);
                dialog.setVisible(true);

                if (dialog.isSucceeded()) {
                    Klaim klaimBaru = dialog.getKlaimBaru();

                    layananAsuransi.prosesKlaim(klaimBaru);

                    // Refresh ulang data klaim setelah simpan
                    List<Klaim> updatedKlaimList = layananAsuransi.semuaKlaim();

                    Object[][] dataKlaim = new Object[updatedKlaimList.size()][6];

                    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd-MMM-yyyy");

                    for (int i = 0; i < updatedKlaimList.size(); i++) {
                        Klaim k = updatedKlaimList.get(i);
                        String tglPengajuan = (k.getTanggal() != null) ? sdf.format(k.getTanggal()) : "";
                        dataKlaim[i] = new Object[]{
                            k.getId(),
                            k.getPolisId(),
                            k.getNamaPeserta() != null ? k.getNamaPeserta() : "Guest",
                            k.getUmur(),
                            tglPengajuan,
                            k.getStatus()
                        };
                    }

                    // Panggil ulang method setKlaimData untuk tampilkan data terbaru
                    setKlaimData(dataKlaim, columnNames);

                    JOptionPane.showMessageDialog(parentFrame, "Klaim berhasil disimpan.", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Gagal menyimpan klaim: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        });
    }

    private void addHeaderComponents() {
        labelUsername.setText(SessionManager.getUserName());
        labelCustomerName.setText(SessionManager.getName());
    }
}
