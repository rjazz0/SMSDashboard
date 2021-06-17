package com.rjasso.smsdashboard.ui.SPAM;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.rjasso.smsdashboard.SMSRepository;

import org.jetbrains.annotations.NotNull;

class SpamViewModelFactory implements ViewModelProvider.Factory {
    private SMSRepository repository;

    SpamViewModelFactory(SMSRepository repository) {
        this.repository = repository;
    }

    @NonNull
    @NotNull
    @Override
    public <T extends ViewModel> T create(@NonNull @NotNull Class<T> modelClass) {
        return (T) new SpamViewModel(repository);
    }
}