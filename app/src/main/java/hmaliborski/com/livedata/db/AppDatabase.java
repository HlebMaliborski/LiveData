package hmaliborski.com.livedata.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import hmaliborski.com.livedata.db.dao.NoteDao;
import hmaliborski.com.livedata.db.entity.Note;

@Database(entities = {Note.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static final String DATABASE_NAME = "note-database";

    public abstract NoteDao getNoteDao();

    public static AppDatabase createDatabase(Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME).build();
    }
}
