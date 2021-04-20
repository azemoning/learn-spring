package dev.azemoning.SpringRelationshipDTO.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "peminjaman_barang")
@Data
public class PeminjamanBarang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date tanggal_pinjam;
    private Date tanggal_pulang;

    @ManyToOne
    @JoinColumn(name = "barang_id")
    private Barang barang;
}
