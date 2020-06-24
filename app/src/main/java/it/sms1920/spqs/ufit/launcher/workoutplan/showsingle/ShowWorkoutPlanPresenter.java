package it.sms1920.spqs.ufit.launcher.workoutplan.showsingle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

import androidx.annotation.NonNull;
import it.sms1920.spqs.ufit.model.firebase.database.FirebaseDbSingleton;
import it.sms1920.spqs.ufit.model.firebase.database.WorkoutPlan;

public class ShowWorkoutPlanPresenter implements ShowWorkoutPlanContract.Presenter {
    private ShowWorkoutPlanContract.View view;

    public ShowWorkoutPlanPresenter(final ShowWorkoutPlanContract.View view, String workoutId) {
        this.view = view;

        Query mWorkout = FirebaseDbSingleton.getInstance().getReference().child("WorkoutPlan").orderByKey().equalTo(workoutId);

        mWorkout.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for( DataSnapshot child : dataSnapshot.getChildren()){
                    view.setToolbarTextEqualToName(Objects.requireNonNull(child.getValue(WorkoutPlan.class)).getName());
                    view.showToolbarNavigationButton();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }


}
