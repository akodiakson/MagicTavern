package com.akodiakson.magictavern.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

import java.io.Serializable;

@NamespaceList({@Namespace(reference = "http://www.itunes.com/dtds/podcast-1.0.dtd", prefix = "itunes")})
@Root(name = "item", strict = false)
public class Item implements Serializable{


        @Element
    private String pubDate;
    @Element(name = "title", required = true)
    private String title;
    //    @Element
//    private Enclosure enclosure;
    @Element(name = "description", required = true)
    private String description;

    @Element(name ="summary")
    private String summary;

    @Element(name ="duration")
    private String duration;

//    @Element
//    private String link;

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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Item{" +
                "title='" + title + '\'' +
//                ", description='" + description + '\'' +
                ", summary='" + summary + '\'' +
                '}';
    }
}
