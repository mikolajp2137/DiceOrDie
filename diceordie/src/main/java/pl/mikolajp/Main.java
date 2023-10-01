package pl.mikolajp;

import pl.mikolajp.core.exception.ValidationException;
import pl.mikolajp.core.model.Dice;
import pl.mikolajp.core.model.DiceImp;
import pl.mikolajp.core.validation.SidesValidator;
import pl.mikolajp.core.validation.Validator;

public class Main {
    public static void main(String[] args) {
        Integer sides = 20;
        Dice dice = DiceImp.Builder.create().withSides(sides).build();
        Validator validator = new SidesValidator();
        try{
            validator.validate(dice);
            System.out.println(dice.roll());
           
        }catch(ValidationException e){
            System.out.println(e.getMessage());
        }
        
    }
}