package it.sms1920.spqs.ufit.launcher.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import it.sms1920.spqs.ufit.launcher.assembliesreport.AssembliesReportActivity;
import it.sms1920.spqs.ufit.launcher.R;
import it.sms1920.spqs.ufit.launcher.toolworkout.TimerFragment;
import it.sms1920.spqs.ufit.launcher.traineradvice.AdviceList;
import it.sms1920.spqs.ufit.launcher.traineradvice.AdviceListContract;

public class HomeFragment extends Fragment implements HomeContract.View, AdviceListContract.View {

    private HomeContract.Presenter presenter;

    private Intent webViewIntent;
    private TextView tvTitleAdvice;
    private TextView tvDescriptionAdvice;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new HomePresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        tvTitleAdvice = view.findViewById(R.id.tvTitleRandomAdvice);
        tvDescriptionAdvice = view.findViewById(R.id.tvDescriptionRandomAdvice);

        presenter.callGetRandomAdvice(this);

        Button btnWebsite = view.findViewById(R.id.btnWebsite);

        webViewIntent = new Intent(Intent.ACTION_VIEW);
        String URL_WEBSITE = "http://www.quatematico.com/Ufit";
        webViewIntent.setData(Uri.parse(URL_WEBSITE));
        btnWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(webViewIntent);
            }
        });

        FloatingActionButton fabAssembliesReport = view.findViewById(R.id.fabAssembliesReport);
        fabAssembliesReport.setOnClickListener(new FloatingActionButton.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onAssembliesReportClicked();
            }
        });

        // Using the correct layout for this fragment
        return view;
    }

    @Override
    public void callNotifyDataSetChanged() {
    }

    @Override
    public void addNewAdvice(String title, String description) {

    }

    public void setRandomAdvice(String title, String description) {
        tvTitleAdvice.setText(title);
        tvDescriptionAdvice.setText(description);
    }


    @Override
    public void startAssembliesReportActivity() {
        startActivity(new Intent(getContext(), AssembliesReportActivity.class));
    }

}
