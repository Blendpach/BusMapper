package com.blendpach.busmapper;

public class Utils {

    private Boolean FirstTransit=false;
    private Boolean EndTransit=false;

    private float StartLat = 0;
    private float StartLng = 0;
    private float EndtLat = 0;
    private float EndtLng = 0;
    

    public Utils() {
        StartLat = 0;
        StartLng = 0;
        EndtLat = 0;
        EndtLng = 0;
    }

    public Utils(Boolean FirstTransit , Boolean EndTransit) {
        this.FirstTransit = FirstTransit;
        this.EndTransit = EndTransit;
    }

    
    public Boolean getFirstTransit() {
        return FirstTransit;
    }

    public void setFirstTransit(Boolean FirstTransit) {
        this.FirstTransit = FirstTransit;
    }

    public Boolean getEndTransit() {
        return EndTransit;
    }

    public void setEndTransit(Boolean EndTransit) {
        this.EndTransit = EndTransit;
    }

    public float getStartLat() {
        return StartLat;
    }

    public float getStartLng() {
        return StartLng;
    }

    public float getEndtLat() {
        return EndtLat;
    }

    public float getEndtLng() {
        return EndtLng;
    }

    public void setStartLat(float startLat) {
        StartLat = startLat;
    }

    public void setEndtLat(float endtLat) {
        EndtLat = endtLat;
    }

    public void setEndtLng(float endtLng) {
        EndtLng = endtLng;
    }

    public void setStartLng(float startLng) {
        StartLng = startLng;
    }

}
