package app.controller;

import org.springframework.web.bind.annotation.RestController;

import app.model.Landmark;
import app.model.Location;
import app.service.LandmarkService;

import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@RequestMapping("/api/landmark")
public class LandmarkController {
	
	private final LandmarkService landmarkService;
	
	@Autowired
	LandmarkController (LandmarkService landmarkService) {
		this.landmarkService = landmarkService;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	String getLandmarkByLocation(@RequestBody @Valid Location location) {
		// Get landmark
		float latitude = location.getLatitude();
		float longitude = location.getLongitude();
		float[] coordinates = {latitude, longitude};
		Landmark landmark = landmarkService.getLandmarkByLocation(coordinates);
		return landmark.customString();
	}
	
	@RequestMapping(method = RequestMethod.PUT) 
	@ResponseStatus(HttpStatus.CREATED)
	Landmark create(@RequestBody @Valid Landmark landmark) {
		System.out.println("weare before create");
		Landmark toReturn = this.landmarkService.createLandmark(landmark);
		System.out.println("We are in create " + toReturn.customString());
		return toReturn;
	}
	

}
