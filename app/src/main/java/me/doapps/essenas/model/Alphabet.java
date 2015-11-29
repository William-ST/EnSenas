package me.doapps.essenas.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by William_ST on 29/11/15.
 */
@DatabaseTable(tableName = "Alphabet")
public class Alphabet {

    @DatabaseField(generatedId = true)
    private int idAlphabet;

    @DatabaseField(canBeNull = false)
    private String text;

    @DatabaseField(canBeNull = false)
    private int image;

    @DatabaseField(canBeNull = false)
    private boolean state;

    public Alphabet() {
    }

    public Alphabet(String text, int image, boolean state) {
        this.text = text;
        this.image = image;
        this.state = state;
    }

    public int getIdAlphabet() {
        return idAlphabet;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
