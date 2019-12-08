package com.example.quiznightt;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShowOneArticle extends Fragment {

    public ShowOneArticle() {

    }



    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.frag_show_one_article,container,false);

        TextView title=v.findViewById(R.id.title);
        TextView type=v.findViewById(R.id.type);
        TextView date=v.findViewById(R.id.date);
        TextView content=v.findViewById(R.id.content);
        ImageView photo =v.findViewById(R.id.articlePhoto);

        MoveObj data=MoveObj.getInstance().Start(Objects.requireNonNull(getContext()));
        String sTitle=data.getTitle();
        String sType=data.getType();
        String sDate=data.getDate();
        String sContent=data.getContent();
        String sPhoto=data.getPhoto();
        title.setText(sTitle);
        type.setText(sType);
        date.setText(sDate);
        content.setText(sContent);



        return v;
    }
}
