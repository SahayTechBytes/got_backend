package com.got.familytree.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.got.familytree.model.ActorEntity;

public interface ActorEntityRepository extends JpaRepository<ActorEntity, Long> {

}
