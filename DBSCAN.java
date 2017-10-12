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
        isnoise = false;
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

        for (int i = 0; i < distMat.length; i++) {

            pt = VisitSequence[i];

            if (Clust[pt] == -1) {

                //[Clust,isnoise]=ExpandCluster1(DistMat,pt,ClusterId,Eps,MinPts,Clust);
                Clust = clusterExpand(distMat, pt, ClusterId, eps, minPts, Clust);

                if (!isnoise) {
                    ClusterId = ClusterId + 1;
                }
            }

            System.out.println(Arrays.toString(Clust));

        }
        return Clust;
    }
}
