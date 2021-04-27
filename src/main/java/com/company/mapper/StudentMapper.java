package com.company.mapper;

import com.company.dto.StudentDto;
import com.company.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface StudentMapper {

 @Mappings({
         //@Mapping(target="employeeId", source="entity.id"),
         @Mapping(target="myCustomName", source="student.name")
 })
  StudentDto getEntityFromModel(Student student);
}