package com.urise.webapp.model;

import java.util.Objects;

public class WholeTextSection extends Section {

    private final String textLine;

    public WholeTextSection(String textLine) {
        this.textLine = textLine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WholeTextSection that = (WholeTextSection) o;
        return Objects.equals(textLine, that.textLine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(textLine);
    }

    @Override
    public String toString() {
        return "WholeTextSection{" +
                "textLine='" + textLine + '\'' +
                '}';
    }
}
