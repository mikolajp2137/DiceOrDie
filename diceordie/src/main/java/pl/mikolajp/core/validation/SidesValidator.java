package pl.mikolajp.core.validation;

import pl.mikolajp.core.Constants;
import pl.mikolajp.core.exception.ImproperDiceSizeException;
import pl.mikolajp.core.model.Dice;

public class SidesValidator implements Validator {
    @Override
    public void validate(Dice dice) throws ImproperDiceSizeException{
        if(!Constants.allowedDiceSizes.contains(dice.getSides())){
            throw new ImproperDiceSizeException(Constants.allowedDiceSizes);
        }
    }
}
