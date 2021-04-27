package dev.azemoning.starter.service;

import com.mongodb.client.result.DeleteResult;
import dev.azemoning.starter.model.Barang;

import java.util.List;

public interface CrudBarangService {
    List<Barang> getAllBarang();
    Barang getBarangById(String id);
    Barang addBarang(Barang barang);
    Barang updateBarang(String id, Barang barang);
    Barang deleteBarang(String id);
    Barang searchBarangByName(String name);
}
