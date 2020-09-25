package net.simplifiedlearning.countryinfo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;


/**
 * Created by Belal on 10/2/2017.
 */

/**
 * Created by Belal on 7/15/2017.
 */
@Entity(tableName="hero")
public class Hero {

    @PrimaryKey @NonNull private String name;
    @ColumnInfo(name = "capital")
    private String capital;
    @ColumnInfo(name = "region")
    private String region;
    @ColumnInfo(name = "subregion")
    private String subregion;
    @ColumnInfo(name = "population")
    private String population;
    @ColumnInfo(name = "borders")
    private String borders;
    @ColumnInfo(name = "flag")
    private String flag;

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSubregion() {
        return subregion;
    }

    public void setSubregion(String subregion) {
        this.subregion = subregion;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getBorders() {
        return borders;
    }

    public void setBorders(String borders) {
        this.borders = borders;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    @ColumnInfo(name = "languages")
    private String languages;

    public Hero(String name, String capital, String region, String subregion, String population, String borders, String flag, String languages) {
        this.name = name;
        this.capital = capital;
        this.region = region;
        this.subregion = subregion;
        this.population = population;
        this.borders = borders;
        this.flag = flag;
        this.languages = languages;
    }




}