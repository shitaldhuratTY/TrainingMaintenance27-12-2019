package com.tyss.trainingmaintenance.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.tyss.trainingmaintenance.dto.CalendarEvent;

@Repository
public class CalendarEventDAOImpl implements CalendarEventDAO{

	@PersistenceUnit
	private EntityManagerFactory factory;
	

	@Override
	public CalendarEvent addEvent(CalendarEvent event) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(event);
			transaction.commit();
			return event;
		} catch (Exception e) {
			manager.close();
			e.printStackTrace();
			return null;
		}
	}


	@Override
	public List<CalendarEvent> getAllEvent() {
		EntityManager em = factory.createEntityManager();
		String queryStr="from CalendarEvent";
		Query query=em.createQuery(queryStr);
		return query.getResultList();
		
	}



}
