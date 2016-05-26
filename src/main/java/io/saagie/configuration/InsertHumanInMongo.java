package io.saagie.configuration;

import io.saagie.domain.HumanEntity;
import io.saagie.repository.HumanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;

import static io.saagie.domain.Sexe.MAN;
import static io.saagie.domain.Sexe.PLANT;

/**
 * Created by pleresteux on 27/04/16.
 */
@Profile("!prod")
@Configuration
public class InsertHumanInMongo {

    @Autowired
    private HumanRepository humanRepository;

    @PostConstruct
    public void insertHumans() {

        if (humanRepository.findOne("pleresteux") == null) {

            final HumanEntity human = new HumanEntity()
                    .setId("pleresteux")
                    .setFirstname("Pierre")
                    .setLastname("Leresteux")
                    .setAddress("10D rue de l'implémentation")
                    .setCity("Jetbrain")
                    .setSex(MAN)
                    .setAge(33);

            humanRepository.save(human);
        }

        if (humanRepository.findOne("jbignon") == null) {

            final HumanEntity human = new HumanEntity()
                    .setId("jbignon")
                    .setFirstname("Julien")
                    .setLastname("Bignon")
                    .setAddress("2 chemin du hacker")
                    .setCity("Hadoop City")
                    .setSex(MAN)
                    .setAge(32);

            humanRepository.save(human);
        }

        if (humanRepository.findOne("jgermond") == null) {

            final HumanEntity human = new HumanEntity()
                    .setId("jgermond")
                    .setFirstname("Jonathan")
                    .setLastname("Germond")
                    .setAddress("15 avenue de la conception")
                    .setCity("Professor Hadoop and Pattern")
                    .setSex(MAN)
                    .setAge(29);

            humanRepository.save(human);
        }

        if (humanRepository.findOne("kvezier") == null) {

            final HumanEntity human = new HumanEntity()
                    .setId("kvezier")
                    .setFirstname("Kevin")
                    .setLastname("Vezier")
                    .setAddress("69 rue du boulet")
                    .setCity("Yvetot")
                    .setSex(MAN)
                    .setAge(27);

            humanRepository.save(human);
        }

        if (humanRepository.findOne("egaouyer") == null) {

            final HumanEntity human = new HumanEntity()
                    .setId("egaouyer")
                    .setFirstname("Etienne")
                    .setLastname("Gaouyer")
                    .setAddress("1 route moins n")
                    .setCity("Cisco Town")
                    .setSex(MAN)
                    .setAge(37);

            humanRepository.save(human);
        }

        if (humanRepository.findOne("jpoulain") == null) {

            final HumanEntity human = new HumanEntity()
                    .setId("jpoulain")
                    .setFirstname("Jeoffrey")
                    .setLastname("Poulain")
                    .setAddress("9 voie Yen Apour Lotre")
                    .setCity("InANuc")
                    .setSex(PLANT)
                    .setAge(19);

            humanRepository.save(human);
        }
    }
}
