package io.saagie.service;

import io.saagie.domain.HumanEntity;
import io.saagie.repository.HumanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by pleresteux on 26/05/16.
 */
@Service
public class HumanService {

    @Autowired
    private HumanRepository humanRepository;


    public List<HumanEntity> getAllHumans() {
        return humanRepository.findAll();
    }

    public HumanEntity getHuman(String id) {
        return humanRepository.findOne(id);
    }

    public HumanEntity delete(String id) {
        HumanEntity humanEntity = humanRepository.findOne(id);
        humanRepository.delete(humanEntity);
        return humanEntity;
    }

    public HumanEntity updateHuman(HumanEntity humanEntity) {
        return humanEntity;
    }

    public HumanEntity createHuman(HumanEntity humanEntity) {
        return humanEntity;
    }
}
