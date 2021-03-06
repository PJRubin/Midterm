package css.midterm;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Card{

    public String word;
    public String definition;

    @PrimaryKey(autoGenerate = true)
    public int id;


    public Card()
    {
        word = "";
        definition = "";
    }

    public Card(String w, String d)
    {
        word = w;
        definition = d;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }


    public String toString()
    {
        return word + " - " + definition;
    }




}
