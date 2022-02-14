package com.rooms.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rooms.spring.model.Rooms;
import com.rooms.spring.repository.RoomsRepository;



@Service
public class RoomsService {
	@Autowired
	private RoomsRepository roomsRepository;
	
	public Rooms create(String name, String[] imageurls, long rentperday, String type, int maxcount, long phonenumber,
			String[] currentbookings, String description) {
				return roomsRepository.save(new Rooms(name,imageurls,rentperday,type,maxcount,phonenumber,currentbookings,description));
		
	}
	
	public Rooms create(Rooms obj) {
				return roomsRepository.save(obj);
		
	}
	
	public List<Rooms> getAllRooms(){
		return roomsRepository.findAll();
		
	}
	public Rooms findById(String id) {
		return roomsRepository.findByid(id);
		
	}
	public Rooms update(int roomid) {
		return null;
		
	}
	public void deleteById(String id) {
		Rooms r=findById(id);
		roomsRepository.delete(r);
	}

	public Rooms getRoom(String id) {
		List<Rooms> rooms=getAllRooms();
		return rooms.stream().filter(room -> room.getId().equals(id)).findAny().orElse(null);
	}

}
