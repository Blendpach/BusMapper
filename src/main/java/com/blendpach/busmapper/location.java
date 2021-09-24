package com.blendpach.busmapper;

public class location {
    
    private String mode;
    private Float startLat;
    private Float startLng;
    private Float endLat;
    private Float endLng;

    private String pointLat;
    private String pointLang;

    // public location(String mode, Float startLat, Float startLng, Float endLat, Float endLng) {
    //     this.mode = mode;
    //     this.startLat = startLat;
    //     this.startLng = startLng;
    //     this.endLat = endLat;
    //     this.endLng = endLng;
    // }


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


    // public Float getStartLat() {
    //     return startLat;
    // }
    // public Float getStartLng() {
    //     return startLng;
    // }
    // public Float getEndLat() {
    //     return endLat;
    // }
    // public Float getEndLng() {
    //     return endLng;
    // }

    // public void setMode(String mode) {
    //     this.mode = mode;
    // }

    // public void setEndLat(Float endLat) {
    //     this.endLat = endLat;
    // }

    // public void setEndLng(Float endLng) {
    //     this.endLng = endLng;
    // }

    // public void setStartLat(Float startLat) {
    //     this.startLat = startLat;
    // }

    // public void setStartLng(Float startLng) {
    //     this.startLng = startLng;
    // }

}
