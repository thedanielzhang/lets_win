package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.mongodb.MongoClient;

import app.model.Landmark;
import app.model.Location;
import app.repository.LandmarkRepository;

@Service
public class LandmarkService {
	
	private final LandmarkRepository landmarkRepository;
	
	@Autowired
	LandmarkService(LandmarkRepository landmarkRepository) {
		this.landmarkRepository = landmarkRepository;
	}
	
	public Landmark getLandmarkByLocation(float[] coordinates) {
		System.out.println(coordinates[0]);
		System.out.println(coordinates[1]);
		Point point = new Point(coordinates[0], coordinates[1]);
	    MongoOperations mongoOps = new MongoTemplate(new SimpleMongoDbFactory(new MongoClient(), "mydatabase"));

		List<Landmark> landmarks = 
				mongoOps.find(new Query(Criteria.where("location").near(point).maxDistance(100)), Landmark.class);
		return landmarks.get(0);
	}
	
	public Landmark createLandmark(Landmark landmark) {
		return landmarkRepository.save(landmark);
	}
	
	
	
}
