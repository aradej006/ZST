package com.pw.zst.service;

import com.pw.zst.DTO.LogTypeDTO;
import com.pw.zst.entities.LogType;
import com.pw.zst.repositories.LogTypeRepository;
import com.pw.zst.translators.LogTypeTranslator;

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
public class LogTypeService {

    @Inject
    LogTypeRepository logTypeRepository;

    @PostConstruct
    public void init(){
        logTypeRepository.toString();
    }

    public void save(LogTypeDTO logTypeDTO){
        if( logTypeRepository.findByLogType(logTypeDTO.getLogType()).size() == 0) {
            logTypeRepository.save(LogTypeTranslator.toEntity(logTypeDTO));
        }else{
            System.out.println("LogType is exist");
        }
    }

    public List<LogTypeDTO> findAll(){
        List<LogTypeDTO> logTypeDTOList = new LinkedList<LogTypeDTO>();
        for(LogType logType : logTypeRepository.findAll()){
            logTypeDTOList.add( LogTypeTranslator.toDTO(logType));
        }
        return logTypeDTOList;
    }

}
