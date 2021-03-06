package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {


	@Autowired
	WhiskyRepository whiskyRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canGetWhiskyByName(){
		Whisky found = whiskyRepository.findWhiskyByName("The Glendronach Revival");
		assertEquals("The Glendronach Revival",found.getName());
	}

	@Test
	public void canGetWhiskyByDistillery(){

		List<Distillery> found = whiskyRepository.findDestilleryWithWhiskyNamed("The Macallan Anniversary Malt");
//		assertEquals("Glendronach", found.get(0).getName());
	}
}
