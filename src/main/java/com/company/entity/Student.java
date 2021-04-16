package com.company.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Entity(name="Student")
@Table(name="Student")
@Data
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false, columnDefinition = "BIGINT(11) UNSIGNED")
    private Integer id;

    @Column(nullable = false)
    private String name;
    private String mobile;
    private String email;
}
