package com.pw.zst.service;

import com.pw.zst.DTO.LogRegisterDTO;
import com.pw.zst.entities.LogRegister;
import com.pw.zst.repositories.LogRegisterRepository;
import com.pw.zst.translators.LogRegisterTranslator;

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
public class LogRegisterService {

    @Inject
    LogRegisterRepository logRegisterRepository;

    @PostConstruct
    public void init(){
        logRegisterRepository.toString();
    }

    public void save(LogRegisterDTO logRegisterDTO){
        if( logRegisterRepository.findByRegisterName(logRegisterDTO.getRegisterName()).size() == 0){
            logRegisterRepository.save(LogRegisterTranslator.toEntity(logRegisterDTO));
        }else{
            System.out.println("LogRegister is exist with registerName="+logRegisterDTO.getRegisterName());
        }
    }

    public List<LogRegisterDTO> findAll(){
        List<LogRegisterDTO> logRegisterDTOList = new LinkedList<LogRegisterDTO>();
        for(LogRegister logRegister: logRegisterRepository.findAll()){
            logRegisterDTOList.add( LogRegisterTranslator.toDTO(logRegister));
        }
        return logRegisterDTOList;
    }

    public List<LogRegisterDTO> findByRegisterName(String registerName){
        List<LogRegister> logRegisterList = logRegisterRepository.findByRegisterName(registerName);
        List<LogRegisterDTO> logRegisterDTOList = new LinkedList<LogRegisterDTO>();
        for(LogRegister logRegister: logRegisterList){
            logRegisterDTOList.add(LogRegisterTranslator.toDTO(logRegister));
        }
        return logRegisterDTOList;
    }

}
