package dev.azemoning.HelloSpring.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "aset")
@Data
public class Aset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nama")
    private String nama;

    @Column(name = "umur_aset")
    private Integer umur_aset;

    @Column(name = "jumlah_aset")
    private Integer jumlah_aset;
}
