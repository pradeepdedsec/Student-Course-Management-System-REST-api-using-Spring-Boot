package com.sample.api;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootApplication(scanBasePackages = {"com.sample.api", "com.sample.api.repo"})
@EnableJpaRepositories(basePackages = "com.sample.api.repo")
public class ApiApplication implements CommandLineRunner {


    public ApiApplication() {}

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //studentService.insertData();
    }
}
