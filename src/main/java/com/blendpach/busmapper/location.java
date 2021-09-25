package com.blendpach.busmapper;

public class location {
    
    private String mode;
    
    private String pointLat;
    private String pointLang;

    public location(String mode, String pointLat, String pointLang ) {
        this.mode = mode;
        this.pointLat = pointLat;
        this.pointLang = pointLang;       
    }

    public void setPointLang(String pointLang) {
        this.pointLang = pointLang;
    }

    public void setPointLat(String pointLat) {
        this.pointLat = pointLat;
    }

    public String getPointLang() {
        return pointLang;
    }

    public String getPointLat() {
        return pointLat;
    }


    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

}
