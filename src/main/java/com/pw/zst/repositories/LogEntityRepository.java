package com.pw.zst.repositories;

import com.pw.zst.entities.LogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by arade on 24-Oct-15.
 */
@Repository
public interface LogEntityRepository extends JpaRepository<LogEntity, Long>{

    List<LogEntity> findByLogType(String logType);
    List<LogEntity> findByLogRegister(String logRegister);

}
