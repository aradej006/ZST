package com.pw.zst.translators;

import com.pw.zst.DTO.LogTypeDTO;
import com.pw.zst.entities.LogType;

/**
 * Created by arade on 25-Oct-15.
 */
public final class LogTypeTranslator {

    public static LogType toEntity(LogTypeDTO logTypeDTO){
        LogType logType = new LogType();
        logType.setLogType(logTypeDTO.getLogType());
        return logType;
    }

    public static LogTypeDTO toDTO(LogType logType){
        LogTypeDTO logTypeDTO = new LogTypeDTO();
        logTypeDTO.setLogType(logType.getLogType());
        return logTypeDTO;
    }
}
