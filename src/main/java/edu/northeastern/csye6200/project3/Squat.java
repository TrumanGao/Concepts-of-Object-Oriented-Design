package edu.northeastern.csye6200.project3;

/**
 * Squat class extends Endurance
 */
public class Squat extends Endurance {

    /**
     * Returns muscles targeted by squats
     *
     * @return array of targeted muscles
     */
    @Override
    public Muscle[] muscleTargeted() {
        return new Muscle[]{Muscle.Glutes, Muscle.Abs, Muscle.Back};
    }

    /**
     * Calculates calorie loss for squats
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
                met = 7.0;
                break;
            case MEDIUM:
                met = 5.0;
                break;
            case LOW:
                met = 2.5;
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
        return Squat.class.getSimpleName();
    }
}