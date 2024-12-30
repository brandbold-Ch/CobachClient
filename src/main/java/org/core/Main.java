package org.core;

import org.core.views.LoginView;


public class Main {

    public static void main(String[] args) {
        new LoginView();

        /*
        AuthService authService = new AuthService(new AuthAdapter());
        LoadServices loadServices = new LoadServices(new LoadAdapter());

        try {
            authService.login("CXGE070815HCSNMRA5", "22A0710217M0041");
            loadServices.get("22A0710217M0041", 1);

            System.out.println(StudentModel.getInstance().getEnrollment());
            System.out.println(StudentModel.getInstance().getNames());
            System.out.println(StudentModel.getInstance().getDetails());

        } catch (InvalidRequest | IOException | InterruptedException | IncorrectPassword | NotFound e) {
            throw new RuntimeException(e);
        }

         */
    }
}
