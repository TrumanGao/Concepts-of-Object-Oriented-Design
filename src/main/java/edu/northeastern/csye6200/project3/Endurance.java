package edu.northeastern.csye6200.project3;

/**
 * Endurance abstract class implements Fitness
 */
public abstract class Endurance implements Fitness {
    /**
     * Returns description of endurance exercise
     *
     * @return description string
     */
    @Override
    public String description() {
        return "Endurance is all about sweat and patience";
    }

    // Abstract methods to be implemented by subclasses
    @Override
    public abstract Muscle[] muscleTargeted();

    @Override
    public abstract double calorieLoss(Intensity intensity, double weight, int duration);
}