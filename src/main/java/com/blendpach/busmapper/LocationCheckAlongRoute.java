package com.blendpach.busmapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationCheckAlongRoute {

    @RequestMapping("/checklocationRequest")
    public String checkrequest() throws ScriptException, NoSuchMethodException, IOException {

        // ScriptEngineManager manager = new ScriptEngineManager();
        // ScriptEngine engine = manager.getEngineByName("nashorn");

        // // read script file
        // File file = ResourceUtils.getFile("src/main/resources/check_along_route.js");
        // //File file = ResourceUtils.getFile("src/main/resources/bundle.js");
        // engine.eval(Files.newBufferedReader(Paths.get(file.getAbsolutePath().toString()),
        // StandardCharsets.UTF_8));

        // //engine.eval(Files.newBufferedReader(Paths.get(file.getAbsolutePath().toString())));
        // // engine.eval(Files.newBufferedReader(Paths.get(""),
        // StandardCharsets.UTF_8));

        // Invocable inv = (Invocable) engine;
        // // call function from script file
        // String temp = (String) inv.invokeFunction("functionDemo2", "Vidusha");

        // return temp;

        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        try {

            File file = ResourceUtils.getFile("src/main/resources/check_along_route.js");
            // File file = ResourceUtils.getFile("src/main/resources/bundle.js");

            engine.eval(new FileReader(file));
            Invocable invocable = (Invocable) engine;
            Object result;
            result = invocable.invokeFunction("functionDemo111", "Vidusha");

            System.out.println("result is " + result);
            System.out.println("result class is " + result.getClass());

        } catch (FileNotFoundException | NoSuchMethodException | ScriptException e) {
            e.printStackTrace();
        }

        return null;

        // try {
        // let response = await fetch('/no-user-here');
        // let user = await response.json();
        // } catch(err) {
        // // catches errors both in fetch and response.json
        // alert(err);
        // }

    }
}
