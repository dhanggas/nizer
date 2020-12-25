/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.view.menu.pengantarktp;

import aplikasi.config.KoneksiDB;
import aplikasi.controller.TableViewController;
import aplikasi.entity.Penduduk;
import aplikasi.entity.KategoriAset;
import aplikasi.entity.LokasiAset;
import aplikasi.entity.Kepemilikan;
import aplikasi.entity.Peminjaman;
import aplikasi.entity.PeminjamanDetail;
import aplikasi.entity.StatusAset;
import aplikasi.service.ServicePenduduk;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import aplikasi.repository.RepoPenduduk;

/**
 *
 * @author dhiskar
 */
public class DetailPeminjamanView extends javax.swing.JDialog {

    private final RepoPenduduk repoAset;
    private final TableViewController tableController;

    private List<Penduduk> daftarAset = new ArrayList<>();
    private final DataPengantarKtpView dataPeminjamanVIewController;
    private final Peminjaman peminjaman;

    /**
     * Creates new form DataPenambahanDetailView
     * @param parent
     * @param dataPeminjamanVIewController
     * @param peminjaman
     * @param modal
     */
    public DetailPeminjamanView(java.awt.Frame parent, DataPengantarKtpView dataPeminjamanVIewController, Peminjaman peminjaman, boolean modal) {
        super(parent, modal);
        initComponents();
        this.repoAset = new ServicePenduduk(KoneksiDB.getDataSource());
        this.tableController = new TableViewController(tableView);
        this.dataPeminjamanVIewController = dataPeminjamanVIewController;
        this.peminjaman = peminjaman;
        refrestDataTable();
    }

    private void refrestDataTable() {
        try {
            tableController.clearData();
            daftarAset = repoAset.findByQtyOneByName(txtCari.getText());
            for (Penduduk aset : daftarAset) {
                Object[] row = {
                    aset.getNik(),
                    aset.getNama(),
//                    aset.getKategoriAset().getNama_kategori(),
//                    aset.getQty()
                };
                tableController.getModel().addRow(row);
            }
            tableController.setContentTableAlignment( Arrays.asList(0,2,3));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Tidak dapat menampilkan data aset", getTitle(), JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(DetailPeminjamanView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void setFields(Penduduk aset) {
        txtKode.setText(aset.getNik());
        txtNama.setText(aset.getNama());

//        KategoriAset ka = aset.getKategoriAset();
//        txtProses.setText(ka.getNama_kategori());
//
//        StatusAset sa = aset.getStatusAset();
//        txtStatus.setText(sa.getStatus());
//
//        LokasiAset la = aset.getLokasiAset();
//        txtLokasi.setText(la.getNama_rak());
//
//        Kepemilikan p = aset.getKepemilikan();
//        txtPemilik.setText(p.getNama());
    }

    private void clearFields() {
        txtKode.setText("");
        txtNama.setText("");
        txtProses.setText("");
        txtStatus.setText("");
        txtLokasi.setText("");
        txtPemilik.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        pmnuTambah = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        pmnuSelesai = new javax.swing.JMenuItem();
        jToolBar1 = new javax.swing.JToolBar();
        btnTambah = new javax.swing.JButton();
        btnSelesai = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        txtKode = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        txtProses = new javax.swing.JTextField();
        txtStatus = new javax.swing.JTextField();
        txtLokasi = new javax.swing.JTextField();
        txtPemilik = new javax.swing.JTextField();
        txtJumlah = new javax.swing.JSpinner();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableView = new javax.swing.JTable();
        txtCari = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        pmnuTambah.setText("Tambah");
        pmnuTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pmnuTambahActionPerformed(evt);
            }
        });
        jPopupMenu1.add(pmnuTambah);
        jPopupMenu1.add(jSeparator2);

        pmnuSelesai.setText("Selesai");
        pmnuSelesai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pmnuSelesaiActionPerformed(evt);
            }
        });
        jPopupMenu1.add(pmnuSelesai);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pilih Aset");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/gambar/logo3.png")).getImage());

        jToolBar1.setRollover(true);

        btnTambah.setText("Tambah");
        btnTambah.setFocusable(false);
        btnTambah.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTambah.setMaximumSize(new java.awt.Dimension(120, 35));
        btnTambah.setMinimumSize(new java.awt.Dimension(120, 35));
        btnTambah.setPreferredSize(new java.awt.Dimension(120, 35));
        btnTambah.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });
        jToolBar1.add(btnTambah);

        btnSelesai.setText("Selesai");
        btnSelesai.setFocusable(false);
        btnSelesai.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSelesai.setMaximumSize(new java.awt.Dimension(120, 35));
        btnSelesai.setMinimumSize(new java.awt.Dimension(120, 35));
        btnSelesai.setPreferredSize(new java.awt.Dimension(120, 35));
        btnSelesai.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSelesai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelesaiActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSelesai);

        getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_END);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Aset"));
        jPanel1.setMaximumSize(new java.awt.Dimension(0, 0));
        jPanel1.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(0, 0));

        jLabel1.setText("Kode");

        jLabel2.setText("Nama Dies");

        jLabel3.setText("Proses");

        jLabel4.setText("Status");

        jLabel5.setText("Lokasi");

        jLabel6.setText("Kepemilikan");

        jLabel7.setText("Jumlah");

        txtKode.setEditable(false);

        txtNama.setEditable(false);

        txtProses.setEditable(false);

        txtStatus.setEditable(false);

        txtLokasi.setEditable(false);

        txtPemilik.setEditable(false);

        txtJumlah.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtJumlah.setModel(new javax.swing.SpinnerNumberModel(1, 1, 1, 5));
        txtJumlah.setEnabled(false);
        txtJumlah.setFocusable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtStatus, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtNama, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtKode, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtProses, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtLokasi, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtPemilik)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(16, 16, 16)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtKode, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNama)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtProses)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtStatus)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtLokasi)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(txtPemilik))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(164, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_END);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Daftar Aset"));

        tableView.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Kode", "Nama", "Kategori", "Stok"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableViewMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableViewMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tableView);
        if (tableView.getColumnModel().getColumnCount() > 0) {
            tableView.getColumnModel().getColumn(0).setPreferredWidth(60);
            tableView.getColumnModel().getColumn(0).setMaxWidth(60);
            tableView.getColumnModel().getColumn(2).setPreferredWidth(150);
            tableView.getColumnModel().getColumn(2).setMaxWidth(150);
            tableView.getColumnModel().getColumn(3).setMinWidth(0);
            tableView.getColumnModel().getColumn(3).setPreferredWidth(0);
            tableView.getColumnModel().getColumn(3).setMaxWidth(0);
        }

        txtCari.setToolTipText("Pencarian berdasaarkan nama dies");
        txtCari.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtCariCaretUpdate(evt);
            }
        });

        jLabel8.setText("Cari");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        if (tableController.isSelected()) {
            Penduduk aset = daftarAset.get(tableController.getRowSelected());
            PeminjamanDetail pd = new PeminjamanDetail();
            pd.setAset(aset);
            pd.setQty((Integer) txtJumlah.getValue());
            pd.setPeminjaman(peminjaman);
            dataPeminjamanVIewController.tambahAsetBelanjaan(pd);
//            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Data barang belum dipilih", getTitle(), JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnSelesaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelesaiActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSelesaiActionPerformed

    private void tableViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableViewMouseClicked
         if (evt.getClickCount() == 2){
            Penduduk aset = daftarAset.get(tableController.getRowSelected());
            PeminjamanDetail pd = new PeminjamanDetail();
            pd.setAset(aset);
            pd.setQty((Integer) txtJumlah.getValue());
            pd.setPeminjaman(peminjaman);
            dataPeminjamanVIewController.tambahAsetBelanjaan(pd);
            this.dispose();
        }
    }//GEN-LAST:event_tableViewMouseClicked

    private void txtCariCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtCariCaretUpdate
refrestDataTable();
    }//GEN-LAST:event_txtCariCaretUpdate

    private void pmnuTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pmnuTambahActionPerformed
        btnTambahActionPerformed(evt);
    }//GEN-LAST:event_pmnuTambahActionPerformed

    private void pmnuSelesaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pmnuSelesaiActionPerformed
        btnSelesaiActionPerformed(evt);
    }//GEN-LAST:event_pmnuSelesaiActionPerformed

    private void tableViewMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableViewMouseReleased
       if (evt.isPopupTrigger()) {
            JTable source = (JTable) evt.getSource();
            int row = source.rowAtPoint(evt.getPoint());
            int column = source.columnAtPoint(evt.getPoint());
            if (!source.isRowSelected(row)) {
                source.changeSelection(row, column, false, false);
            }
            jPopupMenu1.show(evt.getComponent(), evt.getX(), evt.getY());
        } 
    }//GEN-LAST:event_tableViewMouseReleased

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        if (evt.getClickCount()==2) {
            txtCari.setText("");
            txtCari.requestFocus();
        }
    }//GEN-LAST:event_jLabel8MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSelesai;
    private javax.swing.JButton btnTambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenuItem pmnuSelesai;
    private javax.swing.JMenuItem pmnuTambah;
    private javax.swing.JTable tableView;
    private javax.swing.JTextField txtCari;
    private javax.swing.JSpinner txtJumlah;
    private javax.swing.JTextField txtKode;
    private javax.swing.JTextField txtLokasi;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtPemilik;
    private javax.swing.JTextField txtProses;
    private javax.swing.JTextField txtStatus;
    // End of variables declaration//GEN-END:variables
}
