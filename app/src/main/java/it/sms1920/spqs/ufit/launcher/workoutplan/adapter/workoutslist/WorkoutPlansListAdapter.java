package it.sms1920.spqs.ufit.launcher.workoutplan.adapter.workoutslist;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import it.sms1920.spqs.ufit.launcher.R;
import it.sms1920.spqs.ufit.launcher.workoutplan.showlist.WorkoutPlansFragment;

public class WorkoutPlansListAdapter extends RecyclerView.Adapter<WorkoutPlansListAdapter.WorkoutPlanHolder> implements WorkoutPlansListContract.View {
    private static final String TAG = WorkoutPlansListAdapter.class.getCanonicalName();

    private WorkoutPlansListContract.Presenter presenter;

    private WorkoutPlansFragment parentFragment;

    public WorkoutPlansListAdapter(WorkoutPlansFragment parentFragment) {
        this.parentFragment = parentFragment;
        presenter = new WorkoutPlansListPresenter(this);
    }

    @NonNull
    @Override
    public WorkoutPlanHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new WorkoutPlanHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_workout_plan, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull WorkoutPlanHolder holder, int position) {
        presenter.onBindWorkoutPlanItemListViewAtPosition(holder, position);
    }

    @Override
    public void onItemRemoved(int position) {
        presenter.removeItemAt(position);
    }

    @Override
    public int getItemCount() {
        return presenter.getWorkoutPlansCount();
    }

    public void showPersonalWorkoutPlans() {
        presenter.onPersonalWorkoutPlansRequired();
    }

    public void showTrainerWorkoutPlans() {
        presenter.onTrainerWorkoutPlansRequired();
    }

    @Override
    public void callNotifyDataSetChanged(boolean isEmpty) {
        parentFragment.noItemFound(isEmpty);
        notifyDataSetChanged();
    }

    @Override
    public void showWorkoutPlanDetail(String workoutPlanId) {
        parentFragment.insertShowWorkoutPlanFragment(workoutPlanId);
    }

    public class WorkoutPlanHolder extends RecyclerView.ViewHolder implements WorkoutPlansListContract.View.Item {
        private TextView tvName;
        private int position;
        MaterialButton btnRemove;

        public WorkoutPlanHolder(@NonNull View itemView) {
            super(itemView);
            btnRemove = itemView.findViewById(R.id.btnRemove);
            btnRemove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemRemoved(getAdapterPosition());
                }
            });
//            if (presenter.isTrainerTabRequested() && !presenter.isTrainer()) {
//                btnRemove.setVisibility(View.GONE);
//            }

            tvName = itemView.findViewById(R.id.tvWorkoutPlanName);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    presenter.onItemClicked(position);
                }
            });
        }

        @Override
        public void setName(String name) {
            tvName.setText(name);
        }

        @Override
        public void setPosition(int position) {
            this.position = position;
        }


    }


}
