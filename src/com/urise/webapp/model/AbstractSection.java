package com.urise.webapp.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.io.Serializable;

@XmlSeeAlso({ListSection.class, TextSection.class, CompanySection.class})
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class AbstractSection implements Serializable {
}
