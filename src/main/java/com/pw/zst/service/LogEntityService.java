package com.pw.zst.service;

import com.pw.zst.DTO.LogEntityDTO;
import com.pw.zst.entities.LogEntity;
import com.pw.zst.entities.LogRegister;
import com.pw.zst.repositories.LogEntityRepository;
import com.pw.zst.repositories.LogRegisterRepository;
import com.pw.zst.repositories.LogTypeRepository;
import com.pw.zst.translators.LogEntityTranslator;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by arade on 25-Oct-15.
 */
@Stateless
@Named
public class LogEntityService {

    @Inject
    LogEntityRepository logEntityRepository;

    @Inject
    LogRegisterRepository logRegisterRepository;

    @Inject
    LogTypeRepository logTypeRepository;

    @PostConstruct
    public void init(){
        logEntityRepository.toString();
        logRegisterRepository.toString();
        logTypeRepository.toString();
    }


    public void save(LogEntityDTO logEntityDTO){
        LogEntity logEntity = LogEntityTranslator.toEntity(logEntityDTO);
        logEntity.setLogRegister(logRegisterRepository.findByName(logEntity.getLogRegister().getName()).get(0));
        logEntity.setLogType(logTypeRepository.findByLogType(logEntity.getLogType().getLogType()).get(0));
        logEntityRepository.save(logEntity);
    }

    public List<LogEntityDTO> findAll(){
        List<LogEntityDTO> logEntityDTOList = new LinkedList<LogEntityDTO>();
         for(LogEntity logEntity : logEntityRepository.findAll()){
             logEntityDTOList.add( LogEntityTranslator.toDTO(logEntity));
         }
        return logEntityDTOList;
    }

    public List<LogEntityDTO> findByLogRegister(String logRegister){
        List<LogEntityDTO> logEntityDTOList = new LinkedList<LogEntityDTO>();
        for(LogEntity logEntity : logEntityRepository.findByLogRegister(logRegister)){
            logEntityDTOList.add( LogEntityTranslator.toDTO(logEntity));
        }
        return logEntityDTOList;
    }

}
