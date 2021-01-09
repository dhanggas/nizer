/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.view.menu.penduduk;

import aplikasi.config.KoneksiDB;
import aplikasi.controller.TableViewController;
import aplikasi.entity.Penduduk;
import aplikasi.entity.Users;
import aplikasi.service.ServicePenduduk;
import aplikasi.view.MainMenuView;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
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
public class DaftarPendudukView extends javax.swing.JInternalFrame {

    private final RepoPenduduk repoPenduduk = new ServicePenduduk(KoneksiDB.getDataSource());
    private final MainMenuView menuController;
    private final TableViewController tableController;
    private final RepoPenduduk repoAset;
    private List<Penduduk> daftarAset = new ArrayList<>();
    private Users p = null;

    /**
     * Creates new form DaftarAsetView
     *
     * @param menuController
     */
    public DaftarPendudukView(MainMenuView menuController) {
        initComponents();
        this.menuController = menuController;
        this.tableController = new TableViewController(tableView);
        this.repoAset = new ServicePenduduk(KoneksiDB.getDataSource());
        refreshDataTablesByName();
    }

    public DaftarPendudukView(MainMenuView menuController, Users p) {
        initComponents();
        this.menuController = menuController;
        this.tableController = new TableViewController(tableView);
        this.repoAset = new ServicePenduduk(KoneksiDB.getDataSource());
        refreshDataTablesByName();
        this.p = p;
        setEnabledBtnHapus(p);

    }

    public void refreshDataTables() {
        try {
            tableController.clearData();
            this.daftarAset = repoAset.findAll();
            for (Penduduk penduduk : daftarAset) {
                Object[] row = {penduduk.getNik(), penduduk.getNama(), penduduk.getNama_ibu(), penduduk.getNama_ayah(), penduduk.getTmp_lahir(), penduduk.getTgl_lahir(),
                    penduduk.getKelamin(), penduduk.getGol_darah(), penduduk.getAlamat(), penduduk.getRt(), penduduk.getRw(), penduduk.getKelurahan(),
                    penduduk.getKecamatan(), penduduk.getAgama(), penduduk.getPendidikan(), penduduk.getSts_kawin(), penduduk.getPekerjaan(), penduduk.getKewarganegaraan()};
                tableController.getModel().addRow(row);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Tidak dapat mendapatkan data penduduk", getTitle(), JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(DaftarPendudukView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void selectLastRow() {
        tableView.setRowSelectionInterval(tableView.getRowCount() - 1, tableView.getRowCount() - 1);
        tableView.scrollRectToVisible(new Rectangle(tableView.getCellRect(tableView.getRowCount() - 1, 0, true)));
    }

    public void refreshDataTablesByName() {
        try {
            tableController.clearData();
            this.daftarAset = repoAset.findByNama(txtCari.getText());
            for (Penduduk penduduk : daftarAset) {
                Object[] row = {penduduk.getNik(), penduduk.getNama(), penduduk.getNama_ibu(), penduduk.getNama_ayah(), penduduk.getTmp_lahir(), penduduk.getTgl_lahir(),
                    penduduk.getKelamin(), penduduk.getGol_darah(), penduduk.getAlamat(), penduduk.getRt(), penduduk.getRw(), penduduk.getKelurahan(),
                    penduduk.getKecamatan(), penduduk.getAgama(), penduduk.getPendidikan(), penduduk.getSts_kawin(), penduduk.getPekerjaan(),penduduk.getKewarganegaraan()};
                tableController.getModel().addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaftarPendudukView.class.getName()).log(Level.SEVERE, null, ex);
        }
        tableController.setContentTableAlignment(Arrays.asList(0, 1, 3, 4, 5, 6));
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
        pmnuUbah = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        pmnuTambah = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        pmnuLihatTransaksi = new javax.swing.JMenuItem();
        jToolBar1 = new javax.swing.JToolBar();
        btnTambah = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtCari = new javax.swing.JTextField();
        lblCari = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableView = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtNik = new javax.swing.JTextField();
        txtNamaIbu = new javax.swing.JTextField();
        txtNamaAyah = new javax.swing.JTextField();
        txt_tmp_lahir = new javax.swing.JTextField();
        txt_tgl_lahir = new javax.swing.JTextField();
        txt_kelamin = new javax.swing.JTextField();
        txt_gol_darah = new javax.swing.JTextField();
        txtAlamat = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtRt = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtRw = new javax.swing.JTextField();

        pmnuUbah.setText("Ubah");
        pmnuUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pmnuUbahActionPerformed(evt);
            }
        });
        jPopupMenu1.add(pmnuUbah);
        jPopupMenu1.add(jSeparator1);

        pmnuTambah.setText("Tambah");
        pmnuTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pmnuTambahActionPerformed(evt);
            }
        });
        jPopupMenu1.add(pmnuTambah);
        jPopupMenu1.add(jSeparator2);

        pmnuLihatTransaksi.setText("Lihat Transaksi");
        pmnuLihatTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pmnuLihatTransaksiActionPerformed(evt);
            }
        });
        jPopupMenu1.add(pmnuLihatTransaksi);

        setTitle("Master Penduduk");
        setMinimumSize(new java.awt.Dimension(53, 22));
        setPreferredSize(new java.awt.Dimension(710, 490));

        jToolBar1.setRollover(true);
        jToolBar1.setPreferredSize(new java.awt.Dimension(100, 45));

        btnTambah.setText("Tambah");
        btnTambah.setToolTipText("Tambah data baru");
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
        btnTambah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnTambahKeyPressed(evt);
            }
        });
        jToolBar1.add(btnTambah);

        btnUbah.setText("Ubah");
        btnUbah.setToolTipText("Ubah data yang dipilih");
        btnUbah.setFocusable(false);
        btnUbah.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUbah.setMaximumSize(new java.awt.Dimension(120, 35));
        btnUbah.setMinimumSize(new java.awt.Dimension(120, 35));
        btnUbah.setPreferredSize(new java.awt.Dimension(120, 35));
        btnUbah.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });
        jToolBar1.add(btnUbah);

        btnHapus.setText("Hapus");
        btnHapus.setToolTipText("");
        btnHapus.setFocusable(false);
        btnHapus.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHapus.setMaximumSize(new java.awt.Dimension(120, 35));
        btnHapus.setMinimumSize(new java.awt.Dimension(120, 35));
        btnHapus.setPreferredSize(new java.awt.Dimension(120, 35));
        btnHapus.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        btnHapus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnHapusKeyPressed(evt);
            }
        });
        jToolBar1.add(btnHapus);

        getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_END);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Daftar Penduduk"));

        txtCari.setToolTipText("Pencarian berdasarkan nama");
        txtCari.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtCariCaretUpdate(evt);
            }
        });
        txtCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCariActionPerformed(evt);
            }
        });

        lblCari.setText("Cari");
        lblCari.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblCari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCariMouseClicked(evt);
            }
        });

        tableView.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nik", "Nama", "Nama Ibu", "Nama Ayah", "Tempat Lahir", "Tanggal Lahir", "Kelamin"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableView.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tableView.setOpaque(false);
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
            tableView.getColumnModel().getColumn(0).setPreferredWidth(50);
            tableView.getColumnModel().getColumn(1).setPreferredWidth(70);
            tableView.getColumnModel().getColumn(2).setPreferredWidth(250);
            tableView.getColumnModel().getColumn(3).setPreferredWidth(100);
            tableView.getColumnModel().getColumn(4).setPreferredWidth(50);
            tableView.getColumnModel().getColumn(5).setPreferredWidth(50);
            tableView.getColumnModel().getColumn(6).setPreferredWidth(50);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblCari, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCari, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(lblCari, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Penduduk"));
        jPanel4.setAutoscrolls(true);
        jPanel4.setPreferredSize(new java.awt.Dimension(400, 429));

        jLabel12.setText("Nik");

        jLabel13.setText("Nama Ibu");

        jLabel14.setText("Nama Ayah");

        jLabel16.setText("Temapt Lahir");

        jLabel17.setText("Tanggal Lahir");

        jLabel18.setText("Kelamin");

        jLabel19.setText("Gol Darah");

        txtNik.setEditable(false);

        txtNamaIbu.setEditable(false);

        txtNamaAyah.setEditable(false);

        txt_tmp_lahir.setEditable(false);
        txt_tmp_lahir.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        txt_tgl_lahir.setEditable(false);
        txt_tgl_lahir.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        txt_kelamin.setEditable(false);
        txt_kelamin.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        txt_gol_darah.setEditable(false);
        txt_gol_darah.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        txtAlamat.setEditable(false);

        jLabel20.setText("Alamat");

        txtRt.setEditable(false);

        jLabel21.setText("RT");

        txtNama.setEditable(false);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Nama");

        jLabel22.setText("RW");

        txtRw.setEditable(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtRw, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tgl_lahir, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_gol_darah, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtNamaAyah, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                        .addComponent(txtNamaIbu, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(txt_tmp_lahir, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_kelamin, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNik, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNik, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(txtNamaIbu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNamaAyah, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_tmp_lahir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tgl_lahir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_kelamin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_gol_darah, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRw, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(72, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4, java.awt.BorderLayout.LINE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        if (tableController.isSelected()) {
            Penduduk penduduk = daftarAset.get(tableController.getRowSelected());
            DataPendudukView view = new DataPendudukView(menuController, this, penduduk, true, p);
            view.setLocationRelativeTo(null);
            view.setResizable(false);
            view.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Data belum dipilih!", getTitle(), JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        DataPendudukView view = new DataPendudukView(menuController, this, true, p);
        view.setResizable(false);
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }//GEN-LAST:event_btnTambahActionPerformed

    private void txtCariCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtCariCaretUpdate
//        tableController.getSorter().setRowFilter(RowFilter.regexFilter(txtCari.getText()));
        refreshDataTablesByName();
    }//GEN-LAST:event_txtCariCaretUpdate

    private void tableViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableViewMouseClicked
        clearFields();
//        txtCari.setText("");
//        tableView.changeSelection(tableController.getRowSelected(), 1, false, false);
        if (tableController.isSelected()) {
            Penduduk penduduk = daftarAset.get(tableController.getRowSelected());
            setFields(penduduk);
        } else {
        }
    }//GEN-LAST:event_tableViewMouseClicked

    private void txtCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariActionPerformed
    }//GEN-LAST:event_txtCariActionPerformed

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

    private void pmnuLihatTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pmnuLihatTransaksiActionPerformed
//        if (tableController.isSelected()) {
//            Penduduk penduduk = daftarAset.get(tableController.getRowSelected());
//            LaporanLihatTransaksi view = new LaporanLihatTransaksi(menuController, penduduk, true);
//            view.setLocationRelativeTo(null);
//            view.setTitle("Histori Transaksi");
//            view.setResizable(false);
//            view.setVisible(true);
//        } else {
//            JOptionPane.showMessageDialog(this, "Data belum dipilih!", getTitle(), JOptionPane.WARNING_MESSAGE);
//        }
    }//GEN-LAST:event_pmnuLihatTransaksiActionPerformed

    private void pmnuUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pmnuUbahActionPerformed
        btnUbahActionPerformed(evt);
    }//GEN-LAST:event_pmnuUbahActionPerformed

    private void pmnuTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pmnuTambahActionPerformed
        btnTambahActionPerformed(evt);
    }//GEN-LAST:event_pmnuTambahActionPerformed

    private void lblCariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCariMouseClicked
        if (evt.getClickCount() == 2) {
            txtCari.setText("");
            txtCari.requestFocus();
        }
    }//GEN-LAST:event_lblCariMouseClicked

    private void btnTambahKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnTambahKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnTambahActionPerformed(null);
        }
    }//GEN-LAST:event_btnTambahKeyPressed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        if (tableController.isSelected()) {
            try {
                Penduduk penduduk = daftarAset.get(tableController.getRowSelected());
                int j = JOptionPane.showConfirmDialog(this, "Hapus data ?",this.getTitle(),JOptionPane.YES_NO_OPTION);
                if (j == JOptionPane.YES_OPTION) {
                    repoPenduduk.delete(penduduk.getNik());
                    refreshDataTablesByName();
                }
            } catch (Exception e) {
            }
        } else {
            JOptionPane.showMessageDialog(this, "Data belum dipilih!", getTitle(), JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnHapusKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnHapusKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHapusKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUbah;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblCari;
    private javax.swing.JMenuItem pmnuLihatTransaksi;
    private javax.swing.JMenuItem pmnuTambah;
    private javax.swing.JMenuItem pmnuUbah;
    private javax.swing.JTable tableView;
    private javax.swing.JTextField txtAlamat;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNamaAyah;
    private javax.swing.JTextField txtNamaIbu;
    private javax.swing.JTextField txtNik;
    private javax.swing.JTextField txtRt;
    private javax.swing.JTextField txtRw;
    private javax.swing.JTextField txt_gol_darah;
    private javax.swing.JTextField txt_kelamin;
    private javax.swing.JTextField txt_tgl_lahir;
    private javax.swing.JTextField txt_tmp_lahir;
    // End of variables declaration//GEN-END:variables

    public void setFields(Penduduk penduduk) {
        txtNik.setText(penduduk.getNik());
        txtNama.setText(penduduk.getNama());
        txtNamaIbu.setText(penduduk.getNama_ibu());
        txtNamaAyah.setText(penduduk.getNama_ayah());
        txt_tmp_lahir.setText(penduduk.getTmp_lahir());
        txt_tgl_lahir.setText(penduduk.getTgl_lahir().toString());
        txt_kelamin.setText(penduduk.getKelamin());
        txt_gol_darah.setText(penduduk.getGol_darah());
        txtAlamat.setText(penduduk.getAlamat());
        txtRt.setText(penduduk.getRt());
        txtRw.setText(penduduk.getRw());

    }

    public void clearFields() {
        txtNik.setText("");
        txtNama.setText("");
        txtNamaIbu.setText("");
        txtNamaAyah.setText("");
        txt_tmp_lahir.setText("");
        txt_tgl_lahir.setText("");
        txt_kelamin.setText("");
        txt_gol_darah.setText("");
        txtAlamat.setText("");
        txtRt.setText("");
    }

    void btnTambahRequesFocus() {
        btnTambah.requestFocus();
    }

    private void setEnabledBtnHapus(Users p) {
        if (p.getJabatan() == Users.Role.Admin) {
            btnHapus.setEnabled(false);
        } else {
            btnHapus.setEnabled(true);
        }
    }
}
