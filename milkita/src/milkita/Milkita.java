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
        db = new databaseControl(); // konstruktor databaseControl
        db.setDatabase("news_aggregator");
        db.setConnection(); //melakukan koneksi terhadap database
        db.selectQuery("ARTIKEL NATURAL JOIN ARTIKEL_KATEGORI_VERIFIED NATURAL JOIN KATEGORI", new ArrayList<String>() {{
            add("ARTIKEL.ID_ARTIKEL");
            add("JUDUL");
            add("KATEGORI.ID_KELAS");
            add("KATEGORI.LABEL");}}, null);
        System.out.println("a");
        testInstance = new Instances(db.getData());
        for(int i=0;i<testInstance.numInstances();i++){ // print instances
            System.out.println(testInstance.instance(i));
        }
    }
    
}
