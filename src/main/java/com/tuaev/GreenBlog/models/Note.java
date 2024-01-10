package com.tuaev.GreenBlog.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("notes")
public class Note {

    @Id
    @Column("note_id")
    int note_id;
    @Column("note_title")
    String note_title;
    @Column("fk_users_id")
    int fk_users_id;

    public int getFk_users_id() {
        return fk_users_id;
    }

    public void setFk_users_id(int fk_users_id) {
        this.fk_users_id = fk_users_id;
    }

    public int getNote_id() {
        return note_id;
    }

    @Override
    public String toString() {
        return "Note{" +
                "note_id=" + note_id +
                ", note_title='" + note_title + '\'' +
                ", note_description='" + note_description + '\'' +
                '}';
    }

    public void setNote_id(int note_id) {
        this.note_id = note_id;
    }

    @Column("note_description")
    String note_description;

    public Note(){

    }

    public String getNote_title() {
        return note_title;
    }

    public void setNote_title(String note_title) {
        this.note_title = note_title;
    }

    public String getNote_description() {
        return note_description;
    }

    public void setNote_description(String note_description) {
        this.note_description = note_description;
    }
}
