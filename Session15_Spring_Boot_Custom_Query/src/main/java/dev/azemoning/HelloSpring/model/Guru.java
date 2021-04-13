package dev.azemoning.HelloSpring.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "guru")
@Data
public class Guru {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nama")
    private Long nama;

    @Column(name = "alamat")
    private Long alamat;

    @Column(name = "umur")
    private Integer umur;
}
