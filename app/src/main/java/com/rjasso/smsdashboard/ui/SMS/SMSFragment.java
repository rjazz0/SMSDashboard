package com.rjasso.smsdashboard.ui.SMS;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rjasso.smsdashboard.SMSRepository;
import com.rjasso.smsdashboard.database.Inbox;
import com.rjasso.smsdashboard.database.SMSMessagesDataBase;
import com.rjasso.smsdashboard.databinding.FragmentSmsBinding;

import java.util.ArrayList;
import java.util.List;

public class SMSFragment extends Fragment {

    private SMSViewModel viewModelSMS;
    private FragmentSmsBinding binding;
    private SMSRepository repository;
    private List<Inbox> messages = new ArrayList<>();
    private RecyclerView inboxRecyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        repository = new SMSRepository(SMSMessagesDataBase.getInstance(getActivity()));
        viewModelSMS = new ViewModelProvider(this, new SMSViewModelFactory(repository)).get(SMSViewModel.class);

        binding = FragmentSmsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        viewModelSMS.getInboxMessages().observe(getViewLifecycleOwner(), new Observer<List<Inbox>>() {
            @Override
            public void onChanged(List<Inbox> smsMessages) {
                messages.clear();
                messages.addAll(smsMessages);
                inboxRecyclerView.getAdapter().notifyDataSetChanged();
            }
        });

        inboxRecyclerView = binding.inboxRecyclerView;
        inboxRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        inboxRecyclerView.setAdapter(new InboxAdapter(messages));

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();

        viewModelSMS.getSMSs(getActivity().getContentResolver());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}