package org.sid.data;

import java.util.List;

import org.sid.entities.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OperationRepository extends JpaRepository<Operation, Long> {
	@Query(value = "select * from Operation where code_compte = (:accountId)",   nativeQuery = true)
	public List<Operation> getByAccount(String accountId);
}
