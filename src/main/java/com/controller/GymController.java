package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.GymDTO;
import com.service.GymService;

@RequestMapping("jenkins/api/v1")
@RestController
public class GymController {
	
	@Autowired
	GymService gymservice;
	
	@GetMapping("/info")
	public String testMethod() {
		
		return "Just a test!";
	}
	
	//get all Gym Members
	@GetMapping("/members")
	public ResponseEntity<List<GymDTO>> allMembers(){
		
		List<GymDTO> gdtolist= gymservice.getAllMembers();
		
		return new ResponseEntity<>(gdtolist,HttpStatus.OK);
	}
	
	//Find by Member ID
	@GetMapping("/members/{memberid}")
	public ResponseEntity<?> getOneMember(@PathVariable int memberid){
		
		GymDTO gdto = gymservice.findMember(memberid);
		
		if (gdto != null) {
			return new ResponseEntity<>(gdto,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>("No member Found with that MemberID. Try again!", HttpStatus.NOT_FOUND);
		}
	}
	
	//Register a new Gym member
	@PostMapping("/members")
	public ResponseEntity<String> addMember(@RequestBody GymDTO gdto) {
		
		gymservice.registerNewMember(gdto);
		return new ResponseEntity<>("Member registered Successfully!!",HttpStatus.OK);
	}
	
	//Update by ID
	@PutMapping("/members/{memberid}")
	public ResponseEntity<String> editMember(@RequestBody GymDTO gdto){
		
		gymservice.updateMember(gdto);
		return new ResponseEntity<>("Member Updated SuccessFully!!",HttpStatus.OK);
	}
	
	//Delete by ID
	@DeleteMapping("/members/{memberid}")
	public ResponseEntity<String> deleteMember(@PathVariable int memberid){
		
		gymservice.removeMember(memberid);
		return new ResponseEntity<>("Member Deleted SuccessFully!!",HttpStatus.OK);
	}

}

















