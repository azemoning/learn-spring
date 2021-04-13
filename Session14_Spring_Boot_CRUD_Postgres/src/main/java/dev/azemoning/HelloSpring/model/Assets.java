package dev.azemoning.HelloSpring.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "assets")
@Data
public class Assets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column
    private String name;

    @Column
    private Integer qty;

    @Column
    private Integer price;
}
