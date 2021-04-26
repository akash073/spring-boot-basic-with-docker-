package com.company.dto;


import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by DELL on 31-Jul-19.
 */
@Builder
@Data
public class LoginDto implements Serializable {


    private String loginName;


    private String password;
}
