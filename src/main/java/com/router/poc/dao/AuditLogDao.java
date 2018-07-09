package com.router.poc.dao;

import com.router.poc.entity.Audit;

public interface AuditLogDao {
	
	public void saveAuditLog(Audit audit);

}
