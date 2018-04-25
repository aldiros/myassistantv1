package com.example.aldiros.myassistant;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by aldiros on 25/04/2018.
 */

public class babysitterAdapter extends RecyclerView.Adapter<babysitterAdapter.babysitterViewHolder> {

    Context mCtx;
    List<babysitterUser> babysitterList;

    public babysitterAdapter(Context mCtx, List<babysitterUser> babsitterList) {
        this.mCtx = mCtx;
        this.babysitterList = babsitterList;
    }


    @Override
    public babysitterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_babysitter, parent, false);
        babysitterViewHolder babysitterViewHolder = new babysitterViewHolder(view);

        return babysitterViewHolder;
    }

    @Override
    public void onBindViewHolder( babysitterViewHolder holder, int position) {
        babysitterUser bs = babysitterList.get(position);
        holder.user_alamat.setText(bs.getAlamat());
        holder.user_gaji.setText(bs.getGaji());
        holder.user_nama.setText(bs.getNama());
//        holder.user_image.setImageURI(Uri.parse(bs.getImage()));
    }

    @Override
    public int getItemCount() {
        return babysitterList.size();
    }

    class babysitterViewHolder extends RecyclerView.ViewHolder{

        public TextView user_alamat, user_gaji, user_nama;
        //        public ImageView user_image;
        public babysitterViewHolder(View itemView) {
            super(itemView);

            user_alamat = (TextView) itemView.findViewById(R.id.alamat);
            user_gaji = (TextView) itemView.findViewById(R.id.gaji);
//            user_image = (ImageView) itemView.findViewById(R.id.image);
            user_nama = (TextView) itemView.findViewById(R.id.nama);
        }
    }

}
