package dev.azemoning.HelloSpring.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "aset")
@Data
public class Aset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nama;
    private Integer qty;

    @ManyToOne
    @JoinColumn(name = "kategori_id")
    private Kategori kategori;
}
