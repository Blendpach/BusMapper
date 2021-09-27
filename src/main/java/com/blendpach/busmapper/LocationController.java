package com.blendpach.busmapper;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL; 
import org.json.JSONObject;
import org.json.JSONTokener;
import org.json.JSONArray;


@RestController
public class LocationController {
   
    @GetMapping("/directions/{startLat}/{startLng}/{endLat}/{endLng}")
    public List<location> getDirectios(@PathVariable("startLat") String startLat,@PathVariable("startLng") String startLng,@PathVariable("endLat") String endLat,@PathVariable("endLng") String endLng) throws Exception {
        String url = "https://maps.googleapis.com/maps/api/directions/json?origin="+startLat+","+startLng+"&destination="+endLat+","+endLng+"&transit_mode=bus&mode=transit&key=AIzaSyDP3V4_sogsaHcONLPS9d59Ccq_IQhDygQ";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        // optional default is GET
        con.setRequestMethod("GET");
        //add request header
        con.setRequestProperty("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36");
        //firefox agent string "Mozilla/5.0"
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        Utils util = new Utils(false ,false);

        JSONTokener tokener = new JSONTokener(response.toString());
        JSONObject data_obj = new JSONObject(tokener);

        JSONArray routes = (JSONArray) data_obj.get("routes");
        JSONObject routes_obj = (JSONObject) routes.get(0);

        JSONArray legs = (JSONArray) routes_obj.get("legs");
        JSONObject legs_obj = (JSONObject) legs.get(0);

        JSONArray steps = (JSONArray) legs_obj.get("steps");

        List<location> locations = new ArrayList<>();

        for (int i = 0; i < steps.length(); i++) {

           JSONObject step = (JSONObject) steps.get(i);
           String mode = step.get("travel_mode").toString();
                      
           if (mode.equals("TRANSIT") && !util.getFirstTransit()){

                util.setFirstTransit(true);
                JSONObject start = (JSONObject) step.get("start_location");
                String tempStartLat = start.get("lat").toString();
                String tempStartLng = start.get("lng").toString();

                locations.add(new location(mode, tempStartLat, tempStartLng ));

            }         
        }

        for (int i = steps.length()-1; i > 0; i--) {           

            JSONObject step2 = (JSONObject) steps.get(i);
            String mode = step2.get("travel_mode").toString();          
                       
            if (mode.equals("TRANSIT") && !util.getEndTransit() && util.getFirstTransit()){
 
                 util.setEndTransit(true);
                 JSONObject end = (JSONObject) step2.get("end_location");
                 String tempEndtLat =  end.get("lat").toString();
                 String tempEndtLng =  end.get("lng").toString();
 
                 locations.add(new location(mode, tempEndtLat, tempEndtLng));
 
             }          
         }

            JSONArray passingJSONArray = new JSONArray(locations);
            ScheduleCntroller sched = new ScheduleCntroller();
            String getOutPutFromSchedule =  sched.generateSchedule(passingJSONArray);
            System.out.println("Data coming from schedule controller = " + getOutPutFromSchedule);
         

        //return locations;
        return locations;
    }

  
}
