package com.urise.webapp.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
public class TextSection extends AbstractSection {

    private String textLine;

    public TextSection() {
    }

    public TextSection(String textLine) {
        this.textLine = textLine;
    }

    public String getTextLine() {
        return textLine;
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
