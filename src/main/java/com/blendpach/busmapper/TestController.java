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
public class TestController {

    @GetMapping("/testapi")
    public List<routes> getDirectios() throws Exception {

        List<routes> bus = new ArrayList<>();

        bus.add(new routes("routeId", "A1", "5 mins", "1 Hour 20 mins",
                "Sampath Express", "busId1"));

        bus.add(new routes("routeId", "A2", "5 mins", "2 Hour 20 mins",
                "Sampath Express", "busId1"));

        bus.add(new routes("routeId", "A3", "5 mins", "3 Hour 20 mins",
                "Sampath Express", "busId1"));

        bus.add(new routes("routeId", "A4", "5 mins", "4 Hour 20 mins",
                "Sampath Express", "busId1"));

        bus.add(new routes("routeId", "A5", "5 mins", "5 Hour 20 mins",
                "Sampath Express", "busId1"));

        // return locations;
        return bus;

    }

}
