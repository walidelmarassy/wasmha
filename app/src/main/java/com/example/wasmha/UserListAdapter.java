package com.example.wasmha;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter< UserListAdapter.UserViewHolder> {
    private LayoutInflater layoutInflater;
    private Context mcontext;
    private List<User>musers;
    private List<Emoji>memojis;

    public UserListAdapter(Context context) {
        layoutInflater=LayoutInflater.from(context);
        mcontext=context;
    }


    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview=layoutInflater.inflate(R.layout.list_item,parent,false);
        UserViewHolder viewHolder=new UserViewHolder(itemview);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        if (musers!=null){
            User user=musers.get(position);
            holder.setData(user.getMuser(),position);

        }
        else if(memojis!=null){
            Emoji emoji=memojis.get(position);
            holder.emojiitemview.setImageResource(emoji.getMemoji());

        }
        else {
            holder.useritemview.setText("nodata");
        }

    }

    @Override
    public int getItemCount() {
        if (musers!=null)
        return musers.size();
        else if (memojis!=null)
            return memojis.size();
        else return 0;


    }
    public void setUsers(List<User>users){
        musers=users;
        notifyDataSetChanged();
    }
    public void setEmojis(List<Emoji>emojis){
        memojis=emojis;
        notifyDataSetChanged();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        private TextView useritemview;
        private ImageView emojiitemview;
        private int mposition;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            useritemview=itemView.findViewById(R.id.text);
            emojiitemview=itemView.findViewById(R.id.image);

        }
        public void setData(String user,int position){
            useritemview.setText(user);
            mposition=position;
        }


        }
    }

