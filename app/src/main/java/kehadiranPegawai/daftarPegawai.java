/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package kehadiranPegawai;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import kehadiranPegawai.dao.PegawaiDAO; 
import kehadiranPegawai.entities.Pegawai; 
import kehadiranPegawai.dbase.KoneksiDatabase; 

/**
 *
 * @author ASUS
 */
public class daftarPegawai extends javax.swing.JFrame {

    /**
     * Creates new form daftarPegawai
     */
    
    private PegawaiDAO pegawaiDAO;
    private DefaultTableModel modelTabel;
    private int selectedRow = -1; 
    private List<Pegawai> dataAwal; 
    private boolean isSearching = false;
    
    
    
    public daftarPegawai(KoneksiDatabase koneksiDatabase) {
    initComponents(); 
    
    // instance PegawaiDAO
    pegawaiDAO = new PegawaiDAO(koneksiDatabase.getKoneksi());

    // Inisialisasi model tabel
    modelTabel = (DefaultTableModel) dataPegawai.getModel();
    tampilkanDataPegawai(); // Tampilkan data awal di tabel
    dataAwal = pegawaiDAO.getAllPegawai();


}
    
    private void handleSimpanAction() { 
        simpanActionPerformed(null); 
    }
    
    private void updateDataPegawai(int idPegawai) {
        // 1. Ambil data dari input (sama seperti di simpanDataPegawai)
        String nama = inputNama.getText(); 
        String alamat = inputAlamat.getText();
        String jenisKelamin = pria.isSelected() ? "Pria" : "Wanita";

        // 3. Buat objek Pegawai dengan ID 
        Pegawai pegawai = new Pegawai(idPegawai, nama, jenisKelamin, alamat);

        // 4. Update data ke database
        try {
            pegawaiDAO.editPegawai(pegawai);
            JOptionPane.showMessageDialog(this, "Data pegawai berhasil diupdate!", "Sukses", JOptionPane.INFORMATION_MESSAGE);

            // 5. Refresh tabel dan bersihkan input
            tampilkanDataPegawai();
            inputNama.setText(""); 
            inputAlamat.setText("");
            pria.setSelected(false);
            wanita.setSelected(false);

            // 6. Kembalikan tombol "Update" ke "Simpan"
        simpan.setText("Simpan");
        simpan.addActionListener(e -> handleSimpanAction()); 
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Gagal mengupdate data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    

    private void tampilkanDataPegawai() {
        modelTabel.setRowCount(0); // Bersihkan tabel

        List<Pegawai> daftarPegawai = pegawaiDAO.getAllPegawai();
        for (Pegawai pegawai : daftarPegawai) {
            Object[] rowData = {
                pegawai.getIdPegawai(),
                pegawai.getNama(),
                pegawai.getJenisKelamin(),
                pegawai.getAlamat()
            };
            modelTabel.addRow(rowData);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        hapus = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        inputNama = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pria = new javax.swing.JRadioButton();
        wanita = new javax.swing.JRadioButton();
        inputAlamat = new javax.swing.JTextField();
        edit = new javax.swing.JButton();
        back = new javax.swing.JButton();
        simpan = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        dataPegawai = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        inputCari = new javax.swing.JTextField();
        cariPegawai = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Daftar Pegawai");

        hapus.setText("HAPUS");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });

        jLabel2.setText("Nama :");

        inputNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNamaActionPerformed(evt);
            }
        });

        jLabel3.setText("Alamat :");

        jLabel4.setText("Jenis Kelamin :");

        pria.setText("Pria");
        pria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priaActionPerformed(evt);
            }
        });

        wanita.setText("Wanita");
        wanita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wanitaActionPerformed(evt);
            }
        });

        inputAlamat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputAlamatActionPerformed(evt);
            }
        });

        edit.setText("EDIT");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        back.setText("back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        simpan.setText("SIMPAN");
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });

        dataPegawai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id", "Nama", "Kelamin", "Alamat"
            }
        ));
        jScrollPane2.setViewportView(dataPegawai);

        jLabel5.setText("Cari :");

        inputCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputCariActionPerformed(evt);
            }
        });

        cariPegawai.setText("search");
        cariPegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariPegawaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(back)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(18, 18, 18)
                                                .addComponent(inputNama, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(inputAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGap(218, 218, 218)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pria)
                                .addGap(18, 18, 18)
                                .addComponent(wanita)
                                .addGap(142, 142, 142)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inputCari)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cariPegawai))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addComponent(jLabel1)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inputNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(edit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(simpan)
                            .addComponent(jLabel4))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cariPegawai)
                        .addComponent(jLabel5))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(pria)
                        .addComponent(wanita)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(back)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed

        selectedRow = dataPegawai.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih pegawai yang ingin dihapus!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Konfirmasi penghapusan
        int confirmResult = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menghapus data ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
        if (confirmResult != JOptionPane.YES_OPTION) {
            return; // Batalkan penghapusan
        }

        // Ambil ID pegawai dari baris yang dipilih
        int idPegawai = (int) modelTabel.getValueAt(selectedRow, 0);

        // Hapus data dari database
        try {
            pegawaiDAO.hapusPegawai(idPegawai);
            JOptionPane.showMessageDialog(this, "Data pegawai berhasil dihapus!", "Sukses", JOptionPane.INFORMATION_MESSAGE);

            // Refresh tabel
            tampilkanDataPegawai();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Gagal menghapus data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_hapusActionPerformed

    private void inputNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputNamaActionPerformed

    private void priaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priaActionPerformed

    private void wanitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wanitaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_wanitaActionPerformed

    private void inputAlamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputAlamatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputAlamatActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        // TODO add your handling code here:
        selectedRow = dataPegawai.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih pegawai yang ingin diedit!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Ambil data dari baris yang dipilih
        int idPegawai = (int) modelTabel.getValueAt(selectedRow, 0);
        String nama = (String) modelTabel.getValueAt(selectedRow, 1);
        String jenisKelamin = (String) modelTabel.getValueAt(selectedRow, 2);
        String alamat = (String) modelTabel.getValueAt(selectedRow, 3);

        // Isi field input dengan data yang dipilih
        inputNama.setText(nama); 
        inputAlamat.setText(alamat);
        if (jenisKelamin.equals("Pria")) {
            pria.setSelected(true);
        } else {
            wanita.setSelected(true);
        }

        simpan.setText("Update");
        simpan.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            updateDataPegawai(idPegawai); // BENAR
        }
        });
    }//GEN-LAST:event_editActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        home home = new home();
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backActionPerformed

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        // TODO add your handling code here:
        
        // 1. Ambil data dari input
        String nama = inputNama.getText(); 
        String alamat = inputAlamat.getText();
        String jenisKelamin = pria.isSelected() ? "Pria" : "Wanita";

        // 2. Validasi input (
        if (nama.isEmpty() || alamat.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Harap isi semua field!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // 3. Buat objek Pegawai
        Pegawai pegawaiBaru = new Pegawai(0, nama, jenisKelamin, alamat);

        // 4. Simpan data ke database
        try {
            pegawaiDAO.tambahPegawai(pegawaiBaru);
            JOptionPane.showMessageDialog(this, "Data pegawai berhasil disimpan!", "Sukses", JOptionPane.INFORMATION_MESSAGE);

            // 5. Refresh tabel dan bersihkan input
            tampilkanDataPegawai();
            inputNama.setText(""); 
            inputAlamat.setText("");
            pria.setSelected(false);
            wanita.setSelected(false);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Gagal menyimpan data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_simpanActionPerformed

    private void inputCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputCariActionPerformed

    private void cariPegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariPegawaiActionPerformed
        // TODO add your handling code here:
        
        if (!isSearching) {
            // Mode Pencarian

            String keyword = inputCari.getText();
            List<Pegawai> hasilCari = pegawaiDAO.cariPegawai(keyword);

            modelTabel.setRowCount(0);
            if (hasilCari.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Data tidak ditemukan.", "Info", JOptionPane.INFORMATION_MESSAGE);
            } else {
                for (Pegawai pegawai : hasilCari) {
                    Object[] rowData = {
                        pegawai.getIdPegawai(),
                        pegawai.getNama(),
                        pegawai.getJenisKelamin(),
                        pegawai.getAlamat()
                    };
                    modelTabel.addRow(rowData);
                }
            }

            isSearching = true; 
        } else {
            tampilkanDataPegawai(); // Tampilkan semua data
            isSearching = false; 
        }
    
   
    }//GEN-LAST:event_cariPegawaiActionPerformed

    /**
     * @param args the command line arguments
     */
//    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton cariPegawai;
    private javax.swing.JTable dataPegawai;
    private javax.swing.JButton edit;
    private javax.swing.JButton hapus;
    private javax.swing.JTextField inputAlamat;
    private javax.swing.JTextField inputCari;
    private javax.swing.JTextField inputNama;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton pria;
    private javax.swing.JButton simpan;
    private javax.swing.JRadioButton wanita;
    // End of variables declaration//GEN-END:variables
}