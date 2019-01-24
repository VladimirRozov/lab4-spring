package main.lab.repository;

import main.lab.model.Points;
import org.springframework.data.repository.CrudRepository;


import java.util.List;

public interface PointsCrudRepository  extends CrudRepository<Points, Long> {
    List<Points> findAllBySessionID(String sessionID);

    void deleteAllBySessionID(String sessionID);
}
