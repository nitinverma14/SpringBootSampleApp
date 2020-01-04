package com.jarvis.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jarvis.dto.BatchExecution;

@Transactional
@Repository
public class CustomRepository {

	@Autowired
    private EntityManager entityManager;

	private Session getSession() {
        return entityManager.unwrap(Session.class);
    }
	 

	public List<BatchExecution> getBatchStatus() {
		List<BatchExecution> status = new ArrayList<>();
		try {
			String q = "SELECT EXIT_CODE,JOB_NAME,END_TIME FROM BATCH_JOB_EXECUTION BJE " + 
					"INNER JOIN BATCH_JOB_INSTANCE BJI ON BJE.JOB_INSTANCE_ID = BJI.JOB_INSTANCE_ID " + 
					"ORDER BY BJE.END_TIME DESC";
			Query query = getSession().createSQLQuery(q);
			List<Object[]> list = (List<Object[]>) query.getResultList();
			if(null != list && list.size() > 0) {
				for(Object[] o : list) {
					BatchExecution be = new BatchExecution();
					be.setExitCode(o[0].toString());
					be.setJobName(o[1].toString());
					be.setEndTime(o[2].toString());
					status.add(be);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	
}
