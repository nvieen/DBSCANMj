/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package com.navien.dbscantestfinal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.stream.Collectors;

/**
 *
 * @author navien
 */
public class expandCluster {

    public static int[] clusterExpand(double[][] distMat, int pt, int ClusterId, double eps, int minPts, int[] clust) {
       boolean isnoise;
        ArrayList<Integer> seed1 = new ArrayList<>();
        ArrayList<Integer> seed2 = new ArrayList<>();
        ArrayList<Integer> seed3 = new ArrayList<>();
        ArrayList<Integer> seed4 = new ArrayList<>();

        ArrayList<Integer> ptt = new ArrayList<>();
       
        ArrayList<Integer> currentP = new ArrayList<Integer>();

        ArrayList<Integer> resultP = new ArrayList<Integer>();
        ArrayList<Integer> result = new ArrayList<>();

        

        getSeed(distMat, eps, seed1);

        System.out.println(seed1.size());
        
        int[] seedidx = new int[seed1.size()];
        
        if (seed1.size() < minPts) {
            clust[pt] = 0;
            isnoise = true;
            
        }

        for (int i = 0; i < seed1.size(); i++) {   
            seedidx[i] = seed1.get(i);   
        }
        
         System.out.println("*****");
            System.out.println(Arrays.toString(seedidx));
            
            for ( int ii=0; ii< seedidx.length; ii++){
            clust[seedidx[ii]] = ClusterId;
            }

        
        ptt.add(pt);
        
        seed2 = setXOR(seed1, ptt);

        while (seed1.size() != 0) {

            currentP.get(seed1.get(0));

            getSeed(distMat, eps, result);

            if (result.size() >= minPts) {

                for (int j = 0; j < result.size(); j++) {

                    resultP.get(result.get(j));
                    
                    if (clust[resultP.get(j)] == -1 || clust[resultP.get(j)] == 0) {

                        if (clust[resultP.get(j)] == -1) {
                            // merge
                            seed3=mergeNieghbour(seed2,resultP);
                               
                        }
                        clust[resultP.get(j)]=ClusterId;

                    }

                }
            }
            //seeds=setxor(seeds,currentP);
           
        seed4 = setXOR(seed3, currentP);
        }
      isnoise=false;
        return clust ;

    }

    /**
     * getSeed
     *
     * @param distMat
     * @param Eps
     * @param index
     */
    public static void getSeed(double[][] distMat, double Eps, List<Integer> index) {

        for (int i = 0; i < distMat.length; i++) {
            for (int j = 0; j < distMat[i].length; j++) {
                if (distMat[i][j] < Eps) {
                    // int position = ( i + 1 ) + ( j * distMat.length);
                    int position = (i) + (j * distMat.length);

                    index.add(position);
                }
            }
        }
    }

    /**
     * SetXOR
     *
     * @param list1
     * @param list2
     * @return
     */
    public static ArrayList<Integer> setXOR(ArrayList<Integer> list1, ArrayList<Integer> list2) {

//Intersections:
        Set<Integer> s1 = new HashSet<Integer>(list1);
        Set<Integer> s2 = new HashSet<Integer>(list2);

        s1.retainAll(s2);  //now s1 has the intersection

//Everything that is not an intersection:
        Set<Integer> notInter1 = new HashSet<>();

        list1.addAll(list2);

        list1.stream().distinct().filter(e -> !s1.contains(e)).forEach(e -> notInter1.add(e));

        System.out.println(list1);

        List<Integer> notInter = list1.stream().distinct().filter(e -> !s1.contains(e)).collect(Collectors.toList());
        System.out.println(notInter);

        return (ArrayList<Integer>) notInter;

    }
    
    /**
     * merege the reached neighbour
     * @param a
     * @param b
     * @return 
     */
    public static ArrayList<Integer> mergeNieghbour(ArrayList<Integer>  a,ArrayList<Integer>  b)
	{
	
	Iterator<Integer> it5 = b.iterator();
	while(it5.hasNext()){
		Integer  t = it5.next();
		if (!a.contains(t) ){
			a.add(t);
		}
	}
	return a;
	}
}
