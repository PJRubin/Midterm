package css.midterm;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CardViewHolder extends RecyclerView.ViewHolder{

    TextView tvCard = itemView.findViewById(R.id.textViewCard);

    public CardViewHolder(@NonNull View itemView) {
        super(itemView);
    }

}
