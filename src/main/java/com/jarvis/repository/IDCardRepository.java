package com.jarvis.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.jarvis.entity.IDCard;

@Repository
public interface IDCardRepository extends PagingAndSortingRepository<IDCard, String>{

}
