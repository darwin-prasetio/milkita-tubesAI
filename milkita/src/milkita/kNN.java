/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package milkita;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import weka.classifiers.Evaluation;
import weka.classifiers.lazy.IBk;
import weka.core.Instances;

/**
 *
 * @author user
 */
public class kNN {
    private static IBk kNN;
    private Evaluation evaluator,evaluator_2;
    private Instances labeled,instance;
    public kNN(Instances instances) {
        kNN = new IBk();
        instance = new Instances(instances);
    }
    
    public void classifyInstance(){
        labeled = new Instances(instance);
        labeled.setClassIndex(labeled.numAttributes()-1);
        double iLabel=0;
        for(int i=0; i<instance.numInstances();i++){
            try {
                iLabel = kNN.classifyInstance(instance.instance(i));
                labeled.instance(i).setClassValue(iLabel);
            } catch (Exception ex) {
                Logger.getLogger(ID3.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void training(){
        try {
            evaluator = new Evaluation(instance);
            kNN.buildClassifier(instance);
            crossValidate();
            evaluator.evaluateModel(kNN,instance);
        } catch (Exception ex) {
            Logger.getLogger(ID3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void crossValidate() throws Exception {
        evaluator_2 = new Evaluation(instance);
        evaluator_2.crossValidateModel(kNN, labeled, 10,new Random(1));
    }
}
