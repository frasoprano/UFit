package it.sms1920.spqs.ufit.model.firebase.database;

import androidx.annotation.NonNull;

public class ExerciseSetItem {
    private int reps;
    private float load;

    public ExerciseSetItem(){

    }

    public ExerciseSetItem(int reps, float load) {
        this.reps = reps;
        this.load = load;
    }

    public int getReps() {
        return reps;
    }

    public float getLoad() {
        return load;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public void setLoad(float load) {
        this.load = load;
    }

    @NonNull
    @Override
    public String toString() {
        return "ExerciseSetItem{" +
                "reps=" + reps +
                ", load=" + load +
                '}';
    }
}
