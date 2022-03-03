package com.github.danwiseman.kafka.connect.scryfall.model;

public class Card_All_Parts {

    private String id;
    private String object;
    private String component;
    private String name;
    private String type_line;
    private String uri;


    public Card_All_Parts(String id, String object, String component, String name, String type_line, String uri) {
        this.id = id;
        this.object = object;
        this.component = component;
        this.name = name;
        this.type_line = type_line;
        this.uri = uri;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getType_line() {
        return type_line;
    }

    public void setType_line(String type_line) {
        this.type_line = type_line;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }
}
