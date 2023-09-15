package com.hillel.multi.infrastructure.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ErrorInfo {

    private String description;
    private String errorType;
    private String rootCause;
    private String exceptionMessage;
}
