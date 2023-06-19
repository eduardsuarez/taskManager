package com.dev.taskManager.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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