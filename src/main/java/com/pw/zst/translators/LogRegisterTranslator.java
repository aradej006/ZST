package com.pw.zst.translators;

import com.pw.zst.DTO.LogRegisterDTO;
import com.pw.zst.entities.LogRegister;

/**
 * Created by arade on 25-Oct-15.
 */
public final class LogRegisterTranslator {

    public static LogRegister toEntity(LogRegisterDTO logRegisterDTO){
        LogRegister logRegister = new LogRegister();
        logRegister.setRegisterName(logRegisterDTO.getRegisterName());
        logRegister.setAttributesQuantity(logRegisterDTO.getAttributesQuantity());
        return logRegister;
    }

    public static LogRegisterDTO toDTO(LogRegister logRegister){
        LogRegisterDTO logRegisterDTO = new LogRegisterDTO();
        logRegisterDTO.setRegisterName(logRegister.getRegisterName());
        logRegisterDTO.setAttributesQuantity(logRegister.getAttributesQuantity());
        return logRegisterDTO;
    }
}
