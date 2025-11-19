package edu.northeastern.csye6200.project3;

/**
 * WeightLifting class extends Anaerobic
 */
public class WeightLifting extends Anaerobic {

    /**
     * Returns muscles targeted by weight lifting
     *
     * @return array of targeted muscles
     */
    @Override
    public Muscle[] muscleTargeted() {
        return new Muscle[]{Muscle.Shoulders, Muscle.Legs, Muscle.Arms, Muscle.Triceps};
    }

    /**
     * Calculates calorie loss for weight lifting
     *
     * @param intensity the intensity level
     * @param weight    the weight in kg
     * @param duration  the duration in minutes
     * @return calories burned
     */
    @Override
    public double calorieLoss(Intensity intensity, double weight, int duration) {
        double met = 0;
        switch (intensity) {
            case HIGH:
                met = 6.0;
                break;
            case MEDIUM:
                met = 5.0;
                break;
            case LOW:
                met = 3.5;
                break;
        }
        return met * weight * duration / 60.0;
    }

    /**
     * Returns description
     *
     * @return class name
     */
    @Override
    public String description() {
        return WeightLifting.class.getSimpleName();
    }
}