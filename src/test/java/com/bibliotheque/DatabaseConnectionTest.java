package com.bibliotheque;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DatabaseConnectionTest {

    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager entityManager = null;
        try {
            emf = Persistence.createEntityManagerFactory("testPersistenceUnit");

            if (emf == null) {
                System.out.println("La connexion à la base de données a échoué.");
            } else {
                System.out.println("Connexion réussie à la base de données.");
                entityManager = emf.createEntityManager();
                entityManager.getTransaction().begin();
                entityManager.getTransaction().commit();
                entityManager.close();
            }

        } catch (Exception e) {
            System.out.println("Une exception s'est produite lors de la connexion à la base de données : " + e.getMessage());
        } finally {
            if (emf != null) {
                emf.close();
            }
        }
    }
}
