package dev.azemoning.CodeChallenge1.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "kelas")
@Data
public class Kelas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @JsonManagedReference
    @OneToMany(mappedBy = "kelas")
    private List<Siswa> siswa;

    @JsonManagedReference
    @OneToMany(mappedBy = "kelas")
    private List<Guru> guru;


}
