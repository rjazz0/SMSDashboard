package com.rjasso.smsdashboard.ui.SMS;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.rjasso.smsdashboard.SMSRepository;

import org.jetbrains.annotations.NotNull;

class SMSViewModelFactory implements ViewModelProvider.Factory {
    private SMSRepository repository;

    SMSViewModelFactory(SMSRepository repository) {
        this.repository = repository;
    }

    @NonNull
    @NotNull
    @Override
    public <T extends ViewModel> T create(@NonNull @NotNull Class<T> modelClass) {
        return (T) new SMSViewModel(repository);
    }
}