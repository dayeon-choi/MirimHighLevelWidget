package kr.hs.emirim.s2019w18.mirimhighlevelwidget;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    RadioButton radioDate,radioTime;
    DatePicker datePicker;
    TimePicker timePicker;
    TextView textResult;
    Chronometer chrono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation2);
        radioDate = findViewById(R.id.radio_date);
        radioTime = findViewById(R.id.radio_time);
        radioDate.setOnClickListener(radioListener);
        radioTime.setOnClickListener(radioListener);
        datePicker=findViewById(R.id.date_pick);
        timePicker=findViewById(R.id.time_pick);
        chrono=findViewById(R.id.chrono1);
        chrono.setOnClickListener(chronoListener);
        textResult=findViewById(R.id.text_result);
        textResult.setOnLongClickListener(textListener);
    }

    View.OnClickListener radioListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.radio_date:
                    datePicker.setVisibility(View.VISIBLE);
                    timePicker.setVisibility(View.INVISIBLE);
                    break;
                case R.id.radio_time:
                    datePicker.setVisibility(View.INVISIBLE);
                    timePicker.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };
    View.OnClickListener chronoListener =new View.OnClickListener(){
        public void onClick(View v){
            chrono.setBase(SystemClock.elapsedRealtime());
            chrono.start();
            chrono.setTextColor(Color.RED);
            }
        };

    View.OnLongClickListener textListener=new View.OnLongClickListener(){
        public boolean onLongClick(View v){
            chrono.stop();
            chrono.setTextColor(Color.BLUE);
            textResult.setText(datePicker.getYear()+"년 "+(datePicker.getMonth()+1)+"월 "+timePicker.getCurrentHour()+"시 "+timePicker.getCurrentMinute()+"분");
            return false;//기본행동 취소
        }
    };
}