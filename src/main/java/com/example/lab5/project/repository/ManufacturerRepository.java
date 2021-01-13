package com.example.lab5.project.repository;

import com.example.lab5.project.entity.Manufacturer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ManufacturerRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    //RequestParam with PathVariable
    public Manufacturer getManufacturerID(int id, String location) {
        Manufacturer manufacturer = jdbcTemplate.queryForObject("SELECT * FROM manufacturers WHERE id = ? and location = ?",
                new Object[]{id, location},
                (response, rowNumber) ->
                        new Manufacturer(response.getInt("id"),
                                response.getString("location"),
                                response.getFloat("sales"),
                                response.getFloat("marketCap")));
        return manufacturer;
    }


    public List<Manufacturer> getManufacturers() {
        List<Manufacturer> manufacturers = jdbcTemplate.query("SELECT * FROM manufacturers",
                (response, rowNumber) ->
                        new Manufacturer(response.getInt("id"),
                                response.getString("location"),
                                response.getFloat("sales"),
                                response.getFloat("marketCap")));
        return manufacturers;
    }

    public void saveManufacturer(Manufacturer manufacturer){
        jdbcTemplate.update("INSERT INtO manufacturers(location, sales, marketCap) VALUES(?, ?, ?)",
                manufacturer.getLocation(), manufacturer.getSales(), manufacturer.getMarketCap());
    }

    public void updateManufacturer(int id, Manufacturer manufacturer) {
        jdbcTemplate.update("UPDATE manufacturers SET location = ?, sales = ? WHERE id = ?",
                manufacturer.getLocation(), manufacturer.getSales(), id);
    }

    public void deleteManufacturer(int id) {
        jdbcTemplate.update("DELETE from manufacturers where id = ?", id);
    }

}
