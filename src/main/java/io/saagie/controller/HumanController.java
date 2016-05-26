package io.saagie.controller;

import io.saagie.domain.HumanEntity;
import io.saagie.service.HumanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by pleresteux on 26/05/16.
 */
@Slf4j
@RestController
@RequestMapping(
        consumes = "application/json",
        produces = "application/json",
        path = "/api/human")
public class HumanController {

    @Autowired
    private HumanService humanService;

    @RequestMapping(value = {"", "/"}, method = GET)
    public List<HumanEntity> getAllHumans() {
        return humanService.getAllHumans();
    }

    @RequestMapping(value = "/{id}", method = GET)
    public HumanEntity getHuman(@PathVariable("id") String id) {
        return humanService.getHuman(id);
    }


    @RequestMapping(value = "/{id}", method = DELETE)
    public HumanEntity delete(@PathVariable("id") String id) {
        return humanService.delete(id);
    }
}
