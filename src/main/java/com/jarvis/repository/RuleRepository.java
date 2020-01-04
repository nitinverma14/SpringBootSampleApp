package com.jarvis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jarvis.entity.RuleInfo;


public interface RuleRepository extends JpaRepository<RuleInfo, Long> {

	List<RuleInfo> findByRuleName(String fname);
}
