package edu.northeastern.csye6200.project3;

/**
 * Yoga class extends Flexibility
 */
public class Yoga extends Flexibility {

    /**
     * Returns muscles targeted by yoga
     *
     * @return array of targeted muscles
     */
    @Override
    public Muscle[] muscleTargeted() {
        return new Muscle[]{Muscle.Triceps, Muscle.Biceps};
    }

    /**
     * Calculates calorie loss for yoga
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
                met = 4.0;
                break;
            case MEDIUM:
                met = 3.0;
                break;
            case LOW:
                met = 2.0;
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
        return Yoga.class.getSimpleName();
    }
}