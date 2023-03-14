package me.dio.ecommerce.h2ecommerce.repository;

import me.dio.ecommerce.h2ecommerce.entity.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address, String> {

}
