/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.view.menu.skm;

import aplikasi.config.FieldLimit;
import aplikasi.config.FieldMinimal;
import aplikasi.config.KoneksiDB;
import aplikasi.config.ValueFormatter;
import aplikasi.entity.Penduduk;
import aplikasi.entity.SuratKematian;
import aplikasi.entity.Users;
import aplikasi.service.ServicePenduduk;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import aplikasi.repository.RepoPenduduk;
import aplikasi.repository.RepoSkm;
import java.sql.Date;
import java.util.Iterator;
import aplikasi.service.ServiceSkm;

/**
 *
 * @author soraya
 */
public class DataSkmView extends javax.swing.JDialog {

    private Boolean update;

    private final RepoPenduduk repoPenduduk = new ServicePenduduk(KoneksiDB.getDataSource());
    private final RepoSkm repoSkm = new ServiceSkm(KoneksiDB.getDataSource());

    private DaftarSkmView daftarSkmController = null;
    private Penduduk penduduk;
    private SuratKematian suratKematian;
    private FieldMinimal jTextFieldMinimal;
    private Users p = null;

    public Boolean isUpdate() {
        return update;
    }

    public void setUpdate(Boolean update) {
        this.update = update;
    }

    /**
     * Creates new form DataAsetView
     */
    public DataSkmView(java.awt.Frame parent, boolean modal, Users p) {
        super(parent, modal);
        initComponents();
        setUpdate(false);
        this.daftarSkmController = null;
        this.penduduk = new Penduduk();
        this.suratKematian = new SuratKematian();
        this.p = p;
        this.jTextFieldMinimal = new FieldMinimal();
        this.txtTglKematian.setDate(new java.util.Date());
        txtNama.requestFocus();
//        ambilKodeAset();
        textFieldLimit();
    }

    DataSkmView(java.awt.Frame parent, DaftarSkmView daftarAsetController, boolean modal, Users p) {
        super(parent, modal);
        initComponents();
        setUpdate(false);
        this.daftarSkmController = daftarAsetController;
        this.penduduk = new Penduduk();
        this.suratKematian = new SuratKematian();
        this.p = p;
        this.jTextFieldMinimal = new FieldMinimal();
        this.txtTglKematian.setDate(new java.util.Date());
        txtNoSkm.requestFocus();
    }

    DataSkmView(java.awt.Frame parent, DaftarSkmView daftarSkmController, SuratKematian sk, boolean modal, Users p) {
        super(parent, modal);
        initComponents();
        setUpdate(true);
        this.daftarSkmController = daftarSkmController;
        this.penduduk = new Penduduk();
        this.suratKematian = new SuratKematian();
        this.p = p;
        this.jTextFieldMinimal = new FieldMinimal();
        this.txtTglKematian.setDate(new java.util.Date());
        txtNoSkm.setEditable(false);
        txtNik.requestFocus();

        textFieldLimit();
        setFieldsKtp(sk);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jenisKelaminGroup = new javax.swing.ButtonGroup();
        JenisWNGroup = new javax.swing.ButtonGroup();
        jenisKeperluanGroup = new javax.swing.ButtonGroup();
        jToolBar1 = new javax.swing.JToolBar();
        btnSimpan = new javax.swing.JButton();
        btnKembali = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNik = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        txtTempatLahir = new javax.swing.JTextField();
        txtTglLahir = new javax.swing.JTextField();
        txtKelamin = new javax.swing.JTextField();
        txtNamaIbu = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTglKematian = new com.toedter.calendar.JDateChooser();
        txtNoSkm = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtSebab = new javax.swing.JTextField();
        txtTempatKematian = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Data KTP");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/gambar/logo3.png")).getImage());

        jToolBar1.setRollover(true);

        btnSimpan.setText("Simpan");
        btnSimpan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSimpan.setMaximumSize(new java.awt.Dimension(120, 35));
        btnSimpan.setMinimumSize(new java.awt.Dimension(120, 35));
        btnSimpan.setPreferredSize(new java.awt.Dimension(120, 35));
        btnSimpan.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        btnSimpan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnSimpanKeyPressed(evt);
            }
        });
        jToolBar1.add(btnSimpan);

        btnKembali.setText("Kembali");
        btnKembali.setFocusable(false);
        btnKembali.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnKembali.setMaximumSize(new java.awt.Dimension(120, 35));
        btnKembali.setMinimumSize(new java.awt.Dimension(120, 35));
        btnKembali.setPreferredSize(new java.awt.Dimension(120, 35));
        btnKembali.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });
        jToolBar1.add(btnKembali);

        getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_END);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Data"));
        jPanel1.setToolTipText("");

        jLabel1.setText("No SKM");

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel7.setText("Nama");

        jLabel8.setText("Nama Ibu");

        jLabel9.setText("Tempat Lahir");

        jLabel10.setText("Tanggal Lahir");

        jLabel11.setText("Kelamin");

        jLabel5.setText("Nik");

        txtNik.setToolTipText("Isi dengan nama aset  minimal 4 karakter dan maximal 50 karakter");
        txtNik.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNikKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNikKeyReleased(evt);
            }
        });

        txtNama.setEditable(false);
        txtNama.setToolTipText("Isi dengan nama aset  minimal 4 karakter dan maximal 50 karakter");
        txtNama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNamaKeyReleased(evt);
            }
        });

        txtTempatLahir.setEditable(false);
        txtTempatLahir.setToolTipText("Isi dengan nama aset  minimal 4 karakter dan maximal 50 karakter");
        txtTempatLahir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTempatLahirKeyReleased(evt);
            }
        });

        txtTglLahir.setEditable(false);
        txtTglLahir.setToolTipText("Isi dengan nama aset  minimal 4 karakter dan maximal 50 karakter");
        txtTglLahir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTglLahirKeyReleased(evt);
            }
        });

        txtKelamin.setEditable(false);
        txtKelamin.setToolTipText("Isi dengan nama aset  minimal 4 karakter dan maximal 50 karakter");
        txtKelamin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtKelaminKeyReleased(evt);
            }
        });

        txtNamaIbu.setEditable(false);
        txtNamaIbu.setToolTipText("Isi dengan nama aset  minimal 4 karakter dan maximal 50 karakter");
        txtNamaIbu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNamaIbuKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNama, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                    .addComponent(txtNamaIbu)
                    .addComponent(txtNik, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTempatLahir, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtKelamin, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                    .addComponent(txtTglLahir))
                .addContainerGap(222, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(11, 11, 11))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtNik, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNama, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNamaIbu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTempatLahir, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTglLahir, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKelamin, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel3.setText("Tanggal Kematian");

        txtNoSkm.setToolTipText("Isi dengan nama aset  minimal 4 karakter dan maximal 50 karakter");
        txtNoSkm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNoSkmKeyReleased(evt);
            }
        });

        jLabel21.setText("Sebab Kematian");

        txtSebab.setToolTipText("Isi dengan nama aset  minimal 4 karakter dan maximal 50 karakter");
        txtSebab.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSebabKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSebabKeyReleased(evt);
            }
        });

        txtTempatKematian.setToolTipText("Isi dengan nama aset  minimal 4 karakter dan maximal 50 karakter");
        txtTempatKematian.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTempatKematianKeyReleased(evt);
            }
        });

        jLabel2.setText("Tempat Kematian");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTglKematian, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNoSkm, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 228, Short.MAX_VALUE))
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTempatKematian, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSebab, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNoSkm)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTglKematian, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(txtTempatKematian))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSebab, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
 private void textFieldLimit() {
        txtNama.setDocument(new FieldLimit(50));
    }

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed

        suratKematian.setNo_skm(txtNoSkm.getText());
        suratKematian.setTgl_kematian(Date.valueOf(ValueFormatter.getDateSQL(txtTglKematian.getDate())));
        suratKematian.setTmp_kematian(txtTempatKematian.getText());
        penduduk.setNik(txtNik.getText());
        suratKematian.setPenduduk(penduduk);
        suratKematian.setSebab(txtSebab.getText());

        if (isUpdate()) {
            try {
                repoSkm.update(suratKematian);
                this.dispose();
                if (daftarSkmController != null) {
                    daftarSkmController.refreshDataTablesByName();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Tidak dapat merubah data barang", getTitle(), JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(DataSkmView.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                repoSkm.save(suratKematian);
                if (daftarSkmController != null) {
                    daftarSkmController.refreshDataTablesByName();
                    daftarSkmController.selectLastRow();
                    daftarSkmController.btnTambahRequesFocus();
                }
                this.dispose();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Tidak dapat menyimpan data barang baru", getTitle(), JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(DataSkmView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }//GEN-LAST:event_btnSimpanActionPerformed
    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnKembaliActionPerformed

    private void btnSimpanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSimpanKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnSimpanActionPerformed(null);
        }
    }//GEN-LAST:event_btnSimpanKeyPressed

    private void txtNikKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNikKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNikKeyReleased

    private void txtNamaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNamaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaKeyReleased

    private void txtTempatLahirKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTempatLahirKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTempatLahirKeyReleased

    private void txtTglLahirKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTglLahirKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTglLahirKeyReleased

    private void txtKelaminKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKelaminKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKelaminKeyReleased

    private void txtNoSkmKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNoSkmKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNoSkmKeyReleased

    private void txtNamaIbuKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNamaIbuKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaIbuKeyReleased

    private void txtNikKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNikKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                for (Iterator<Penduduk> it = repoPenduduk.findByNik(txtNik.getText()).iterator(); it.hasNext();) {
                    Penduduk a = it.next();
                    a.getNik();
                    a.getNama();
                    a.getNama_ibu();
                    a.getNama_ayah();
                    a.getTmp_lahir();
                    a.getTgl_lahir();
                    a.getKelamin();
                    a.getGol_darah();
                    a.getAlamat();
                    a.getRt();
                    a.getRw();
                    a.getKelurahan();
                    a.getKecamatan();
                    a.getAgama();
                    a.getPendidikan();
                    a.getSts_kawin();
                    a.getPekerjaan();
                    a.getKewarganegaraan();
                    setFields(a);
                }

            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_txtNikKeyPressed

    private void txtSebabKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSebabKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSebabKeyPressed

    private void txtSebabKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSebabKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSebabKeyReleased

    private void txtTempatKematianKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTempatKematianKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTempatKematianKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup JenisWNGroup;
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.ButtonGroup jenisKelaminGroup;
    private javax.swing.ButtonGroup jenisKeperluanGroup;
    private javax.swing.JTextField txtKelamin;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNamaIbu;
    private javax.swing.JTextField txtNik;
    private javax.swing.JTextField txtNoSkm;
    private javax.swing.JTextField txtSebab;
    private javax.swing.JTextField txtTempatKematian;
    private javax.swing.JTextField txtTempatLahir;
    private com.toedter.calendar.JDateChooser txtTglKematian;
    private javax.swing.JTextField txtTglLahir;
    // End of variables declaration//GEN-END:variables

    private void setFields(Penduduk p) {
        txtNama.setText(p.getNama());
        txtNamaIbu.setText(p.getNama_ibu());
        txtTempatLahir.setText(p.getTmp_lahir());
        txtTglLahir.setText(p.getTgl_lahir().toString());
        txtKelamin.setText(p.getKelamin());
    }

//    private void ambilKodeAset() {
//        try {
//            String s = null;
//            StringBuilder sb = new StringBuilder("MD").append("-");
//            List<Penduduk> daftarPenduduk = repoPenduduk.findMaxValue();
//            if (!daftarPenduduk.isEmpty()) {
//                for (Penduduk penduduk1 : daftarPenduduk) {
//                    s = penduduk1.getNik();
//                }
//                String s2 = s.substring(3);
//                int s3 = Integer.valueOf(s2) + 1;
//                sb.append(String.format("%04d", s3));
//                this.penduduk.setNik(sb.toString());
//                txtKode.setText(this.penduduk.getNik());
//            } else {
//                this.penduduk.setNik("MD-0001");
//                txtKode.setText(this.penduduk.getNik());
//            }
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(this, "Tidak dapat mendapatkan kode!", getTitle(), JOptionPane.ERROR_MESSAGE);
//            Logger.getLogger(DataSpView.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    private void setFieldsKtp(SuratKematian sk) {
        txtNoSkm.setText(sk.getNo_skm());
        txtTglKematian.setDate(sk.getTgl_kematian());
        txtTempatKematian.setText(sk.getTmp_kematian());
        txtNik.setText(sk.getPenduduk().getNik());
        txtSebab.setText(sk.getSebab());
    }
}