package com.rjasso.smsdashboard.ui.SMS;

import android.content.ContentResolver;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.rjasso.smsdashboard.SMSRepository;
import com.rjasso.smsdashboard.database.Inbox;

import java.util.List;

public class SMSViewModel extends ViewModel {

    private SMSRepository repository;

    public SMSViewModel(SMSRepository repository) {
        this.repository = repository;
    }

    public void getSMSs(ContentResolver contentResolver) {
        repository.getData(contentResolver);
    }

    public LiveData<List<Inbox>> getInboxMessages() {
        return repository.getInboxMessagesLiveData();
    }
}