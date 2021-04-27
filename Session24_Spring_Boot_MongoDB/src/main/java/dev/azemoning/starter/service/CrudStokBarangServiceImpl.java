package dev.azemoning.starter.service;

import dev.azemoning.starter.exception.ResourceNotFoundException;
import dev.azemoning.starter.model.Barang;
import dev.azemoning.starter.model.Inventori;
import dev.azemoning.starter.model.StokBarang;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrudStokBarangServiceImpl implements CrudStokBarangService{
    
    private final MongoTemplate mongoTemplate;

    public CrudStokBarangServiceImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<StokBarang> getAllStokBarang() {
        return mongoTemplate.findAll(StokBarang.class);
    }

    @Override
    public StokBarang getStokBarangById(String id) {
        return mongoTemplate.findById(id, StokBarang.class);
    }

    @Override
    public StokBarang addStokBarang(String barangId, StokBarang stokBarang) {
        Query query = new Query(Criteria.where("id").is(barangId));
        Barang findBarang = mongoTemplate.findOne(query, Barang.class, "barang");
        if (findBarang == null) {
            throw new ResourceNotFoundException("Barang not found");
        } else {
            stokBarang.setBarang(findBarang);
            mongoTemplate.insert(stokBarang);
            return stokBarang;
        }
    }

    @Override
    public StokBarang updateStokBarang(String id, StokBarang stokBarang) {
        StokBarang findStokBarang = mongoTemplate.findById(id, StokBarang.class);
        
        if (findStokBarang != null) {
            findStokBarang.setStock(stokBarang.getStock());
            return findStokBarang;
        } else {
            throw new ResourceNotFoundException("Stok Barang not found");
        }
    }

    @Override
    public StokBarang deleteStokBarang(String id) {
        StokBarang findStokBarang = mongoTemplate.findById(id, StokBarang.class);

        if (findStokBarang != null) {
            mongoTemplate.remove(findStokBarang);
            return findStokBarang;
        } else {
            throw new ResourceNotFoundException("Stok Barang not found");
        }
    }

    @Override
    public StokBarang searchStokBarangByBarangId(String barangId) {
        Barang findBarang = mongoTemplate.findById(barangId, Barang.class, "barang");
        if (findBarang != null) {
            Query query = new Query(Criteria.where("barang._id").is(findBarang.getId()));
            return mongoTemplate.findOne(query, StokBarang.class, "stokBarang");
        } else {
            throw new ResourceNotFoundException("Inventori not found");
        }
    }
}
