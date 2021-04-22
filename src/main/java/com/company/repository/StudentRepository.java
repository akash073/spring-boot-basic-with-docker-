package com.company.repository;

import com.company.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>,StudentRepositoryCustom {
}
interface StudentRepositoryCustom {

    public List<Student> getStudentsByHql();
}
@RequiredArgsConstructor
class StudentRepositoryCustomImpl implements StudentRepositoryCustom {

    private final EntityManager manager;

    @Override
    public List<Student> getStudentsByHql() {
        List<Student> studentList
                = manager.createQuery("Select a From Student a", Student.class)
                .getResultList();
        return studentList;
    }
}

