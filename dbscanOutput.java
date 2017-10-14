/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.navien.dbscantestfinal;

/**
 *
 * @author navien
 */
public class dbscanOutput {

    public dbscanOutput(int[] Clusters, boolean isnoise) {
        this.Clusters = Clusters;
        this.isnoise = isnoise;
    }

    int Clusters[];
    boolean isnoise;

    public int[] getClusters() {
        return Clusters;
    }

    public boolean getIsnoise() {
        return isnoise;
    }

}
