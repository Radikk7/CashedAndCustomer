package com.example.cashedandcustomer.schedule;


import com.example.cashedandcustomer.Models.Client;
import com.example.cashedandcustomer.Models.CollectionClient;
import com.example.cashedandcustomer.Models.UserBalance;
import com.example.cashedandcustomer.repository.UserBalanceRepository;
import com.example.cashedandcustomer.service.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class ConsumingBalanceUserByHttpClient {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    HttpEntity httpEntity;
    @Autowired
    DocumentBuilder documentBuilder;
    @Autowired
    UserBalanceRepository userBalanceRepository;


    @Scheduled(fixedDelayString = "${N}")
    public void getResponce() throws IOException, SAXException, TransformerException, JAXBException, ParserConfigurationException {
        System.out.println("Hi");

        ResponseEntity<String> responseEntity = restTemplate.exchange("http://localhost:8099/allusers", HttpMethod.GET, httpEntity, String.class);

        if (responseEntity != null) {
            System.out.println(responseEntity.getBody());
            //  DOMResult domResult = new DOMResult();
            //   DOMSource domSource = new DOMSource(documentBuilder.parse(new InputSource(new StringReader(Objects.requireNonNull(responseEntity.getBody())))));
            File output = new File("temp.xml");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(output));
            bufferedWriter.write(Objects.requireNonNull(responseEntity.getBody()));
            bufferedWriter.flush();
            CollectionClient collectionClient = Convert.deserialize();
            List<UserBalance> userBalanceList = new ArrayList<>();
            for (Client i : collectionClient.getItem()) {
                UserBalance userBalance = new UserBalance();
                userBalance.setId((i.getId()));
                userBalance.setValue(i.getBalance().getValue());
                userBalanceRepository.save(userBalance);
            }
        }
    }
}
