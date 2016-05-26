package io.saagie.repository;

import io.saagie.domain.HumanEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by pleresteux on 26/05/16.
 */
@Repository
public interface HumanRepository extends MongoRepository<HumanEntity, String> {
}
