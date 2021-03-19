package css.midterm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class CardsActivity extends AppCompatActivity {

    ViewModell viewModell;
    TextView tvTerm;

    Button bFlip;
    Button bNext;
    Button bPrevious;
    Button bRandom;
    EditText etDate;
    Button bCalendar;
    int position = 0;
    int min = 0;
    int max = 0;
    String topic;
    TextView tvTopic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cards);


        viewModell = new ViewModelProvider(this).get(ViewModell.class);

        Bundle extras = getIntent().getExtras();
        //ArrayList<String> words = extras.getStringArrayList("Words");
        //ArrayList<String> defs = extras.getStringArrayList("Defs");

        topic = extras.getString("Topic");
        tvTopic = findViewById(R.id.textViewTopic);
        tvTopic.setText(topic);

/*
        for(int i = 0; i < words.size(); i++)
        {
            viewModell.addToList(words.get(i), defs.get(i));
        }

 */

        tvTerm = findViewById(R.id.textViewTerm);

        bFlip = findViewById(R.id.buttonFlip);
        bNext = findViewById(R.id.buttonNext);
        bPrevious = findViewById(R.id.buttonPrevious);
        bRandom = findViewById(R.id.buttonRandom);

        etDate = findViewById(R.id.editTextDate);

        bCalendar = findViewById(R.id.buttonCalendar);





        setButtonFlip();
        setButtonNext();
        setButtonPrevious();
        setButtonRandom();
        setButtonCalendar();







    }

    public void setButtonFlip() {
        bFlip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //set up the max
                max = viewModell.getListSize() - 1;

                if(tvTerm.getText().equals(viewModell.getWord(position)))
                {
                    tvTerm.setText(viewModell.getDefinition(position));
                }
                else
                {
                    tvTerm.setText(viewModell.getWord(position));
                }

            }
        });
    }

    public void setButtonNext()
    {
        bNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position < max) {
                    position++;
                    tvTerm.setText(viewModell.getWord(position));
                }
            }
        });
    }

    public void setButtonPrevious()
    {
        bPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position > min) {
                    position--;
                    tvTerm.setText(viewModell.getWord(position));
                }

            }
        });
    }

    public void setButtonRandom()
    {
        bRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModell.randomize();
                position = 0;
                tvTerm.setText(viewModell.getWord(position));
            }
        });
    }

    public void setInitialTerm()
    {
        //set up initial word
        //tvTerm.setText(viewModell.getWord(position));
    }

    public void setButtonCalendar()
    {

        bCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent calIntent = new Intent(Intent.ACTION_INSERT);
                calIntent.setType("vnd.android.cursor.item/event");
                calIntent.putExtra(CalendarContract.Events.TITLE, tvTopic.getText().toString() + " Test");

                String month = etDate.getText().toString().substring(0,2);
                String day = etDate.getText().toString().substring(3);
                int mon = Integer.parseInt(month) - 1;
                int da = Integer.parseInt(day);


                GregorianCalendar begDate = new GregorianCalendar(2021, mon, da, 8, 00);
                GregorianCalendar endDate = new GregorianCalendar(2021, mon, da, 9, 00);
                calIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,
                        begDate.getTimeInMillis());
                calIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,
                        endDate.getTimeInMillis());
                startActivity(calIntent);
            }
        });
    }




}