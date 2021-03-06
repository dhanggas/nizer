/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.view;

import aplikasi.entity.Users;
import aplikasi.view.menu.laporan.LaporanSkm;
import aplikasi.view.menu.laporan.LaporanSuratPengantar;
import aplikasi.view.menu.user.DaftarUserView;
import aplikasi.view.menu.sp.DaftarSpView;
import aplikasi.view.menu.penduduk.DaftarPendudukView;
import aplikasi.view.menu.skm.DaftarSkmView;
import java.beans.PropertyVetoException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;

public class MainMenuView extends javax.swing.JFrame {

    private Users p = null;

    /**
     * Creates new form MainMenuView
     */
    public MainMenuView() {
        initComponents();
        showTanggal();
        lblIdUser.setVisible(false);
//        mniUbahTransaksi.setVisible(false);
    }

    public void showTanggal() {
        Date d = new Date();
        SimpleDateFormat tanggal = new SimpleDateFormat("EEEE, dd MMMM yyyy");
        lblTanggal.setText(tanggal.format(d));
    }

    public void showLoginScreen() {
        LoginView login = new LoginView(this, this, true);
        login.setTitle("DATA DESA SARAKAN- Application");
        login.setLocationRelativeTo(null);
        login.setVisible(true);
    }

    public void setInnerLayout(JInternalFrame internal) throws PropertyVetoException {
        this.desktop.removeAll();
        this.desktop.add(internal);
        internal.setMaximum(true);
        internal.setVisible(true);
        this.desktop.repaint();
    }

    public void showUser(Users p) {
        lblIdUser.setText(p.getId_user().toString());
        lblUser.setText(p.getUsername());
        lblJabatan.setText(p.getJabatan().toString());
        this.p = p;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem3 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        lblTanggal = new javax.swing.JLabel();
        lblIdUser = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblJabatan = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jSeparator9 = new javax.swing.JToolBar.Separator();
        jSeparator12 = new javax.swing.JToolBar.Separator();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        desktop = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuAplikasi = new javax.swing.JMenu();
        mniLogin = new javax.swing.JMenuItem();
        mniLogout = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        mniExit = new javax.swing.JMenuItem();
        mnuMasterData = new javax.swing.JMenu();
        mniUsers = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        mniPenduduk = new javax.swing.JMenuItem();
        mnuPengantar = new javax.swing.JMenu();
        mniSuratPengantar = new javax.swing.JMenuItem();
        jSeparator11 = new javax.swing.JPopupMenu.Separator();
        mniSKM = new javax.swing.JMenuItem();
        mnuLaporan = new javax.swing.JMenu();
        mniLapSuratPengantar = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        mniLapSKM = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        mniTentangAplikasi = new javax.swing.JMenuItem();

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/gambar/logo3.png")).getImage());
        setMinimumSize(new java.awt.Dimension(1024, 600));

        jPanel1.setPreferredSize(new java.awt.Dimension(624, 40));

        jLabel1.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jLabel1.setText("Login by :");

        lblUser.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        lblUser.setText("null");
        lblUser.setToolTipText("Username pengguna yang login");

        lblTanggal.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        lblTanggal.setText("null");

        lblIdUser.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        lblIdUser.setText("-");

        jLabel2.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jLabel2.setText("|");

        lblJabatan.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        lblJabatan.setText("null");
        lblJabatan.setToolTipText("Jabatan");

        jLabel3.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jLabel3.setText(" (");

        jLabel4.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jLabel4.setText(")");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblIdUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblJabatan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTanggal)
                .addContainerGap(476, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(lblJabatan)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(lblUser)
                        .addComponent(lblTanggal)
                        .addComponent(lblIdUser)
                        .addComponent(jLabel2)))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel3.setPreferredSize(new java.awt.Dimension(2, 270));

        jToolBar1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jToolBar1.setRollover(true);
        jToolBar1.setPreferredSize(new java.awt.Dimension(209, 328));
        jToolBar1.add(jSeparator1);
        jToolBar1.add(jSeparator2);
        jToolBar1.add(jSeparator3);
        jToolBar1.add(jSeparator9);
        jToolBar1.add(jSeparator12);
        jToolBar1.add(jSeparator6);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.LINE_START);

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 675, Short.MAX_VALUE)
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 479, Short.MAX_VALUE)
        );

        getContentPane().add(desktop, java.awt.BorderLayout.CENTER);

        jMenuBar1.setMinimumSize(new java.awt.Dimension(320, 35));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(320, 35));

        mnuAplikasi.setText("Aplikasi");

        mniLogin.setText("Login");
        mniLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniLoginActionPerformed(evt);
            }
        });
        mnuAplikasi.add(mniLogin);

        mniLogout.setText("Logout");
        mniLogout.setEnabled(false);
        mniLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniLogoutActionPerformed(evt);
            }
        });
        mnuAplikasi.add(mniLogout);
        mnuAplikasi.add(jSeparator4);

        mniExit.setForeground(new java.awt.Color(253, 0, 3));
        mniExit.setText("Exit");
        mniExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniExitActionPerformed(evt);
            }
        });
        mnuAplikasi.add(mniExit);

        jMenuBar1.add(mnuAplikasi);

        mnuMasterData.setText("Master Data");

        mniUsers.setText("User");
        mniUsers.setEnabled(false);
        mniUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniUsersActionPerformed(evt);
            }
        });
        mnuMasterData.add(mniUsers);
        mnuMasterData.add(jSeparator5);

        mniPenduduk.setText("Penduduk");
        mniPenduduk.setEnabled(false);
        mniPenduduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniPendudukActionPerformed(evt);
            }
        });
        mnuMasterData.add(mniPenduduk);

        jMenuBar1.add(mnuMasterData);

        mnuPengantar.setText("Transaksi");

        mniSuratPengantar.setForeground(new java.awt.Color(0, 110, 4));
        mniSuratPengantar.setText("Surat Pengantar (KTP / KK / Pindah)");
        mniSuratPengantar.setEnabled(false);
        mniSuratPengantar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniSuratPengantarActionPerformed(evt);
            }
        });
        mnuPengantar.add(mniSuratPengantar);
        mnuPengantar.add(jSeparator11);

        mniSKM.setText("Surat Kematian");
        mniSKM.setEnabled(false);
        mniSKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniSKMActionPerformed(evt);
            }
        });
        mnuPengantar.add(mniSKM);

        jMenuBar1.add(mnuPengantar);

        mnuLaporan.setText("Laporan");
        mnuLaporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuLaporanActionPerformed(evt);
            }
        });

        mniLapSuratPengantar.setText("Surat Pengantar (KTP / KK / Pindah)");
        mniLapSuratPengantar.setEnabled(false);
        mniLapSuratPengantar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniLapSuratPengantarActionPerformed(evt);
            }
        });
        mnuLaporan.add(mniLapSuratPengantar);
        mnuLaporan.add(jSeparator8);

        mniLapSKM.setText("Surat Kematian");
        mniLapSKM.setEnabled(false);
        mniLapSKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniLapSKMActionPerformed(evt);
            }
        });
        mnuLaporan.add(mniLapSKM);

        jMenuBar1.add(mnuLaporan);

        jMenu1.setText("Tentang");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        mniTentangAplikasi.setText("Tentang Aplikasi");
        mniTentangAplikasi.setEnabled(false);
        mniTentangAplikasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniTentangAplikasiActionPerformed(evt);
            }
        });
        jMenu1.add(mniTentangAplikasi);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mniLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniLoginActionPerformed
        showLoginScreen();
    }//GEN-LAST:event_mniLoginActionPerformed

    private void mniExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_mniExitActionPerformed

    private void mniPendudukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniPendudukActionPerformed
        try {
            DaftarPendudukView view = new DaftarPendudukView(this, p);
            setInnerLayout(view);
        } catch (Exception e) {
            Logger.getLogger(MainMenuView.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_mniPendudukActionPerformed
    public void daftarCaraPenggunaanAplikasi() {
        try {
            TentangAplikasi view = new TentangAplikasi(this);
            setInnerLayout(view);
        } catch (Exception e) {
            Logger.getLogger(MainMenuView.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void mniUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniUsersActionPerformed
        try {
            DaftarUserView view = new DaftarUserView(this);
            setInnerLayout(view);
        } catch (Exception e) {
            Logger.getLogger(MainMenuView.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_mniUsersActionPerformed

    private void mniLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniLogoutActionPerformed
        this.setLoginEnabled(false);
        this.enabledMenu(false);
        this.desktop.removeAll();
        this.desktop.repaint();
        lblUser.setText("null");
        lblJabatan.setText("null");
        mniLoginActionPerformed(null);
    }//GEN-LAST:event_mniLogoutActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void mniTentangAplikasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniTentangAplikasiActionPerformed
        try {
            TentangAplikasi view = new TentangAplikasi(this);
            setInnerLayout(view);
        } catch (Exception e) {
            Logger.getLogger(MainMenuView.class.getName()).log(Level.SEVERE, null, e);
        }

    }//GEN-LAST:event_mniTentangAplikasiActionPerformed

    private void mniSuratPengantarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniSuratPengantarActionPerformed
        try {
            DaftarSpView view = new DaftarSpView(this, p);
            setInnerLayout(view);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(MainMenuView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mniSuratPengantarActionPerformed

    private void mnuLaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuLaporanActionPerformed
    }//GEN-LAST:event_mnuLaporanActionPerformed

    private void mniLapSuratPengantarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniLapSuratPengantarActionPerformed
        try {
            LaporanSuratPengantar view = new LaporanSuratPengantar(this, p);
            setInnerLayout(view);
        } catch (Exception ex) {
            Logger.getLogger(MainMenuView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mniLapSuratPengantarActionPerformed

    private void mniLapSKMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniLapSKMActionPerformed
        try {
            LaporanSkm view = new LaporanSkm(this, p);
            setInnerLayout(view);
        } catch (Exception ex) {
            Logger.getLogger(MainMenuView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mniLapSKMActionPerformed

    private void mniSKMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniSKMActionPerformed
        try {
            DaftarSkmView view = new DaftarSkmView(this, p);
            setInnerLayout(view);
        } catch (Exception e) {
            Logger.getLogger(MainMenuView.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_mniSKMActionPerformed

    public void setEnabledMenuUser(Boolean aktif) {
        this.mniUsers.setEnabled(aktif);
    }

    public void setEnabledMenuLaporan(Boolean aktif) {
        this.mniLapSuratPengantar.setEnabled(aktif);
        this.mniLapSKM.setEnabled(aktif);
    }

    public void setEnabledMenuTentang(boolean aktif) {
        this.mniTentangAplikasi.setEnabled(aktif);
    }

    public void setLoginEnabled(Boolean login) {
        if (login) {
            this.mniLogin.setEnabled(false);
            this.mniLogout.setEnabled(true);
        } else {
            this.mniLogin.setEnabled(true);
            this.mniLogout.setEnabled(false);
        }
    }

    public void enabledMenu(Boolean aktif) {
        this.mniUsers.setEnabled(aktif);
        this.mniPenduduk.setEnabled(aktif);
        this.mniSuratPengantar.setEnabled(aktif);
        this.mniSKM.setEnabled(aktif);

        this.mniLapSuratPengantar.setEnabled(aktif);
        this.mniLapSKM.setEnabled(aktif);

        this.mniTentangAplikasi.setEnabled(aktif);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator11;
    private javax.swing.JToolBar.Separator jSeparator12;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JToolBar.Separator jSeparator9;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblIdUser;
    private javax.swing.JLabel lblJabatan;
    private javax.swing.JLabel lblTanggal;
    private javax.swing.JLabel lblUser;
    private javax.swing.JMenuItem mniExit;
    private javax.swing.JMenuItem mniLapSKM;
    private javax.swing.JMenuItem mniLapSuratPengantar;
    private javax.swing.JMenuItem mniLogin;
    private javax.swing.JMenuItem mniLogout;
    private javax.swing.JMenuItem mniPenduduk;
    private javax.swing.JMenuItem mniSKM;
    private javax.swing.JMenuItem mniSuratPengantar;
    private javax.swing.JMenuItem mniTentangAplikasi;
    private javax.swing.JMenuItem mniUsers;
    private javax.swing.JMenu mnuAplikasi;
    private javax.swing.JMenu mnuLaporan;
    private javax.swing.JMenu mnuMasterData;
    private javax.swing.JMenu mnuPengantar;
    // End of variables declaration//GEN-END:variables

    void setEnabledMenuAdmin(boolean aktif) {
        this.mniPenduduk.setEnabled(aktif);
        this.mniSuratPengantar.setEnabled(aktif);
        this.mniSKM.setEnabled(aktif);

    }

}
