package main.lab.service;

import main.lab.model.Points;
import org.springframework.data.util.Pair;

import java.util.List;

public interface PointsService {

    Pair<Boolean, Boolean> addResult(String strX, String strY, String strR, String user);

    List<Points> getAllResults(String user);

    void disableSession(String user);
}
