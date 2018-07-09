package com.router.poc.repo;
import org.springframework.data.repository.CrudRepository;

import com.router.poc.entity.Audit;

public interface AuditRepo extends CrudRepository<Audit, Long>{
	
}
