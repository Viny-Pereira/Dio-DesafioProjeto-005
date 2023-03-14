package me.dio.ecommerce.h2ecommerce.service;

import me.dio.ecommerce.h2ecommerce.entity.Client;
import org.springframework.context.annotation.Bean;


public interface ClientService {
    Iterable<Client> searchAll();

    Client searchById(Long id);

    void insert(Client client);

    void update(Long id, Client client);

    void delete(Long id);
}
