package com.pw.zst.translators;

import com.pw.zst.DTO.LogAttributeDTO;
import com.pw.zst.entities.LogAttribute;

/**
 * Created by aradej on 2015-10-28.
 */
public final class LogAttributeTranslator {

    public static LogAttribute toEntity(LogAttributeDTO logAttributeDTO){
        LogAttribute logAttribute = new LogAttribute();
        logAttribute.setValue(logAttributeDTO.getValue());
        return logAttribute;
    }

    public static LogAttributeDTO toDTO(LogAttribute logAttribute){
        LogAttributeDTO logAttributeDTO = new LogAttributeDTO();
        logAttributeDTO.setValue(logAttribute.getValue());
        return logAttributeDTO;
    }

}
