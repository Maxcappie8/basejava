package com.urise.webapp.model;

import java.io.Serializable;
import java.util.Objects;

public class WebLink implements Serializable {

    private final String name;

    private final String url;

    public WebLink(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WebLink webLink = (WebLink) o;
        return Objects.equals(name, webLink.name) &&
                Objects.equals(url, webLink.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, url);
    }

    @Override
    public String toString() {
        return "WebLink{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
