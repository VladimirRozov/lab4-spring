package main.lab.controller;

import com.google.gson.Gson;
import main.lab.service.PointsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/results") //страница с резами
public class PointController {
    @Autowired
    private PointsService resultService;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseEntity getAllResults(@RequestParam("sessionID") String sessionID) {
        return ResponseEntity.ok(new Gson().toJson(resultService.getAllResults(sessionID)));
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseEntity addResult(@RequestParam("x") String strX,
                             @RequestParam("y") String strY,
                             @RequestParam("r") String strR,
                             @RequestParam("user") String sessionID) {
        Pair<Boolean, Boolean> result = resultService.addResult(strX, strY, strR, sessionID);
        if (result.getFirst())
            return ResponseEntity.ok("{\"checking\": \"" + result.getSecond() + "\"}");
        else
            return ResponseEntity.badRequest().body("Illegal set of arguments");
    }

    @RequestMapping(value = "/disablesession", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseEntity disableSession(@RequestParam("user") String sessionID) {
        resultService.disableSession(sessionID);
        return ResponseEntity.ok().body("Session was disabled");
    }
}
