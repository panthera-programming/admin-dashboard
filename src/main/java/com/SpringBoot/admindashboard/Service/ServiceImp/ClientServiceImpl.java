package com.SpringBoot.admindashboard.Service.ServiceImp;

import com.SpringBoot.admindashboard.Entities.ClientEntity;
import com.SpringBoot.admindashboard.Repository.ClientRepository;
import com.SpringBoot.admindashboard.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository repository;
    @Autowired
    private EmailServiceImpl emailService;
    @Override
    public String saveClient(ClientEntity client) {
        repository.save(client);
        return ("Client saved successfully");
    }
    @Override
    public ClientEntity findClientByEmail(String email)
    {
        return (repository.findByEmail(email));
    }
    @Override
    public List<ClientEntity> findAllClients()
    {
        return (repository.findAll());
    }
    @Override
    public List<ClientEntity> findAllPerProduct(Long prodId){
        return (repository.findAllByProduct(prodId));
    }
    @Override
    public void deleteClient(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void emailClient(Map<String, ?> mailParts) {
        emailService.sendClientMail(
                (String) mailParts.get("subject"),
                (String) mailParts.get("message"),
                (ClientEntity) mailParts.get("client")
        );
    }

    @Override
    public void messageClient() {
    }
}
