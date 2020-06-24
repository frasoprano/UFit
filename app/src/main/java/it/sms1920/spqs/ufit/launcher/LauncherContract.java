package it.sms1920.spqs.ufit.launcher;


public interface LauncherContract {

    interface View {
        void insertHomeFragment();

        void insertPlansFragment();

        void insertTrainerFragment();

        void insertStatsFragment();

        void insertProfileFragment();

        void startSearchActivity();

        void insertChooseFragment();

        void endActivity();

        void resetActivity();

        enum FragType {HOME, PLANS, TRAINER, STATS, PROFILE, SHOW_PLAN }
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

        void onShowPlanClosed();
    }

}
