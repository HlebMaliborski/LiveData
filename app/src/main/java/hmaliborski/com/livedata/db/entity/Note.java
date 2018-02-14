package hmaliborski.com.livedata.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "notes")
public class Note {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int mId;
    @ColumnInfo(name = "color")
    private int mColor;
    @ColumnInfo(name = "high_priority")
    private boolean mHighPriority;
    @ColumnInfo(name = "text")
    private String mText;

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public int getColor() {
        return mColor;
    }

    public void setColor(int color) {
        mColor = color;
    }

    public boolean isHighPriority() {
        return mHighPriority;
    }

    public void setHighPriority(boolean highPriority) {
        mHighPriority = highPriority;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }
}
