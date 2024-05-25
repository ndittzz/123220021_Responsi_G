/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOdatapenitipan;
import java.sql.*;
import java.util.*;
import koneksi.connector;
import model.*;
import DAOImplement.dataImplement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author PC PRAKTIKUM
 */
public class datapenitipanDAO implements dataImplement{
    
    Connection connection;
    
    final String select = "SELECT * FROM titip_hewan";
    final String insert = "INSERT INTO titip_hewan (id,nama_pemilik,nama_hewan,jenis_hewan,nomor_telepon, durasi_titip,total_biaya) VALUES (?,?,?,?,?,?,?);";
    final String update = "UPDATE titip_hewan SET nama_pemilik=?, nama_hewan=?, jenis_hewan=?, nomor_telepon=?, durasi_titip=?,total_biaya=? WHERE id=?;";
    final String delete = "delete from titip_hewan where id = ?";

    public datapenitipanDAO(){
        connection = connector.connection();
    }
    
    @Override
    public void insert(datapenitipan p) {
        PreparedStatement statement = null;
            try{
                statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
                statement.setDouble(1, p.getId());
                statement.setString(2, p.getNama_pemilik());
                statement.setString(3, p.getNama_hewan());
                statement.setString(4, p.getJenis_hewan());
                statement.setDouble(5, p.getNomor_telepon());
                statement.setDouble(6, p.getDurasi_titip());
                statement.setDouble(7, p.getTotal_biaya());
                statement.executeUpdate();
                ResultSet rs = statement.getGeneratedKeys();
                while(rs.next()){
                    p.setId(rs.getDouble(1));
                }
            }catch(SQLException ex){
                ex.printStackTrace();

            }finally{
                try{
                    statement.close();
                }catch(SQLException ex){
                    ex.printStackTrace();
                }    
            }
    }

    @Override
    public void update(datapenitipan p) {
    PreparedStatement statement = null;
            try{
            statement = connection.prepareStatement(update);
                statement.setString(1, p.getNama_pemilik());
                statement.setString(2, p.getNama_hewan());
                statement.setString(3, p.getJenis_hewan());
                statement.setDouble(4, p.getNomor_telepon());
                statement.setDouble(5, p.getDurasi_titip());
                statement.setDouble(6, p.getTotal_biaya());
                statement.setDouble(7, p.getId());
                statement.executeUpdate();

            }catch(SQLException ex){
                ex.printStackTrace();

            }finally{
                try{
                    statement.close();
                }catch(SQLException ex){
                    ex.printStackTrace();
                }    
            }    }

    @Override
    public void delete(String id) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(delete);
            
            statement.setString(1, id);
            statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
            
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }    }

    @Override
    public List<datapenitipan> getAll() {
    List<datapenitipan> dp = null;
        try{
            dp = new ArrayList<datapenitipan>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                datapenitipan m = new datapenitipan();
                m.setId(rs.getDouble("id"));
                m.setNama_pemilik(rs.getString("nama_pemilik"));
                m.setNama_hewan(rs.getString("nama_hewan"));
                m.setJenis_hewan(rs.getString("jenis_hewan"));                
                m.setNomor_telepon(rs.getDouble("nomor_telepon"));
                m.setDurasi_titip(rs.getDouble("durasi_titip"));
                m.setTotal_biaya(rs.getDouble("total_biaya"));
                dp.add(m);
            }
        }catch(SQLException ex){
            Logger.getLogger(datapenitipanDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return dp;       
    }
    
}
