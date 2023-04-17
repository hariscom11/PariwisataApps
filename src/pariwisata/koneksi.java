/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pariwisata;

import com.toedter.calendar.JDateChooser;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Haris
 */
public class koneksi {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    public Integer id;
    public Integer cekLogin;
    public boolean cekFormAdmin = false;
    private int sesi;

    public Integer getIdAdmin() {
        return id;
    }
    
    public int getSesi(){
        return sesi;
    }
    
    public void setKodeJadwalPemesanan(int sesi){
         this.sesi = sesi;
    }

    public void setIdAdmin(Integer id) {
        this.id = id;
    }
    
    
    
    public Connection getConnection() {
        return connection;
    }

    public void getCon() {
        
        try {
            String urlDatabase = "jdbc:mysql://localhost/pariwisata"; //alamat database
            String user = "root"; //user yang dipakai utk akses database
            String password = ""; //password yang digunakan utk akses database
            connection = DriverManager.getConnection(urlDatabase, user, password);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Koneksi Gagal! " + ex.getMessage());
        }   
       
    }

    public void Eksekusi(String Query, String Pesan){
        getCon();
        try {
            statement=connection.createStatement();
            statement.execute(Query);
            statement.close();
            JOptionPane.showMessageDialog(null, Pesan);
        } catch (SQLException ex) {
            Logger.getLogger(koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eksekusiFor(String Query){
          getCon();
        try {
            statement=connection.createStatement();
            statement.execute(Query);
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    public void tampil(javax.swing.JTable table, String Query) {
        getCon();
        try {
     
            statement = connection.createStatement();
            resultSet = statement.executeQuery(Query);
            
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
            
            statement.close();
            resultSet.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    

    
    public void combo(String Query, String ID,String Nama, javax.swing.JComboBox cb) {
        getCon();
        try {

            String showDataQuery = Query;
            statement = connection.createStatement();
            resultSet = statement.executeQuery(showDataQuery);
          
            while (resultSet.next()) {
                cb.addItem(resultSet.getString(ID) + "-" + resultSet.getString(Nama));
            }

            statement.close();
            resultSet.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Gagal Menampilkan di combobox " + ex.getMessage());
        }
    }
    
    private String dateNow(){
        Calendar cal =  Calendar.getInstance();

        int day = cal.get(Calendar.DAY_OF_MONTH);
        int month = cal.get(Calendar.MONTH) +1;
        int year = cal.get(Calendar.YEAR);
        
        String datenow = String.valueOf(day) + String.valueOf(month) + String.valueOf(year);
        
        return datenow;
    }
    
    public void autoNumber(javax.swing.JTextField textField){
        
        try{
           getCon();
            Statement s = connection.createStatement();
            String sql = "SELECT `nomerFaktur` FROM `tbl_transaksi` WHERE nomerFaktur LIKE '%"+ dateNow() +"%' ORDER BY ID DESC";
            ResultSet r = s.executeQuery(sql);
            if (r.next()){
                String prefix = "TSC" + dateNow() ;
                String NoFaktur = r.getString("nomerFaktur").substring(13);
                String TR = "" + (Integer.parseInt(NoFaktur)+1);
                String No1 = "";
                
                if(TR.length()==1)
                {No1 = "00";}
                else if (TR.length()==2)
                {No1 = "0";}
                else if (TR.length()==3)
                {No1 = "";}
               
                textField.setText(prefix + No1 + TR);
            }else {
                textField.setText("TSC" + dateNow() + "001");
            }
            r.close();
            s.close();  
        }catch (NumberFormatException | SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    
  /*  public void cetakStrukstatic(javax.swing.JTextField textField) {
          try {
            getCon();

            try {

                String report = ("C:\\Users\\LURY\\Documents\\NetBeansProjects\\pujasera_restoran\\src\\pujasera\\cetakStruk.jrxml");
                 HashMap hash = new HashMap();
                //Mengambil parameter dari ireport
                hash.put("nomerFaktur", textField.getText());
                
                JasperReport JRpt = JasperCompileManager.compileReport(report);
                JasperPrint JPrint = JasperFillManager.fillReport(JRpt, hash, connection);
                JasperViewer.viewReport(JPrint, false);
            } catch (JRException rptexcpt) {
                System.out.println("Report Can't view because : " + rptexcpt);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
 /*   public void cetakReport(String tanggalPertama,String tanggalKedua) {
          try {
            getCon();

            try {

                String report = ("C:\\Users\\LURY\\Documents\\NetBeansProjects\\pujasera_restoran\\src\\pujasera\\cetakReport.jrxml");
                 HashMap hash = new HashMap();
                //Mengambil parameter dari ireport
                hash.put("tanggalPertama",tanggalPertama);
                hash.put("tanggalKedua",tanggalKedua);
                
                JasperReport JRpt = JasperCompileManager.compileReport(report);
                JasperPrint JPrint = JasperFillManager.fillReport(JRpt, hash, connection);
                JasperViewer.viewReport(JPrint, false);
            } catch (JRException rptexcpt) {
                System.out.println("Report Can't view because : " + rptexcpt);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}*/
    
    
    public String formatTanggal(JDateChooser tanggal){
        Date date = tanggal.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = sdf.format(date);
        return formattedDate;
    }
}
