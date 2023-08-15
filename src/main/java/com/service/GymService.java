package com.service;

import java.util.List;

import com.dto.GymDTO;

public interface GymService {

	List<GymDTO> getAllMembers();
	
	void registerNewMember(GymDTO gdto);

	GymDTO findMember(int memberid);

	void updateMember(GymDTO gdto);

	void removeMember(int memberid);

}

