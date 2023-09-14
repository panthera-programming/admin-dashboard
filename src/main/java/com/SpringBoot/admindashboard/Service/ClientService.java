package com.SpringBoot.admindashboard.Service;

import com.SpringBoot.admindashboard.Entities.ClientEntity;

import java.util.Map;

public interface ClientService {
    String saveClient(ClientEntity client);
    ClientEntity findClientByEmail(String email);
    void deleteClient(Long id);
    void emailClient(Map<String, ?> mailParts);
    void messageClient();
}
