package com.rjasso.smsdashboard.ui.SMS;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SMSViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SMSViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}