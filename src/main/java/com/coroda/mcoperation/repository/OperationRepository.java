package com.coroda.mcoperation.repository;

import com.coroda.mcoperation.model.entity.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {
    @Query("from Operation o where o.operationId =:operationId")
    List<Operation> searchId (@Param("operationId")Long operationId);

}
