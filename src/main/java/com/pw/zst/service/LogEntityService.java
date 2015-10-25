package com.pw.zst.service;

import com.pw.zst.DTO.LogEntityDTO;
import com.pw.zst.entities.LogEntity;
import com.pw.zst.repositories.LogEntityRepository;
import com.pw.zst.translators.LogEntityTranslator;
import sun.rmi.runtime.Log;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by arade on 25-Oct-15.
 */
@Stateless
@Named
public class LogEntityService {

    @Inject
    private LogEntityRepository logEntityRepository;

    @PostConstruct
    public void init(){
        logEntityRepository.toString();
    }

    public void save(LogEntityDTO logEntityDTO){
        logEntityRepository.save(LogEntityTranslator.toEntity(logEntityDTO));
    }

    public List<LogEntityDTO> findAll(){
        List<LogEntityDTO> logEntityDTOList = new LinkedList<LogEntityDTO>();
         for(LogEntity logEntity : logEntityRepository.findAll()){
             logEntityDTOList.add( LogEntityTranslator.toDTO(logEntity));
         }
        return logEntityDTOList;
    }

}
