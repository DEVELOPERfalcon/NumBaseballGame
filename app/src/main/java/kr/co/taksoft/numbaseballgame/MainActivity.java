package kr.co.taksoft.numbaseballgame;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText et1;
    EditText et2;
    EditText et3;
    Button btn;
    ScrollView scroll;
    TextView tv;

    int com;
    int com1;
    int com2;
    int com3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        do {
            com = new Random().nextInt(900) + 100;
            com1 = com/100;
            com2 = (com-com1*100)/10;
            com3 = com-com1*100-com2*10;
        }while (com1==com2 || com1==com3 || com2==com3);

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        et3 = findViewById(R.id.et3);
        btn = findViewById(R.id.btn);
        scroll = findViewById(R.id.scroll);
        tv = findViewById(R.id.tv);


        btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if(et1.getText().toString().length()==1 && et2.getText().toString().length()==1 && et3.getText().toString().length()==1){
                    int strike=0;
                    int ball=0;
                    int num1 = Integer.parseInt(et1.getText().toString());
                    int num2 = Integer.parseInt(et2.getText().toString());
                    int num3 = Integer.parseInt(et3.getText().toString());
                    et1.setText("");
                    et2.setText("");
                    et3.setText("");
                    if(num1==num2 || num1==num3 || num2==num3){
                        tv.setText(tv.getText().toString()+"\n중복된 값을 입력하셨습니다. 다시 입력하세요.");
                        return;
                    }else{
                        if(com1==num1) strike++;
                        else if(com1==num2) ball++;
                        else if(com1==num3) ball++;
                        if(com2==num1) ball++;
                        else if(com2==num2) strike++;
                        else if(com2==num3) ball++;
                        if(com3==num1) ball++;
                        else if(com3==num2) ball++;
                        else if(com3==num3) strike++;

                        if(strike==3) tv.setText(tv.getText().toString()+"\n"+strike+"strike"+", "+ball+"ball"+"\n클리어 하셨습니다. \n축하합니다.");
                        else tv.setText(tv.getText().toString()+"\n"+strike+"strike"+", "+ball+"ball");
                    }
                }else tv.setText(tv.getText().toString()+"\n입력이 덜 되었습니다.");
                //tv.scrollTo(0, tv.getBottom());
                scroll.fullScroll(View.FOCUS_DOWN);
            }
        });
    }
}
