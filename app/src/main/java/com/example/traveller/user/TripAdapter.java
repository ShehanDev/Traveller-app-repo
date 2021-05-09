package com.example.traveller.user;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.traveller.R;
import com.example.traveller.dataBases.Trip;

import java.util.ArrayList;
import java.util.List;

public class TripAdapter extends  RecyclerView.Adapter<TripHolder> {
    private final Context context;
    List<Trip> myTripList;


    public TripAdapter(Context context, List<Trip> myTripList) {
        this.context = context;
        this.myTripList = myTripList;
    }


    @Override
    public TripHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mview = LayoutInflater.from ( viewGroup.getContext ( ) ).inflate ( R.layout.recycler_row_item, viewGroup, false );
        return new TripHolder ( mview );
    }

    @Override
    public void onBindViewHolder(@NonNull TripHolder holder, int position) {

       Glide.with ( context ).load ( myTripList.get ( position ).getImageURL ( ) ).into ( holder.imageView1 );
      //

        holder.mTitle.setText ( myTripList.get ( position ).getTname ( ) );
        holder.mdescription.setText ( myTripList.get ( position ).getDiscription ( ) );
        holder.mLocation.setText ( myTripList.get ( position ).getLocation ( ) );

        holder.mcardVeiw.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {

                Intent intent =new Intent ( context,TripDetails.class );
                intent.putExtra ( "txdImage",myTripList.get ( holder.getAdapterPosition () ).getImageURL ( ) );
                intent.putExtra ( "txdname",myTripList.get ( holder.getAdapterPosition () ).getTname () );
                intent.putExtra ( "txdlocation",myTripList.get ( holder.getAdapterPosition () ).getLocation () );
                intent.putExtra ( "txddes",myTripList.get ( holder.getAdapterPosition () ).getDiscription () );
                context.startActivity ( intent );

            }
        } );
    }

    @Override
    public int getItemCount() {

        return myTripList.size ( );
    }



}
class  TripHolder extends RecyclerView.ViewHolder {
    ImageView imageView1;
    TextView mTitle,mdescription,mLocation;
    CardView mcardVeiw;

    public TripHolder( View itemView) {
        super ( itemView );
        imageView1 = itemView.findViewById ( R.id.ivImage );
        mTitle = itemView.findViewById ( R.id.tripTitle );
        mdescription = itemView.findViewById ( R.id.tvDescrip );
        mLocation = itemView.findViewById ( R.id.tvLoc );

        mcardVeiw = itemView.findViewById ( R.id.MytripCardVeiw );

    }
}

