package com.sample.api.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Name cannot be blank")
    @NonNull
    private String title;

    private int credits;
    

    @JsonIgnore
    @ManyToMany(
        mappedBy = "courses",
        cascade = CascadeType.ALL
    )
    private Set<Student> students;

    @OneToOne(
        mappedBy = "course"
    )
    @NotBlank(message = "Name cannot be blank")
    @NotNull
    @JsonIgnore
    @JoinColumn(
        name = "teacher_id"
    )
    private Teacher teacher;
}
