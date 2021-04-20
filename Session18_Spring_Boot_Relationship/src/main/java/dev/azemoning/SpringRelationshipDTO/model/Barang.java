package dev.azemoning.SpringRelationshipDTO.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "barang")
@Data
public class Barang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nama;
    private Integer qty;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "kategori_id")
    private Kategori kategori;
}
