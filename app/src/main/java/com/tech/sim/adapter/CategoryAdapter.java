package com.tech.sim.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;
import com.tech.sim.ItemActivity;
import com.tech.sim.MenuActivity;
import com.tech.sim.R;
import com.tech.sim.model.CategoryItem;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CustomViewHolder> {

    private List<CategoryItem> dataList;
    private Context context;

    public CategoryAdapter(Context context, List<CategoryItem> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

        TextView title, status, count;
        private ImageView icon;
        RelativeLayout ll;

        CustomViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            ll= mView.findViewById(R.id.ll);
            title = mView.findViewById(R.id.title);
            //status = mView.findViewById(R.id.status);
            //created_date = mView.findViewById(R.id.created_date);

            icon = mView.findViewById(R.id.icon);

        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.category_row, parent, false);

        return new CustomViewHolder(view);
    }
    @Override
    public void onBindViewHolder(CustomViewHolder holder, final int position) {
        String code=dataList.get(position).getCode();
        holder.title.setText(code +". "+dataList.get(position).getTitle());
        //holder.status.setText(dataList.get(position).getCode());
        //holder.created_date.setText(dataList.get(position).getCreated_date());
        holder.ll.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent intent = new Intent(context, ItemActivity.class);
                intent.putExtra("CATEGORY_ID", dataList.get(position).getId());
                context.startActivity(intent);
            }
        });
        if(!dataList.get(position).getIcon().equals("")) {

            Picasso.Builder builder = new Picasso.Builder(context);
            builder.downloader(new OkHttp3Downloader(context));
            builder.build().load(dataList.get(position).getIcon())
                    .placeholder((R.drawable.ic_launcher_background))
                    .error(R.drawable.ic_launcher_background)
                    .into(holder.icon);
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}