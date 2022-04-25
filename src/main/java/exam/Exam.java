package exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import tables.User;




public class Exam  {
    private final SessionFactory sessionFactory;

    public Exam(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public void getQuestions() {


        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
          //  NOT WORKING:
          //  System.out.println("Users (JOIN): " + session.createQuery("SELECT q FROM User q JOIN q.question", User.class).list());

            Query <User> query =  session.createQuery ("FROM User WHERE idNumber = 1", User.class);
            System.out.println("TEST: " + query.list());



            session.getTransaction().commit();


        }


    }


}
