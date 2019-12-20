package com.example.weatherappapi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.weatherappapi.R;
import com.example.weatherappapi.model.ForeCastFiveDay;
import java.util.List;

public class FiveDayAdapter extends RecyclerView.Adapter<FiveDayAdapter.ViewHolder> {
    /*private List<ForeCastFiveDay.List.Main> list1;
    private List<ForeCastFiveDay.List.Weather> list2;*/
    private List<ForeCastFiveDay.List> list;

    private Context context;


    public FiveDayAdapter(List<ForeCastFiveDay.List> list,Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_five_day, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        ForeCastFiveDay.List foreCastFiveDay = list.get(position);
//        holder.txvTems.setText(foreCastFiveDay.getMain().getTemp()+"");

        double tems = list.get(position).getMain().getTemp() -273.15;//đổi từ độ K sang độ C
        double temsRound = Math.round(tems*10)/10;//làm tròn lấy 1 chữ số sau dấu phẩy

        holder.txvTems.setText(temsRound + "°C");
        holder.txvClouds.setText(list.get(position).getWeather().get(0).getDescription());
        holder.txvDateMonth.setText(list.get(position).getDtTxt());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txvTems, txvClouds, txvDateMonth;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txvTems = itemView.findViewById(R.id.txvTems);
            txvClouds = itemView.findViewById(R.id.txvClouds);
            txvDateMonth = itemView.findViewById(R.id.txvDateMonth);
        }
    }
}
