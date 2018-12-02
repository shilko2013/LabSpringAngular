package com.shilko.ru.labspringangular.main;

import com.shilko.ru.labspringangular.config.ApplicationConfigController;
import org.springframework.context.*;

/*import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication*/
public class LabSpringAngular {

    /*public static void main(String[] args) {
        SpringApplication.run(WitcherApplication.class, args);
    }*/
    public static void main(String[] args) {
        ApplicationContext applicationContext = ApplicationConfigController.getApplicationContext();
    }

}