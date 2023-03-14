package me.dio.ecommerce.h2ecommerce.service;

import me.dio.ecommerce.h2ecommerce.entity.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ByCepService {

    @GetMapping("/{cep}/json/")
    Address searchCep(@PathVariable("cep") String cep);
}