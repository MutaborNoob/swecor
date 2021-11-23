package com.testProd.swecorWebServer;

import com.testProd.swecorWebServer.model.Device;
import com.testProd.swecorWebServer.model.Event;
import com.testProd.swecorWebServer.model.EventType;
import com.testProd.swecorWebServer.model.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DeleteMe {
    //private static SessionFactory sessionFactory;

    public static void main(String[] args){
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Project.class)
                .addAnnotatedClass(Device.class)
                .addAnnotatedClass(Event.class)
                .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        Project project1 = new Project("ФотоЭлектроника 3000");
        Project project2 = new Project("Антитеррористическая диагностика");

        Device device1 = new Device("A2DD");
        Device device2 = new Device("A3DD");
        Device device3 = new Device("A4DD");
        Device device4 = new Device("A5DD");
        Device device5 = new Device("A6DD");

        Device device6 = new Device("C3PO");
        Device device7 = new Device("C4PO");
        Device device8 = new Device("C5PO");
        Device device9 = new Device("C6PO");
        Device device10 = new Device("C8PO");

        Date date = new GregorianCalendar(1975, Calendar.APRIL, 06).getTime();

        Event event1 = new Event(date, EventType.EVENT, true);
        Event event2 = new Event(date, EventType.ERROR, false);
        Event event3 = new Event(date, EventType.WARNING, true);
        Event event4 = new Event(date, EventType.WARNING, false);
        Event event5 = new Event(date, EventType.EVENT, true);

        event1.setDevice(device1);
        event2.setDevice(device2);
        event3.setDevice(device3);
        event4.setDevice(device4);
        event5.setDevice(device5);

        event1.setDevice(device6);
        event2.setDevice(device7);
        event3.setDevice(device8);
        event4.setDevice(device9);
        event5.setDevice(device10);

        project1.addDeviceToProject(device1);
        project1.addDeviceToProject(device2);
        project1.addDeviceToProject(device3);
        project1.addDeviceToProject(device4);
        project1.addDeviceToProject(device5);

        project2.addDeviceToProject(device6);
        project2.addDeviceToProject(device7);
        project2.addDeviceToProject(device8);
        project2.addDeviceToProject(device9);
        project2.addDeviceToProject(device10);

        session.beginTransaction();
        session.save(event1);
        session.save(event2);
        session.save(event3);
        session.save(event4);
        session.save(event5);
        session.save(project1);
        session.save(project2);

        session.getTransaction().commit();



    }
}
