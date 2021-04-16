package com.company.repository.impl;

import com.company.entity.Student;
import com.company.repository.StudentRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class StudentRepositoryCustomImpl implements StudentRepositoryCustom {

    @PersistenceContext
    private EntityManager manager;


    @Override
    public List<Student> getStudentsByHql() {
        List<Student> studentList
                = manager.createQuery("Select a From Student a", Student.class)
                .getResultList();
        return studentList;
    }
}
