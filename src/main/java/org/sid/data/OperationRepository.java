package org.sid.data;

import java.util.ArrayList;
import java.util.List;

import org.sid.entities.Operation;
import org.springframework.stereotype.Repository;

@Repository
public class OperationRepository {
	public Operation setOperation(Operation operation) {
        return operation;
    }

    public List<Operation> getAll(String accountId) {
        return new ArrayList<>();
    }
}
