package edu.northeastern.csye6200.project3;

/**
 * Flexibility abstract class implements Fitness
 */
public abstract class Flexibility implements Fitness {
    /**
     * Returns description of flexibility exercise
     *
     * @return description string
     */
    @Override
    public String description() {
        return "Flexibility is uncomfortable and it takes time, so people don't like to do it";
    }

    // Abstract methods to be implemented by subclasses
    @Override
    public abstract Muscle[] muscleTargeted();

    @Override
    public abstract double calorieLoss(Intensity intensity, double weight, int duration);
}