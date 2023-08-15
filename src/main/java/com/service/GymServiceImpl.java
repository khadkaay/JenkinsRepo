package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.MagicDaoRepository;
import com.dto.GymDTO;
import com.entity.GymEntity;

@Service
@Transactional
public class GymServiceImpl implements GymService {
	
	@Autowired
	MagicDaoRepository magicdao;

	//Register a new Gym Member
	@Override
	public void registerNewMember(GymDTO gdto) {
		
		GymEntity gent = new GymEntity();
		BeanUtils.copyProperties(gdto, gent);
		magicdao.save(gent);
	}
	
	//To get all the Gym Members
	@Override
	public List<GymDTO> getAllMembers() {
		
		List<GymEntity> gentlist = magicdao.findAll();
		List<GymDTO> gdtolist = new ArrayList<>();
		
		if (gentlist.size()>0) {
			
			for(GymEntity temp:gentlist) {
				
				GymDTO gdto = new GymDTO();
				BeanUtils.copyProperties(temp, gdto);
				gdtolist.add(gdto);
			}
		}
		return gdtolist;
	}
	
	//Find a member by ID
	@Override
	public GymDTO findMember(int memberid) {
		
		Optional<GymEntity> optional = magicdao.findById(memberid);
		
		if(optional.isPresent()) {
			
			GymEntity gent = optional.get();
			GymDTO gdto = new GymDTO();
			BeanUtils.copyProperties(gent, gdto);
			return gdto;
		}
		return null;
	}

	@Override
	public void updateMember(GymDTO gdto) {
		
		GymEntity gent = new GymEntity();
		BeanUtils.copyProperties(gdto, gent);
		magicdao.save(gent);
	}

	@Override
	public void removeMember(int memberid) {
		
		magicdao.deleteById(memberid);
	}

}
