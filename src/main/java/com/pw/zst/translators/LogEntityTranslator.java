package com.pw.zst.translators;

import com.pw.zst.DTO.LogAttributeDTO;
import com.pw.zst.DTO.LogEntityDTO;
import com.pw.zst.entities.LogAttribute;
import com.pw.zst.entities.LogEntity;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by arade on 24-Oct-15.
 */
public final class LogEntityTranslator {

    public static LogEntity toEntity(LogEntityDTO logEntityDTO) {
        LogEntity logEntity = new LogEntity();
        logEntity.setLogDate(logEntityDTO.getLogDate());
        logEntity.setLogType(LogTypeTranslator.toEntity(logEntityDTO.getLogTypeDTO()));
        logEntity.setId(logEntityDTO.getId());
        logEntity.setLogRegister(LogRegisterTranslator.toEntity(logEntityDTO.getLogRegisterDTO()));
        logEntity.setSourceId(logEntityDTO.getSourceId());
        List<LogAttribute> logAttributes = new LinkedList<LogAttribute>();
        LogAttribute logAttribute;
        for (LogAttributeDTO logAttributeDTO : logEntityDTO.getLogAttributeDTOs()) {
            logAttribute = LogAttributeTranslator.toEntity(logAttributeDTO);
            logAttribute.setLogEntity(logEntity);
            logAttributes.add(logAttribute);
        }
        logEntity.setLogAttributes(logAttributes);
        return logEntity;
    }

    public static LogEntityDTO toDTO(LogEntity logEntity) {
        LogEntityDTO logEntityDTO = new LogEntityDTO();
        logEntityDTO.setLogDate(logEntity.getLogDate());
        logEntityDTO.setLogTypeDTO(LogTypeTranslator.toDTO(logEntity.getLogType()));
        logEntityDTO.setId(logEntity.getId());
        logEntityDTO.setLogRegisterDTO(LogRegisterTranslator.toDTO(logEntity.getLogRegister()));
        logEntityDTO.setSourceId(logEntity.getSourceId());
        List<LogAttributeDTO> logAttributeDTOs = new LinkedList<LogAttributeDTO>();
        for (LogAttribute logAttribute: logEntity.getLogAttributes()){
            logAttributeDTOs.add(LogAttributeTranslator.toDTO(logAttribute));
        }
        logEntityDTO.setLogAttributeDTOs(logAttributeDTOs);
        return logEntityDTO;
    }
}
