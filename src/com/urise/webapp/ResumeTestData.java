package com.urise.webapp;

import com.urise.webapp.model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ResumeTestData {

    public static Resume createNewResume(String uuid, String fullName) {

        Resume newResume = new Resume(uuid, fullName);

        newResume.getContacts().put(ContactType.PHONE_MOBILE, "+7(921) 855-0482");
        newResume.getContacts().put(ContactType.SKYPE,"grigory.kislin");
        newResume.getContacts().put(ContactType.EMAIL, "gkislin@yandex.ru");
        newResume.getContacts().put(ContactType.LINKEDIN, "Профиль LinkedIn");

        TextSection objective = new TextSection("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям");
        newResume.getSections().put(SectionType.OBJECTIVE, objective);

        TextSection personal = new TextSection("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры.");
        newResume.getSections().put(SectionType.PERSONAL, personal);

        List<String> achievementList = new ArrayList<>();
        achievementList.add("С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 1000 выпускников.");
        achievementList.add("Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.");
        ListSection achievement = new ListSection(achievementList);
        newResume.getSections().put(SectionType.ACHIEVEMENT, achievement);

        List<String> qualificationsList = new ArrayList<>();
        qualificationsList.add("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2");
        qualificationsList.add("Version control: Subversion, Git, Mercury, ClearCase, Perforce");
        AbstractSection qualifications = new ListSection(qualificationsList);
        newResume.getSections().put(SectionType.QUALIFICATIONS, qualifications);

        List<Company> workList = new ArrayList<>();
        List<Company.Position> luxoftPosition = new ArrayList<>();
        luxoftPosition.add(new Company.Position(
                LocalDate.of(2010, 12, 1),
                LocalDate.of(2012, 4, 1),
                "Ведущий программист",
                "Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, SmartGWT, GWT, Jasper, Oracle). Реализация клиентской и серверной части CRM. Реализация RIA-приложения для администрирования, мониторинга и анализа результатов в области алгоритмического трейдинга. JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, Commet, HTML5."
        ));
        Company luxoft = new Company(
                "Luxoft (Deutsche Bank)",
                "http://www.luxoft.ru/",
                luxoftPosition);
        workList.add(luxoft);
        List<Company.Position> ritPosition = new ArrayList<>();
        ritPosition.add(new Company.Position(
                LocalDate.of(2012, 4, 1),
                LocalDate.of(2014, 10, 1),
                "Java архитектор",
                "Организация процесса разработки системы ERP для разных окружений: релизная политика, версионирование, ведение CI (Jenkins), миграция базы (кастомизация Flyway), конфигурирование системы (pgBoucer, Nginx), AAA via SSO. Архитектура БД и серверной части системы. Разработка интергационных сервисов: CMIS, BPMN2, 1C (WebServices), сервисов общего назначения (почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online редактирование из браузера документов MS Office. Maven + plugin development, Ant, Apache Commons, Spring security, Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell remote scripting via ssh tunnels, PL/Python"
        ));
        Company rit = new Company(
                "RIT Center",
                "", ritPosition);
        workList.add(rit);
        AbstractSection experience = new CompanySection(workList);
        newResume.getSections().put(SectionType.EXPERIENCE, experience);

        List<Company> eduList = new ArrayList<>();
        List<Company.Position> mftiPosition = new ArrayList<>();
        mftiPosition.add(new Company.Position(
                LocalDate.of(1984, 9, 1),
                LocalDate.of(1987, 6, 1),
                "Закончил с отличием",
                null
        ));
        Company mfti = new Company(
                "Заочная физико-техническая школа при МФТИ",
                "http://www.school.mipt.ru/",
                mftiPosition
        );
        eduList.add(mfti);
        List<Company.Position> itmoPosition = new ArrayList<>();
        itmoPosition.add(new Company.Position(
                LocalDate.of(1987, 9, 1),
                LocalDate.of(1993, 7, 1),
                "Инженер (программист Fortran, C)",
                null
        ));
        itmoPosition.add(new Company.Position(
                LocalDate.of(1993, 9, 1),
                LocalDate.of(1996, 7, 1),
                "Аспирантура (программист С, С++)",
                null
        ));
        Company itmo = new Company(
                "Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики",
                "https://itmo.ru/ru/",
                itmoPosition
        );
        eduList.add(itmo);
        AbstractSection edu = new CompanySection(eduList);
        newResume.getSections().put(SectionType.EDUCATION, edu);

        return newResume;
    }
}
