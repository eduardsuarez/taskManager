/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.taskManager.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author eduar
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String  title;
    private String description;
    private Date creationDate;
    private Date expirationDate;
    private Boolean  completed;

    @ManyToOne
    @JoinColumn(name = "userId")
    @JsonIgnoreProperties("tasks")
    private User user;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "task-category",
            joinColumns = {@JoinColumn(name = "taskId")},
            inverseJoinColumns = {@JoinColumn(name = "categoryId")}
    )
    private Set<CategoryTask> categoryTasks = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "stateId")
    @JsonIgnoreProperties("tasks")
    private StatusTask statusTask;

    @OneToMany(cascade = { CascadeType.PERSIST}, mappedBy = "task")
    @JsonIgnoreProperties("task")
    private Set<Comment> comments;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "task-label",
            joinColumns = {@JoinColumn(name = "taskId")},
            inverseJoinColumns = {@JoinColumn(name = "labelId")}
    )
    private Set<Label> labels = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "priorityId")
    @JsonIgnoreProperties("tasks")
    private PriorityTask priorityTask;
    
}
