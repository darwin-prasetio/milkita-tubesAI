/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package milkita;

import java.util.ArrayList;
import weka.core.Instances;

/**
 *
 * @author user
 */
public class Milkita {
    private static databaseControl db;
    private static Instances testInstance;
    public static void main(String[] args) throws Exception {
        db.getInstance(); // konstruktor databaseControl
        db.setDatabase("news_aggregator");
        db.setConnection(); //melakukan koneksi terhadap database
        db.selectQuery("ARTIKEL JOIN ARTIKEL_KATEGORI_VERIFIED JOIN KATEGORI", new ArrayList<String>() {{
            add("ID_ARTIKEL");
            add("ARTIKEL");
            add("JUDUL");
            add("ID_KELAS");
            add("KATEGORI");}}, null);
        testInstance=new Instances(db.getData());
        for(int i=0;i<testInstance.numInstances();i++){ // print instances
            System.out.println(testInstance.instance(i));
        }
    }
    
}
