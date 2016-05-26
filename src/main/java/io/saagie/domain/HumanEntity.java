package io.saagie.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by pleresteux on 26/05/16.
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@Document(collection = "human")
public class HumanEntity {
    @Id
    private String id;
    private String lastname;
    private String firstname;
    private String address;
    private String city;
    private int age;
    private Sexe sex;
}
