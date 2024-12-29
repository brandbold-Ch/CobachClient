package org.core.services;


import org.core.adapters.LoadAdapter;
import org.core.adapters.exceptions.InvalidRequest;
import org.core.models.LoadsModel;
import org.core.models.StudentModel;

import java.io.IOException;
import java.util.ArrayList;

public class LoadServices {

    private final LoadAdapter loadAdapter;

    public LoadServices(LoadAdapter loadAdapter) {
        this.loadAdapter = loadAdapter;
    }

    public void get(String enrollment, int partial) throws InvalidRequest,
            IOException, InterruptedException {
        ArrayList<LoadsModel> loadsArrayList = loadAdapter.get(enrollment, partial);
        StudentModel.getInstance().setLoads(loadsArrayList);
    }
}
