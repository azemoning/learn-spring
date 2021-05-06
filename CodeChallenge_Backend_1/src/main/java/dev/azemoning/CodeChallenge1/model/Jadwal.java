package dev.azemoning.CodeChallenge1.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "jadwal")
@Data
public class Jadwal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String hari;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "mata_pelajaran_id")
    private MataPelajaran mataPelajaran;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "kelas_id")
    private Kelas kelas;
}
