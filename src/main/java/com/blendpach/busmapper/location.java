package com.blendpach.busmapper;

public class location {
    
    private String mode;
    private String startLat;
    private String startLng;
    private String endLat;
    private String endLng;

    public location(String mode, String startLat, String startLng, String endLat, String endLng) {
        this.mode = mode;
        this.startLat = startLat;
        this.startLng = startLng;
        this.endLat = endLat;
        this.endLng = endLng;
    }

    public String getMode() {
        return mode;
    }
    public String getStartLat() {
        return startLat;
    }
    public String getStartLng() {
        return startLng;
    }
    public String getEndLat() {
        return endLat;
    }
    public String getEndLng() {
        return endLng;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
    public void setStartLat(String startLat) {
        this.startLat = startLat;
    }
    public void setStartLng(String startLng) {
        this.startLng = startLng;
    }
    public void setEndLat(String endLat) {
        this.endLat = endLat;
    }
    public void setEndLng(String endLng) {
        this.endLng = endLng;
    }

}
