package com.router.poc.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.router.poc.entity.Audit;

public class AuditLogDaoImpl implements AuditLogDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void saveAuditLog(Audit audit) {
		entityManager.persist(audit);
	}

}
