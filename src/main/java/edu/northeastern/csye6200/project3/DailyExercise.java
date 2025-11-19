package edu.northeastern.csye6200.project3;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * DailyExercise class represents a daily exercise plan
 */
public class DailyExercise {
    private Fitness[] exerciseList;
    private int duration; // in minutes
    private double calorieTarget;
    private Profile profile;

    /**
     * Constructor with all parameters
     *
     * @param exerciseList  array of fitness exercises
     * @param duration      duration in minutes
     * @param calorieTarget target calorie loss
     * @param profile       user's profile
     */
    public DailyExercise(Fitness[] exerciseList, int duration, double calorieTarget, Profile profile) {
        this.exerciseList = exerciseList;
        this.duration = duration;
        this.calorieTarget = calorieTarget;
        this.profile = profile;
    }

    /**
     * Constructor with default duration and calorie target
     *
     * @param exerciseList array of fitness exercises
     * @param profile      user's profile
     */
    public DailyExercise(Fitness[] exerciseList, Profile profile) {
        this(exerciseList, 60, 500, profile);
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
     * Adds an exercise to the list
     *
     * @param ex the fitness exercise to add
     */
    public void addExercise(Fitness ex) {
        Fitness[] newList = new Fitness[exerciseList.length + 1];
        System.arraycopy(exerciseList, 0, newList, 0, exerciseList.length);
        newList[exerciseList.length] = ex;
        exerciseList = newList;
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
     * Sets the duration
     *
     * @param duration the duration in minutes
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * Sets the calorie target
     *
     * @param target the calorie target
     */
    public void setCalorieTarget(double target) {
        this.calorieTarget = target;
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
     * Gets the duration
     *
     * @return the duration in minutes
     */
    public int getDuration() {
        return this.duration;
    }

    /**
     * Gets the calorie target
     *
     * @return the calorie target
     */
    public double getCalorieTarget() {
        return this.calorieTarget;
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
     * Gets exercises that target all specified muscles
     *
     * @param targetMuscle array of target muscles
     * @return array of matching exercises or null
     */
    public Fitness[] getExercises(Muscle[] targetMuscle) {
        ArrayList<Fitness> result = new ArrayList<>();

        for (Fitness fit : exerciseList) {
            Muscle[] muscles = fit.muscleTargeted();
            if (containsAll(muscles, targetMuscle)) {
                result.add(fit);
            }
        }

        return result.isEmpty() ? null : result.toArray(new Fitness[0]);
    }

    /**
     * Gets exercises that target all or some of the specified muscles
     *
     * @param targetMuscle array of target muscles
     * @return array of matching exercises or null
     */
    public Fitness[] getAllExercises(Muscle[] targetMuscle) {
        ArrayList<Fitness> result = new ArrayList<>();

        for (Fitness fit : exerciseList) {
            Muscle[] muscles = fit.muscleTargeted();
            if (containsAny(muscles, targetMuscle)) {
                result.add(fit);
            }
        }

        return result.isEmpty() ? null : result.toArray(new Fitness[0]);
    }

    /**
     * Helper method to check if array contains all target muscles
     */
    private boolean containsAll(Muscle[] muscles, Muscle[] targetMuscle) {
        for (Muscle target : targetMuscle) {
            boolean found = false;
            for (Muscle m : muscles) {
                if (m == target) {
                    found = true;
                    break;
                }
            }
            if (!found) return false;
        }
        return true;
    }

    /**
     * Helper method to check if array contains any target muscle
     */
    private boolean containsAny(Muscle[] muscles, Muscle[] targetMuscle) {
        for (Muscle target : targetMuscle) {
            for (Muscle m : muscles) {
                if (m == target) {
                    return true;
                }
            }
        }
        return false;
    }
}