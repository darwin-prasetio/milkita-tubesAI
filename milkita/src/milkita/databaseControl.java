/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package milkita;

import java.io.IOException;
import java.util.ArrayList;
import weka.core.Instances;
import weka.core.converters.DatabaseLoader;

/**
 *
 * @author user
 */
public class databaseControl {
    private String URL;
    private final String USER,PASS;
    private DatabaseLoader connect;
    
    public databaseControl() throws Exception{
        this.connect = new DatabaseLoader();
        this.URL="jdbc:mysql://localhost/";
        this.USER="root";
        this.PASS="";
    }
    
    public void setDatabase(String databaseName){
        this.URL="jdbc:mysql://localhost/"+databaseName;
    }
    
    public void setConnection() throws Exception{
            connect.setSource(this.URL,this.USER,this.PASS);
    }
    
    public void selectQuery(String tableName, ArrayList<String> columns, String condition){
        String query = new String("SELECT ");
        for(int i=0;i<columns.size();i++){
            query = query+columns.get(i);
            if(i!=columns.size()-1){
                query += ",";
            }
        }
        query+=" FROM " + tableName;
        if(condition!=null){
            query+= " WHERE " + condition;
        }
        connect.setQuery(query);
    }
    public Instances getData() throws IOException{
        return connect.getDataSet();
    }
    public void getDB(){
        System.out.println(this.URL);
    }
}
