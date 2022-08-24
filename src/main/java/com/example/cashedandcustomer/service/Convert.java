package com.example.cashedandcustomer.service;

import com.example.cashedandcustomer.Models.Balance;
import com.example.cashedandcustomer.Models.Client;
import com.example.cashedandcustomer.Models.CollectionClient;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import java.io.File;
import java.util.TreeMap;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

@Service
public class Convert {


    public static String createXml() throws ParserConfigurationException, IOException, SAXException {
        File file = new File("temp.xml");
        String xml = new String(
                Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
      String result = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" + xml;
      return result;
    }

    public static final CollectionClient deserialize() throws JAXBException, ParserConfigurationException, IOException, SAXException {
        JAXBContext context = JAXBContext.newInstance(CollectionClient.class);
        Unmarshaller m = context.createUnmarshaller();
        return (CollectionClient) m.unmarshal(new StringReader(createXml()));

    }

    public static Map<Long, Integer> createString(CollectionClient collectionClient){
        Map<Long,Integer> mapa = new TreeMap<>();
        for (Client i: collectionClient.getItem()) {
           mapa.put(i.getId(),i.getBalance().getValue());
        }
        return mapa;
    }

}