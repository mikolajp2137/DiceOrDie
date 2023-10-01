package pl.mikolajp.core.exception;

import java.util.List;

public class ImproperDiceSizeException extends ValidationException{
    public ImproperDiceSizeException(List<Integer> sizes){
        super(String.format("Dice size is invalid. Allowed dice sizes - %s", sizes));
    }
}
