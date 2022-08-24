package com.example.cashedandcustomer.service;


import com.example.cashedandcustomer.Models.Client;

import java.util.List;

public interface ClientService {
     Client creatClient(Client client);
     List<Client> getClientByBalanceValue(int value);



}
