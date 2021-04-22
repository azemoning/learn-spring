package dev.azemoning.HelloSpring.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "kategori")
@Data
public class Kategori {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nama;
}
