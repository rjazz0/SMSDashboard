package com.rjasso.smsdashboard.ui.SPAM;

import android.content.ContentResolver;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.rjasso.smsdashboard.SMSRepository;
import com.rjasso.smsdashboard.database.Spam;

import java.util.List;

public class SpamViewModel extends ViewModel {

    private SMSRepository repository;

    public SpamViewModel(SMSRepository repository) {
        this.repository = repository;
    }

    public void getSMSs(ContentResolver contentResolver) {
        repository.getData(contentResolver);
    }

    public LiveData<List<Spam>> getSpamMessages() {
        return repository.getSpamMessagesLiveData();
    }
}