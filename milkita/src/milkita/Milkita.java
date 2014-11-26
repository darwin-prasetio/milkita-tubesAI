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
    private static String s;
    public static void main(String[] args) throws Exception {
        db = new databaseControl(); // konstruktor databaseControl
        db.setDatabase("news_aggregator");
        db.setConnection(); //melakukan koneksi terhadap database
        db.selectQuery("ARTIKEL NATURAL JOIN ARTIKEL_KATEGORI_VERIFIED NATURAL JOIN KATEGORI", new ArrayList<String>() {{
            add("ARTIKEL.ID_ARTIKEL");
            add("JUDUL");
            add("KATEGORI.ID_KELAS");
            add("ARTIKEL.FULL_TEXT");}}, null);
        testInstance = new Instances(db.getData());
        for(int i=0;i<testInstance.numInstances();i++){ // filter
            s=testInstance.instance(i).stringValue(3);
            System.out.println(s);
            s = Filtering.Filter(s);
            System.out.println("a");
            System.out.println(s);
            System.out.println();
        }
    }
    
}
