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
public class RouteSummaryController {
   
    @GetMapping("/routesummary/{startLat}/{startLng}/{endLat}/{endLng}")
    public List<routedata> getSummary(@PathVariable("startLat") String startLat,@PathVariable("startLng") String startLng,@PathVariable("endLat") String endLat,@PathVariable("endLng") String endLng) throws Exception {
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

       
        JSONTokener tokener = new JSONTokener(response.toString());
        JSONObject data_obj = new JSONObject(tokener);

        JSONArray routes = (JSONArray) data_obj.get("routes");
        JSONObject routes_obj = (JSONObject) routes.get(0);

        JSONArray legs = (JSONArray) routes_obj.get("legs");
        JSONObject legs_obj = (JSONObject) legs.get(0);

        JSONArray steps = (JSONArray) legs_obj.get("steps");

        List<routedata> summary = new ArrayList<>();

        for (int i = 0; i < steps.length(); i++) {

            JSONObject step = (JSONObject) steps.get(i);
      
           JSONObject distance = (JSONObject) step.get("distance");
           String distance_value = distance.get("value").toString(); //distance is in meters 
           System.out.println("distance_value is = " +  distance_value);

           JSONObject duration = (JSONObject) step.get("duration");
           String duration_value = duration.get("value").toString(); //distance is in meters 
           System.out.println("duration_value is = " +  duration_value);

           String html_instructions_txt = step.get("html_instructions").toString(); 
           System.out.println("html_instructions_txt is = " +  html_instructions_txt);

           String travel_mode = step.get("travel_mode").toString();
           System.out.println("travel_mode is = " +  travel_mode);

           JSONObject start_location = (JSONObject) step.get("start_location");
           String start_lata = start_location.get("lat").toString();
           String start_lang = start_location.get("lng").toString();

           JSONObject end_location = (JSONObject) step.get("end_location");
           String end_lat = end_location.get("lat").toString();
           String end_lang = end_location.get("lng").toString();

           summary.add(new routedata(travel_mode, distance_value, duration_value, html_instructions_txt , start_lata , start_lang, end_lat, end_lang));  
           System.out.println("for loop " + summary );   

        }

         return summary;
    }

  
}
