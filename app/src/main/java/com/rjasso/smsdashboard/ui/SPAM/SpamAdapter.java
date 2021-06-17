package com.rjasso.smsdashboard.ui.SPAM;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rjasso.smsdashboard.R;
import com.rjasso.smsdashboard.database.Spam;
import com.rjasso.smsdashboard.model.SMSMessage;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class SpamAdapter extends RecyclerView.Adapter<SpamAdapter.SpamViewHolder> {
    private List<Spam> messages;

    public SpamAdapter(List<Spam> messages) {
        this.messages = messages;
    }

    @NonNull
    @NotNull
    @Override
    public SpamViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new SpamViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.message_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull SpamViewHolder holder, int position) {
        Spam message = messages.get(position);
        ((TextView)holder.itemView.findViewById(R.id.item_address)).setText(message.getAddress());
        ((TextView)holder.itemView.findViewById(R.id.item_body)).setText(message.getBody());
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    public class SpamViewHolder extends RecyclerView.ViewHolder{
        public SpamViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
        }
    }
}
