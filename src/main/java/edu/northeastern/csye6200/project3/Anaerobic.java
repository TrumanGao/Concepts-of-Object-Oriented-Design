package edu.northeastern.csye6200.project3;

public abstract class Anaerobic implements Fitness {
    /**
     * Returns description of anaerobic exercise
     *
     * @return description string
     */
    @Override
    public String description() {
        return "Anaerobic means \"without oxygen.\"";
    }

    // Abstract methods to be implemented by subclasses
    @Override
    public abstract Muscle[] muscleTargeted();

    @Override
    public abstract double calorieLoss(Intensity intensity, double weight, int duration);
}