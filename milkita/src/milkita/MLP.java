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
import weka.classifiers.functions.MultilayerPerceptron;
import weka.core.Instances;

/**
 *
 * @author user
 */
public class MLP{
    private static MultilayerPerceptron mlp;
    private Evaluation evaluator,evaluator_2;
    private Instances labeled,instance;
    public MLP(Instances instances) {
        mlp = new MultilayerPerceptron();
        instance = new Instances(instances);
    }
    
    public void classifyInstance(){
        labeled = new Instances(instance);
        labeled.setClassIndex(labeled.numAttributes()-1);
        double iLabel=0;
        for(int i=0; i<instance.numInstances();i++){
            try {
                iLabel = mlp.classifyInstance(instance.instance(i));
                labeled.instance(i).setClassValue(iLabel);
            } catch (Exception ex) {
                Logger.getLogger(ID3.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void training(){
        try {
            evaluator = new Evaluation(instance);
            mlp.buildClassifier(instance);
            crossValidate();
            evaluator.evaluateModel(mlp,instance);
        } catch (Exception ex) {
            Logger.getLogger(ID3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void crossValidate() throws Exception {
        evaluator_2 = new Evaluation(instance);
        evaluator_2.crossValidateModel(mlp, labeled, 10,new Random(1));
    }
}
