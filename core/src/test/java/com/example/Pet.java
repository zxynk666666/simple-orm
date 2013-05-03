package com.example;

import com.thoughtworks.orm.annotations.Column;
import com.thoughtworks.orm.annotations.Table;

@Table("pets")
public class Pet {

    @Column
    private Integer id;
    @Column
    private String name;
    @Column
    private String gender;
    @Column
    private Integer age;


    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public Integer getAge() {
        return age;
    }
}
