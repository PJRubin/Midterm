package css.midterm;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Card {

    public String word;
    public String definition;


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




}
