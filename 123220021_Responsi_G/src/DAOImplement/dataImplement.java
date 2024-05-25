/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOImplement;
import java.util.List;
import model.*;
/**
 *
 * @author PC PRAKTIKUM
 */
public interface dataImplement {
    public void insert(datapenitipan p);
    public void update(datapenitipan p);
    public void delete(String id);
    public List<datapenitipan> getAll(); 
}
