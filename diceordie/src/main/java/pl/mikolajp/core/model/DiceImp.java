package pl.mikolajp.core.model;

import java.util.Random;

public class DiceImp implements Dice {
    private final Integer sides;

    private DiceImp(Integer sides){
        this.sides = sides;
    }

    @Override
    public Integer roll() {
        Random rand = new Random();
        return rand.nextInt(sides) + 1;
    }

    public Integer getSides() {
        return sides;
    }

    public static class Builder{
        private Integer sides;

        private Builder(){}

        public static Builder create(){ return new Builder();}
        public Builder withSides(Integer sides){
            this.sides = sides;
            return this;
        }
        public DiceImp build(){
            return new DiceImp(sides);
        }
    }
}
