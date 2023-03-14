package me.dio.ecommerce.h2ecommerce.service.impl;

import me.dio.ecommerce.h2ecommerce.entity.Address;
import me.dio.ecommerce.h2ecommerce.entity.Client;
import me.dio.ecommerce.h2ecommerce.repository.AddressRepository;
import me.dio.ecommerce.h2ecommerce.repository.ClientRepository;
import me.dio.ecommerce.h2ecommerce.service.ByCepService;
import me.dio.ecommerce.h2ecommerce.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ByCepService byCepService;

    @Override
    public Iterable<Client> searchAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client searchById(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        return client.get();
    }

    @Override
    public void insert(Client client) {
        saveClientByCep(client);
    }

    @Override
    public void update(Long id, Client client) {
        Optional<Client> clientBd = clientRepository.findById(id);
        if (clientBd.isPresent()) {
            saveClientByCep(client);
        }
    }

    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    private void saveClientByCep(Client client) {
        String cep = client.getAddress().getCep();
        Address address = addressRepository.findById(cep).orElseGet(() -> {
            Address novoEndereco = byCepService.searchCep(cep);
            addressRepository.save(novoEndereco);
            return novoEndereco;
        });
        client.setAddress(address);
        clientRepository.save(client);
    }
}
