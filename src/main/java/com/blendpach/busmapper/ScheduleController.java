package com.blendpach.busmapper;


public class ScheduleController {
   
     private String inputObj;
     private String outputObj;

    public ScheduleController(){
    }

    public ScheduleController(String inputObj , String outputObj){
        this.inputObj = inputObj;
        this.outputObj  = outputObj;
    }


    public String generateSchedule(org.json.JSONArray passingJSONArray) {
       
       System.out.println("passingJSONArray is "  + passingJSONArray);
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