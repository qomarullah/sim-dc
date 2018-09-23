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

import com.tech.sim.MenuActivity;
import com.tech.sim.R;
import com.tech.sim.model.ProjectItem;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;

public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.CustomViewHolder> {

    private List<ProjectItem> dataList;
    private Context context;

    public ProjectAdapter(Context context, List<ProjectItem> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

        TextView title, desc, created_date;
        private ImageView coverImage;
        RelativeLayout ll;
        //Button btnTraktir;

        CustomViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            ll= mView.findViewById(R.id.ll);
            title = mView.findViewById(R.id.title);
            desc = mView.findViewById(R.id.desc);
            created_date = mView.findViewById(R.id.created_date);

            coverImage = mView.findViewById(R.id.coverImage);

        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.project_row, parent, false);

        return new CustomViewHolder(view);
    }
    private String toRupiah(String nominal){
        String hasil = "";

        DecimalFormat toRupiah = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatAngka = new DecimalFormatSymbols();

        formatAngka.setCurrencySymbol("Rp. ");
        formatAngka.setMonetaryDecimalSeparator(',');
        toRupiah.setDecimalFormatSymbols(formatAngka);

        hasil = toRupiah.format(Double.valueOf(nominal));

        return hasil;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, final int position) {
        holder.title.setText(dataList.get(position).getTitle());
        holder.desc.setText(dataList.get(position).getDesc());
        holder.created_date.setText(dataList.get(position).getCreated_date());

        //holder.txtTotal.setText(x);
        holder.ll.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent intent = new Intent(context, MenuActivity.class);
                //EditText editText = (EditText) findViewById(R.id.editText);
                //String message = editText.getText().toString();
                intent.putExtra("PROJECT_ID", dataList.get(position).getId());
                context.startActivity(intent);
            }
        });

        /*Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context));
        builder.build().load(dataList.get(position).getThumbnailUrl())
                .placeholder((R.drawable.ic_launcher_background))
                .error(R.drawable.ic_launcher_background)
                .into(holder.coverImage);
        */
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}