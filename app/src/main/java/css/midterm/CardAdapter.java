package css.midterm;

import android.app.Application;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

public class CardAdapter extends RecyclerView.Adapter<CardViewHolder>{

    public Application a;
    public ViewModell v;

    public CardAdapter(Application application, ViewModell viewmodell)
    {
        a = application;
        v = viewmodell;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_row, parent, false);

        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {

        Card currentCard = v.getListItem(position);
        holder.tvCard.setText(currentCard.toString());

    }

    @Override
    public int getItemCount() {
        return v.getListSize();
    }
}
