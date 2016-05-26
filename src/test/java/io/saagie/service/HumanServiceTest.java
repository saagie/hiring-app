package io.saagie.service;

import io.saagie.domain.HumanEntity;
import io.saagie.repository.HumanRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static io.saagie.domain.Sexe.MAN;
import static io.saagie.domain.Sexe.WOMAN;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

/**
 * Created by pleresteux on 26/05/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class HumanServiceTest {

    @Mock
    private HumanRepository humanRepository;

    @InjectMocks
    private HumanService humanService;

    @Test
    public void should_get_all_humans() {
        //Given
        when(humanRepository.findAll()).thenReturn(Arrays.asList(
                getHuman1(),
                getHuman2()
        ));
        //When
        List<HumanEntity> humans = humanService.getAllHumans();
        //Then
        assertThat(humans).hasSize(2)
                .containsOnly(getHuman1(), getHuman2());
    }

    @Test
    public void should_get_one_human_if_exists() {
        //Given
        String id = getHuman1().getId();
        when(humanRepository.findOne(id)).thenReturn(getHuman1());
        //When
        HumanEntity human = humanService.getHuman(id);
        //Then
        assertThat(human).isEqualTo(getHuman1());
    }

    @Test
    public void should_get_an_error_if_human_not_exists_when_we_want_to_get_it() {
        //Given
        String id = getHuman1().getId();
        //When
        try {
            humanService.getHuman(id);
            fail("An exception should be thrown");
        } catch (Exception e) {// TODO: remplace Exception with the correct Not Found Exception
            assertThat(e).hasMessage("Not found");
        }
    }

    @Test
    public void should_delete_one_human_if_exists_and_returns_it() {
        //Given
        String id = getHuman1().getId();
        when(humanRepository.findOne(id)).thenReturn(getHuman1());
        //When
        HumanEntity human = humanService.delete(id);
        //Then
        assertThat(human).isEqualTo(getHuman1());
    }

    @Test
    public void should_get_an_error_if_human_not_exists_when_we_want_to_delete_it() {
        //Given
        String id = getHuman1().getId();
        //When
        try {
            humanService.delete(id);
            fail("An exception should be thrown");
        } catch (Exception e) {// TODO: remplace Exception with the correct Not Found Exception
            assertThat(e).hasMessage("Not found");
        }
    }

    @Test
    public void should_create_a_new_human() {
        //Given
        //When
        HumanEntity human = humanService.createHuman(getHuman1());
        //Then
        assertThat(human).isEqualTo(getHuman1());
    }

    @Test
    public void should_update_an_existing_human() {
        //Given
        //When
        HumanEntity human = humanService.updateHuman(getHuman1());
        //Then
        assertThat(human).isEqualTo(getHuman1());
    }

    @Test
    public void should_get_an_error_if_human_not_exists_when_we_want_to_update_it() {
        //Given
        //When
        try {
            humanService.updateHuman(getHuman1());
            fail("An exception should be thrown");
        } catch (Exception e) {// TODO: remplace Exception with the correct Not Found Exception
            assertThat(e).hasMessage("Not found");
        }
    }

    private HumanEntity getHuman1() {
        return new HumanEntity()
                .setId("1")
                .setFirstname("firstname1")
                .setLastname("lastname1")
                .setAddress("address1")
                .setCity("city1")
                .setAge(1)
                .setSex(MAN);
    }

    private HumanEntity getHuman2() {
        return new HumanEntity()
                .setId("2")
                .setFirstname("firstname2")
                .setLastname("lastname2")
                .setAddress("address2")
                .setCity("city2")
                .setAge(2)
                .setSex(WOMAN);
    }

}