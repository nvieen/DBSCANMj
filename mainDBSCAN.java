/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.navien.dbscantestfinal;

import static com.navien.dbscantestfinal.DBSCAN.applyDBSCAN;
import static com.navien.dbscantestfinal.expandCluster.clusterExpand;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 *
 * @author navien
 */
public class mainDBSCAN {
    
    
    
    public static void main(String [] args) throws IOException  {    
        // the epsilon parameter and minimum points
          double eps= 1;
          int minPt = 37;
          
          
          
        //read the data set
        String thefile = "c:\\users\\navien\\Desktop\\dataTest\\dataset3ID.csv";
        CsvReader reader = new CsvReader();
        // String content = reader.readFile(thefile, true);
        reader.readFile(thefile, true);
        List<Data> dataFile = reader.getData(thefile, true);
        double[][] data = new double[dataFile.size()][];
        String[] Id = new String[dataFile.size()];
        for (int i = 0; i < dataFile.size(); i++) {
            data[i] = new double[]{dataFile.get(i).D1, dataFile.get(i).D2};
            Id[i] = dataFile.get(i).ID;
        } 
       
        double distMat[][] = new double[data.length][data.length];
        
        for (int i = 0; i < data.length; ++i) {
            for (int j = 0; j < data.length; ++j) {
                distMat[i][j] = Utility.euclideanDist(data[i], data[j]);

            }
         }
       // %randomly choose the visiting order
    // for (int ii = 0; ii < data.length; ii++) {
        // VisitSequence[ii]= Utility.getRandomIdx(data);
     //}
        //  System.out.println("VisitSequence" + Arrays.toString(VisitSequence));
          
          
  int [] clustIdx = new int [data.length];
  
  for ( int i=0; i <data.length; i++){
        clustIdx  =  applyDBSCAN(distMat, eps, minPt);
  }
    System.out.println(clustIdx);
     
    }
    
    
    
    }    

