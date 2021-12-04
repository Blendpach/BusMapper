package com.blendpach.busmapper;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
// import org.springframework.web.bind.annotation.RestController;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import net.minidev.json.JSONArray;
import net.minidev.json.parser.JSONParser;

@RestController
public class AlgorithmController {

    // AlgorithmController(){

    // }

    // AlgorithmController(String jsonstr){
    //     jsonstr = this.jsonObjAsString;
    // }

    // String jsonObjAsString = "";

    // Boolean root_follow = true;
    // Boolean root_unfollow = true;
    
    // public Boolean getRoot_follow() {
    //     return root_follow;
    // }

    // public void setRoot_follow(Boolean root_follow) {
    //     this.root_follow = root_follow;
    // }

    // public Boolean getRoot_unfollow() {
    //     return root_unfollow;
    // }

    // public void setRoot_unfollow(Boolean root_unfollow) {
    //     this.root_unfollow = root_unfollow;
    // }
  
    // public String getJsonObjAsString() {
    //     return jsonObjAsString;
    // }

    // public void setJsonObjAsString(String jsonObjAsString) {
    //     this.jsonObjAsString = jsonObjAsString;
    // }

    // void loadJsonData(String Jsonboj){
                
    // }
    
    @GetMapping("/assignbus/{SL}/{BL}/{OL}/{DL}/{EL}/{LIVE_BUS}")
    public List<location> getSummary(
        @PathVariable("SL") Float SL,
        @PathVariable("EL") Float EL,
        @PathVariable("BL") Float BL,
        @PathVariable("DL") Float DL,
        @PathVariable("OL") Float OL,
        @PathVariable("LIVE_BUS") Boolean LIVE_BUS)
        
        throws Exception { 

        List<location> BestBus = new ArrayList<>();

        if(checkLocationBetweenPoints(SL,OL,DL)){              
                if(LIVE_BUS == false){
                    if(checkLocationBetweenPoints(OL,EL,BL)){
                        BestBus.add(new location("RIVERSE", "temp_latitude", "temp_longtitude" ));  
                    }
                }              
        }
        else if(checkLocationBetweenPoints(EL,OL,DL)){
            if(LIVE_BUS == true){
                if(checkLocationBetweenPoints(OL,SL,BL)){
                    BestBus.add(new location("FORWARD", "temp_latitude", "temp_longtitude" ));  
                }
            }
        }
        else{
            BestBus.add(new location("ERROR", "temp_latitude", "temp_longtitude" ));
        }

        return BestBus; 
    
    }

    boolean checkLocationBetweenPoints(Float STARTPOINT, Float ENDPOINT, Float MIDPOINT){

        //    if(STARTPOINT < MIDPOINT){
        //        if(MIDPOINT < ENDPOINT){
        //         return true;    
        //        }else{
        //            return false;
        //        }
        //     }else{
        //         return false;
        //     }
            System.out.println("STARTPOINT " + STARTPOINT);
            System.out.println("ENDPOINT " + ENDPOINT);
            System.out.println("MIDPOINT " + MIDPOINT);
        return true;

    }


    

}