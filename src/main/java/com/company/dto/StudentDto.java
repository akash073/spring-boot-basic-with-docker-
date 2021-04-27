package com.company.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Data
public class StudentDto implements Serializable {

    /*  @Positive(groups = UpdateOperation.class,message = "Id can not be blank for update")
      private Integer id;*/
    @NotNull
    @NotBlank(message = "Name can not be blank")
    private String name;
    @Schema(description = "Phone number of the contact.", example = "62482211")
   // @Pattern(regexp ="^\\+?[0-9. ()-]{7,25}$", message = "Phone number")
    private String mobile;
    //@ApiModelProperty(example = "akash073@gmail.com")
    @Schema(example = "akash073@gmail.com")
    private String email;


    @Schema(hidden = true)
    private String myCustomName;

/*
    @ContactInfo(message = "Contact info is not correct")
    @NotNull
    private String contactInfo;*/
}
