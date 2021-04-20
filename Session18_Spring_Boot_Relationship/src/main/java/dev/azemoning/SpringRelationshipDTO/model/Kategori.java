package dev.azemoning.SpringRelationshipDTO.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "kategori")
@Data
public class Kategori {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nama;

    @JsonManagedReference
    @OneToMany(mappedBy = "kategori")
    private List<Barang> barangs;
}
