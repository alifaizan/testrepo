
import org.junit.Assert;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JPATest {

    public void performJPA() {

        // Creating objects representing some products
        JBuddy product1 = new JBuddy("ahmed",322);
        product1.setPhoneN(2332);
        product1.setName("Ahmed");

        JBuddy product2 = new JBuddy("khatt", 333);
        product2.setPhoneN(21313);
        product2.setName("Khattab");

        // Connecting to the database through EntityManagerFactory
        // connection details loaded from persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");

        EntityManager em = emf.createEntityManager();

        // Creating a new transaction
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        // Persisting the product entity objects
        em.persist(product1);
        em.persist(product2);

        tx.commit();

        // Querying the contents of the database using JPQL query
        Query q = em.createQuery("SELECT bud FROM JBuddy bud");

        @SuppressWarnings("unchecked")
        List<JBuddy> results = q.getResultList();

        System.out.println("List of names\n----------------");

        for (JBuddy bud : results) {

            System.out.println(bud.getName() + " (phone numbers=" + bud.getPhoneN() + ")");
            Assert.assertTrue(bud.equals(product1) || bud.equals(product2));
        }

        // Closing connection
        em.close();

        emf.close();
    }
    public static void  main(String args[]){
        JPATest t = new JPATest();
        t.performJPA();
    }
}