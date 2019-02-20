package com.max;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {

    private static EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("HibernateJPAPersistenceUnit");

    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Publisher johnDoe = new Publisher("John Doe");
        entityManager.persist(johnDoe);
        Book book = new Book();
        book.setName("My Book Name");
        book.setPublisher(johnDoe);
        entityManager.persist(book);
        entityManager.flush();
        entityManager.getTransaction().commit();
        Book singleResult = (Book) entityManager.createQuery("from Book b where b.id=1").getSingleResult();
        entityManager.close();
        entityManagerFactory.close();
    }
}



