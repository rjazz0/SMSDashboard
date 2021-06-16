package com.rjasso.smsdashboard.ui.SPAM;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SPAMViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SPAMViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}