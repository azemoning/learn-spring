package dev.azemoning.HelloSpring.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "siswa")
@Data
public class Siswa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nama")
    private String nama;

    @Column(name = "alamat")
    private String alamat;

    @Column(name = "umur")
    private Integer umur;
}
