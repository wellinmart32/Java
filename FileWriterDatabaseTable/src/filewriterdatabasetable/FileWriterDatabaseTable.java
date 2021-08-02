/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filewriterdatabasetable;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
/**
 *
 * @author welli
 */
public class FileWriterDatabaseTable {

    private DbConnector db_conn;
    private String file_name, path;
    private FileWriter report;
    private ArrayList<ArrayList<String>> record_list;
    
    public FileWriterDatabaseTable(ArrayList<ArrayList<String>> record_list) {
        this.db_conn = null;
        this.file_name = "";
        this.path = "D:/Wellington Martinez/Trabajo/Programación/Software/Java/FileWriterDatabaseTable/product reports/";
        this.record_list = record_list;
        fileDataSetting();
    }
    
    public void fileDataSetting() {
        Calendar cal = Calendar.getInstance();
        String date_name = String.format("%1$tY%1$tm%1$td_%1$tH%1$tM%1$tS", cal);
        this.file_name = "ProductReport_" + date_name + ".txt";
        try {
            report = new FileWriter(path + file_name);
            writeRecord();
            System.out.println("Archivo creado con éxito");
        } catch (IOException ex) {
            System.out.println("Error al crear el archivo");
        } 
    }
    
    public void writeRecord() {
        try {
            for(ArrayList<String> r: record_list) {
                for(String s: r) {
                    this.report.write(s + "\t");
                }
                this.report.write("\n");
            }
            this.report.close();
        } catch (IOException ex) {
            System.out.println("Error al escribir el archivo");
        }
    }
}
