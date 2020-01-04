package com.jarvis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jarvis.entity.MemberInfo;


public interface MockEpmpRepository extends JpaRepository<MemberInfo, Long> {

	 MemberInfo findByFirstNameIsLike(String fname);
}
