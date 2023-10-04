package pl.mikolajp.client.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.mikolajp.core.exception.ImproperDiceNameException;
import pl.mikolajp.core.exception.ValidationException;
import pl.mikolajp.core.model.Dice;
import pl.mikolajp.core.model.DiceImp;
import pl.mikolajp.core.validation.SidesValidator;
import pl.mikolajp.core.validation.Validator;

@RestController
@RequestMapping("/dice")
public class Controller {
    @GetMapping("/{diceType}")
    public ResponseEntity<?> rollDice(@PathVariable String diceType){
        try{
            if(diceType.charAt(0) != 'd')
                throw new ImproperDiceNameException(diceType);

            Integer sides = Integer.parseInt(diceType.substring(1));

            Dice dice = DiceImp.Builder.create().withSides(sides).build();
            Validator diceValidator = new SidesValidator();
            
            diceValidator.validate(dice);
            return ResponseEntity.ok(dice.roll());
        }catch(ImproperDiceNameException e){
                return ResponseEntity.badRequest().body(e.getMessage());
        }catch(ValidationException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/d20/{weightedSide}")
    public Integer rollWeightedD20(@PathVariable Integer weightedSide){
        Dice dice = DiceImp.Builder.create().withSides(20).build();
        dice.setWeight(weightedSide);

        return dice.roll();
    }
}
