package com.mavenTask.webclient;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mavenTask.webspring.dtos.PersonDto;

@RestController
public class ClientRESTPerson {
	
	@RequestMapping("/peopleclient")
	public List<PersonDto> peopleList() {
		RestTemplate template = new RestTemplate();
		ResponseEntity<PersonDto[]> list = template.getForEntity("http://localhost:8083/people", PersonDto[].class);
		PersonDto[] newList = list.getBody();
		return Arrays.asList(newList);
	}

}
