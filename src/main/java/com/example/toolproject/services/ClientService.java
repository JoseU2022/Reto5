package com.example.toolproject.services;

import com.example.toolproject.entities.Client;
import com.example.toolproject.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(int id){
        return clientRepository.getClient(id);
    }

    public Client save(Client client){
        if(client.getIdClient() == null){
            return clientRepository.save(client);
        }
        else {
            Optional<Client> e = clientRepository.getClient(client.getIdClient());

            if(e.isPresent()){
                return client;
            }
            else {
                return clientRepository.save(client);
            }
        }
    }

    public Client update(Client client) {
        if (client.getIdClient() != null) {
            Optional<Client> e = clientRepository.getClient(client.getIdClient());

            if (!e.isEmpty()) {

                if (client.getEmail() != null) {
                    e.get().setEmail(client.getEmail());
                }

                if (client.getPassword() != null) {
                    e.get().setPassword(client.getPassword());
                }

                if (client.getAge() != null) {
                    e.get().setAge(client.getAge());
                }

                if (client.getName() != null) {
                    e.get().setName(client.getName());
                }

                clientRepository.save(e.get());
                return e.get();
            } else {
                return client;
            }
        } else {
            return client;
        }
    }

    public boolean delete(int id){
        boolean flag = false;
        Optional<Client> e = clientRepository.getClient(id);
        if(!e.isEmpty()){
            clientRepository.delete(e.get());
            flag = true;
        }
        return flag;
    }
}
