package it.sms1920.spqs.ufit.launcher.workoutplan.adapter.exerciseslist;

import android.media.Image;

import java.util.ArrayList;
import java.util.List;

import it.sms1920.spqs.ufit.model.firebase.database.Exercise;
import it.sms1920.spqs.ufit.model.firebase.database.ExerciseSetItem;

public interface WorkoutExercisesListContract {

    interface View {
        void callNotifyItemRemoved(int position);
        void callNotifyItemRangeChanged(int position, int range);
        void callNotifyDataSetChanged();
        void onItemRemoved(int position);

        interface Item {
            void setName(String name);
            void setImage(Image image);
            void setId(String id);
            void setExerciseSets(List<ExerciseSetItem> exerciseSets);

            void setExerciseSetsAdapter(int position, List<ExerciseSetItem> exerciseSets);

            void addExerciseSet(int reps, float loads);
        }
    }

    interface Presenter {

        void onSaveCurrentWorkoutPlanRequested(String name);
        void onBindExerciseItemViewAtPosition(View.Item holder, int position);
        int getExerciseCount();
        void removeItemAt(int position);
        void onNewExercisesAdded(ArrayList<String> exerciseId);
        ArrayList<String> onExercisesIdRequested();
        List<ExerciseSetItem> onSetsListRequested(int position);

    }

}