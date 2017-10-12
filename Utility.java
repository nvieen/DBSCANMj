
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.navien.dbscantestfinal;

import java.io.IOException;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author navien
 */
public class Utility {

    
  
    /**
     * Intialization with out replicate
     *
     * @param data
     * @param nPoints
     * @return
     */
    static public double[][] getRandomPoints(double[][] data, int nPoints) {
        int nRows = data.length;
        int nCols = data[0].length;
        Random RNG = new Random();

        if (nPoints > nRows) {
            throw new RuntimeException(
                    "Requested more random points than total number of points in data");
        }

        double[][] randomPoints = new double[nPoints][nCols];

        // keep track of indices already selected so they are not selected again
        List<Integer> randomIndices = new ArrayList<Integer>();

        for (int i = 0; i < nPoints; i++) {

            // keep generating a random number until a new one is found
            int randomIndex = RNG.nextInt(nRows);
            while (randomIndices.contains(randomIndex)) {
                randomIndex = RNG.nextInt(nRows);
            }

            // save the index selected
            randomIndices.add(randomIndex);
            Collections.sort(randomIndices);

            // add the random point to the results array
            randomPoints[i] = data[randomIndex];
        }

        return randomPoints;
    }

    /**
     * Euclidean distance between all possible point
     *
     * @param p1
     * @param p2
     * @return
     */
    public static double euclideanDist(double[] p1, double[] p2) {
        return sqrt(pow(p1[0] - p2[0], 2) + pow(p1[1] - p2[1], 2));
    }

    /**
     * return Symmatric format
     * @param X
     * @return 
     */
    public static double [][] symMat(double X [][]){
    double symatricMat[][] = new double[X.length][X.length];

        for (int i = 0; i < X.length; ++i) {

            for (int j = 0; j < X.length; ++j) {

                symatricMat[i][j] = euclideanDist(X[i], X[j]);

            }
         }
        return symatricMat;
    }
    
   
    /**
     * getRandom
     * @param data
     * @return 
     */
     public static int[]getRandomIdx(double[][] data) {
        
        int nRows = data.length;
        int nCols = data[0].length;
        Random RNG = new Random();

       

       // int [] randomPoints = new int [nRows];

        // keep track of indices already selected so they are not selected again
        List<Integer> randomIndices = new ArrayList<Integer>();

        

            // keep generating a random number until a new one is found
            int randomIndex = RNG.nextInt(nRows);
            while (randomIndices.contains(randomIndex)) {
                randomIndex = RNG.nextInt(nRows);
            }

            // save the index selected
            randomIndices.add(randomIndex);
            Collections.sort(randomIndices);
            
            
        int[] A = new int[randomIndices.size()];
        for(int i = 0;i < A.length;i++){
        A[i] = randomIndices.get(i);
        }
        return A;
    } 
    
 /**
  * Convert List Integer to int [] array 
  * @param integers
  * @return 
  */    
 public static int[] convertIntegers(List<Integer> integers)
{
    int[] ret = new int[integers.size()];
    for (int i=0; i < ret.length; i++)
    {
        ret[i] = integers.get(i).intValue();
    }
    return ret;
}    
    
/**
 * Shuffle
 * @param B 
 */
private static void shuffle1(int[] B) {

        Random random = new Random();

        for (int i = B.length-1;i>0; i--) {

            int index = random.nextInt(i + 1);

            if (index != i) {
                int temp = B[index];
                B[index] = B[i];
                B[i] = temp;
            }

        }
  
}

/**
 * Shuffle
 * @param B
 * @return 
 */
public static int [] shuffle(int[] B) {

        Random random = new Random();

        for (int i = B.length-1;i>0; i--) {

            int index = random.nextInt(i + 1);

            if (index != i) {
                int temp = B[index];
                B[index] = B[i];
                B[i] = temp;
            }

        }
        return B;
    }

 
}
