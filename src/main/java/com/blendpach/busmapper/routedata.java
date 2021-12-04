package com.blendpach.busmapper;

public class routedata {
    
    private String mode;    
    private String distance;
    private String duration;
    private String description;
    private String start_lat;
    private String start_lang;
    private String end_lat;
    private String end_lang;
   
    public routedata(String mode, String distance, String duration, String description, String start_lat, String start_lang, String end_lat, String end_lang) {
        this.mode = mode;
        this.distance = distance;
        this.duration = duration; 
        this.description = description;
        this.start_lat = start_lat;
        this.start_lang = start_lang;
        this.end_lat = end_lat;
        this.end_lang = end_lang;
    }

            public String getDescription() {
                return description;
            }

            public String getDistance() {
                return distance;
            }

            public String getDuration() {
                return duration;
            }

            public String getMode() {
                return mode;
            }

            public String getEnd_lang() {
                return end_lang;
            }

            public String getEnd_lat() {
                return end_lat;
            }

            public String getStart_lang() {
                return start_lang;
            }

            public String getStart_lat() {
                return start_lat;
            }
            

            public void setDescription(String description) {
                this.description = description;
            }

            public void setDistance(String distance) {
                this.distance = distance;
            }

            public void setDuration(String duration) {
                this.duration = duration;
            }

            public void setMode(String mode) {
                this.mode = mode;
            }

            public void setEnd_lang(String end_lang) {
                this.end_lang = end_lang;
            }

            public void setEnd_lat(String end_lat) {
                this.end_lat = end_lat;
            }

            public void setStart_lang(String start_lang) {
                this.start_lang = start_lang;
            }

            public void setStart_lat(String start_lat) {
                this.start_lat = start_lat;
            }

         
}
