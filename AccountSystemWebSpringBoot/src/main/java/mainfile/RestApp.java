package mainfile;


import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.example.domain.persistence.GetResponse;

import org.example.domain.persistence.GetResponse;


@RestController
@RequestMapping
@SpringBootApplication
public class RestApp {
    public static void main(String [] args)
   {
       SpringApplication.run(RestApp.class,args);
   }


}

