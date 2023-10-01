package pl.mikolajp.client.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.mikolajp.core.exception.ValidationException;
import pl.mikolajp.core.model.Dice;
import pl.mikolajp.core.model.DiceImp;
import pl.mikolajp.core.validation.SidesValidator;
import pl.mikolajp.core.validation.Validator;

@RestController
public class Controller {
    @GetMapping("/d20")
    public Integer rollD20(){
        Integer sides = 20;
        Dice dice = DiceImp.Builder.create().withSides(sides).build();
        Validator validator = new SidesValidator();
        try{
            validator.validate(dice);
            return dice.roll();
           
        }catch(ValidationException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
