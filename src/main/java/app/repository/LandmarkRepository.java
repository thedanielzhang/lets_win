package app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;


import app.model.Landmark;


public interface LandmarkRepository extends Repository<Landmark, String>{
	void delete(Landmark deleted);
    List<Landmark> findAll();
    Optional<Landmark> findById(String id);
    Landmark save(Landmark saved);
}
