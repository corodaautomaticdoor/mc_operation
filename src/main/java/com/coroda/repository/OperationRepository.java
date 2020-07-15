package com.coroda.repository;

import com.coroda.entity.Operation;
import com.coroda.entity.TypeOperation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {

    @Query(" from Operation o where o.typeOperation =:typeOperation")
    List<Operation> searchTypeOperation(@Param("typeOperation") TypeOperation typeOperation);

    @Query(" from Operation o where o.client =:client")
    List<Operation> searchClient(@Param("client") String client);

    @Query("from Operation o where o.typeOperation =:typeOperation and o.client =:client")
    List<Operation> getData(@Param("typeOperation") TypeOperation typeOperation, @Param("client") String client);

    @Transactional
    @Modifying
    @Query(value = "update Operation o set o.typeOperation =:typeOperation WHERE o.operationId = :id")
    int updateType(Long id, TypeOperation typeOperation);


}
