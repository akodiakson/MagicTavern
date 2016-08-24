package com.akodiakson.magictavern.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class MagicTavernRssResponse {
    @Element
    private Channel channel;

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    @Override
    public String toString() {
        return "ClassPojo [channel = " + channel + "]";
    }
}
