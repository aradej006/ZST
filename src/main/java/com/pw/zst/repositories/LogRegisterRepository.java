package com.pw.zst.repositories;

import com.pw.zst.entities.LogRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by arade on 25-Oct-15.
 */
@Repository
public interface LogRegisterRepository extends JpaRepository<LogRegister, Long>{

    List<LogRegister> findByRegisterName(String registerName);

}
