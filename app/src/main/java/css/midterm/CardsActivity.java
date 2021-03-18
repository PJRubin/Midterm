package css.midterm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class CardsActivity extends AppCompatActivity {

    ViewModell viewModell;
    TextView tvTerm;

    Button bFlip;
    Button bNext;
    Button bPrevious;
    Button bRandom;
    EditText etDate;
    EditText etTime;
    Button bCalendar;
    int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cards);

        viewModell = new ViewModelProvider(this).get(ViewModell.class);

        Bundle extras = getIntent().getExtras();
        ArrayList<String> words = extras.getStringArrayList("Words");
        ArrayList<String> defs = extras.getStringArrayList("Defs");

        for(int i = 0; i < words.size(); i++)
        {
            viewModell.addToList(words.get(i), defs.get(i));
        }







        tvTerm = findViewById(R.id.textViewTerm);

        bFlip = findViewById(R.id.buttonFlip);
        bNext = findViewById(R.id.buttonNext);
        bPrevious = findViewById(R.id.buttonPrevious);
        bRandom = findViewById(R.id.buttonRandom);

        etDate = findViewById(R.id.editTextDate);
        etTime = findViewById(R.id.editTextTime);
        bCalendar = findViewById(R.id.buttonCalendar);

        //set up initial word
        tvTerm.setText(viewModell.getListItem(0).getWord());

        setButtonFlip();





    }

    public void setButtonFlip() {
        bFlip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = getWord();
                if(tvTerm.getText().equals(getWord()))
                {
                    tvTerm.setText(getDef());
                }
                else
                {
                    tvTerm.setText(getWord());
                }

            }
        });
    }

    public String getWord()
    {
        return viewModell.getListItem(position).getWord();
    }

    public String getDef()
    {
        return viewModell.getListItem(position).getDefinition();
    }


}