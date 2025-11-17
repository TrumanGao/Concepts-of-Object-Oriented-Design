package edu.northeastern.csye6200.project3;

public class Swimming extends Aerobic {
    private enum SwimmingType {
        ButterflyStroke,
        Breaststroke,
        Freestyle
    }

    private SwimmingType swimmingType;

    public Swimming(SwimmingType type) {
        this.swimmingType = type;
    }

    public Swimming() {
        this.swimmingType = SwimmingType.Freestyle;
    }

    /**
     * A setter for the swimmingType.
     *
     * @param type
     */
    public void setSwimmingType(SwimmingType type) {
        this.swimmingType = type;
    }

    /**
     * A getter for the swimmingType.
     *
     * @return
     */
    public SwimmingType getSwimmingType() {
        return this.swimmingType;
    }

    @Override
    public String description() {
        return Swimming.class.getSimpleName();
    }

    @Override
    public Muscle[] muscleTargeted() {
        switch (this.swimmingType) {
            case ButterflyStroke:
                return new Muscle[]{Muscle.Abs, Muscle.Back, Muscle.Shoulders, Muscle.Biceps, Muscle.Triceps};
            case Breaststroke:
                return new Muscle[]{Muscle.Glutes, Muscle.Cardio};
            case Freestyle:
            default:
                return new Muscle[]{Muscle.Arms, Muscle.Legs, Muscle.Cardio};
        }
    }

    @Override
    public double calorieLoss(Intensity intensity, double weight, int duration) {
        switch (intensity) {
            case Low:
                return 6 * weight * duration / 60.0;
            case Medium:
                return 8.3 * weight * duration / 60.0;
            case High:
                return 10.0 * weight * duration / 60.0;
            default:
                return 0.0;
        }
    }
}
