package com.company.dto;

import com.company.validation.groups.UpdateOperation;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;


@Data
public class StudentDto implements Serializable {

    @Positive(groups = UpdateOperation.class,message = "Id can not be blank for update")
    private Integer id;
    @NotNull
    @NotBlank(message = "Name can not be blank")
    private String name;
    //@ApiModelProperty(example = "01719461643")
    private String mobile;
    //@ApiModelProperty(example = "akash073@gmail.com")
    private String email;


    private String myCustomName;

/*
    @ContactInfo(message = "Contact info is not correct")
    @NotNull
    private String contactInfo;*/
}
