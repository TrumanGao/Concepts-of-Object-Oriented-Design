package edu.northeastern.csye6200.project3;

public class Cycling extends Aerobic {
    @Override
    public String description() {
        return Cycling.class.getSimpleName();
    }

    @Override
    public Muscle[] muscleTargeted() {
        return new Muscle[]{Muscle.Glutes, Muscle.Cardio, Muscle.Legs};
    }

    @Override
    public double calorieLoss(Intensity intensity, double weight, int duration) {
        switch (intensity) {
            case LOW:
                return 4 * weight * duration / 60.0;
            case MEDIUM:
                return 8.5 * weight * duration / 60.0;
            case HIGH:
                return 14.0 * weight * duration / 60.0;
            default:
                return 0.0;
        }
    }
}
