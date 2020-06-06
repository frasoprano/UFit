package it.sms1920.spqs.ufit.contract;

import android.content.Intent;

import it.sms1920.spqs.ufit.model.firebase.Exercise;

public interface ShowExerciseContract {

    interface view {
        void load(Exercise exercise);
        void back();
    }

    interface presenter {
        void onCreateComplete(Intent intent);
        void onBackPressed();
    }

}
