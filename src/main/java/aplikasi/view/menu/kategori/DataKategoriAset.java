/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.view.menu.kategori;

import aplikasi.config.FieldLimit;
import aplikasi.config.FieldMinimal;
import aplikasi.config.KoneksiDB;
import aplikasi.entity.KategoriAset;
import aplikasi.repository.RepoKategoriAset;
import aplikasi.service.ServiceKategoriAset;
import aplikasi.view.menu.lokasi.DataLokasiView;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author soraya
 */
public class DataKategoriAset extends javax.swing.JDialog {

    private List<KategoriAset> dafratKategoriAsets = new ArrayList<>();

    private final DaftarKategoriView daftarKategoriViewController;
    private boolean update;
    private KategoriAset kategoriAset;
    private final RepoKategoriAset repoKategoriAset;
    private FieldMinimal jTextFieldMinimal;

    public Boolean isUpdate() {
        return update;
    }

    public void setUpdate(Boolean update) {
        this.update = update;
    }

    /**
     * Creates new form DataKategoriAset
     *
     * @param parent
     * @param b
     *
     */
    public DataKategoriAset(java.awt.Frame parent, boolean b) {
        super(parent, b);
        initComponents();
        this.daftarKategoriViewController = null;
        this.repoKategoriAset = new ServiceKategoriAset(KoneksiDB.getDataSource());
        setUpdate(false);
        this.kategoriAset = new KategoriAset();
        this.jTextFieldMinimal = new FieldMinimal();
        textFieldLimit();
        ambilIdTerbesar();
        txtSingkatan.requestFocus();
    }

    public DataKategoriAset(java.awt.Frame parent, DaftarKategoriView daftarKategoriViewController, boolean modal) {
        super(parent, modal);
        initComponents();
        this.daftarKategoriViewController = daftarKategoriViewController;
        this.repoKategoriAset = new ServiceKategoriAset(KoneksiDB.getDataSource());
        setUpdate(false);
        this.kategoriAset = new KategoriAset();
        this.jTextFieldMinimal = new FieldMinimal();
        textFieldLimit();
        ambilIdTerbesar();
        txtSingkatan.requestFocus();
    }

    public DataKategoriAset(java.awt.Frame parent, DaftarKategoriView daftarKategoriViewController, KategoriAset kategoriAset, boolean modal) {
        super(parent, modal);
        initComponents();
        this.daftarKategoriViewController = daftarKategoriViewController;
        this.kategoriAset = new KategoriAset();
        this.repoKategoriAset = new ServiceKategoriAset(KoneksiDB.getDataSource());
        this.jTextFieldMinimal = new FieldMinimal();
        setUpdate(true);
        textFieldLimit();
        setFilds(kategoriAset);
        txtSingkatan.requestFocus();
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        btnSimpan = new javax.swing.JButton();
        btnKembali = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtKode = new javax.swing.JTextField();
        txtSingkatan = new javax.swing.JTextField();
        txtNamaKategori = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Kategori");
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
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btnSimpanKeyReleased(evt);
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Kategori Aset"));

        jLabel1.setText("Kode");

        jLabel2.setText("Singkatan");

        jLabel3.setText("Nama Kategori");

        txtKode.setEditable(false);
        txtKode.setFocusable(false);

        txtSingkatan.setToolTipText("Singkatan minimal 2 karakter dan maximal 4 karakter");
        txtSingkatan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSingkatanKeyReleased(evt);
            }
        });

        txtNamaKategori.setToolTipText("Nama Kategori minimal 4 karakter dan maximal 30 karakter");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtKode, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                        .addComponent(txtSingkatan, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(txtNamaKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(64, Short.MAX_VALUE))
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
                    .addComponent(txtSingkatan, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNamaKategori, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
  private void textFieldLimit() {
        txtSingkatan.setDocument(new FieldLimit(4));
        txtNamaKategori.setDocument(new FieldLimit(30));
    }
    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        if (!jTextFieldMinimal.setMinInputValue(txtSingkatan.getText(), 2)) {
            JOptionPane.showMessageDialog(this, "Singkatan minimal 2 karakter !");
            txtSingkatan.requestFocus();
            txtSingkatan.selectAll();
        } else if (!jTextFieldMinimal.setMinInputValue(txtNamaKategori.getText(), 4)) {
            JOptionPane.showMessageDialog(this, "Nama Kategori minimal 4 karakter !");
            txtNamaKategori.requestFocus();
            txtNamaKategori.selectAll();
        } else {
            kategoriAset.setId_kategori(Integer.valueOf(txtKode.getText()));
            kategoriAset.setKode(txtSingkatan.getText());
            kategoriAset.setNama_kategori(txtNamaKategori.getText());
            if (isUpdate()) {
                try {
                    repoKategoriAset.update(kategoriAset);
                    this.dispose();
                    if (daftarKategoriViewController != null) {
                        daftarKategoriViewController.refreshDataTableByName();
                        daftarKategoriViewController.setFields(kategoriAset);

                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Tidak dapat merubah data kategoriAset", getTitle(), JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(DataLokasiView.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    repoKategoriAset.save(kategoriAset);
                    this.dispose();
                    if (daftarKategoriViewController != null) {
                        daftarKategoriViewController.refreshDataTableByName();
                        daftarKategoriViewController.setFields(kategoriAset);
                        daftarKategoriViewController.selectLastRow();
                        daftarKategoriViewController.btnTambahRequesFocus();
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Tidak dapat menyimpan data kategoriAset", getTitle(), JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(DataLokasiView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnKembaliActionPerformed

    private void btnSimpanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSimpanKeyReleased
        if (evt.getKeyCode()== KeyEvent.VK_ENTER) {
            btnSimpanActionPerformed(null);
        }
    }//GEN-LAST:event_btnSimpanKeyReleased

    private void txtSingkatanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSingkatanKeyReleased
        txtSingkatan.setText(txtSingkatan.getText().toUpperCase());
    }//GEN-LAST:event_txtSingkatanKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField txtKode;
    private javax.swing.JTextField txtNamaKategori;
    private javax.swing.JTextField txtSingkatan;
    // End of variables declaration//GEN-END:variables

    private void setFilds(KategoriAset kategoriAset) {
        txtKode.setText(kategoriAset.getId_kategori().toString());
        txtSingkatan.setText(kategoriAset.getKode());
        txtNamaKategori.setText(kategoriAset.getNama_kategori());
    }

    private void ambilIdTerbesar() {
        try {
            dafratKategoriAsets = repoKategoriAset.findMaxValue();
            if (dafratKategoriAsets.size() != 0) {
                for (KategoriAset p : dafratKategoriAsets) {
                    int i = p.getId_kategori() + 1;
                    txtKode.setText(String.valueOf(i));
                }

            } else {
                txtKode.setText("1");
            }
        } catch (Exception e) {
            Logger.getLogger(DataKategoriAset.class.getName()).log(Level.SEVERE, null, e);

        }
    }
}