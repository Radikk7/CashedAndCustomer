package com.example.cashedandcustomer.service;

import com.example.cashedandcustomer.Models.Client;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
 //       @Autowired
 //   ClientRepository clientRepository;

    public static String springQueue = "queue1";

    @Override
    public Client creatClient(Client client) {
        return null;
    }

    @Override
    public List<Client> getClientByBalanceValue(int value) {
        return null;
    }


}
