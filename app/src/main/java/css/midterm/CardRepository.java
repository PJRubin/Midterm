package css.midterm;



import android.app.Application;
import android.os.Handler;
import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardRepository{

    private CardDao cardDao;
    private List<Card> currentCards;          // list of Cards so far


    // Note that in order to unit test the WordRepository, you have to remove the Application
    // dependency. This adds complexity and much more code, and this sample is not about testing.
    // See the BasicSample in the android-architecture-components repository at
    // https://github.com/googlesamples
    CardRepository(Application application) {
        CardDatabase db = CardDatabase.getDatabase(application);
        cardDao = db.cardDao();
        //currentCards = new ArrayList<Card>();

        currentCards = this.getList();
        if(currentCards == null)
        {
            currentCards = new ArrayList<Card>();
        }
    }

    /***
     * Add an Card to the list
     * @return the description of the Card is returned if needed
     */
    public String AddCard(Card newCard){
        // ROOM -- Add insert into database
        CardDatabase.databaseWriteExecutor.execute(() -> {
            cardDao.insert(newCard);
            //Log.d ("CIS 3334", newCard.toString());
        });
        currentCards.add(newCard);
        return newCard.toString();             // return a description of the new card
    }

    /***
     * Retrieve the full list
     * @return a list of Cards, each one describe by a single string
     */
    public List<Card> getList() {
        CardDatabase.databaseWriteExecutor.execute(() -> {
            //cardDao.deleteAll();               // if database is currupted delete all the rows
            currentCards = cardDao.getAll();
            //Log.d("CIS 3334", "HeartrateRepository: Heartrates retreived = "+allHeartrates.size());
        });
        return currentCards;
    }

    /***
     * Retrieve one item from the list
     * @return a list of Cards, each one describe by a single string
     */
    public Card getSingleCard(Integer position) {
        Card currentCard = currentCards.get(position);
        return currentCard;
    }

    public int getNumberOfCards() {
        return currentCards.size();
    }

    public String getWord(Integer position)
    {
        return currentCards.get(position).getWord();
    }

    public String getDefinition(Integer position)
    {
        return currentCards.get(position).getDefinition();
    }

    public void randomize()
    {
        Collections.shuffle(currentCards);
    }


}
