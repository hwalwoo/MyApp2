package com.example.user.myapp2.kaup;

/**
 * Created by USER on 2016-06-04.
 */
public class KaupBean {
    private double vWeight, vHeight;
    private String rstMsg;

    public double getvWeight() {
        return vWeight;
    }

    public void setvWeight(double vWeight) {
        this.vWeight = vWeight;
    }

    public double getvHeight() {
        return vHeight;
    }

    public void setvHeight(double vHeight) {
        this.vHeight = vHeight;
    }

    public String getRstMsg() {
        return rstMsg;
    }

    public void setRstMsg(String rstMsg) {
        this.rstMsg = rstMsg;
    }


}
