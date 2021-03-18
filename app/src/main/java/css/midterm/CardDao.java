package css.midterm;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.io.Serializable;
import java.util.List;

@Dao
public interface CardDao{
    @Query("SELECT * FROM Card")
    List<Card> getAll();

    @Insert
    void insert(Card card);

    @Delete
    void delete(Card card);

    @Query("DELETE FROM Card")
    void deleteAll();




}
