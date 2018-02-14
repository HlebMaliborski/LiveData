package hmaliborski.com.livedata.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import hmaliborski.com.livedata.db.entity.Note;

@Dao
public interface NoteDao {
    @Insert
    void insert(Note note);

    @Delete
    void delete(Note note);

    @Query("SELECT * From notes")
    List<Note> getAllNotes();
}
