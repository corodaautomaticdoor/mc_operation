package com.coroda.repository;

import com.coroda.model.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<Operation,Integer> {
}
