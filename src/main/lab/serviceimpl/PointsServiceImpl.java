package main.lab.serviceimpl;

import org.springframework.data.util.Pair;
import main.lab.model.Points;
import main.lab.repository.PointsCrudRepository;
import main.lab.service.PointsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PointsServiceImpl implements PointsService {

    @Autowired
    private PointsCrudRepository resultCrudRepository;

    private static float equalsXArray[] = new float[]{-3, -2, -1,  0, 1, 2,3,4,5};
    private static float equalsRArray[] = new float[]{-3, -2, -1,  0, 1, 2,3,4,5};

    @Override
    public Pair<Boolean, Boolean> addResult(String strX, String strY, String strR, String sessionID) {
        float x, y, r;
        try {
            x = Float.parseFloat(strX);
            y = Float.parseFloat(strY);
            r = Float.parseFloat(strR);
        } catch (Exception e) {
            return Pair.of(false, false);
        }
        if (Arrays.binarySearch(equalsXArray, x) < 0
                || Arrays.binarySearch(equalsRArray, r) < 0
                || y < -3 || y > 5)
            return Pair.of(false, false);
        boolean checking = (x <= r && x > 0 && y <= 0 && y >= -r) ||
                (x >= 0 && y >= 0 && y <= -x + r / 2) ||
                (x <= 0 && y <= 0 && y * y + x * x < r * r/4);
        int check=0;
        if (checking){
            check=1;
        }
        Points result = new Points(x, y, r, check, sessionID);
        resultCrudRepository.save(result);
        return Pair.of(true, checking);
    }

    @Override
    public List<Points> getAllResults(String sessionID) {
        List<Points> results = resultCrudRepository.findAllBySessionID(sessionID);
        results.forEach(e -> e.setId(null));
        results.forEach(e -> e.setUser(null));
        return results;
    }
    @Override
    public void disableSession(String sessionID) {
        resultCrudRepository.deleteAllBySessionID(sessionID);
    }
}
