package com.jarvis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jarvis.entity.ActionIDInfo;


public interface ActionRepository extends JpaRepository<ActionIDInfo, Long> {

	//RuleInfo findByFirstNameIsLike(String fname);
	ActionIDInfo findByActionIDName(String actionIDName);
}
