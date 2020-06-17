package it.sms1920.spqs.ufit.presenter;

import java.util.ArrayList;
import java.util.List;

import it.sms1920.spqs.ufit.contract.iSearchClient;
import it.sms1920.spqs.ufit.contract.iSearchListAdapter;
import it.sms1920.spqs.ufit.model.ExerciseDetailed;
import it.sms1920.spqs.ufit.model.SearchExercise;
import it.sms1920.spqs.ufit.view.ExerciseActivity;

/**
 * Presenter for SearchListAdapter View.
 * Implements iSearchClient to communicate with Model SearchExercise.
 */
public class SearchListAdapterPresenter implements iSearchListAdapter.Presenter, iSearchClient {
    private static final String TAG = SearchListAdapterPresenter.class.getCanonicalName();

    private iSearchListAdapter.View view;

    private SearchExercise searchExercise;
    private List<ExerciseDetailed> exerciseDetailedList = new ArrayList<>();

    public SearchListAdapterPresenter(iSearchListAdapter.View view) {
        this.view = view;
        searchExercise = new SearchExercise(this);
        onQueryTextChanged("");
    }

    @Override
    public void onQueryTextChanged(final String keyword) {
        exerciseDetailedList.clear();
        searchExercise.getExerciseWithNameStarting(keyword);
    }


    @Override
    public void onBindExerciseItemViewAtPosition(iSearchListAdapter.View.Item holder, int position) {
        ExerciseDetailed exercise = exerciseDetailedList.get(position);

        holder.setName(exercise.getName());
        holder.setImage(exercise.getImageUrl());
        holder.setId(exercise.getExerciseId());
    }

    @Override
    public int getExerciseCount() {
        return exerciseDetailedList.size();
    }

    @Override
    public void notifyResultListReady() {
        exerciseDetailedList = searchExercise.getExerciseResultList();
        view.callNotifyDataSetChanged();
    }


}