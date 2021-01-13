package com.example.lab5.project.repository;

import com.example.lab5.project.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Repository
@RequestMapping("client")
public class ClientRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Client getClientId(int id, String location) {
        Client client = jdbcTemplate.queryForObject("SELECT * FROM manufacturers WHERE id = ? and location = ?",
                new Object[]{id, location},
                (response, rowNumber) ->
                        new Client(response.getInt("id"),
                                response.getString("name"),
                                response.getInt("creditRating"),
                                response.getFloat("salary")));
        return client;
    }


    public List<Client> getClients() {
        List<Client> clients = jdbcTemplate.query("SELECT * FROM clients",
                (response, rowNumber) ->
                        new Client(response.getInt("id"),
                                response.getString("name"),
                                response.getInt("creditRating"),
                                response.getFloat("salary")));
        return clients;
    }

    public void saveClient(Client client){
        jdbcTemplate.update("INSERT INtO clients(name, creditRating, salary) VALUES(?, ?, ?)",
                client.getName(), client.getCreditRating(), client.getSalary());
    }

    public void updateClient(int id, Client client) {
        jdbcTemplate.update("UPDATE clients SET name = ?, creditRating = ? WHERE id = ?",
                client.getName(), client.getCreditRating(), id);
    }

    public void deleteClient(int id) {
        jdbcTemplate.update("DELETE from clients where id = ?", id);
    }

}
