/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.applyDBSCAN
 */
package com.navien.dbscantestfinal;

import static com.navien.dbscantestfinal.expandCluster.clusterExpand;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 *
 * @author navien
 */
public class DBSCAN {

    public static int[] applyDBSCAN(double[][] distMat, double eps, int minPts) {
        
        boolean isnoise;
        int pt = 0;
        isnoise = true;
        int ClusterId = 0;
        int VisitSequence[] = new int[distMat.length];

        //Clust=zeros(size(DistMat,1),1)-1;
        int[] Clust = new int[distMat.length];

        for (int i = 0; i < Clust.length; i++) {
            Clust[i] = -1;
        }
        System.out.println(Arrays.toString(Clust));

        
        
        
        int[] indexes = IntStream.range(0, distMat.length).toArray();
        VisitSequence = Utility.shuffle(indexes);
        System.out.println(Arrays.toString(VisitSequence));

        for (int i = 0; i < Clust.length; i++) {

            pt = VisitSequence[i];

            System.out.println("PT+-Pt-+" + "" + pt);

            if (Clust[pt] == -1) {

                //[Clust,isnoise]=ExpandCluster1(DistMat,pt,ClusterId,Eps,MinPts,Clust);
                dbscanOutput out = clusterExpand(distMat, pt, ClusterId, eps, minPts, Clust);
                
                Clust = out.getClusters();
                System.out.println(Arrays.toString(Clust));
                isnoise = out.getIsnoise();
                System.out.println(isnoise);

                if (!isnoise) {
                    ClusterId = ClusterId + 1;
                }
            }


        }
        return Clust;
    }
}
