package edu.northeastern.csye6200.project3;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * WeeklyExercise class represents a weekly exercise plan
 */
public class WeeklyExercise {
    private Fitness[] exerciseList;
    private int days;
    private double weeklyCalorieTarget;
    private Profile profile;

    /**
     * Constructor with all parameters
     *
     * @param exerciseList        array of fitness exercises
     * @param days                number of days per week
     * @param weeklyCalorieTarget weekly calorie target
     * @param profile             user's profile
     */
    public WeeklyExercise(Fitness[] exerciseList, int days, double weeklyCalorieTarget, Profile profile) {
        this.exerciseList = exerciseList;
        this.days = days;
        this.weeklyCalorieTarget = weeklyCalorieTarget;
        this.profile = profile;
    }

    /**
     * Constructor with default days and weekly calorie target
     *
     * @param exerciseList array of fitness exercises
     * @param profile      user's profile
     */
    public WeeklyExercise(Fitness[] exerciseList, Profile profile) {
        this(exerciseList, 7, 3500, profile);
    }

    /**
     * Adds an exercise to the list
     *
     * @param ex the fitness exercise to add
     */
    public void addExercise(Fitness ex) {
        ArrayList<Fitness> list = new ArrayList<>(Arrays.asList(exerciseList));
        list.add(ex);
        this.exerciseList = list.toArray(new Fitness[list.size()]);
    }

    /**
     * Removes an exercise from the list
     *
     * @param ex the fitness exercise to remove
     */
    public void removeExercise(Fitness ex) {
        ArrayList<Fitness> list = new ArrayList<>(Arrays.asList(exerciseList));
        list.remove(ex);
        exerciseList = list.toArray(new Fitness[0]);
    }

    /**
     * Sets the exercise list
     *
     * @param list the new exercise list
     */
    public void setExerciseList(Fitness[] list) {
        this.exerciseList = list;
    }

    /**
     * Sets the days
     *
     * @param days number of days per week
     */
    public void setDays(int days) {
        this.days = days;
    }

    /**
     * Sets the weekly calorie target
     *
     * @param target the weekly calorie target
     */
    public void setWeeklyCalorieTarget(double target) {
        this.weeklyCalorieTarget = target;
    }

    /**
     * Sets the profile
     *
     * @param profile the user's profile
     */
    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    /**
     * Gets the exercise list
     *
     * @return array of fitness exercises
     */
    public Fitness[] getExerciseList() {
        return this.exerciseList;
    }

    /**
     * Gets the size of exercise list
     *
     * @return number of exercises
     */
    public int getSize() {
        return exerciseList.length;
    }

    /**
     * Gets the days
     *
     * @return number of days per week
     */
    public int getDays() {
        return this.days;
    }

    /**
     * Gets the profile
     *
     * @return the user's profile
     */
    public Profile getProfile() {
        return this.profile;
    }

    /**
     * Gets the weekly calorie target
     *
     * @return the weekly calorie target
     */
    public double getWeeklyCalorieTarget() {
        return this.weeklyCalorieTarget;
    }

    /**
     * Gets weekly exercises with specified intensity
     *
     * @param intensity the intensity level
     * @return array of daily exercises
     */
    public DailyExercise[] getWeeklyExercises(Intensity intensity) {
        DailyExercise[] result = new DailyExercise[days];
        double caloriePerDay = weeklyCalorieTarget / days;

        for (int i = 0; i < days; i++) {
            Fitness exercise = exerciseList[i];
            Fitness[] singleExercise = new Fitness[]{exercise};

            // Calculate duration needed to burn caloriePerDay
            double calPerMinute = exercise.calorieLoss(intensity, profile.getWeight(), 1);
            int duration = (int) (caloriePerDay / calPerMinute);

            result[i] = new DailyExercise(singleExercise, duration, caloriePerDay, profile);
        }

        return result;
    }

    /**
     * Gets weekly exercises with LOW intensity
     *
     * @return array of daily exercises
     */
    public DailyExercise[] getWeeklyExercises() {
        return getWeeklyExercises(Intensity.LOW);
    }

    /**
     * Calculates targeted calorie loss plan
     *
     * @param targetWeight target weight in kg
     * @param withInDays   number of days to achieve target
     * @return formatted string with plan details
     */
    public String targetedCalorieLoss(double targetWeight, int withInDays) {
        double currentWeight = profile.getWeight();

        if (targetWeight >= currentWeight) {
            return "Only works to lose weight";
        }

        double weightToLose = currentWeight - targetWeight;
        double totalCaloriesToBurn = weightToLose * 7000; // 7000 cal per kg
        double caloriesPerDay = totalCaloriesToBurn / withInDays;
        double dailyIntake = profile.dailyCalorieIntake();
        double newIntake = dailyIntake - caloriesPerDay;

        return String.format("You need to lose %.2f calories per day or decrease your intake from %.2f to %.2f in order to lose %.2f kg of weight",
                caloriesPerDay, dailyIntake, newIntake, weightToLose);
    }
}