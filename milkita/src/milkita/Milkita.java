/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package milkita;

import java.util.ArrayList;
import weka.classifiers.*;
import weka.classifiers.Classifier;
import weka.classifiers.lazy.IBk;
import weka.classifiers.trees.J48;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.SerializationHelper;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.NominalToString;
import weka.filters.unsupervised.attribute.StringToWordVector;

/**
 *
 * @author user
 */
public class Milkita {

    public static void main(String[] args) throws Exception {
        DatabaseController db = new DatabaseController();         db.setDatabase("news_aggregator");
        db.setConnection(); //melakukan koneksi terhadap database
        db.selectQuery("ARTIKEL NATURAL JOIN ARTIKEL_KATEGORI_VERIFIED NATURAL JOIN KATEGORI", new ArrayList<String>() {
            {
                add("ARTIKEL.ID_ARTIKEL");
                add("JUDUL");
                add("KATEGORI.LABEL");
                add("ARTIKEL.FULL_TEXT");
            }
        }, null);
        Instances instances = new Instances(db.getData());
        
        NominalToString filterNominalToString = new NominalToString();
        filterNominalToString.setInputFormat(instances);
        
        instances = Filter.useFilter(instances, filterNominalToString);
        for (int it = 0; it < instances.numInstances(); ++it) {
            Instance curr = instances.instance(it);
            curr.setValue(3, Utility.Filtering(curr.stringValue(3)));
        }
        
        StringToWordVector filterStringToVector = new StringToWordVector();
        String[] optionsStringToVector = "-R 4".split(" ");
        filterStringToVector.setOptions(optionsStringToVector);
        filterStringToVector.setInputFormat(instances);
        instances = Filter.useFilter(instances, filterStringToVector);
        instances.setClassIndex(2);
        
        System.out.println(instances.toSummaryString());
        Classifier classifier = new IBk();
        classifier.buildClassifier(instances);
        SerializationHelper.write("model", classifier);
        
        classifier = (Classifier) SerializationHelper.read("model");
        
        Evaluation eval = new Evaluation(instances);
        eval.evaluateModel(classifier, instances);
        System.out.println(eval.toSummaryString());
    }
}
