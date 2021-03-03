/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.view.menu.sp;

import aplikasi.config.KoneksiDB;
import aplikasi.controller.TableViewController;
import aplikasi.entity.SuratPengantar;
import aplikasi.entity.Penduduk;
import aplikasi.entity.Users;
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
import aplikasi.service.ServiceSp;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import aplikasi.repository.RepoSp;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
public class DaftarSpView extends javax.swing.JInternalFrame {

//    private final RepoSp repoKtp = new ServiceSp(KoneksiDB.getDataSource());
    private final MainMenuView menuController;
    private final TableViewController tableController;
    private final RepoSp repoKtp;
    private List<SuratPengantar> daftarKtp;
    private List<SuratPengantar> daftarKtp2;
    private Users p = null;
    private SuratPengantar ktp = null;

    /**
     * Creates new form DaftarView
     *
     * @param menuController
     */
    public DaftarSpView(MainMenuView menuController) {
        initComponents();
        this.menuController = menuController;
        this.tableController = new TableViewController(tableView);
        this.repoKtp = new ServiceSp(KoneksiDB.getDataSource());
        this.daftarKtp = new ArrayList<>();
        this.daftarKtp2 = new ArrayList<>();
        refreshDataTablesByName();
    }

    public DaftarSpView(MainMenuView menuController, Users p) {
        initComponents();
        this.menuController = menuController;
        this.tableController = new TableViewController(tableView);
        this.repoKtp = new ServiceSp(KoneksiDB.getDataSource());
        this.daftarKtp = new ArrayList<>();
        this.daftarKtp2 = new ArrayList<>();
        refreshDataTablesByName();
        this.p = p;
        if (p != null && p.getJabatan() == Users.Role.Admin) {
            setBtnKelapaDisable();
        } else {
        }
        this.ktp = ktp;

    }
    public void buatQrCode(String kode) throws Exception{
//        String data = "ada";
//		String path = "D:\\QR-Code\\infybuzz.jpg";
//        
////        URI uri = getClass().getClassLoader().getResource("/gambar/infybuzz.jpg").toURI(); 
////Path path = Paths.get(uri);
////		String path = "//resources/gambar/infybuzz.jpg";
//		
//		BitMatrix matrix = new MultiFormatWriter().encode(data, BarcodeFormat.QR_CODE, 500, 500);
//		
//		MatrixToImageWriter.writeToPath(matrix, "jpg", Paths.get(path));

String data = kode;
		String path = "D:\\QR-Code\\qrCode.jpg";
		
		BitMatrix matrix = new MultiFormatWriter()
				.encode(data, BarcodeFormat.QR_CODE, 500, 500);
		
		MatrixToImageWriter.writeToPath(matrix, "jpg", Paths.get(path));
    }
    public void refreshDataTables() {
        try {
            tableController.clearData();
            this.daftarKtp = repoKtp.findAll();
            for (SuratPengantar k : daftarKtp) {
                Object[] row = {k.getNo_sp(), k.getTgl(), k.getPenduduk().getNik(), k.getPenduduk().getNama(), k.getKeperluan(), k.getPenduduk().getNama_ibu(), k.getPenduduk().getNama_ayah(), k.getPenduduk().getTmp_lahir(), k.getPenduduk().getTgl_lahir(),
                    k.getPenduduk().getKelamin(), k.getPenduduk().getGol_darah(), k.getPenduduk().getAlamat(), k.getPenduduk().getRt(), k.getPenduduk().getRw(), k.getPenduduk().getKelurahan(),
                    k.getPenduduk().getKecamatan(), k.getPenduduk().getAgama(), k.getPenduduk().getPendidikan(), k.getPenduduk().getSts_kawin(), k.getPenduduk().getPekerjaan(), k.getPenduduk().getKewarganegaraan(), k.isVerifikasi()};
                tableController.getModel().addRow(row);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Tidak dapat mendapatkan data penduduk", getTitle(), JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(DaftarSpView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void selectLastRow() {
        tableView.setRowSelectionInterval(tableView.getRowCount() - 1, tableView.getRowCount() - 1);
        tableView.scrollRectToVisible(new Rectangle(tableView.getCellRect(tableView.getRowCount() - 1, 0, true)));
    }

    public void refreshDataTablesByName() {
        try {
            tableController.clearData();
            this.daftarKtp = repoKtp.findByNama(txtCari.getText());
            for (SuratPengantar k : daftarKtp) {
                Object[] row = {k.getNo_sp(), k.getTgl(), k.getPenduduk().getNik(), k.getPenduduk().getNama(), k.getKeperluan(), k.getPenduduk().getNama_ibu(), k.getPenduduk().getNama_ayah(), k.getPenduduk().getTmp_lahir(), k.getPenduduk().getTgl_lahir(),
                    k.getPenduduk().getKelamin(), k.getPenduduk().getGol_darah(), k.getPenduduk().getAlamat(), k.getPenduduk().getRt(), k.getPenduduk().getRw(), k.getPenduduk().getKelurahan(),
                    k.getPenduduk().getKecamatan(), k.getPenduduk().getAgama(), k.getPenduduk().getPendidikan(), k.getPenduduk().getSts_kawin(), k.getPenduduk().getPekerjaan(), k.getPenduduk().getKewarganegaraan(), k.isVerifikasi()};
                tableController.getModel().addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaftarSpView.class.getName()).log(Level.SEVERE, null, ex);
        }
        tableController.setContentTableAlignment(Arrays.asList(0, 1, 3));
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
        btnCetak = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtCari = new javax.swing.JTextField();
        lblCari = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableView = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtNik = new javax.swing.JTextField();
        txtNamaIbu = new javax.swing.JTextField();
        txt_tmp_lahir = new javax.swing.JTextField();
        txt_tgl_lahir = new javax.swing.JTextField();
        txt_kelamin = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtTglPengajuan = new javax.swing.JTextField();
        txtNoSp = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        btnVerifikasi = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtKeperluan = new javax.swing.JTextArea();

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

        setTitle("Surat Pengantar");
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

        btnCetak.setText("Cetak");
        btnCetak.setToolTipText("");
        btnCetak.setFocusable(false);
        btnCetak.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCetak.setMaximumSize(new java.awt.Dimension(120, 35));
        btnCetak.setMinimumSize(new java.awt.Dimension(120, 35));
        btnCetak.setPreferredSize(new java.awt.Dimension(120, 35));
        btnCetak.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });
        btnCetak.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnCetakKeyPressed(evt);
            }
        });
        jToolBar1.add(btnCetak);

        getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_END);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("List Data"));

        txtCari.setToolTipText("Pencarian berdasarkan nomor surat pengantar");
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
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "No SP", "Tanggal Pengajuan", "Nik", "Nama"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
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

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Detail Data"));
        jPanel4.setAutoscrolls(true);
        jPanel4.setPreferredSize(new java.awt.Dimension(400, 429));

        jLabel12.setText("Nik");

        jLabel13.setText("Nama Ibu");

        jLabel16.setText("Tempat Lahir");

        jLabel17.setText("Tanggal Lahir");

        jLabel18.setText("Kelamin");

        jLabel19.setText("Tgl Pengajuan");

        txtNik.setEditable(false);

        txtNamaIbu.setEditable(false);

        txt_tmp_lahir.setEditable(false);
        txt_tmp_lahir.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        txt_tgl_lahir.setEditable(false);
        txt_tgl_lahir.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        txt_kelamin.setEditable(false);
        txt_kelamin.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_kelamin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_kelaminActionPerformed(evt);
            }
        });

        txtNama.setEditable(false);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Nama");

        txtTglPengajuan.setEditable(false);
        txtTglPengajuan.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        txtNoSp.setEditable(false);
        txtNoSp.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jLabel20.setText("No SP");

        btnVerifikasi.setText("Verifikasi");
        btnVerifikasi.setToolTipText("");
        btnVerifikasi.setFocusable(false);
        btnVerifikasi.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVerifikasi.setMaximumSize(new java.awt.Dimension(120, 35));
        btnVerifikasi.setMinimumSize(new java.awt.Dimension(120, 35));
        btnVerifikasi.setPreferredSize(new java.awt.Dimension(120, 35));
        btnVerifikasi.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnVerifikasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerifikasiActionPerformed(evt);
            }
        });
        btnVerifikasi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnVerifikasiKeyPressed(evt);
            }
        });

        jLabel21.setText("Keperluan");

        txtKeperluan.setEditable(false);
        txtKeperluan.setColumns(20);
        txtKeperluan.setLineWrap(true);
        txtKeperluan.setRows(5);
        jScrollPane2.setViewportView(txtKeperluan);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtNoSp, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVerifikasi, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNamaIbu, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txt_kelamin, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_tgl_lahir, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_tmp_lahir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
                            .addComponent(txtNik, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTglPengajuan, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE))
                        .addGap(23, 23, 23)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNoSp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnVerifikasi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTglPengajuan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNik, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNamaIbu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tmp_lahir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tgl_lahir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_kelamin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4, java.awt.BorderLayout.LINE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        if (btnVerifikasi.getText().equals("Unverifikasi")) {
            JOptionPane.showMessageDialog(this, "Data sudah di Verifikasi!", getTitle(), JOptionPane.WARNING_MESSAGE);

        } else {
            if (tableController.isSelected()) {
                SuratPengantar ktp = daftarKtp.get(tableController.getRowSelected());
                DataSpView view = new DataSpView(menuController, this, ktp, true, p);
                view.setLocationRelativeTo(null);
                view.setResizable(false);
                view.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Data belum dipilih!", getTitle(), JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        DataSpView view = new DataSpView(menuController, this, true, p);
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
        tableView.changeSelection(tableController.getRowSelected(), 1, false, false);
        if (tableController.isSelected()) {
            SuratPengantar ktp = daftarKtp.get(tableController.getRowSelected());
            setFields(ktp);
            try {
                buatQrCode(txtNoSp.getText());
            } catch (Exception ex) {
                Logger.getLogger(DaftarSpView.class.getName()).log(Level.SEVERE, null, ex);
            }
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
        if (btnVerifikasi.getText().equals("Unverifikasi")) {
            JOptionPane.showMessageDialog(this, "Data sudah di Verifikasi!", getTitle(), JOptionPane.WARNING_MESSAGE);

        } else {

            if (tableController.isSelected()) {
                try {
                    SuratPengantar ktp = daftarKtp.get(tableController.getRowSelected());
                    int j = JOptionPane.showConfirmDialog(this, "Hapus data ?", this.getTitle(), JOptionPane.YES_NO_OPTION);
                    if (j == JOptionPane.YES_OPTION) {
                        repoKtp.delete(ktp.getNo_sp());
                        refreshDataTables();
                    }
                } catch (Exception e) {
                }
            } else {
                JOptionPane.showMessageDialog(this, "Data belum dipilih!", getTitle(), JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnHapusKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnHapusKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHapusKeyPressed

    private void txt_kelaminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_kelaminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_kelaminActionPerformed

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
        if (tableController.isSelected()) {
            try {
                this.daftarKtp2 = repoKtp.findByNama(txtNoSp.getText());
                String url = "/laporan/SpKtp.jasper";
                Map<String, Object> map = new HashMap<>();
//                map.put("nama", ktp.getPenduduk().getNama());
                JasperPrint print = JasperFillManager.fillReport(
                        getClass().getResourceAsStream(url),
                        map,
                        new JRBeanCollectionDataSource(daftarKtp2));
                JasperViewer view = new JasperViewer(print, false);
                view.setLocationRelativeTo(null);
                view.setExtendedState(JasperViewer.MAXIMIZED_BOTH);
                view.setVisible(true);
            } catch (JRException ex) {
                Logger.getLogger(DaftarSpView.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(DaftarSpView.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Data belum dipilih!", getTitle(), JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnCetakActionPerformed

    private void btnCetakKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCetakKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCetakKeyPressed

    private void btnVerifikasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerifikasiActionPerformed

        if (tableController.isSelected()) {
            try {
                SuratPengantar k = new SuratPengantar();
                k.setNo_sp(txtNoSp.getText());
                Penduduk penduduk = new Penduduk();
                penduduk.setNik(txtNik.getText());
                k.setPenduduk(penduduk);
                if (btnVerifikasi.getText().equals("Verifikasi")) {
                    k.setVerifikasi(true);
                    repoKtp.verifikasi(k);
                    btnVerifikasi.setText("Unerifikasi");
                } else {
                    k.setVerifikasi(false);
                    repoKtp.verifikasi(k);
                    btnVerifikasi.setText("Verifikasi");
                }
                JOptionPane.showMessageDialog(rootPane, "Berhasil !");
                refreshDataTablesByName();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Tidak dapat merubah memverifikasi", getTitle(), JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(DataSpView.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            JOptionPane.showMessageDialog(this, "Data belum dipilih!", getTitle(), JOptionPane.WARNING_MESSAGE);
        }


    }//GEN-LAST:event_btnVerifikasiActionPerformed

    private void btnVerifikasiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnVerifikasiKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVerifikasiKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUbah;
    private javax.swing.JButton btnVerifikasi;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblCari;
    private javax.swing.JMenuItem pmnuLihatTransaksi;
    private javax.swing.JMenuItem pmnuTambah;
    private javax.swing.JMenuItem pmnuUbah;
    private javax.swing.JTable tableView;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextArea txtKeperluan;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNamaIbu;
    private javax.swing.JTextField txtNik;
    private javax.swing.JTextField txtNoSp;
    private javax.swing.JTextField txtTglPengajuan;
    private javax.swing.JTextField txt_kelamin;
    private javax.swing.JTextField txt_tgl_lahir;
    private javax.swing.JTextField txt_tmp_lahir;
    // End of variables declaration//GEN-END:variables

    public void setFields(SuratPengantar ktp) {
        txtNoSp.setText(ktp.getNo_sp());
        txtTglPengajuan.setText(ktp.getTgl().toString());
        txtNik.setText(ktp.getPenduduk().getNik());
        if (ktp.isVerifikasi()) {
            btnVerifikasi.setText("Unverifikasi");

        } else {
            btnVerifikasi.setText("Verifikasi");
        }

        txtNama.setText(ktp.getPenduduk().getNama());
        txtNamaIbu.setText(ktp.getPenduduk().getNama_ibu());
        txt_tmp_lahir.setText(ktp.getPenduduk().getTmp_lahir());
        txt_tgl_lahir.setText(ktp.getPenduduk().getTgl_lahir().toString());
        txt_kelamin.setText(ktp.getPenduduk().getKelamin());
        txtKeperluan.setText(ktp.getKeperluan());

    }

    public void clearFields() {
        txtNik.setText("");
        txtNama.setText("");
        txtNamaIbu.setText("");
        txt_tmp_lahir.setText("");
        txt_tgl_lahir.setText("");
        txt_kelamin.setText("");
        txtKeperluan.setText("");
    }

    void btnTambahRequesFocus() {
        btnTambah.requestFocus();
    }

    private void setBtnKelapaDisable() {
        btnVerifikasi.setEnabled(false);
        btnHapus.setEnabled(false);
    }
}
