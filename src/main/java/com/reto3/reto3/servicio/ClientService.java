package com.reto3.reto3.servicio;

import com.reto3.reto3.entidad.Client;
import com.reto3.reto3.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll() {
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(int id) {
        return clientRepository.getClient(id);
    }

    public Client save(Client client) {
        if (client.getIdClient() == null) {
            return clientRepository.save(client);
        } else {
            Optional<Client> clientFound = getClient(client.getIdClient());
            if (clientFound.isEmpty()) {
                return clientRepository.save(client);
            } else {
                return client;
            }
        }

    }
}
