package com.example.quiznightt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quiznightt.sql.QuModule;
import com.example.quiznightt.sql.sql;

import java.util.List;
import java.util.Random;

public class PlayAct extends AppCompatActivity {
    private TextView Qusti ,Anas1,Anas2,Anas3,Anas4,timerTxt,Score,Lives;
    int score=0,lives=3;
    private String RightAns="";
    private List<QuModule>qustList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
    }

    private  void Int(){
      Qusti=findViewById(R.id.qu_text);
        Anas1=findViewById(R.id.ans1);
        Anas2=findViewById(R.id.ans2);
        Anas3=findViewById(R.id.ans3);
        Anas4=findViewById(R.id.ans4);
        timerTxt=findViewById(R.id.timer_txt);
       Score=findViewById(R.id.score_txt);
        Lives=findViewById(R.id.lives_txt);

        qustList= sql.getInstance().Start(PlayAct.this).getAllQus();
    }


    private void showQuestion(int liv){
        Random r=new Random();
        if(liv>0){

            QuModule q=qustList.get(r.nextInt(qustList.size()));
            Qusti.setText(q.getQus());
            Anas1.setText(q.getAns1());
            Anas2.setText(q.getAns2());
            Anas3.setText(q.getAns3());
          Anas4.setText(q.getAns4());
          RightAns=q.getR_ans();
        }

    }
    private  boolean checkAns(String Ans){
        return Ans.equals(RightAns);
    }

    public void monClickHandeler(View v){

   TextView clickedText=(TextView)v;

String chosedAns=clickedText.getText()+"";

if(checkAns(chosedAns)){
    Toast.makeText(this,"إجابة صحيحة",Toast.LENGTH_SHORT).show();

}else {
    Toast.makeText(this,"إجابة خاطئة",Toast.LENGTH_SHORT).show();

}
    }

}
