package it.sms1920.spqs.ufit.launcher;


public interface LauncherContract {

    interface View {
        void insertHomeFragment();

        void insertPlansFragment();

        void insertStatsFragment();

        void insertProfileFragment();

        void insertProfileSettingsFragment();

        void startSearchActivity();

        void insertChooseFragment();

        void endActivity();

        void resetActivity();

        String getWorkoutId();

        void startEditWorkoutActivity(String id);

        void startMaxStrengthTest();

        void startTimer();

        void setToolbarTitle(String text);

        void insertBluetoothLinkingFragment();

        String getLoginRequiredString();

        void lockView();

        void startAdviceTrainerActivity();


        enum FragType {HOME, PLANS, SHOW_PLAN, TRAINER, STATS, PROFILE, PROFILE_SETTINGS, CHOOSE}
    }

    interface Presenter {

        void onHomeIconClicked();

        void onPlansIconClicked();

        void onTrainerIconClicked();

        void onStatsIconClicked();

        void onProfileIconClicked();

        void onSearchIconClicked();

        void onShowPlanClicked();

        void onBackPressed();

        void onLogOutIconClicked();

        void onProfileSettingsClicked();

        void onEditIconClicked();

        void onTimerIconClicked();

        void onMaxStrengthTestIconClicked();

        void onAdviceTrainerIconClicked();
    }

}
