package it.sms1920.spqs.ufit.model.firebase.database;

import androidx.annotation.NonNull;

import java.util.List;

public class ExerciseSetDetails {
    private String exerciseId;
    private String exerciseName;
    private String imageUrl;
    private List<ExerciseSetItem> exerciseSetItems;

    public ExerciseSetDetails(){

    }

    public ExerciseSetDetails(String exerciseId, String exerciseName, List<ExerciseSetItem> exerciseSetItems, String imageUrl) {
        this.exerciseId = exerciseId;
        this.exerciseName = exerciseName;
        this.exerciseSetItems = exerciseSetItems;
        this.imageUrl = imageUrl;
    }

    public String getExerciseId() {
        return exerciseId;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public List<ExerciseSetItem> getExerciseSetItems() {
        return exerciseSetItems;
    }

    public void setExerciseSetItems(List<ExerciseSetItem> exerciseSetItems) {
        this.exerciseSetItems = exerciseSetItems;
    }

    @NonNull
    @Override
    public String toString() {
        return "ExerciseSetDetails{" +
                "exerciseId=" + exerciseId +
                ", exerciseSetItems=" + exerciseSetItems +
                '}';
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
