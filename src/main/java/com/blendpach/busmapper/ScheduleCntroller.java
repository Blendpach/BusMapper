package com.blendpach.busmapper;

import java.util.List;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

public class ScheduleCntroller {
   
     private String inputObj;
     private String outputObj;

    public ScheduleCntroller(){

    }

    public ScheduleCntroller(String inputObj , String outputObj){
        this.inputObj = inputObj;
        this.outputObj  = outputObj;

    }


    public String generateSchedule(org.json.JSONArray passingJSONArray) {
       
       //JSONObject routes_obj = (JSONObject) passingJSONArray.get(0);
       System.out.println(passingJSONArray);

       return passingJSONArray.toString();
   
    }

  
    public void setInputObj(String inputObj) {
        this.inputObj = inputObj;
    }

    public void setOutputObj(String outputObj) {
        this.outputObj = outputObj;
    }

    public String getInputObj() {
        return inputObj;
    }

    public String getOutputObj() {
        return outputObj;
    }
    

 
}