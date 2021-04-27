package dev.azemoning.starter.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Barang {
    @Id
    private String id;
    private String name;
}
