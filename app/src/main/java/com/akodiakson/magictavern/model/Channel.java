package com.akodiakson.magictavern.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

import java.util.List;

@NamespaceList({@Namespace(reference = "http://www.itunes.com/dtds/podcast-1.0.dtd", prefix = "itunes")})
@Root(strict = false)
public class Channel {

    @Element
    private String pubDate;
    @Element
    private String title;
    @Element
    private String description;
    @ElementList(name = "item", required = true, inline = true)
    private List<Item> items;

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return "Channel{" +
                "pubDate='" + pubDate + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", item=" +items +
                '}';
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
