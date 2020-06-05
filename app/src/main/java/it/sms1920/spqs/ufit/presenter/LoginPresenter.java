package it.sms1920.spqs.ufit.presenter;

import android.text.TextUtils;

import it.sms1920.spqs.ufit.contract.Login;
import it.sms1920.spqs.ufit.model.Auth;

public class LoginPresenter implements Login.Presenter {
    final static int SINGUP_SUCCESSFULL = 0;
    final static int EMAIL_NOT_MATCH = 4;
    final static int PASSWORD_NOT_MATCH = 5;


    private Login.View view;
    private Auth auth;

    public LoginPresenter(Login.View view) {
        this.view = view;
    }


    @Override
    public void onSignIn(String email, String password) {
        auth = new Auth();
        auth.setEmail(email);
        auth.setPassword(password);


        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            view.showSignInFail("Fields are empty");
        } else
            auth.signIn(this);

    }

    @Override
    public void onResultSignIn(int check) {
        switch (check) {
            case PASSWORD_NOT_MATCH:
                view.showSignInFail("Password not match");
                break;
            case SINGUP_SUCCESSFULL:
                view.showSignInSuccessFully("Login successfully");
                break;
            case EMAIL_NOT_MATCH:
                view.showSignInFail("This user doesn't exists");
                break;
        }
    }

}
