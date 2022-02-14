package com.rooms.spring.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rooms.spring.model.Rooms;
import com.rooms.spring.model.RoomsRequest;
import com.rooms.spring.model.RoomsResponse;
import com.rooms.spring.service.RoomsService;

@CrossOrigin
@RestController
public class RoomsController {
	@Autowired
	private RoomsService roomsService;
	
//	@PostMapping("/rooms")
//	public String create(@RequestBody RoomsRequest roomsRequest) {
//		System.out.println(roomsRequest.toString());
//		Rooms r=roomsService.create(roomsRequest.getName(), roomsRequest.getImageurls(), roomsRequest.getRentperday(), roomsRequest.getType(), roomsRequest.getMaxcount(), roomsRequest.getPhonenumber(), roomsRequest.getCurrentbookings(), roomsRequest.getDescription());
//		return r.toString();
//	}
	
	@PostMapping("/rooms")
	private ResponseEntity<?> create(@RequestBody Rooms roomsRequest) {
		try {
			roomsService.create(roomsRequest);	
		} catch (Exception e) {
			return ResponseEntity.ok(new RoomsResponse("error"));
		}
		
		return ResponseEntity.ok(new RoomsResponse("ok"));
	}
	
	@GetMapping("/rooms")
	public List<Rooms> getAllRooms() {
		return roomsService.getAllRooms();
		
	}
	
	@GetMapping("/rooms/{id}")
	public Rooms getRoom(@PathVariable("id") String id) {
		return roomsService.getRoom(id);
	}
	
	@DeleteMapping("/rooms/{id}")
	private ResponseEntity<?> delete(@PathVariable String id) {
		try {
			if(id!="") {
				roomsService.deleteById(id);
			}	
		} catch (Exception e) {
			return ResponseEntity.ok(new RoomsResponse("deletion unsuccessful"));
		}
		
		return ResponseEntity.ok(new RoomsResponse("Deleted "+id));
	}
	
}
