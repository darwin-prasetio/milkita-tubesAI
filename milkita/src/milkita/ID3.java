/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package milkita;

import java.util.logging.Level;
import java.util.logging.Logger;
import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import java.util.Random;

/**
 *
 * @author user
 */
public class ID3 {
    private static J48 tree;
    private Evaluation evaluator,evaluator_2;
    private Instances labeled,instance;
    public ID3(Instances instances) {
        tree = new J48();
        instance = new Instances(instances);
    }
    
    public void classifyInstance(){
        labeled = new Instances(instance);
        labeled.setClassIndex(labeled.numAttributes()-1);
        double iLabel=0;
        for(int i=0; i<instance.numInstances();i++){
            try {
                iLabel = tree.classifyInstance(instance.instance(i));
                labeled.instance(i).setClassValue(iLabel);
            } catch (Exception ex) {
                Logger.getLogger(ID3.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void training(){
        try {
            evaluator = new Evaluation(instance);
            tree.buildClassifier(instance);
            crossValidate();
            evaluator.evaluateModel(tree,instance);
        } catch (Exception ex) {
            Logger.getLogger(ID3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void crossValidate() throws Exception {
        evaluator_2 = new Evaluation(instance);
        evaluator_2.crossValidateModel(tree, labeled, 10,new Random(1));
    }
}
