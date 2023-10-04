package pl.mikolajp.core.exception;

public class ImproperDiceNameException extends ValidationException {

    public ImproperDiceNameException(String diceType) {
        super(String.format("%s is not a valid dice type.", diceType));
    }
}
