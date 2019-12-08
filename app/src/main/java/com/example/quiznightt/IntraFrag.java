package com.example.quiznightt;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quiznightt.R;

import java.util.List;
public class IntraFrag extends Fragment {
    private boolean isGrid=false;
    private LinearLayout noDataCon;
    private MyAdapter adapter;
    private ImageButton convert;
    private RecyclerView recyclerView;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){
        View root=inflater.inflate(R.layout.ftrag_intran,container,false);
        final Context co =getContext();

        recyclerView =root.findViewById(R.id.myRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(co));
        adapter =new MyAdapter;
        recyclerView =setAdapter(adapter);
       convert =root.findViewById(R.id.convert);
       convert.setOnClickListener(){
           if (isGrid){}else{
               isGrid=true;
               adapter.setmLayout(R.layout.row_artical_grid);
               convert.setImageResource(R.drawable.ic_list);
               recyclerView.setLayoutManager(new GridLayoutManager(co,2));
               recyclerView.setAdapter(adapter);
           }
        }


    }
}
