package com.urise.webapp.model;

import java.util.Objects;

public class Contact {

    private final String name;

    private final WebLink url;

    public Contact(String name, String url) {
        this.url = new WebLink(name, url);
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(name, contact.name) &&
                Objects.equals(url, contact.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, url);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", url=" + url +
                '}';
    }
}
