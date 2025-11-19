package edu.northeastern.csye6200.project3;

/**
 * Profile class represents a user's profile
 */
public class Profile {
    private int age;
    private double height; // in meters
    private double weight; // in kg
    private Gender gender;

    /**
     * Constructor
     *
     * @param age    user's age
     * @param height user's height in meters
     * @param weight user's weight in kg
     * @param gender user's gender
     */
    public Profile(int age, double height, double weight, Gender gender) {
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.gender = gender;
    }

    /**
     * Sets the height
     *
     * @param height the height in meters
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * Sets the weight
     *
     * @param weight the weight in kg
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Sets the age
     *
     * @param age the age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Sets the gender
     *
     * @param gender the gender
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     * Gets the height
     *
     * @return the height in meters
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * Gets the weight
     *
     * @return the weight in kg
     */
    public double getWeight() {
        return this.weight;
    }

    /**
     * Gets the age
     *
     * @return the age
     */
    public int getAge() {
        return this.age;
    }

    /**
     * Gets the gender
     *
     * @return the gender
     */
    public Gender getGender() {
        return this.gender;
    }

    /**
     * Returns string representation of profile
     *
     * @return formatted string
     */
    @Override
    public String toString() {
        return String.format("Age %d, Weight %.1fkg, Height %.1fm, Gender %s",
                age, weight, height, gender);
    }

    /**
     * Calculates BMI
     *
     * @return the BMI value
     */
    public double calcBMI() {
        return weight / (height * height);
    }

    /**
     * Calculates daily calorie intake
     *
     * @return the daily calorie intake
     */
    public double dailyCalorieIntake() {
        double bmr;
        double heightInCm = height * 100;

        if (gender == Gender.MALE) {
            bmr = 66.47 + (13.75 * weight) + (5.003 * heightInCm) - (6.755 * age);
        } else {
            bmr = 655.1 + (9.563 * weight) + (1.85 * heightInCm) - (4.676 * age);
        }

        return bmr;
    }
}