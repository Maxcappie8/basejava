package com.urise.webapp.model;

public enum ContactType {
    PHONE_MOBILE("Номер мобильного телефона"),
    PHONE_HOME("Номер домашнего телефона"),
    EMAIL("Адрес электронной почты"),
    SKYPE("Aккаунт Skype"),
    LINKEDIN("Aккаунт LinkedIn"),
    GITHUB("Aккаунт GitHub"),
    STATCKOVERFLOW("Aккаунт Stackoverflow"),
    HOME_PAGE("Домашняя страница");

    private String title;

    ContactType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
