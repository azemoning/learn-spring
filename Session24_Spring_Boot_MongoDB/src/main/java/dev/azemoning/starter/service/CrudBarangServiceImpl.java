package dev.azemoning.starter.service;

import dev.azemoning.starter.exception.ResourceNotFoundException;
import dev.azemoning.starter.model.Barang;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrudBarangServiceImpl implements CrudBarangService{
    private final MongoTemplate mongoTemplate;

    public CrudBarangServiceImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<Barang> getAllBarang() {
        return mongoTemplate.findAll(Barang.class);
    }

    @Override
    public Barang getBarangById(String id) {
        return mongoTemplate.findById(id, Barang.class);
    }

    @Override
    public Barang addBarang(Barang barang) {
        return mongoTemplate.insert(barang);
    }

    @Override
    public Barang updateBarang(String id, Barang barang) {
        Barang findBarang = mongoTemplate.findById(id, Barang.class);
        if (findBarang != null) {
            findBarang.setName(barang.getName());
            return mongoTemplate.save(findBarang);
        } else {
            throw new ResourceNotFoundException("Barang not found");
        }
    }

    @Override
    public Barang deleteBarang(String id) {
        Barang barang = mongoTemplate.findById(id, Barang.class);
        if (barang != null) {
            mongoTemplate.remove(barang);
            return barang;
        } else {
            throw new ResourceNotFoundException("Barang not found");
        }
    }

    @Override
    public Barang searchBarangByName(String name) {
        Query query = new Query(Criteria.where("name").is(name));
        Barang barang = mongoTemplate.findOne(query, Barang.class);
        if (barang != null) {
            return barang;
        } else {
            throw new ResourceNotFoundException("Barang not found");
        }
    }
}
