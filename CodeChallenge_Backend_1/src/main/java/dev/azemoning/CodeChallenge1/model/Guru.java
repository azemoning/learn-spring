package dev.azemoning.CodeChallenge1.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "guru")
@Data
public class Guru {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String gender;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "kelas_id")
    private Kelas kelas;
}
