package com.company.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by DELL on 31-Jul-19.
 */
@Builder
@Data
public class LoginDto implements Serializable {

    @ApiModelProperty(example = "01719461643")
    private String loginName;

    @ApiModelProperty(dataType = "String",example = "123456")
    private String password;
}
