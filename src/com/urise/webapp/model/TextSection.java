package com.urise.webapp.model;

import java.util.Objects;

public class TextSection extends AbstractSection {

    private final String textLine;

    public TextSection(String textLine) {
        this.textLine = textLine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextSection that = (TextSection) o;
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
