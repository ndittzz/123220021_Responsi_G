/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author PC PRAKTIKUM
 */
public class modeltabeldatapenitipan extends AbstractTableModel {
    
    List<datapenitipan> dp;
    public modeltabeldatapenitipan(List<datapenitipan>dp){
        this.dp = dp;
    }
    
    @Override
    public int getRowCount() {
        return dp.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "Id";
            case 1:
                return "Nama Pemilik";
            case 2:
                return "Nama Hewan";
            case 3:
                return "Jenis Hewan";
            case 4:
                return "Nomor Telepon";
            case 5:
                return "Durasi Titip";
            case 6:
                return "Total Biaya";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
 switch(column){
            case 0:
                return dp.get(row).getId();
            case 1:
                return dp.get(row).getNama_pemilik();
            case 2:
                return dp.get(row).getNama_hewan();
            case 3:
                return dp.get(row).getJenis_hewan();
            case 4:
                return dp.get(row).getNomor_telepon();
            case 5:
                return dp.get(row).getDurasi_titip();
            case 6:
                return dp.get(row).getTotal_biaya();
            default:
                return null;
        }    
    }
    
}
