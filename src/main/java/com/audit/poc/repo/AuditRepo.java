package com.audit.poc.repo;
import org.springframework.data.repository.CrudRepository;

import com.audit.poc.entity.Audit;

public interface AuditRepo extends CrudRepository<Audit, Long>{
	
}
