package dev.azemoning.starter.service;

import dev.azemoning.starter.model.StokBarang;

import java.util.List;

public interface CrudStokBarangService {
    List<StokBarang> getAllStokBarang();
    StokBarang getStokBarangById(String id);
    StokBarang addStokBarang(String barangId, StokBarang stokBarang);
    StokBarang updateStokBarang(String id, StokBarang stokBarang);
    StokBarang deleteStokBarang(String id);
    StokBarang searchStokBarangByBarangId(String barangId);
}
