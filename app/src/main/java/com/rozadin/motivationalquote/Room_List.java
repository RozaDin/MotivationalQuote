package com.rozadin.motivationalquote;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Room_List {
  @PrimaryKey  public int id;
  public byte start;
  public byte end;
  public byte period;

    public Room_List(int id, byte start, byte end, byte period) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.period = period;
    }
}
