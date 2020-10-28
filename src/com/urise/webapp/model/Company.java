package com.urise.webapp.model;

import java.time.LocalDate;
import java.util.Objects;

public class Company {

    private final WebLink homePage;

    private final LocalDate startDate;

    private final LocalDate endDate;

    private final String name;

    private final String title;

    private final String description;

    public Company(String name, String homePageLink, LocalDate startDate, LocalDate endDate, String title, String description) {
        Objects.requireNonNull(startDate, "startDate must not be null");
        Objects.requireNonNull(name, "name must not be null");
        Objects.requireNonNull(title, "title must not be null");
        this.homePage = new WebLink(name, homePageLink);
        this.startDate = startDate;
        this.endDate = endDate;
        this.name = name;
        this.title = title;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(homePage, company.homePage) &&
                Objects.equals(startDate, company.startDate) &&
                Objects.equals(endDate, company.endDate) &&
                Objects.equals(name, company.name) &&
                Objects.equals(title, company.title) &&
                Objects.equals(description, company.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homePage, startDate, endDate, name, title, description);
    }

    @Override
    public String toString() {
        return "\nCompany{" +
                "homePage=" + homePage +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
