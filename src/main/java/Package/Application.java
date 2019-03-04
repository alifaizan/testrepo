package Package;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

    @SpringBootApplication
    public class Application {

        private static final Logger log = LoggerFactory.getLogger(Application.class);

        public static void main(String[] args) {
            SpringApplication.run(Application.class);
        }

        @Bean
        public CommandLineRunner demo(BuddyRepository repository) {
            return (args) -> {
                // save a couple of customers

               // repository.save(new BuddyInfo("Chloe", 6465));
               // repository.save(new BuddyInfo("Bauer", 9846));
               // repository.save(new BuddyInfo("David", 46245));
              //  repository.save(new BuddyInfo("Michelle", 35647));

                // fetch all customers
                log.info("Customers found with findAll():");
                log.info("-------------------------------");
                for (BuddyInfo buddy : repository.findAll()) {
                    log.info(buddy.toString());
                }
                log.info("");


                // fetch customers by last name
                log.info("Customer found with findByName('Bauer'):");
                log.info("--------------------------------------------");
                repository.findByName("Bauer").forEach(bauer -> {
                    log.info(bauer.toString());
                });
                // for (Customer bauer : repository.findByLastName("Bauer")) {
                // 	log.info(bauer.toString());
                // }
                log.info("");
            };
        }

    }

