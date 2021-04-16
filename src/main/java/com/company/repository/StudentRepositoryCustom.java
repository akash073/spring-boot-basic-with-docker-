package com.company.repository;

import com.company.entity.Student;

import java.util.List;

public interface StudentRepositoryCustom {

    public List<Student> getStudentsByHql();
}
