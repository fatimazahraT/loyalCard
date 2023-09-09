package com.example.app.Service;

import com.example.app.Models.Client;

import java.util.List;

public interface ClientService {
    Client createClient(Client client);
    Client updateClient(Long clientId, Client updatedClient);
    void deleteClient(Long clientId);
    Client getClientById(Long clientId);
    List<Client> getAllClients();
}
