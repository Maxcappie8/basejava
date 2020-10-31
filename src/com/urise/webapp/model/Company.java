package com.urise.webapp.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Company {

    private final WebLink homePage;

    private List<Position> positionsList;

    public Company(String name, String homePageLink, List<Position> positionsList) {
        Objects.requireNonNull(name, "name must not be null");
        this.positionsList = positionsList;
        this.homePage = new WebLink(name, homePageLink);
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

    public static class Position {

        private final LocalDate startDate;

        private final LocalDate endDate;

        private final String title;

        private final String description;

        public Position(LocalDate startDate, LocalDate endDate, String title, String description) {
            Objects.requireNonNull(startDate, "startDate must not be null");
            Objects.requireNonNull(title, "title must not be null");
            this.startDate = startDate;
            this.endDate = endDate;
            this.title = title;
            this.description = description;
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
