package model;

import controller.BarangController;
import database.DatabaseConnect;

import javax.swing.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
/**
 *
 * @author Lisa Anis Safitri
 */
public class BarangModel {
    private Connection connection;
    private Statement statement;
    
    public BarangModel(){
        DatabaseConnect db = new DatabaseConnect();
        connection = db.getConnection();
    }
    
    public void tambahBarang(String[] data){
        try{
            String sql = "insert into barang (nama, massa, harga) values (?, ?, ?)";
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, data[0]);
            p.setString(2, data[1]);
            p.setString(3, data[2]);
            p.executeUpdate();
            connection.close();
            JOptionPane.showMessageDialog(null, "Tambah Data Sukses!!!");
        } catch (SQLException error) {
            System.out.println("Error");
            JOptionPane.showMessageDialog(null, error.getMessage());
        } 
    }
    
    public String[][] lihatBarang(){
        try{
            int baris = 0;
            int jmlBaris = jmlBaris("barang");
            if(jmlBaris==0){
                return null;
            }
            String[][] data = new String[jmlBaris][4];
            statement = connection.createStatement();
            String sql = "Select * from barang"; 
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                data[baris][0] = resultSet.getString("id");
                data[baris][1] = resultSet.getString("nama");
                data[baris][2] = resultSet.getString("massa");
                data[baris][3] = resultSet.getString("harga");
                baris++;
            }
            return data;
        }
        catch(SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
            return null;
        }
    }
    
    public String[] lihatBarang(String id){
        try{
            String[] data = new String[4];
            statement = connection.createStatement();
            String sql = "Select * from barang where id = " +id+ "";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                data[0] = resultSet.getString("id");
                data[1] = resultSet.getString("nama");
                data[2] = resultSet.getString("massa");
                data[3] = resultSet.getString("harga");
            }
            return data;
        }
        catch(SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
            return null;
        }
    }    
    
    public int jmlBaris(String table){
        int jml = 0;
        try{
            statement = connection.createStatement();
            String query = "select * from " + table;
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                jml++;
            }
            return jml;

        }catch(SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
            return 0;
        }
    }
    
    public void delete(String id) {
        try {
            String query = " delete from barang where id = ?";
            PreparedStatement p = connection.prepareStatement(query);
            p.setString (1, id);
            p.execute();
            connection.close();

            JOptionPane.showMessageDialog(null, "Hapus Barang Berhasil!!!");
        }
        catch (SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
        BarangController brgCtrl = new BarangController();
        brgCtrl.lihatBarang();
    }
    
    public String getData(String column, String table, String where, String value){
        try{
            String data = new String();
            statement = connection.createStatement();
            String sql = "select "+column+" from "+table+" where "+where+" = '" + value + "'";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                data = resultSet.getString(column);
            }
            return data;
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }
    
    public void updateData(String[] data){
        try{
            String query = "UPDATE barang SET nama = '"+data[1]+"', massa = '"+data[2]+"', harga = '"+data[3]+"' WHERE id = '"+data[0]+"'";
            statement = connection.createStatement();
            statement.executeUpdate(query);   
            JOptionPane.showMessageDialog(null, "Update Barang Berhasil");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

}