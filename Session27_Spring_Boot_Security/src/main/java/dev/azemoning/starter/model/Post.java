package dev.azemoning.starter.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "posts")
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
