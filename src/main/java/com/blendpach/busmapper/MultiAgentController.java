package com.blendpach.busmapper;

import java.io.IOException;

import javax.script.ScriptException;

import com.tripAgent;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MultiAgentController {

    @GetMapping("/agent")
    public String agentStart() throws ScriptException, NoSuchMethodException, IOException {

        tripAgent t1 = new tripAgent();
        t1.start();

        return "Agent Started ";

    }

    // @GetMapping("/agent/{id}/{routeid}")
    // public List<busAgentStat> gcheckAgentWithDatabase(@PathVariable("id") Float
    // id,
    // @PathVariable("routeid") Float routeid) throws ScriptException,
    // NoSuchMethodException, IOException {

    // return null;

    // }

}
