package com.company.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


@Data
public class StudentDto implements Serializable {

    @ApiModelProperty(example = "akash")
    private String name;
    @ApiModelProperty(example = "01719461643")
    private String mobile;
    @ApiModelProperty(example = "akash073@gmail.com")
    private String email;
}
