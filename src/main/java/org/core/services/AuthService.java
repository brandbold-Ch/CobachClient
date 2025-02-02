package org.core.services;

import org.core.adapters.AuthAdapter;
import org.core.adapters.exceptions.IncorrectPassword;
import org.core.adapters.exceptions.InvalidRequest;
import org.core.adapters.exceptions.NotFound;
import org.core.models.StudentModel;

import java.io.IOException;

public class AuthService {

    private final AuthAdapter authAdapter;

    public AuthService(AuthAdapter authAdapter) {
        this.authAdapter = authAdapter;
    }

    public boolean login(String username, String password)
            throws InvalidRequest, IOException, InterruptedException, IncorrectPassword, NotFound {

        boolean response = authAdapter.post(username, password);
        if (response) StudentModel.getInstance().setAccessed(true);
        return response;
    }
}
