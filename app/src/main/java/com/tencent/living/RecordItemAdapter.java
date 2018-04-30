package com.tencent.living;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.living.Data.Record;

import java.util.ArrayList;
import java.util.List;
public class RecordItemAdapter extends BaseAdapter {
    private List<RecordDetailPlan> data = new ArrayList<>();
    private Context context;
    public RecordItemAdapter(Context context) {
        this.context = context;
    }
    public int getCount() {
        return data.size();
    }
    public Object getItem(int position) {
        return data.get(position);
    }
    public long getItemId(int position) {
        return position;
    }
    public void addItem(Record record){
        data.add(new RecordDetailPlan(context, record));
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        return data.get(position).getView();
    }
}
