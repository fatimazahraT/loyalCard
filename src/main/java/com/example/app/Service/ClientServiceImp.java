package com.example.app.Service;

import com.example.app.Models.Client;
import com.example.app.Repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImp implements ClientService{
    private final ClientRepository clientRepository;

    public ClientServiceImp(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client updateClient(Long clientId, Client updatedClient) {
        Optional<Client> existingClientOptional = clientRepository.findById(clientId);
        if (existingClientOptional.isPresent()) {
            Client existingClient = existingClientOptional.get();
            // Update the properties of the existing client with the values from the updated client
            existingClient.setClientCode(updatedClient.getClientCode());
            existingClient.setClientName(updatedClient.getClientName());
            existingClient.setClientType(updatedClient.getClientType());
            existingClient.setClientBankCode(updatedClient.getClientBankCode());
            existingClient.setClientBranchCode(updatedClient.getClientBranchCode());
            existingClient.setNumberOfTries(updatedClient.getNumberOfTries());
            existingClient.setNumberOfTriesAllowed(updatedClient.getNumberOfTriesAllowed());
            existingClient.setIpAddress(updatedClient.getIpAddress());
            existingClient.setConnected(updatedClient.getConnected());
            existingClient.setFirstConnection(updatedClient.getFirstConnection());
            existingClient.setNumberOfSessionAllowed(updatedClient.getNumberOfSessionAllowed());
            existingClient.setNumberOfSessionConnected(updatedClient.getNumberOfSessionConnected());
            existingClient.setPasswordLength(updatedClient.getPasswordLength());
            existingClient.setComplexityFlag(updatedClient.getComplexityFlag());
            existingClient.setPasswordExpiration(updatedClient.getPasswordExpiration());
            existingClient.setPasswordStartDate(updatedClient.getPasswordStartDate());
            existingClient.setPasswordEndDate(updatedClient.getPasswordEndDate());
            existingClient.setBlockAccess(updatedClient.getBlockAccess());
            existingClient.setLanguageCode(updatedClient.getLanguageCode());
            existingClient.setLastFourPasswords(updatedClient.getLastFourPasswords());
            existingClient.setEmail(updatedClient.getEmail());
            existingClient.setMobileNumber(updatedClient.getMobileNumber());
            existingClient.setForgotPasswordRequest(updatedClient.getForgotPasswordRequest());
            existingClient.setSecretKey(updatedClient.getSecretKey());

            return clientRepository.save(existingClient);
        } else {
            throw new IllegalArgumentException("Client not found with ID: " + clientId);
        }
    }

    @Override
    public void deleteClient(Long clientId) {
        clientRepository.deleteById(clientId);
    }

    @Override
    public Client getClientById(Long clientId) {
        return clientRepository.findById(clientId)
                .orElseThrow(() -> new IllegalArgumentException("Client not found with ID: " + clientId));
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }
}
