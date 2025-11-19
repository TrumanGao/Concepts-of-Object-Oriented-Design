package edu.northeastern.csye6200.project3;

public class Plyometrics extends Anaerobic {

    /**
     * Returns muscles targeted by plyometrics
     *
     * @return array of targeted muscles
     */
    @Override
    public Muscle[] muscleTargeted() {
        return new Muscle[]{Muscle.Abs, Muscle.Legs, Muscle.Glutes};
    }

    /**
     * Calculates calorie loss for plyometrics
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
                met = 7.4;
                break;
            case MEDIUM:
                met = 4.8;
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
        return Plyometrics.class.getSimpleName();
    }
}