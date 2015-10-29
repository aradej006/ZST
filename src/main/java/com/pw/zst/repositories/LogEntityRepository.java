package com.pw.zst.repositories;

import com.pw.zst.entities.LogEntity;
import com.pw.zst.entities.LogRegister;
import com.pw.zst.entities.LogType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sun.rmi.runtime.Log;

import java.util.Date;
import java.util.List;

/**
 * Created by arade on 24-Oct-15.
 */
@Repository
public interface LogEntityRepository extends JpaRepository<LogEntity, Long>{

    List<LogEntity> findByLogType(String logType);
    List<LogEntity> findByLogRegister(LogRegister logRegister);
    List<LogEntity> findByLogRegister_Name(String name);
    List<LogEntity> findByLogDateAndSourceIdAndLogRegisterAndLogType(Date logDate, Long sourceId, LogRegister logRegister, LogType logType);
}
