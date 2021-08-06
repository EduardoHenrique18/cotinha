package com.cotinha.cotinha.exceptions;

import java.io.Serializable;
import lombok.Data;

@Data
public class StandardError implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer status;
    private String message;

    public StandardError(Integer status, String message) {
        super();
        this.status = status;
        this.message = message;
    }
}
