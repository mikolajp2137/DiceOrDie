package pl.mikolajp.core.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import pl.mikolajp.core.model.neighbors.D20;

public class DiceImp implements Dice {
    private final Integer sides;
    private Integer weightedSide;
    private final List<List<Integer>> neighbors;

    private DiceImp(Integer sides) {
        this.sides = sides;
        this.neighbors = D20.getNeighbors();
    }

    @Override
    public Integer roll() {
        Random rand = new Random();
        if (weightedSide == null)
            return rand.nextInt(sides) + 1;

        Double randomNumber = rand.nextDouble();
        List<Double> probabilites = new ArrayList<>(Collections.nCopies(20, 1.0));
        List<Integer> neigboringValues = neighbors.get(weightedSide - 1);
        
        probabilites.set(weightedSide - 1, 4.0);
        probabilites.set(neigboringValues.get(0), 2.0);
        probabilites.set(neigboringValues.get(1), 2.0);
        probabilites.set(neigboringValues.get(2), 2.0);

        Double totalProbability = 0.0;
        for (Double p : probabilites) {
            totalProbability += p;
        }
        for (int i = 0; i < 20; i++) {
            probabilites.set(i, probabilites.get(i) / totalProbability);
        }

        Double cumulativeProbability = 0.0;
        for (int i = 0; i < 20; i++) {
            cumulativeProbability += probabilites.get(i);
            if (randomNumber <= cumulativeProbability) {
                return i + 1;
            }
        }
        return 1;
    }

    public Integer getSides() {
        return sides;
    }

    public void setWeight(Integer weightedSide) {
        this.weightedSide = weightedSide;
    }

    public static class Builder {
        private Integer sides;

        private Builder() {
        }

        public static Builder create() {
            return new Builder();
        }

        public Builder withSides(Integer sides) {
            this.sides = sides;
            return this;
        }

        public DiceImp build() {
            return new DiceImp(sides);
        }
    }
}
