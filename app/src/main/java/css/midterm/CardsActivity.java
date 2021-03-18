package css.midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class CardsActivity extends AppCompatActivity {

    ViewModell viewModell;
    TextView tvWord;
    TextView tvDef;
    Button bFlip;
    Button bNext;
    Button bPrevious;
    Button bRandom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cards);

        Bundle extras = getIntent().getExtras();
        ArrayList<String> words = extras.getStringArrayList("Words");
        ArrayList<String> defs = extras.getStringArrayList("Defs");

        for(int i = 0; i < words.size(); i++)
        {
            viewModell.addToList(words.get(i), defs.get(i));
        }

        tvWord = findViewById(R.id.textViewWord);
        tvDef = findViewById(R.id.textViewDefinition);
        bFlip = findViewById(R.id.buttonFlip);
        bNext = findViewById(R.id.buttonNext);
        bPrevious = findViewById(R.id.buttonPrevious);
        bRandom = findViewById(R.id.buttonRandom);






    }
}