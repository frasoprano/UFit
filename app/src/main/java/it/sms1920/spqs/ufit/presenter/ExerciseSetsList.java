package it.sms1920.spqs.ufit.presenter;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

import it.sms1920.spqs.ufit.contract.iShowWorkoutPlanAdapter;
import it.sms1920.spqs.ufit.model.ExerciseSetDetails;
import it.sms1920.spqs.ufit.model.ExerciseSetItem;

public class ExerciseSetsList implements iShowWorkoutPlanAdapter.Presenter {
    private static final String TAG = ExerciseSetsList.class.getCanonicalName();

    private iShowWorkoutPlanAdapter.View view;

    private DatabaseReference mDatabase;
    private int workoutPlanId;
    private List<ExerciseSetItem> exerciseSetList;

    public ExerciseSetsList(iShowWorkoutPlanAdapter.View view, int workoutPlanId) {
        this.view = view;
        this.workoutPlanId = workoutPlanId;

        mDatabase = FirebaseDatabase.getInstance().getReference();
        loadExerciseSetList();
    }

    private void loadExerciseSetList() {
        Query mExeriseSetListQuery = mDatabase.child("WorkoutPlanExerciseSets").orderByKey().equalTo(String.valueOf(workoutPlanId));

        mExeriseSetListQuery.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    for (DataSnapshot set : child.getChildren()) {
                        Log.d(TAG, set.getValue(ExerciseSetDetails.class).toString());
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
