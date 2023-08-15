package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.GymEntity;

public interface MagicDaoRepository extends JpaRepository<GymEntity,Integer>{

}
