package com.rjasso.smsdashboard.ui.SMS;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rjasso.smsdashboard.R;
import com.rjasso.smsdashboard.database.Inbox;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class InboxAdapter extends RecyclerView.Adapter<InboxAdapter.InboxViewHolder> {
    private List<Inbox> messages;

    public InboxAdapter(List<Inbox> messages) {
        this.messages = messages;
    }

    @NonNull
    @NotNull
    @Override
    public InboxViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new InboxViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.message_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull InboxViewHolder holder, int position) {
        Inbox message = messages.get(position);
        ((TextView)holder.itemView.findViewById(R.id.item_address)).setText(message.getAddress());
        ((TextView)holder.itemView.findViewById(R.id.item_body)).setText(message.getBody());
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    public class InboxViewHolder extends RecyclerView.ViewHolder{
        public InboxViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
        }
    }
}
