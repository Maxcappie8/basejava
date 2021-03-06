package com.urise.webapp.model;

import com.urise.webapp.util.LocalDateAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
public class Company implements Serializable {

    private WebLink homePage;

    private List<Position> positionsList;

    public Company() {
    }

    public Company(WebLink homePage, List<Position> positionsList) {
        this.homePage = homePage;
        this.positionsList = positionsList;
    }

    public Company(String name, String homePageLink, List<Position> positionsList) {
        Objects.requireNonNull(name, "name must not be null");
        this.positionsList = positionsList;
        this.homePage = new WebLink(name, homePageLink);
    }

    public WebLink getHomePage() {
        return homePage;
    }

    public List<Position> getPositionsList() {
        return positionsList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(homePage, company.homePage) &&
                Objects.equals(positionsList, company.positionsList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homePage, positionsList);
    }

    @Override
    public String toString() {
        return "Company{" +
                "homePage=" + homePage +
                ", positionsList=" + positionsList +
                '}';
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Position implements Serializable {

        @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
        private LocalDate startDate;

        @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
        private LocalDate endDate;

        private String title;

        private String description;

        public Position() {
        }

        public Position(LocalDate startDate, LocalDate endDate, String title, String description) {
            Objects.requireNonNull(startDate, "startDate must not be null");
            Objects.requireNonNull(title, "title must not be null");
            this.startDate = startDate;
            this.endDate = endDate;
            this.title = title;
            this.description = (description != null) ? description : "";
        }

        public LocalDate getStartDate() {
            return startDate;
        }

        public LocalDate getEndDate() {
            return endDate;
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return Objects.equals(startDate, position.startDate) &&
                    Objects.equals(endDate, position.endDate) &&
                    Objects.equals(title, position.title) &&
                    Objects.equals(description, position.description);
        }

        @Override
        public int hashCode() {
            return Objects.hash(startDate, endDate, title, description);
        }

        @Override
        public String toString() {
            return "Position{" +
                    "startDate=" + startDate +
                    ", endDate=" + endDate +
                    ", title='" + title + '\'' +
                    ", description='" + description + '\'' +
                    '}';
        }
    }
}
