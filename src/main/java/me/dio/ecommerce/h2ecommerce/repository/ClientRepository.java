package me.dio.ecommerce.h2ecommerce.repository;

import me.dio.ecommerce.h2ecommerce.entity.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {

}
