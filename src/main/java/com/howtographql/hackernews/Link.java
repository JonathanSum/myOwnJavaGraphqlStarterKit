package com.howtographql.hackernews;

public class Link {
    private final String id; //the new field
    private final String url;
    private final String description;
    private final String userId;

    public Link(String url, String description, String userId) {
//        this.url = url;
//        this.description = description;

        this(null,url,description, userId);
    }
    public Link(String id, String url, String description, String userId){
        this.id=id;
        this.url=url;
        this.description=description;
        this.userId = userId;
    }
    public String getId(){
        return id;
    }
    public String getUrl() {
        return url;
    }

    public String getDescription() {
        return description;
    }
    public String getUserId() {
        return userId;
    }

}
