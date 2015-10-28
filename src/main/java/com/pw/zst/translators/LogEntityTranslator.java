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
        logEntity.setLogType(LogTypeTranslator.toEntity(logEntityDTO.getLogTypeDTO()));
        logEntity.setAtr1(logEntityDTO.getAtr1());
        logEntity.setAtr2(logEntityDTO.getAtr2());
        logEntity.setAtr3(logEntityDTO.getAtr3());
        logEntity.setAtr4(logEntityDTO.getAtr4());
        logEntity.setAtr5(logEntityDTO.getAtr5());
        logEntity.setAtr6(logEntityDTO.getAtr6());
        logEntity.setAtr7(logEntityDTO.getAtr7());
        logEntity.setAtr8(logEntityDTO.getAtr8());
        logEntity.setAtr9(logEntityDTO.getAtr9());
        logEntity.setAtr10(logEntityDTO.getAtr10());
        logEntity.setId(logEntityDTO.getId());
        logEntity.setLogRegister(LogRegisterTranslator.toEntity(logEntityDTO.getLogRegisterDTO()));
        logEntity.setSourceId(logEntityDTO.getSourceId());
        return logEntity;
    }

    public static LogEntityDTO toDTO(LogEntity logEntity){
        LogEntityDTO logEntityDTO = new LogEntityDTO();
        logEntityDTO.setLogDate(logEntity.getLogDate());
        logEntityDTO.setLogTypeDTO(LogTypeTranslator.toDTO(logEntity.getLogType()));
        logEntityDTO.setAtr1(logEntity.getAtr1());
        logEntityDTO.setAtr2(logEntity.getAtr2());
        logEntityDTO.setAtr3(logEntity.getAtr3());
        logEntityDTO.setAtr4(logEntity.getAtr4());
        logEntityDTO.setAtr5(logEntity.getAtr5());
        logEntityDTO.setAtr6(logEntity.getAtr6());
        logEntityDTO.setAtr7(logEntity.getAtr7());
        logEntityDTO.setAtr8(logEntity.getAtr8());
        logEntityDTO.setAtr9(logEntity.getAtr9());
        logEntityDTO.setAtr10(logEntity.getAtr10());
        logEntityDTO.setId(logEntity.getId());
        logEntityDTO.setLogRegisterDTO(LogRegisterTranslator.toDTO(logEntity.getLogRegister()));
        logEntityDTO.setSourceId(logEntity.getSourceId());
        return  logEntityDTO;
    }
}
