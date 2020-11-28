package com.coroda.mcoperation.repository;

import com.coroda.mcoperation.model.entity.Operacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperacionRepository extends JpaRepository<Operacion, Long> {
    @Query("from Operacion o where o.operationId =:operationId")
    List<Operacion> searchId (@Param("operationId")Long operationId);

}
