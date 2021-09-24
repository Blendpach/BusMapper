package com.blendpach.busmapper;

import java.util.ArrayList;
import java.util.List;

import javax.tools.DocumentationTool.Location;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriBuilder;


import java.io.BufferedReader;
import java.io.Console;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL; 
import org.json.JSONObject;
import org.json.JSONTokener;
import org.json.JSONArray;
//import org.json.parser.JSONParser;

@RestController
public class StudentController {

    @GetMapping("/student")
    public Student getStudent() {

        return new Student("Ushira", "Tissera");

    }

    @GetMapping("/students")
    public List<Student> getstudents() {

        List<Student> students = new ArrayList<>();
        students.add(new Student("Dinith", "Shavindu"));
        students.add(new Student("Name1", "Surname1"));
        students.add(new Student("Name2", "Surname2"));
        students.add(new Student("Name3", "Surname3"));
        students.add(new Student("Name4", "Surname4"));
        students.add(new Student("Name5", "Surname5"));
        students.add(new Student("Name6", "Surname6"));

        return students;

    }

    @GetMapping("/student/{firstName}/{lastName}")
    public Student studentPathVariable(@PathVariable("firstName") String firstName,
            @PathVariable("lastName") String lastName) {

        return new Student(firstName, lastName);

    }

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

        JSONTokener tokener = new JSONTokener(response.toString());
        JSONObject data_obj = new JSONObject(tokener);

        JSONArray routes = (JSONArray) data_obj.get("routes");
        JSONObject routes_obj = (JSONObject) routes.get(0);

        JSONArray legs = (JSONArray) routes_obj.get("legs");
        JSONObject legs_obj = (JSONObject) legs.get(0);

        JSONArray steps = (JSONArray) legs_obj.get("steps");

        List<location> locations = new ArrayList<>();

        Utils util = new Utils(false ,false);
        location loc = new location("TRANSIT","","");
        // String mode  = "";


        for (int i = 0; i < steps.length(); i++) {

            JSONObject step = (JSONObject) steps.get(i);          
            String  mode = step.get("travel_mode").toString();

            // JSONObject step = (JSONObject) steps.get(i);
            
            // // String mode = step.get("travel_mode").toString();
              
            // String mode = step.getString("travel_mode");
           
            loc.setMode("TRANSIT");

            if (mode==loc.getMode() && !util.getFirstTransit()){

                util.setFirstTransit(true);
                JSONObject start = (JSONObject) step.get("start_location");
                String tempStartLat = start.get("lat").toString();
                String tempStartLng = start.get("lng").toString();

                // util.setStartLat(tempStartLat);
                // util.setStartLng(tempStartLng);

                locations.add(new location(mode, tempStartLat, tempStartLng ));

            }

            if (mode==loc.getMode() && !util.getEndTransit() && util.getFirstTransit()){

                util.setEndTransit(true);
                JSONObject end = (JSONObject) step.get("end_location");
                String tempEndtLat =  end.get("lat").toString();
                String tempEndtLng =  end.get("lng").toString();

                // util.setEndtLat(tempEndtLat);
                // util.setEndtLng(tempEndtLng);

                locations.add(new location(mode, tempEndtLat, tempEndtLng));

            }

            // loc.setMode(mode);
            // System.out.print("mode is = ");
            // System.out.println(loc);

            // locations.add(new location(mode, "tempStartLat", "tempStartLng" ));

            // if (mode==loc.getMode()){

            //     util.setFirstTransit(true);
            //     JSONObject start = (JSONObject) step.get("start_location");
            //     String tempStartLat = start.get("lat").toString();
            //     String tempStartLng = start.get("lng").toString();

            //     // util.setStartLat(tempStartLat);
            //     // util.setStartLng(tempStartLng);

            //     locations.add(new location(mode, tempStartLat, tempStartLng ));

            // }






            // if (mode=="TRANSIT" && !util.getFirstTransit()){

            //     util.setFirstTransit(true);
            //     JSONObject start = (JSONObject) step.get("start_location");
            //     Float tempStartLat = (Float) start.get("lat");
            //     Float tempStartLng = (Float) start.get("lng");

            //     util.setStartLat(tempStartLat);
            //     util.setStartLng(tempStartLng);

            //     locations.add(new location(mode, util.getStartLat(), 
            //                                         util.getStartLng(),
            //                                             util.getEndtLat(),
            //                                                 util.getEndtLng() ));

            // }

            // if (mode=="TRANSIT" && !util.getEndTransit() && util.getFirstTransit()){

            //     util.setEndTransit(true);
            //     JSONObject end = (JSONObject) step.get("end_location");
            //     Float tempEndtLat = (Float) end.get("lat");
            //     Float tempEndtLng = (Float) end.get("lng");

            //     util.setEndtLat(tempEndtLat);
            //     util.setEndtLng(tempEndtLng);

            //     locations.add(new location(mode, util.getStartLat(), 
            //                                         util.getStartLng(),
            //                                             util.getEndtLat(),
            //                                                 util.getEndtLng() ));

            // }


           
            
            // mode = step.get("travel_mode").toString();
            // JSONObject start = (JSONObject) step.get("start_location");
            // float tempStartLat = (float) start.get("lat");
            // float tempStartLng = (float) start.get("lng");

            // JSONObject end = (JSONObject) step.get("end_location");
            // float tempEndtLat = (float) end.get("lat");
            // float tempEndtLng = (float) end.get("lng");

            // locations.add(new location(mode, tempStartLat,tempStartLng,tempEndtLat,tempEndtLng));

           
        }

        // if(!util.getFirstTransit()){

        //     float a = 0;
        //     float b = 0;
        //     float c = 0;
        //     float d = 0;


        //     locations.add(new location("First NOT IDEANTIFIED", a,b,c,d ));
        // }

        // if(!util.getEndTransit()){

        //     float a = 0;
        //     float b = 0;
        //     float c = 0;
        //     float d = 0;


        //     locations.add(new location("Second NOT IDEANTIFIED", a,b,c,d ));
        // }

        //   locations.add(new location(mode, util.getStartLat(), 
        //                                         util.getStartLng(),
        //                                             util.getEndtLat(),
        //                                                 util.getEndtLng() ));

        //url : http://localhost:57090/directions/6.903313/79.911253/6.812951/79.887970

        //request url : https://maps.googleapis.com/maps/api/directions/json?origin=6.903313,79.911253&destination=6.812951,79.887970&transit_mode=bus&mode=transit&key=AIzaSyDP3V4_sogsaHcONLPS9d59Ccq_IQhDygQ
    
        return locations;
    }
   

}
