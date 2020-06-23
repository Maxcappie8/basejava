package com.urise.webapp.model;

/**
 * Initial resume class
 */
public class Resume {

    // Unique identifier
    private String uuid;
    private int verson = 1; // For test update();

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getVerson() {
        return verson;
    }

    public void setVerson(int verson) {
        this.verson = verson;
    }

    @Override
    public String toString() {
        return uuid;
    }
}
