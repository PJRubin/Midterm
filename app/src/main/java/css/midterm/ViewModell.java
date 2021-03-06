package css.midterm;

import android.app.Application;
import android.os.Handler;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import android.app.Application;
import android.os.Handler;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.io.Serializable;
import java.util.List;

public class ViewModell extends AndroidViewModel implements Serializable {


    CardRepository cardsrepo;


    public ViewModell(@NonNull Application application) {
        super(application);
        cardsrepo = new CardRepository(application);
    }

    // For live data updates from https://developer.android.com/topic/libraries/architecture/livedata
    private MutableLiveData<String> orderStatus;
    public MutableLiveData<String> getOrderStatus() {
        if (orderStatus == null) {
            orderStatus = new MutableLiveData<String>();
        }
        return orderStatus;
    }

    public void addToList(String inWord, String inDefinition) {
        Card newCard = new Card(inWord, inDefinition);
        cardsrepo.AddCard(newCard);
    }


    public Card getListItem(Integer position) {
        return cardsrepo.getSingleCard(position);
    }

    public int getListSize() {
        return cardsrepo.getNumberOfCards();
    }

    public String getWord(Integer position)
    {
        return cardsrepo.getWord(position);
    }

    public String getDefinition(Integer position)
    {
        return cardsrepo.getDefinition(position);
    }

    public void randomize()
    {
        cardsrepo.randomize();
    }


}
