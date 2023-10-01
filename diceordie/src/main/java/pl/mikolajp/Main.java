package pl.mikolajp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import pl.mikolajp.core.exception.ValidationException;
import pl.mikolajp.core.model.Dice;
import pl.mikolajp.core.model.DiceImp;
import pl.mikolajp.core.validation.SidesValidator;
import pl.mikolajp.core.validation.Validator;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}