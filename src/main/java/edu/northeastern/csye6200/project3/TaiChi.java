package edu.northeastern.csye6200.project3;

/**
 * TaiChi class extends Flexibility
 */
public class TaiChi extends Flexibility {

    /**
     * Returns muscles targeted by Tai Chi
     *
     * @return array of targeted muscles
     */
    @Override
    public Muscle[] muscleTargeted() {
        return new Muscle[]{Muscle.Arms, Muscle.Legs};
    }

    /**
     * Calculates calorie loss for Tai Chi
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
                met = 5.0;
                break;
            case MEDIUM:
                met = 3.0;
                break;
            case LOW:
                met = 1.5;
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
        return TaiChi.class.getSimpleName();
    }
}