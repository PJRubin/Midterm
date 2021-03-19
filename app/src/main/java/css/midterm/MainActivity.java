package css.midterm;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.material.chip.Chip;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    EditText etTopic;
    EditText etWord;
    EditText etDefinition;
    Button bAdd;
    Button bDone;

    RecyclerView rvCards;
    CardAdapter cardAdapter;
    ViewModell viewModell;
    String topic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModell = new ViewModelProvider(this).get(ViewModell.class);
        cardAdapter = new CardAdapter(this.getApplication(), viewModell);

        etTopic = findViewById(R.id.editTextTopic);
        etWord = findViewById(R.id.editTextWord);
        etDefinition = findViewById(R.id.editTextDefinition);
        bAdd = findViewById(R.id.buttonAdd);
        bDone = findViewById(R.id.buttonDone);
        rvCards = findViewById(R.id.recyclerViewCards);

        rvCards.setAdapter(cardAdapter);
        rvCards.setLayoutManager(new LinearLayoutManager(this));

        setButtonAdd();
        setButtonDone();




    }

    public void setButtonAdd()
    {
        bAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String word = etWord.getText().toString();
                String definition = etDefinition.getText().toString();

                viewModell.addToList(word, definition);
                cardAdapter.notifyDataSetChanged();

            }
        });
    }

    public void setButtonDone()
    {
        bDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                //ArrayList<String> words = new ArrayList<>();
                //ArrayList<String> defs = new ArrayList<>();
                topic = etTopic.getText().toString();

/*
                for(int i = 0; i < viewModell.getListSize(); i++)
                {
                    words.add(viewModell.getListItem(i).getWord());
                    defs.add(viewModell.getListItem(i).getDefinition());
                    Log.d("CIS 3334","This should display a lot");

                }

 */

                Intent secondIntent = new Intent(v.getContext(), CardsActivity.class);
                //secondIntent.putExtra("Words", words);
                //secondIntent.putExtra("Defs", defs);
                secondIntent.putExtra("Topic", topic);
                startActivityForResult(secondIntent, 1001);

            }
        });
    }


}