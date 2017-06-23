package model;

import java.io.Serializable;

/**
 * Created by PUNIT SHARMA on 6/23/2017.
 * Email: mailpunitsharma@gmail.com
 * Website: www.xordroid.com
 */

public class Article implements Serializable{
    private int id;
    private String image;
    private String created_at;
    private String title;
    private String content;

    public Article(String created_at, String title) {
        this.created_at = created_at;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreated_at() {
        return created_at;
    }


    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return id+","+image+", "+title+" ,"+content+" ,"+created_at;
    }
}
