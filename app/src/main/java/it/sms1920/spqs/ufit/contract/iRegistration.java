package it.sms1920.spqs.ufit.contract;

public interface iRegistration {
    interface View {

        void setInputError(Presenter.InputErrorType inputErrorType);

        void setSignUpError(Presenter.AuthResultType authResultType);

        void startLauncherActivity();

        void setEnabledUI(boolean enabled);

        void startLoginActivity();

    }

    interface Presenter {

        enum InputErrorType {
            EMAIL_FIELD_EMPTY,
            EMAIL_FORMAT_NOT_VALID,
            PASSWORD_FIELD_EMPTY,
            PASSWORD_FORMAT_NOT_VALID,
            PASSWORDS_NOT_MATCHING
        }

        enum AuthResultType {
            SIGNUP_SUCCESSFUL,
            USER_ALREADY_EXISTS
        }

        void onSignUp(String email, String password, String confirmPassword);

        void onLoginRequest();

        void onBackPressed();

        void returnSignUpResult(AuthResultType check);

        void signUpSuccessful();
    }
}