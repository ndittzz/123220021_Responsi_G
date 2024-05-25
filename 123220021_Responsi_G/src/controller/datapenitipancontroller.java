/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import DAOdatapenitipan.datapenitipanDAO;
import DAOImplement.dataImplement;
import java.util.List;
import javax.swing.*;
import model.datapenitipan;
import model.modeltabeldatapenitipan;
import view.MainView;
/**
 *
 * @author PC PRAKTIKUM
 */
public class datapenitipancontroller {
    MainView frame;
    dataImplement impldatapenitipan;
    List<datapenitipan> dp;
    
    public datapenitipancontroller(MainView frame) {
        this.frame = frame;
        impldatapenitipan = new datapenitipanDAO();
        dp = impldatapenitipan.getAll();
    }

    public void isitabel() {
        dp = impldatapenitipan.getAll();
        modeltabeldatapenitipan mp = new modeltabeldatapenitipan(dp);
        frame.getTabelDatapenitipan().setModel(mp);
    }
    
    public void insert() {
        // Mendapatkan nilai dari JTextField
        // Mendapatkan nilai dari JTextField
        

        String id = frame.getJTxtid().getText();
        String pemilikText = frame.getJTxtnama_pemilik().getText();
        String hewanText = frame.getJTxtnama_hewan().getText();
        String jenisText = frame.getJTxtjenis_hewan().getText();
        String nomorText = frame.getJTxtnomor_telepon().getText();
        String durasiText = frame.getJTxtdurasi().getText();

        // Memeriksa apakah salah satu JTextField belum diisi
        if (id.isEmpty() || pemilikText.isEmpty() || hewanText.isEmpty() || jenisText.isEmpty() || nomorText.isEmpty() || durasiText.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Harap isi semua field", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return; // Keluar dari metode insert() jika ada field yang belum diisi
        }

        try {
            double nomor = Double.parseDouble(nomorText);
            double durasi = Double.parseDouble(durasiText);

            // Harga per malam berdasarkan tipe ruang
            double hargaPerMalam = 0.0;
            double totalHarga;
            if (durasi <= 2) {
                hargaPerMalam = 100000;   
                totalHarga = hargaPerMalam * durasi;
            } else if (durasi >= 3) {
                hargaPerMalam = 100000;   
                totalHarga = hargaPerMalam * durasi + 50000;
            } else {
                JOptionPane.showMessageDialog(frame, "Tipe ruang tidak valid", "Peringatan", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Membuat objek datapenginapan baru
            datapenitipan dp = new datapenitipan();
            double idValue = Double.parseDouble(id);
            dp.setId(idValue);            
            dp.setNama_pemilik(pemilikText);
            dp.setNama_hewan(hewanText);
            dp.setJenis_hewan(jenisText);
            dp.setNomor_telepon(nomor);
            dp.setDurasi_titip(durasi);
            dp.setTotal_biaya(totalHarga);

            // Memasukkan objek datapenginapan baru ke database
            impldatapenitipan.insert(dp);

            // Mengosongkan field setelah data disimpan
            frame.getJTxtid().setText("");
            frame.getJTxtnama_pemilik().setText("");
            frame.getJTxtnama_hewan().setText("");
            frame.getJTxtjenis_hewan().setText("");
            frame.getJTxtnomor_telepon().setText("");
            frame.getJTxtdurasi().setText("");

            // Memperbarui tabel dengan data terbaru
            isitabel();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Nomor telepon dan durasi harus berupa angka", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }

    }
    
        public void update() {
        // Mendapatkan nilai dari JTextField
        String id = frame.getJTxtid().getText();
        String pemilikText = frame.getJTxtnama_pemilik().getText();
        String hewanText = frame.getJTxtnama_hewan().getText();
        String jenisText = frame.getJTxtjenis_hewan().getText();
        String nomorText = frame.getJTxtnomor_telepon().getText();
        String durasiText = frame.getJTxtdurasi().getText();

        // Memeriksa apakah salah satu JTextField belum diisi
        if (id.isEmpty() || pemilikText.isEmpty() || hewanText.isEmpty() || jenisText.isEmpty() || nomorText.isEmpty() || durasiText.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Harap isi semua field", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return; // Keluar dari metode insert() jika ada field yang belum diisi
        }

        try {
            double nomor = Double.parseDouble(nomorText);
            double durasi = Double.parseDouble(durasiText);

            // Harga per malam berdasarkan tipe ruang
            double hargaPerMalam = 0.0;
            double totalHarga;
            if (durasi <= 2) {
                hargaPerMalam = 100000;   
                totalHarga = hargaPerMalam * durasi;
            } else if (durasi >= 3) {
                hargaPerMalam = 100000;   
                totalHarga = hargaPerMalam * durasi + 50000;
            } else {
                JOptionPane.showMessageDialog(frame, "Tipe ruang tidak valid", "Peringatan", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Membuat objek datapenginapan baru
            datapenitipan dp = new datapenitipan();
            double idValue = Double.parseDouble(id);
            dp.setId(idValue);            
            dp.setNama_pemilik(pemilikText);
            dp.setNama_hewan(hewanText);
            dp.setJenis_hewan(jenisText);
            dp.setNomor_telepon(nomor);
            dp.setDurasi_titip(durasi);
            dp.setTotal_biaya(totalHarga);

            // Memasukkan objek datapenginapan baru ke database
            impldatapenitipan.update(dp);

            // Mengosongkan field setelah data disimpan
            frame.getJTxtid().setText("");
            frame.getJTxtnama_pemilik().setText("");
            frame.getJTxtnama_hewan().setText("");
            frame.getJTxtjenis_hewan().setText("");
            frame.getJTxtnomor_telepon().setText("");
            frame.getJTxtdurasi().setText("");

            // Memperbarui tabel dengan data terbaru
            isitabel();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Nomor telepon dan durasi harus berupa angka", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }

    }
        
     public void delete() {
        String id = frame.getJTxtid().getText();
        impldatapenitipan.delete(id);
        JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
            frame.getJTxtid().setText("");
            frame.getJTxtnama_pemilik().setText("");
            frame.getJTxtnama_hewan().setText("");
            frame.getJTxtjenis_hewan().setText("");
            frame.getJTxtnomor_telepon().setText("");
            frame.getJTxtdurasi().setText("");
    }
    
    
}
