package com.example.user.myapp2.kaup;

/**
 * Created by USER on 2016-06-04.
 */
public class KaupService {
    double vWeight, vHeight;
    String rstMsg;

    public String getKaup(double vWeight, double vHeight){

        int idx = (int)(vWeight /(vHeight * vHeight)*10000);

        if(idx > 30){
            rstMsg = "비만";
        }else if(idx >= 24){
            rstMsg = "과체중";
        }else if(idx >= 20){
            rstMsg = "정상";
        }else if(idx >= 15){
            rstMsg = "저체중";
        }else if(idx >= 13){
            rstMsg = "마름";
        }else if(idx >= 10){
            rstMsg = "영양실조";
        }else if(idx < 10){
            rstMsg = "소모증";
        }else{
            rstMsg = "측정불가";
        }

        return rstMsg;
    }
}
