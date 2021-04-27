package dev.azemoning.starter.service;

import dev.azemoning.starter.exception.ResourceNotFoundException;
import dev.azemoning.starter.model.Barang;
import dev.azemoning.starter.model.Inventori;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Queue;

@Repository
public class CrudInventoriServiceImpl implements CrudInventoriService{

    private final MongoTemplate mongoTemplate;

    public CrudInventoriServiceImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }


    @Override
    public List<Inventori> getAllInventori() {
        return mongoTemplate.findAll(Inventori.class);
    }

    @Override
    public Inventori getInventoriById(String id) {
        return mongoTemplate.findById(id, Inventori.class);
    }

    @Override
    public Inventori addInventori(String barangId, Inventori inventori) {
        Query query = new Query(Criteria.where("id").is(barangId));
        Barang findBarang = mongoTemplate.findOne(query, Barang.class, "barang");
        if (findBarang == null) {
            throw new ResourceNotFoundException("Barang not found");
        } else {
            inventori.setBarang(findBarang);
            mongoTemplate.insert(inventori);
            return inventori;
        }
    }

    @Override
    public Inventori updateInventori(String id, Inventori inventori) {
        Inventori findInventori = mongoTemplate.findById(id, Inventori.class);
        if (findInventori != null) {
            findInventori.setDateIn(inventori.getDateIn());
            findInventori.setDateOut(inventori.getDateOut());
            return findInventori;
        } else {
            throw new ResourceNotFoundException("Inventori not found");
        }
    }

    @Override
    public Inventori deleteInventori(String id) {
        Inventori findInventori = mongoTemplate.findById(id, Inventori.class);
        if (findInventori != null) {
            mongoTemplate.remove(findInventori);
            return findInventori;
        } else {
            throw new ResourceNotFoundException("Inventori not found");
        }
    }

    @Override
    public Inventori searchInventoriByBarangId(String barangId) {
        Barang findBarang = mongoTemplate.findById(barangId, Barang.class, "barang");
        if (findBarang != null) {
            Query query = new Query(Criteria.where("barang._id").is(findBarang.getId()));
            return mongoTemplate.findOne(query, Inventori.class, "inventori");
        } else {
            throw new ResourceNotFoundException("Inventori not found");
        }
    }
}
