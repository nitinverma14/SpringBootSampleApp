package com.jarvis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jarvis.entity.Template;
import com.jarvis.enums.TemplateEnum;


public interface TemplateRepository extends JpaRepository<Template, Long> {
	
	public List<Template> findAllByOrderByLastModifiedDateDesc();
	
	@Query("SELECT temp FROM Template temp WHERE temp.tempType=(:p1) AND temp.active= (:p2)")
    List<Template> findByTempTypeAndActiveByOrderByTitleAsc(@Param("p1") TemplateEnum tempType, @Param("p2") boolean active);
}
