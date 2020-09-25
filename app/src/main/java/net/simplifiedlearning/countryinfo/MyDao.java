package net.simplifiedlearning.countryinfo;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface MyDao  {
    @Insert
    public void addData(Hero hero);

    @Query("select * from hero")
    public List<Hero>getMyData();


    @Delete
    public void delete(Hero hero);

    @Update
    public void update(Hero hero);

}
