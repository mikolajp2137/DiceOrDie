package pl.mikolajp.core.validation;

import pl.mikolajp.core.exception.ValidationException;
import pl.mikolajp.core.model.Dice;

public interface Validator {
    void validate(Dice dice) throws ValidationException;
}
