package com.pw.zst.translators;

import com.pw.zst.DTO.LogAttributeNameDTO;
import com.pw.zst.DTO.LogRegisterDTO;
import com.pw.zst.entities.LogAttributeName;
import com.pw.zst.entities.LogRegister;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by arade on 25-Oct-15.
 */
public final class LogRegisterTranslator {

    public static LogRegister toEntity(LogRegisterDTO logRegisterDTO){
        LogRegister logRegister = new LogRegister();
        logRegister.setName(logRegisterDTO.getName());
        List<LogAttributeName> logAttributeNames = new LinkedList<LogAttributeName>();
        LogAttributeName logAttributeName;
        for(LogAttributeNameDTO logAttributeNameDTO : logRegisterDTO.getLogAttributeNameDTOs()){
            logAttributeName = LogAttributeNameTranslator.toEntity(logAttributeNameDTO);
            logAttributeName.setLogRegister(logRegister);
            logAttributeNames.add(logAttributeName);
        }
        logRegister.setAttributeNames(logAttributeNames);
        return logRegister;
    }

    public static LogRegisterDTO toDTO(LogRegister logRegister){
        LogRegisterDTO logRegisterDTO = new LogRegisterDTO();
        logRegisterDTO.setName(logRegister.getName());
        List<LogAttributeNameDTO> logAttributeNameDTOs = new LinkedList<LogAttributeNameDTO>();
        for( LogAttributeName logAttributeName:logRegister.getAttributeNames()){
            logAttributeNameDTOs.add(LogAttributeNameTranslator.toDTO(logAttributeName));
        }
        logRegisterDTO.setLogAttributeNameDTOs(logAttributeNameDTOs);
        return logRegisterDTO;
    }
}
