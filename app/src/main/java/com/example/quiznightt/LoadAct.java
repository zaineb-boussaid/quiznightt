package com.example.quiznightt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.quiznightt.sql.QuModule;
import com.example.quiznightt.sql.sql;

public class LoadAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);
         String [] qusti={"من باني ومؤسس مدينة القطائع؟",
                 "صوت العرير هو صوت؟",
                 "ما هي أكثر سورة قد ورد فيها اسم مريم؟",
                 "صوت الزمار هو صوت؟",
                 "من هي الدولة الإفريقية الثانية من حيث المساحة؟",
                 "ماذا يطلق على صوت النسر؟",
                 "ماذا يطلق على صوت العصفور؟",
                 " كم ورد اسم نبي الله نوح في القرآن الكريم؟",
                 "ما هو الطائر الوحيد الذي باستطاعته تمييز اللون الأزرق؟"};
         String [] anas1={"المنصور بن أبي عامر",
                 "الذباب",
                 "المائدة",
                 "البومة",
                 "مصر",
                 "صليل",
                 "صياح",
                  "50 مرة",
                 "النسر" };

        String [] anas2={"أحمد بن طولون",
                "الفأر",
                "القصص",
                "الطاووس",
                "السودان",
                "نعيق",
                "تغريد",
                "22 مرة",
                "البومة" };

        String [] anas3={"أبو جعفر المنصور",
                "الجراد",
                "آل عمران",
                "الطاووس",
                "تونس",
                "صياح",
                "طنين",
                "43 مرة",
                "الصقر" };


        String [] anas4={"جوهر الصقلي",
                "الصرصار",
                "مريم",
                "اليمامة",
                "الجزائر",
                "صفير",
                "صرير",
                "ولا مرة",
                "الهدهد" };

        String []R_anas={"أحمد بن طولون",
                "الصرصار",
                "المائدة",
                "النعامة",
                "السودان",
                "صفير",
                "صياح",
                "43 مرة",
                "البومة" };
        int size=getSharedPreferences("info",0).getInt("quSize",0);
       if (size<qusti.length) {

           sql databaes = sql.getInstance().Start(LoadAct.this);
           for (int i = 0; i < qusti.length; ) {
               QuModule q = new QuModule();
               q.setQus(qusti[i]);
               q.setAns1(qusti[i]);
               q.setAns2(qusti[i]);
               q.setAns3(qusti[i]);
               q.setAns4(qusti[i]);
               q.setR_ans(qusti[i]);
               if (databaes.AddToDataBase(q)) {
                   i++;
               }
               if (i == qusti.length - 1) {

                   getSharedPreferences("info", 0).edit().putInt("quSize", qusti.length).apply();

               }
           }

       }



        new Thread(){

            @Override
            public void run() {
                super.run();
                try {
                    sleep(3 * 1000);
                    startActivity(new Intent(LoadAct.this,MainActivity.class));
                }catch(InterruptedException e){
                    e.printStackTrace();
                }


            }
        }.start();




    }
}
