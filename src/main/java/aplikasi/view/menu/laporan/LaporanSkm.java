/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.view.menu.laporan;

import aplikasi.config.KoneksiDB;
import aplikasi.config.ValueFormatter;
import aplikasi.controller.TableViewController;
import aplikasi.entity.SuratKematian;
import aplikasi.entity.Users;
import aplikasi.repository.RepoSkm;
import aplikasi.service.ServiceSkm;
import aplikasi.view.MainMenuView;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author niser
 */
public final class LaporanSkm extends javax.swing.JInternalFrame {

    private final MainMenuView mainMenuController;
    private final TableViewController tableController;
    private Users p;

    private final RepoSkm repoSkm = new ServiceSkm(KoneksiDB.getDataSource());

    private List<SuratKematian> daftarSuratKematian = new ArrayList<>();

    /**
     * Creates new form LaporanPeminjaman
     *
     * @param mainMenuController
     */
    public LaporanSkm(MainMenuView mainMenuController, Users p) {
        initComponents();
        this.mainMenuController = mainMenuController;
        this.tableController = new TableViewController(tableView);
        this.p = p;
//        hideFilter();
        txtTanggalAwal.setDate(new java.util.Date());
        txtTanggalAkhir.setDate(new java.util.Date());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jLabel1 = new javax.swing.JLabel();
        txtTanggalAwal = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        txtTanggalAkhir = new com.toedter.calendar.JDateChooser();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jLabel3 = new javax.swing.JLabel();
        btnProses = new javax.swing.JButton();
        btnCetak = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableView = new javax.swing.JTable();

        setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(99, 130, 203)));
        setTitle("Laporan Kematiaan");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setPreferredSize(new java.awt.Dimension(721, 52));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jToolBar1.setBorder(null);
        jToolBar1.setRollover(true);

        jLabel1.setText(" Tanggal : ");
        jToolBar1.add(jLabel1);

        txtTanggalAwal.setMaximumSize(new java.awt.Dimension(120, 29));
        txtTanggalAwal.setMinimumSize(new java.awt.Dimension(120, 29));
        txtTanggalAwal.setPreferredSize(new java.awt.Dimension(120, 29));
        jToolBar1.add(txtTanggalAwal);

        jLabel2.setText("s/d");
        jToolBar1.add(jLabel2);

        txtTanggalAkhir.setMaximumSize(new java.awt.Dimension(120, 29));
        txtTanggalAkhir.setMinimumSize(new java.awt.Dimension(120, 29));
        txtTanggalAkhir.setPreferredSize(new java.awt.Dimension(120, 29));
        jToolBar1.add(txtTanggalAkhir);

        jSeparator1.setMaximumSize(new java.awt.Dimension(5, 5));
        jSeparator1.setMinimumSize(new java.awt.Dimension(5, 5));
        jSeparator1.setPreferredSize(new java.awt.Dimension(5, 5));
        jSeparator1.setSeparatorSize(new java.awt.Dimension(5, 5));
        jToolBar1.add(jSeparator1);

        jLabel3.setText("  ");
        jToolBar1.add(jLabel3);

        btnProses.setText("Proses");
        btnProses.setFocusable(false);
        btnProses.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProses.setMaximumSize(new java.awt.Dimension(100, 29));
        btnProses.setMinimumSize(new java.awt.Dimension(100, 29));
        btnProses.setPreferredSize(new java.awt.Dimension(100, 29));
        btnProses.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnProses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProsesActionPerformed(evt);
            }
        });
        jToolBar1.add(btnProses);

        btnCetak.setText("Cetak");
        btnCetak.setEnabled(false);
        btnCetak.setFocusable(false);
        btnCetak.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCetak.setMaximumSize(new java.awt.Dimension(100, 29));
        btnCetak.setMinimumSize(new java.awt.Dimension(100, 29));
        btnCetak.setPreferredSize(new java.awt.Dimension(100, 29));
        btnCetak.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });
        jToolBar1.add(btnCetak);

        jPanel1.add(jToolBar1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Daftar Kematian"));

        tableView.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No SKM", "Tanggal", "Tempat", "NIK", "Nama", "Kelamin", "Tmp Lahir", "Tgl Lahir", "Keterangan"
            }
        ));
        jScrollPane1.setViewportView(tableView);
        if (tableView.getColumnModel().getColumnCount() > 0) {
            tableView.getColumnModel().getColumn(0).setPreferredWidth(135);
            tableView.getColumnModel().getColumn(0).setMaxWidth(135);
            tableView.getColumnModel().getColumn(1).setPreferredWidth(75);
            tableView.getColumnModel().getColumn(1).setMaxWidth(75);
            tableView.getColumnModel().getColumn(2).setPreferredWidth(150);
            tableView.getColumnModel().getColumn(2).setMaxWidth(150);
            tableView.getColumnModel().getColumn(6).setPreferredWidth(150);
            tableView.getColumnModel().getColumn(6).setMaxWidth(150);
            tableView.getColumnModel().getColumn(7).setPreferredWidth(150);
            tableView.getColumnModel().getColumn(7).setMaxWidth(150);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1008, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProsesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProsesActionPerformed
        String valueTglAwal = ValueFormatter.getDateSQL(txtTanggalAwal.getDate());
        String valueTglAkhir = ValueFormatter.getDateSQL(txtTanggalAkhir.getDate());
        refreshDataSp(Date.valueOf(valueTglAwal), Date.valueOf(valueTglAkhir));
    }//GEN-LAST:event_btnProsesActionPerformed
//    private void hideFilter() {
//        lblKategori.setVisible(false);
//        txtKategori.setVisible(false);
//        lblKepemilikan.setVisible(false);
//        txtKepemilikan.setVisible(false);
//    }
//
//    private void showFilter() {
//        lblKategori.setVisible(true);
//        txtKategori.setVisible(true);
//        lblKepemilikan.setVisible(true);
//        txtKepemilikan.setVisible(true);
//    }
    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
        if (daftarSuratKematian.size() > 0) {
            try {
                String url = "/laporan/LaporanSuratKematian.jasper";
                Map<String, Object> map = new HashMap<>();
                map.put("tglAwal", txtTanggalAwal.getDate());
                map.put("tglAkhir", txtTanggalAkhir.getDate());
                map.put("pengguna", p.getNama());
                map.put("jabatan", p.getJabatan().toString());
                JasperPrint print = JasperFillManager.fillReport(
                        getClass().getResourceAsStream(url),
                        map,
                        new JRBeanCollectionDataSource(daftarSuratKematian));
                JasperViewer view = new JasperViewer(print, false);
                view.setLocationRelativeTo(null);
                view.setExtendedState(JasperViewer.MAXIMIZED_BOTH);
                view.setVisible(true);
            } catch (JRException ex) {
                Logger.getLogger(LaporanSkm.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Data belum diproses", getTitle(), JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnCetakActionPerformed


    private void refreshDataSp(Date tglAwal, Date tglAkhir) {
        try {
            
            tableController.clearData();
            daftarSuratKematian = repoSkm.findSpByTglBetween(tglAwal, tglAkhir);
            if (daftarSuratKematian.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Tidak ada transaksi !", getTitle(), JOptionPane.INFORMATION_MESSAGE);
            }
            btnCetak.setEnabled(!daftarSuratKematian.isEmpty());
            for (SuratKematian k : daftarSuratKematian) {
                     Object[] row = {k.getNo_skm(), k.getTgl_kematian(), k.getTmp_kematian(), k.getPenduduk().getNik(), k.getPenduduk().getNama(),k.getPenduduk().getKelamin(),k.getPenduduk().getTmp_lahir(), k.getPenduduk().getTgl_lahir(), k.getSebab(), k.getPenduduk().getNama_ibu(), k.getPenduduk().getNama_ayah(),
                     k.getPenduduk().getGol_darah(), k.getPenduduk().getAlamat(), k.getPenduduk().getRt(), k.getPenduduk().getRw(), k.getPenduduk().getKelurahan(),
                    k.getPenduduk().getKecamatan(), k.getPenduduk().getAgama(), k.getPenduduk().getPendidikan(), k.getPenduduk().getSts_kawin(), k.getPenduduk().getPekerjaan(), k.getPenduduk().getKewarganegaraan(), k.isVerifikasi()};
               tableController.getModel().addRow(row);
            }
            tableController.setContentTableAlignment(Arrays.asList(0, 2, 3, 4, 5, 6));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Tidak dapat menampilkan data peminjaman", getTitle(), JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(LaporanSkm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnProses;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tableView;
    private com.toedter.calendar.JDateChooser txtTanggalAkhir;
    private com.toedter.calendar.JDateChooser txtTanggalAwal;
    // End of variables declaration//GEN-END:variables

}
