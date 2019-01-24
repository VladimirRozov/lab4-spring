package main.lab.repository;

import main.lab.model.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UsersCrudRepository extends CrudRepository<Users, Long>{


    Users save(Users users);

    Optional<Users> findById(Long id);

    void deleteById(Long id);

    Optional<Users> findByUsername(String username);

    List<Users> findAll();
}
