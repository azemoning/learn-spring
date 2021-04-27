package dev.azemoning.starter.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "stokBarang")
@Data
public class StokBarang {
    @Id
    private String id;
    private Barang barang;
    private Integer stock;
}
