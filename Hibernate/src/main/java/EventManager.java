import domain.Person;
import org.hibernate.Session;

import java.util.*;

import domain.Event;
import util.HibernateUtil;

public class EventManager {
    public static void main(String[] args) {
        EventManager mgr = new EventManager();
        if (args[0].equals("store")) {
            mgr.createAndStoreEvent("My Event", new Date());
        } else if (args[0].equals("list")) {
            List events = mgr.listEvents();
            for (int i = 0; i < events.size(); i++) {
                Event theEvent = (Event) events.get(i);
                System.out.println(
                        "Event: " + theEvent.getTitle() + " Time: " + theEvent.getDate()
                );
            }
        } else if (args[0].equals("addpersontoevent")) {
            Long eventId = mgr.createAndStoreEvent("My Event", new Date());
            Long personId = mgr.createAndStorePerson("Foo", "Bar");
            mgr.addPersonToEventWithAutomaticallyDirtyChecking(personId, eventId);
            System.out.println("Added person " + personId + " to event " + eventId);
        }else if (args[0].equals("addEmailAddressToPerson")) {
            Long personId = mgr.createAndStorePerson("Foo", "Bar");
            mgr.addEmailAddressToPerson(personId, "abc@d.com");
            System.out.println("Added person " + personId + " an email");
        }

        HibernateUtil.getSessionFactory().close();
    }

    private Long createAndStoreEvent(String title, Date theDate) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Event theEvent = new Event();
        theEvent.setTitle(title);
        theEvent.setDate(theDate);
        session.save(theEvent);
        session.getTransaction().commit();
        return theEvent.getId();
    }

    private Long createAndStorePerson(String firstname, String lastname) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Person person = new Person();
        person.setFirstname(firstname);
        person.setLastname(lastname);
        session.save(person);
        session.getTransaction().commit();
        return person.getId();
    }

    private List listEvents() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List result = session.createQuery("from Event").list();
        session.getTransaction().commit();
        return result;
    }

    private void addPersonToEventWithAutomaticallyDirtyChecking(Long personId, Long eventId) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Person aPerson = (Person) session.load(Person.class, personId);
        Event anEvent = (Event) session.load(Event.class, eventId);
        aPerson.getEvents().add(anEvent);
        session.getTransaction().commit();
    }

    private void addPersonToEventInTwoUnits(Long personId, Long eventId) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Person aPerson = (Person) session.createQuery("select p from Person p left join fetch p.events where p.id = :pid")
                .setParameter("pid", personId)
                .uniqueResult();
        Event anEvent = (Event) session.load(Event.class, eventId);
        session.getTransaction().commit();

        aPerson.getEvents().add(anEvent);

        Session session2 = HibernateUtil.getSessionFactory().getCurrentSession();
        session2.beginTransaction();
        session2.update(aPerson);
        session2.getTransaction().commit();
    }

    private void addEmailAddressToPerson(Long personId, String emailAddress){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Person aPerson = (Person) session.load(Person.class,personId);
        aPerson.getEmailAddresses().add(emailAddress);
        session.getTransaction().commit();

    }

} 
