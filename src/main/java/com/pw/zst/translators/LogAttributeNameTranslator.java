package com.pw.zst.translators;

import com.pw.zst.DTO.LogAttributeNameDTO;
import com.pw.zst.entities.LogAttributeName;

/**
 * Created by arade on 28-Oct-15.
 */
public final class LogAttributeNameTranslator {

    public static LogAttributeName toEntity(LogAttributeNameDTO logAttributeNameDTO){
        LogAttributeName logAttributeName = new LogAttributeName();
        logAttributeName.setName(logAttributeNameDTO.getName());
        return logAttributeName;
    }

    public static LogAttributeNameDTO toDTO(LogAttributeName logAttributeName){
        LogAttributeNameDTO logAttributeNameDTO = new LogAttributeNameDTO();
        logAttributeNameDTO.setName(logAttributeName.getName());
        return logAttributeNameDTO;
    }



}
