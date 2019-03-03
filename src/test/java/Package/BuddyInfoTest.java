package Package;

import org.junit.Test;
import Package.BuddyInfo;

import static org.junit.Assert.assertEquals;


public class BuddyInfoTest {

    BuddyInfo buddy1;

    @Test
    public void test1(){ //testing of buddy's name
        buddy1 = new BuddyInfo("Ahmed", 567865);
        assertEquals("Ahmed", buddy1.getName());
    }

    @Test
    public void test2(){ //testing of buddy's number
        buddy1 = new BuddyInfo("Ahmed", 567865);
        assertEquals(567865, buddy1.getNumber());
    }

    /*
    @Test
    public void test3(){
        Package.BuddyInfo buddy1 = new Package.BuddyInfo();
        buddy1.setName("AK");
        buddy1.setNumber(25486);

        // Connecting to the database through EntityManagerFactory
        // connection details loaded from persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyPersistenceUnit");

        EntityManager em = emf.createEntityManager();

        // Creating a new transaction
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        // Persisting the product entity objects
        em.persist(buddy1);

        tx.commit();

        // Querying the contents of the database using JPQL query
        Query q = em.createQuery("SELECT b FROM Package.BuddyInfo b");
        @SuppressWarnings("unchecked")
        List<Package.BuddyInfo> results = q.getResultList();

        System.out.println("List of products\n----------------");

        for (Package.BuddyInfo p : results) {

            System.out.println(p.getName() + " (phone=" + p.getNumber() + ")");
            assertTrue( p.equals(buddy1));
        }


        // Closing connection
        em.close();

        emf.close();


    }
    */
}

