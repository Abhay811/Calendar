package abhay.mypappcompany.calendar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayout;
    GridLayout daysLayout;
    Button[] daysButton=new Button[49];
    ImageButton previousMonth,nextMonth;
    Button showMonth;
    Button monthYear;
    Button newEvent;
    int ccode;
    int[] centuryCode={2,0,6,4,2,0};
    int[] monthCode={0,3,3,6,1,4,6,2,5,0,3,5};
    int monthCount;
    int year=2020;
    int month=2;
    int firstDate=1;
    int last_2_DigitofYear;
    String[] days={"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
    String[] monthsName={"January","February","March","April","May","June","July","August","September","October","November","December"};

    Button yearButton;
    ImageButton previousYears,nextYears;
    GridLayout monthLayout;
    GridLayout yearGrid;
    LinearLayout next_Years;
    Button[] months=new Button[12];
    Button[] years=new Button[16];
    TextView yearTextView;
    int currentYear=2020;
    int previous,next;
    String monthAndYear;
    public void onNewEventClicked(){
        Intent intent =new Intent(MainActivity.this,NewEvent.class);
        startActivity(intent);
    }
    public int calculateDay(){
        int result,yearCode,leapCode=0;
        if(((year % 4 == 0) && (year % 100 != 0)) ||(year % 400 == 0))
        {
            if(month<2)
            leapCode=1;
        }
        else{
            leapCode=0;
        }
        last_2_DigitofYear=year%100;
        yearCode=(last_2_DigitofYear+(last_2_DigitofYear/4))%7;
        result=yearCode+monthCode[month]+centuryCode[ccode]+firstDate-leapCode;
        int day=result%7;
        return day;

    }

    public void showDates(){
        for(int i=7;i<49;i++)
            daysButton[i].setText("");
        getYearCode(year);
        int startingDay=calculateDay();
        monthYear.setText(monthsName[month]+" "+Integer.toString(year));
        int j=0,m=0;
        for(int i=0;i<49;i++) {
            if(month==1&&(((year % 4 == 0) && (year % 100 != 0)) ||(year % 400 == 0))&&i>=1 && i<=29){
                daysButton[i + 6 + startingDay].setText(Integer.toString(i));
            }else if(month!=1 && i>=1 && i<=31) {
                daysButton[i + 6 + startingDay].setText(Integer.toString(i));
            }else if(i>=1&& i<29){
                daysButton[i + 6 + startingDay].setText(Integer.toString(i));
            }
            if(daysButton[i].getTag().equals(Integer.toString(j*7))){
                daysButton[i].setTextColor(Color.RED);
                j++;
            }
            if(daysButton[i].getTag().equals(Integer.toString(6+m*7))){
                daysButton[i].setTextColor(Color.RED);
                m++;
            }
        }

    }
    public void getYearCode(int year)
    {
        if(year>=1800&& year<1900)
            ccode=0;
        else if(year>=1900&& year<2000)
            ccode=1;
        else if(year>=2000&& year<2100)
            ccode=2;
        else if(year>=2100&& year<2200)
            ccode=3;
        else if(year>=2200&& year<2300)
            ccode=4;
        else if(year>=2300&& year<2400)
            ccode=5;
    }

    public void onPreviousClicked(View view){
        previousMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=7;i<49;i++)
                    daysButton[i].setText("");
                month--;
                if(month<0){
                    month=11;
                    year--;

                }

                showDates();
            }
        });

    }
    public void onNextClicked(View view){
        nextMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=7;i<49;i++)
                    daysButton[i].setText("");
                month++;
                if(month>11){
                    month=0;
                    year++;

                }

                showDates();
            }
        });

    }
    public void onMonthYearClicked(View view){

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout=findViewById(R.id.linearLayout);
        daysLayout=findViewById(R.id.daysLayout);
        daysButton[0]=findViewById(R.id.sun0);  daysButton[1]=findViewById(R.id.mon0);  daysButton[2]=findViewById(R.id.tue0);  daysButton[3]=findViewById(R.id.wed0);  daysButton[4]=findViewById(R.id.thu0);  daysButton[5]=findViewById(R.id.fri0);  daysButton[6]=findViewById(R.id.sat0);
        daysButton[7]=findViewById(R.id.sun1);  daysButton[8]=findViewById(R.id.mon1);  daysButton[9]=findViewById(R.id.tue1);  daysButton[10]=findViewById(R.id.wed1); daysButton[11]=findViewById(R.id.thu1); daysButton[12]=findViewById(R.id.fri1); daysButton[13]=findViewById(R.id.sat1);
        daysButton[14]=findViewById(R.id.sun2); daysButton[15]=findViewById(R.id.mon2); daysButton[16]=findViewById(R.id.tue2); daysButton[17]=findViewById(R.id.wed2); daysButton[18]=findViewById(R.id.thu2); daysButton[19]=findViewById(R.id.fri2); daysButton[20]=findViewById(R.id.sat2);
        daysButton[21]=findViewById(R.id.sun3); daysButton[22]=findViewById(R.id.mon3); daysButton[23]=findViewById(R.id.tue3); daysButton[24]=findViewById(R.id.wed3); daysButton[25]=findViewById(R.id.thu3); daysButton[26]=findViewById(R.id.fri3); daysButton[27]=findViewById(R.id.sat3);
        daysButton[28]=findViewById(R.id.sun4); daysButton[29]=findViewById(R.id.mon4); daysButton[30]=findViewById(R.id.tue4); daysButton[31]=findViewById(R.id.wed4); daysButton[32]=findViewById(R.id.thu4); daysButton[33]=findViewById(R.id.fri4); daysButton[34]=findViewById(R.id.sat4);
        daysButton[35]=findViewById(R.id.sun5); daysButton[36]=findViewById(R.id.mon5); daysButton[37]=findViewById(R.id.tue5); daysButton[38]=findViewById(R.id.wed5); daysButton[39]=findViewById(R.id.thu5); daysButton[40]=findViewById(R.id.fri5); daysButton[41]=findViewById(R.id.sat5);
        daysButton[42]=findViewById(R.id.sun6); daysButton[43]=findViewById(R.id.mon6); daysButton[44]=findViewById(R.id.tue6); daysButton[45]=findViewById(R.id.wed6); daysButton[46]=findViewById(R.id.thu6); daysButton[47]=findViewById(R.id.fri6); daysButton[48]=findViewById(R.id.sat6);

        previousMonth=(ImageButton)findViewById(R.id.previousMonth);
        nextMonth=(ImageButton)findViewById(R.id.nextMonth);
        monthYear=(Button) findViewById(R.id.month_year);
        showMonth=(Button)findViewById(R.id.month_year);
        newEvent=(Button)findViewById(R.id.newEvent);

        yearButton=findViewById(R.id.currentYear);
        monthLayout=findViewById(R.id.monthLayout);
        next_Years=findViewById(R.id.next_Years);
        previousYears=(ImageButton)findViewById(R.id.previousYears);
        nextYears=(ImageButton)findViewById(R.id.nextYears);
        yearTextView=(TextView)findViewById(R.id.yearTextView);
        yearGrid=findViewById(R.id.yearGrid);
        months[0]=findViewById(R.id.month0);        months[1]=findViewById(R.id.month1);        months[2]=findViewById(R.id.month2);        months[3]=findViewById(R.id.month3);
        months[4]=findViewById(R.id.month4);        months[5]=findViewById(R.id.month5);        months[6]=findViewById(R.id.month6);        months[7]=findViewById(R.id.month7);
        months[8]=findViewById(R.id.month8);          months[9]=findViewById(R.id.month9);        months[10]=findViewById(R.id.month10);        months[11]=findViewById(R.id.month11);
        years[0]=findViewById(R.id.button19);        years[1]=findViewById(R.id.button20);        years[2]=findViewById(R.id.button21);        years[3]=findViewById(R.id.button22);
        years[4]=findViewById(R.id.button23);        years[5]=findViewById(R.id.button24);        years[6]=findViewById(R.id.button25);        years[7]=findViewById(R.id.button26);
        years[8]=findViewById(R.id.button27);        years[9]=findViewById(R.id.button28);        years[10]=findViewById(R.id.button29);        years[11]=findViewById(R.id.button30);
        years[12]=findViewById(R.id.button31);        years[13]=findViewById(R.id.button32);        years[14]=findViewById(R.id.button33);        years[15]=findViewById(R.id.button34);

        showDates();

        monthYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayout.setVisibility(View.INVISIBLE);
                daysLayout.setVisibility(View.INVISIBLE);
                newEvent.setVisibility(View.INVISIBLE);
                yearButton.setVisibility(View.VISIBLE);
                monthLayout.setVisibility(View.VISIBLE);
                yearButton.setText(Integer.toString(year));

            }
        });



        yearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yearButton.setVisibility(View.INVISIBLE);
                monthLayout.setVisibility(View.INVISIBLE);

                next_Years.setVisibility(View.VISIBLE);
                yearGrid.setVisibility(View.VISIBLE);
                year=currentYear/16;
                year=year*16+1;
                yearTextView.setText(Integer.toString(year)+" - "+Integer.toString(year+15));
                next=previous=year;
                for(int i=0;i<16;i++)
                {
                    years[i].setText(Integer.toString(year+i));
                }

            }
        });

        previousYears.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                previous-=16;

                year=previous;
                yearTextView.setText(Integer.toString(year)+" - "+Integer.toString(year+15));
                for(int i=0;i<16;i++)
                {
                    years[i].setText(Integer.toString(year+i));
                }
                next-=16;
            }
        });

        nextYears.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next+=16;
                previous+=16;
                year=next;
                yearTextView.setText(Integer.toString(year)+" - "+Integer.toString(year+15));
                for(int i=0;i<16;i++)
                {
                    years[i].setText(Integer.toString(year+i));
                }

            }
        });
        months[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yearButton.setVisibility(View.INVISIBLE);
                monthLayout.setVisibility(View.INVISIBLE);
                newEvent.setVisibility(View.VISIBLE);
                linearLayout.setVisibility(View.VISIBLE);
                daysLayout.setVisibility(View.VISIBLE);
                month=0;
                year=Integer.parseInt((String) yearButton.getText());
                showDates();

            }
        });
        months[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yearButton.setVisibility(View.INVISIBLE);
                monthLayout.setVisibility(View.INVISIBLE);
                newEvent.setVisibility(View.VISIBLE);
                linearLayout.setVisibility(View.VISIBLE);
                daysLayout.setVisibility(View.VISIBLE);
                month=1;
                year=Integer.parseInt((String) yearButton.getText());
                showDates();

            }
        });
        months[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yearButton.setVisibility(View.INVISIBLE);
                monthLayout.setVisibility(View.INVISIBLE);
                newEvent.setVisibility(View.VISIBLE);
                linearLayout.setVisibility(View.VISIBLE);
                daysLayout.setVisibility(View.VISIBLE);
                month=2;
                year=Integer.parseInt((String) yearButton.getText());
                showDates();

            }
        });
        months[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yearButton.setVisibility(View.INVISIBLE);
                monthLayout.setVisibility(View.INVISIBLE);
                newEvent.setVisibility(View.VISIBLE);
                linearLayout.setVisibility(View.VISIBLE);
                daysLayout.setVisibility(View.VISIBLE);
                month=3;
                year=Integer.parseInt((String) yearButton.getText());
                showDates();

            }
        });
        months[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yearButton.setVisibility(View.INVISIBLE);
                monthLayout.setVisibility(View.INVISIBLE);
                newEvent.setVisibility(View.VISIBLE);
                linearLayout.setVisibility(View.VISIBLE);
                daysLayout.setVisibility(View.VISIBLE);
                month=4;
                year=Integer.parseInt((String) yearButton.getText());
                showDates();

            }
        });
        months[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yearButton.setVisibility(View.INVISIBLE);
                monthLayout.setVisibility(View.INVISIBLE);
                newEvent.setVisibility(View.VISIBLE);
                linearLayout.setVisibility(View.VISIBLE);
                daysLayout.setVisibility(View.VISIBLE);
                month=5;
                year=Integer.parseInt((String) yearButton.getText());
                showDates();

            }
        });
        months[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yearButton.setVisibility(View.INVISIBLE);
                monthLayout.setVisibility(View.INVISIBLE);
                newEvent.setVisibility(View.VISIBLE);
                linearLayout.setVisibility(View.VISIBLE);
                daysLayout.setVisibility(View.VISIBLE);
                month=6;
                year=Integer.parseInt((String) yearButton.getText());
                showDates();

            }
        });
        months[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yearButton.setVisibility(View.INVISIBLE);
                monthLayout.setVisibility(View.INVISIBLE);
                newEvent.setVisibility(View.VISIBLE);
                linearLayout.setVisibility(View.VISIBLE);
                daysLayout.setVisibility(View.VISIBLE);
                month=7;
                year=Integer.parseInt((String) yearButton.getText());
                showDates();

            }
        });
        months[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yearButton.setVisibility(View.INVISIBLE);
                monthLayout.setVisibility(View.INVISIBLE);
                newEvent.setVisibility(View.VISIBLE);
                linearLayout.setVisibility(View.VISIBLE);
                daysLayout.setVisibility(View.VISIBLE);
                month=8;
                year=Integer.parseInt((String) yearButton.getText());
                showDates();

            }
        });
        months[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yearButton.setVisibility(View.INVISIBLE);
                monthLayout.setVisibility(View.INVISIBLE);
                newEvent.setVisibility(View.VISIBLE);
                linearLayout.setVisibility(View.VISIBLE);
                daysLayout.setVisibility(View.VISIBLE);
                month=9;
                year=Integer.parseInt((String) yearButton.getText());
                showDates();

            }
        });
        months[10].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yearButton.setVisibility(View.INVISIBLE);
                monthLayout.setVisibility(View.INVISIBLE);
                newEvent.setVisibility(View.VISIBLE);
                linearLayout.setVisibility(View.VISIBLE);
                daysLayout.setVisibility(View.VISIBLE);
                month=10;
                year=Integer.parseInt((String) yearButton.getText());
                showDates();

            }
        });
        months[11].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yearButton.setVisibility(View.INVISIBLE);
                monthLayout.setVisibility(View.INVISIBLE);
                newEvent.setVisibility(View.VISIBLE);
                linearLayout.setVisibility(View.VISIBLE);
                daysLayout.setVisibility(View.VISIBLE);
                month=11;
                year=Integer.parseInt((String) yearButton.getText());
                showDates();

            }
        });
        years[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yearButton.setVisibility(View.VISIBLE);
                monthLayout.setVisibility(View.VISIBLE);
                next_Years.setVisibility(View.INVISIBLE);
                yearGrid.setVisibility(View.INVISIBLE);
                yearButton.setText(years[0].getText());
            }
        });
        years[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yearButton.setVisibility(View.VISIBLE);
                monthLayout.setVisibility(View.VISIBLE);
                next_Years.setVisibility(View.INVISIBLE);
                yearGrid.setVisibility(View.INVISIBLE);
                yearButton.setText(years[1].getText());
            }
        });
        years[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yearButton.setVisibility(View.VISIBLE);
                monthLayout.setVisibility(View.VISIBLE);
                next_Years.setVisibility(View.INVISIBLE);
                yearGrid.setVisibility(View.INVISIBLE);
                yearButton.setText(years[2].getText());
            }
        });
        years[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yearButton.setVisibility(View.VISIBLE);
                monthLayout.setVisibility(View.VISIBLE);
                next_Years.setVisibility(View.INVISIBLE);
                yearGrid.setVisibility(View.INVISIBLE);
                yearButton.setText(years[3].getText());
            }
        });
        years[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yearButton.setVisibility(View.VISIBLE);
                monthLayout.setVisibility(View.VISIBLE);
                next_Years.setVisibility(View.INVISIBLE);
                yearGrid.setVisibility(View.INVISIBLE);
                yearButton.setText(years[4].getText());
            }
        });
        years[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yearButton.setVisibility(View.VISIBLE);
                monthLayout.setVisibility(View.VISIBLE);
                next_Years.setVisibility(View.INVISIBLE);
                yearGrid.setVisibility(View.INVISIBLE);
                yearButton.setText(years[5].getText());
            }
        });
        years[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yearButton.setVisibility(View.VISIBLE);
                monthLayout.setVisibility(View.VISIBLE);
                next_Years.setVisibility(View.INVISIBLE);
                yearGrid.setVisibility(View.INVISIBLE);
                yearButton.setText(years[6].getText());
            }
        });
        years[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yearButton.setVisibility(View.VISIBLE);
                monthLayout.setVisibility(View.VISIBLE);
                next_Years.setVisibility(View.INVISIBLE);
                yearGrid.setVisibility(View.INVISIBLE);
                yearButton.setText(years[7].getText());
            }
        });
        years[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yearButton.setVisibility(View.VISIBLE);
                monthLayout.setVisibility(View.VISIBLE);
                next_Years.setVisibility(View.INVISIBLE);
                yearGrid.setVisibility(View.INVISIBLE);
                yearButton.setText(years[8].getText());
            }
        });
        years[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yearButton.setVisibility(View.VISIBLE);
                monthLayout.setVisibility(View.VISIBLE);
                next_Years.setVisibility(View.INVISIBLE);
                yearGrid.setVisibility(View.INVISIBLE);
                yearButton.setText(years[9].getText());
            }
        });
        years[10].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yearButton.setVisibility(View.VISIBLE);
                monthLayout.setVisibility(View.VISIBLE);
                next_Years.setVisibility(View.INVISIBLE);
                yearGrid.setVisibility(View.INVISIBLE);
                yearButton.setText(years[10].getText());
            }
        });
        years[11].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yearButton.setVisibility(View.VISIBLE);
                monthLayout.setVisibility(View.VISIBLE);
                next_Years.setVisibility(View.INVISIBLE);
                yearGrid.setVisibility(View.INVISIBLE);
                yearButton.setText(years[11].getText());
            }
        });
        years[12].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yearButton.setVisibility(View.VISIBLE);
                monthLayout.setVisibility(View.VISIBLE);
                next_Years.setVisibility(View.INVISIBLE);
                yearGrid.setVisibility(View.INVISIBLE);
                yearButton.setText(years[12].getText());
            }
        });
        years[13].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yearButton.setVisibility(View.VISIBLE);
                monthLayout.setVisibility(View.VISIBLE);
                next_Years.setVisibility(View.INVISIBLE);
                yearGrid.setVisibility(View.INVISIBLE);
                yearButton.setText(years[13].getText());
            }
        });
        years[14].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yearButton.setVisibility(View.VISIBLE);
                monthLayout.setVisibility(View.VISIBLE);
                next_Years.setVisibility(View.INVISIBLE);
                yearGrid.setVisibility(View.INVISIBLE);
                yearButton.setText(years[14].getText());
            }
        });
        years[15].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yearButton.setVisibility(View.VISIBLE);
                monthLayout.setVisibility(View.VISIBLE);
                next_Years.setVisibility(View.INVISIBLE);
                yearGrid.setVisibility(View.INVISIBLE);
                yearButton.setText(years[15].getText());
            }
        });

    }

}
