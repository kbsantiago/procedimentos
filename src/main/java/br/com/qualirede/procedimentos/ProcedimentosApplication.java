package br.com.qualirede.procedimentos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@SpringBootApplication
public class ProcedimentosApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProcedimentosApplication.class, args);
    }

}
