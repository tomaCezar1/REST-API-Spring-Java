package com.example.lab5.project.repository;

import com.example.lab5.project.entity.Automobile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AutomobileRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public List<Automobile> getAutomobiles() {
        List<Automobile> automobile = jdbcTemplate.query("SELECT * FROM automobile",
                (response, rowNumber) ->
                new Automobile(response.getLong("id"),
                        response.getString("brand"),
                        response.getString("country"),
                        response.getInt("price"),
                        response.getString("power")));
        return automobile;
    }

    public Automobile getCar(long id) {
        Automobile automobile = jdbcTemplate.queryForObject("SELECT * FROM automobile WHERE id = ?",
                new Object[]{id},
                (response, rowNumber) ->
                        new Automobile(response.getLong("id"),
                                response.getString("brand"),
                                response.getString("country"),
                                response.getInt("price"),
                                response.getString("power")));
        return automobile;
    }

    public void saveCar(String country, String brand, Integer price) {
        jdbcTemplate.update("INSERT INTO automobile(country, brand, price) VALUES (?, ?, ?)",
                country, brand, price);
    }

    public void saveCar(String country, String brand, Integer price, String power) {
        jdbcTemplate.update("INSERT INTO automobile(country, brand, price, power) VALUES (?, ?, ?, ?)",
                country, brand, price, power);
    }

    public void saveCarBody(Automobile automobile) {
        jdbcTemplate.update("INSERT INTO automobile(country, brand, price, power) VALUES (?, ?, ?, ?)",
                automobile.getCountry(), automobile.getBrand(),
                automobile.getPrice(), automobile.getPower());
    }

    public void updateCar(long id,Automobile automobile) {
        jdbcTemplate.update("UPDATE automobile SET country = ?, price = ? WHERE id = ?",
                automobile.getCountry(), automobile.getPrice(), id);
    }

    public void updateCarPower(long id, Automobile automobile) {
        jdbcTemplate.update("UPDATE automobile SET power = ? WHERE id = ?",
                automobile.getPower(), id);
    }

    public void deleteCar(long id) {
        jdbcTemplate.update("DELETE FROM automobile WHERE id = ?", id);
    }

}
