package com.coroda.mcoperation.repository;

import com.coroda.mcoperation.model.entity.Operation;
import com.coroda.mcoperation.model.entity.TypeOperation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {
    @Query("from Operation o where o.operationId =:operationId")
    List<Operation> searchId (@Param("operationId")Long operationId);

    @Query(" from Operation o where o.typeOperation =:typeOperation")
    List<Operation> searchTypeOperation(@Param("typeOperation") TypeOperation typeOperation);

    @Query(" from Operation o where o.numberDocument =:numberDocument")
    List<Operation> searchClient(@Param("numberDocument") long numberDocument);

    @Query("from Operation o where o.typeOperation =:typeOperation and o.numberDocument =:numberDocument")
    List<Operation> getData(@Param("typeOperation") TypeOperation typeOperation, @Param("numberDocument") long numberDocument);

    @Transactional
    @Modifying
    @Query(value = "update Operation o set o.typeOperation =:typeOperation WHERE o.operationId = :id")
    int updateType(Long id, TypeOperation typeOperation);
}
