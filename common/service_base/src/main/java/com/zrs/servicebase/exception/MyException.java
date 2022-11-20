package com.zrs.servicebase.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyException extends Exception{
    private Integer code;
    private String msg;

}
