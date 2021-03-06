package it.sms1920.spqs.ufit.launcher.traineradvice;


public interface AdviceListContract {
    interface View {

        void callNotifyDataSetChanged();

        void addNewAdvice(String title, String description);

        interface Item {
            void setTitle(String name);

            void setDescription(String name);

            void setPosition(int position);

            void setAuthor(String author);

            void setAdviceId(String adviceId);
        }

        void setRandomAdvice(String title, String description);
    }

    interface Presenter {
        void onDeleteClicked(int position, String adviceId);

        void onBindAdviceItemListViewAtPosition(AdviceListContract.View.Item holder, int position);

        int getAdviceCount();

        void addNewAdviceItem(String title, String description, String author);

        void onPersonalAdviceRequired();

        void getRandomAdvice();


    }
}
