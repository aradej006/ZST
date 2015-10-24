package com.pw.zst.translators;

import com.pw.zst.DTO.LogEntityDTO;
import com.pw.zst.entities.LogEntity;

/**
 * Created by arade on 24-Oct-15.
 */
public final class LogEntityTranslator {

    public static LogEntity toEntity(LogEntityDTO logEntityDTO){
        LogEntity logEntity = new LogEntity();
        logEntity.setLogDate(logEntityDTO.getLogDate());
        logEntity.setLogType(logEntityDTO.getLogType());
        logEntity.setAtr1(logEntityDTO.getAtr1());
        logEntity.setAtr2(logEntityDTO.getAtr2());
        logEntity.setAtr3(logEntityDTO.getAtr3());
        logEntity.setId(logEntityDTO.getId());
        return logEntity;
    }

    public static LogEntityDTO toDTO(LogEntity logEntity){
        LogEntityDTO logEntityDTO = new LogEntityDTO();
        logEntityDTO.setLogDate(logEntity.getLogDate());
        logEntityDTO.setLogType(logEntity.getLogType());
        logEntityDTO.setAtr1(logEntity.getAtr1());
        logEntityDTO.setAtr2(logEntity.getAtr2());
        logEntityDTO.setAtr3(logEntity.getAtr3());
        logEntityDTO.setId(logEntity.getId());
        return  logEntityDTO;
    }
}
