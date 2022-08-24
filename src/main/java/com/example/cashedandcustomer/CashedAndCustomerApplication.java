package com.example.cashedandcustomer;
import com.example.cashedandcustomer.Models.CollectionClient;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;




@EnableCaching
@EnableScheduling
@SpringBootApplication
public class CashedAndCustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CashedAndCustomerApplication.class, args);


    }
    //  @Value("${spring.rabbitmq.queue}")
    public static String springQueue = "queue";

    //  @Value("${spring.rabbitmq.exchange}")
    public static String springExchange = "exchanger";

    //   @Value("${spring.rabbitmq.bindingkey}")
    public static String springBinding = "binding";


    @Bean
    public Queue queue(){
        return new Queue(springQueue);
    }
    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange(springExchange);
    }
    @Bean
    public Binding binding(Queue queue, TopicExchange topicExchange){
        return BindingBuilder.bind(queue).to(topicExchange).with(springBinding);
    }
  //  @Bean JAXBContext jaxbContext() throws JAXBException {
  //      return JAXBContext.newInstance(CollectionClient.class);
  //  }

 //@Bean Unmarshaller jaxbUnmarshaller(JAXBContext jaxbContext) throws JAXBException {
 //    return jaxbContext.createUnmarshaller();
 //}


    @Bean
    DocumentBuilder builder() throws ParserConfigurationException {
        return DocumentBuilderFactory.newInstance().newDocumentBuilder();
    }

 //  @Bean
 //  public Transformer transformer() throws TransformerConfigurationException {
 //      return TransformerFactory.newInstance().newTransformer(new StreamSource(CashedAndCustomerApplication.class
 //              .getClassLoader().getResourceAsStream("transform.xsl")));
 //  }

    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }
    
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    @Bean
    public HttpEntity httpEntity(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Accept","application/xml");
        return new HttpEntity<>(httpHeaders);
    }
}
