package com.rjasso.smsdashboard.ui.SPAM;

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
import com.rjasso.smsdashboard.database.SMSMessagesDataBase;
import com.rjasso.smsdashboard.database.Spam;
import com.rjasso.smsdashboard.databinding.FragmentSpamBinding;

import java.util.ArrayList;
import java.util.List;


    public class SPAMFragment extends Fragment {

        private SpamViewModel viewModelSPAM;
        private FragmentSpamBinding binding;
        private SMSRepository repository;
        private List<Spam> messages = new ArrayList<>();
        private RecyclerView spamRecyclerView;

        public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            repository = new SMSRepository(SMSMessagesDataBase.getInstance(getActivity()));
            viewModelSPAM = new ViewModelProvider(this, new SpamViewModelFactory(repository)).get(SpamViewModel.class);

            binding = FragmentSpamBinding.inflate(inflater, container, false);
            View root = binding.getRoot();

            viewModelSPAM.getSpamMessages().observe(getViewLifecycleOwner(), new Observer<List<Spam>>() {
                @Override
                public void onChanged(List<Spam> smsMessages) {
                    messages.clear();
                    messages.addAll(smsMessages);
                    spamRecyclerView.getAdapter().notifyDataSetChanged();
                }
            });

            spamRecyclerView = binding.spamRecyclerView;
            spamRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            spamRecyclerView.setAdapter(new SpamAdapter(messages));

            return root;
        }

        @Override
        public void onResume() {
            super.onResume();
            viewModelSPAM.getSMSs(getActivity().getContentResolver());
        }

        @Override
        public void onDestroyView() {
            super.onDestroyView();
            binding = null;
        }
    }