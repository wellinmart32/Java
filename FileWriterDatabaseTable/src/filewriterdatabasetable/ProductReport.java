/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filewriterdatabasetable;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author welli
 */
public class ProductReport {
    
    private ArrayList<String> record;
    private FileWriterDatabaseTable file;
    private ArrayList<ArrayList<String>> record_list;
    private String start_date, finish_date;
    private int milisec, sec, min; 
    
    public ProductReport() {
        Calendar cal = Calendar.getInstance();
        this.record = new ArrayList();
        this.record_list = new ArrayList();
        this.start_date = "01-01-2020 00:00:00";
        this.finish_date = String.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", cal);
        this.milisec = 1000;
        this.sec = 60;
        this.min = 1;
        generateFiles();
    }   
    
    public void generateFiles() {
        Timer timer = new Timer();
        TimerTask tk = new TimerTask() {
            @Override
            public void run() {
                getProductReport();
            }
        };
        
        timer.schedule(tk, 0, milisec*sec*min);
    }
    
    public void getProductReport() {
        Connection conn = new DbConnector().startConnection();

        try {
            String query = "SELECT * "
                    + "FROM products "
                    + "WHERE created_at "
                    + "BETWEEN '" + this.start_date 
                    + "' AND '" + this.finish_date + "';";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                this.record.add(rs.getString("code"));
                this.record.add(rs.getString("name"));
                this.record.add(rs.getString("description"));
                this.record.add(rs.getString("weight"));
                this.record.add(rs.getString("state"));
                this.record.add(rs.getString("created_at"));
                this.record.add(rs.getString("updated_at"));
                this.record_list.add(this.record);
                this.record = new ArrayList();
            }
            this.file = new FileWriterDatabaseTable(this.record_list);
            this.record_list = new ArrayList();
            updateDates();
        } catch (SQLException ex) {
            System.out.println("Error al consultar la base de datos");
        }
    }
    
    public void updateDates() {
        Calendar cal = Calendar.getInstance();
        this.start_date = this.finish_date;
        this.finish_date = String.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", cal);
    }
    
    public static void main(String[] args) {
        new ProductReport();
    }

}
