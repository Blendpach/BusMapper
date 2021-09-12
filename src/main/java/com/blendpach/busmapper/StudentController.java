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
import org.json.simple.JSONObject;

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
    public static void call_me(@PathVariable("startLat") String startLat,@PathVariable("startLng") String startLng,@PathVariable("endLat") String endLat,@PathVariable("endLng") String endLng) throws Exception {
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
        //print in String
        System.out.println(response.toString());
        //Read JSON response and print
        // JSONObject myResponse = new JSONObject(response.toString());
        // System.out.println("result after Reading JSON Response");
        // System.out.println("statusCode- "+myResponse.getString("statusCode"));
        // System.out.println("statusMessage- "+myResponse.getString("statusMessage"));
        // System.out.println("ipAddress- "+myResponse.getString("ipAddress"));
        // System.out.println("countryCode- "+myResponse.getString("countryCode"));
        // System.out.println("countryName- "+myResponse.getString("countryName"));
        // System.out.println("regionName- "+myResponse.getString("regionName"));
        // System.out.println("cityName- "+myResponse.getString("cityName"));
        // System.out.println("zipCode- "+myResponse.getString("zipCode"));
        // System.out.println("latitude- "+myResponse.getString("latitude"));
        // System.out.println("longitude- "+myResponse.getString("longitude"));
        // System.out.println("timeZone- "+myResponse.getString("timeZone"));  
    }
   

}
