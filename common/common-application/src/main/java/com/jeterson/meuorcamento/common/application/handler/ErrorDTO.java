package com.jeterson.meuorcamento.common.application.handler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorDTO {
    private final String code;
    private final String message;
    private List<ErrorDTO> details;

    public void addError(String code, String message) {
        if (details == null)
            details = new ArrayList<>();

        details.add(new ErrorDTO(code, message, null));
    }

}
