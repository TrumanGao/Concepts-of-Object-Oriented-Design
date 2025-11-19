package edu.northeastern.csye6200.project3;

public interface Fitness {
    /**
     * returns the muscle that is going to be affected by the fitness. Note that the return type of the method is Muscle. A human body has a finite number of muscle parts that can be affected by fitness exercises.
     *
     * @return Muscle[] - an array of Muscle enums representing the targeted muscles.
     */
    public Muscle[] muscleTargeted();

    /**
     * returns the total amount of calorie burnedby the exercise for the duration number of minutes for a person with the given weight
     *
     * @param intensity
     * @param weight
     * @param duration
     * @return double - total calorie loss
     */
    public double calorieLoss(Intensity intensity, double weight, int duration);

    /**
     * returns a short description of the fitness type
     *
     * @return String - description of the fitness type
     */
    public String description();
}

enum Muscle {
    Abs, Back, Biceps, Chest, Arms, Glutes, Shoulders, Triceps, Legs, Cardio
}

enum Intensity {
    LOW, MEDIUM, HIGH
}

enum Gender {
    MALE, FEMALE
}

enum SwimmingType {
    ButterflyStroke,
    Breaststroke,
    Freestyle
}