package com.blendpach.busmapper;

public class routes {

    private String routeId;
    private String routeName;
    private String eta;
    private String estimatedDuration;
    private String busName;
    private String busId;

    public routes() {

    }

    public routes(String routeId, String routeName, String eta, String estimatedDuration, String busName,
            String busId) {
        this.routeId = routeId;
        this.routeName = routeName;
        this.eta = eta;
        this.estimatedDuration = estimatedDuration;
        this.busName = busName;
        this.busId = busId;
    }

    public String getBusId() {
        return busId;
    }

    public String getBusName() {
        return busName;
    }

    public String getEstimatedDuration() {
        return estimatedDuration;
    }

    public String getEta() {
        return eta;
    }

    public String getRouteId() {
        return routeId;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setBusId(String busId) {
        this.busId = busId;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }

    public void setEstimatedDuration(String estimatedDuration) {
        this.estimatedDuration = estimatedDuration;
    }

    public void setEta(String eta) {
        this.eta = eta;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

}
