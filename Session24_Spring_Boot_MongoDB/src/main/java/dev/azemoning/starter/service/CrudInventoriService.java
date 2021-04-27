package dev.azemoning.starter.service;

import dev.azemoning.starter.model.Inventori;

import java.util.List;

public interface CrudInventoriService {
    List<Inventori> getAllInventori();
    Inventori getInventoriById(String id);
    Inventori addInventori(String barangId, Inventori inventori);
    Inventori updateInventori(String id, Inventori inventori);
    Inventori deleteInventori(String id);
    Inventori searchInventoriByBarangId(String barangId);
}
