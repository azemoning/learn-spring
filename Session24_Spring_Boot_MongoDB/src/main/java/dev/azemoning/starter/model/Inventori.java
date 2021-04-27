package dev.azemoning.starter.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Data
public class Inventori {
    @Id
    private String id;
    private Date dateIn;
    private Date dateOut;
    private Barang barang;
}
