package com.beto.test.json;

/**
 * Created by energetic on 22.07.2016.
 */
public class Data {
    private String id;
    private String body;
    private String title;
    private String userId;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getBody ()
    {
        return body;
    }

    public void setBody (String body)
    {
        this.body = body;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getUserId ()
    {
        return userId;
    }

    public void setUserId (String userId)
    {
        this.userId = userId;
    }

    @Override
    public String toString()
    {
        return "Data [id = "+id+", body = "+body+",ntitle = "+title+", userId = "+userId+"]";
    }
}
