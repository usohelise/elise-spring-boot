package com.test.api.testapi.services;

import com.test.api.testapi.TestApiApplication;
import com.test.api.testapi.model.Location;
import com.test.api.testapi.repository.LocationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
@ContextConfiguration(loader = SpringBootContextLoader.class, classes= TestApiApplication.class)
class LocationServiceTest {

    @Autowired
    LocationService locationService;

    @MockBean
    LocationRepository mockLocationRepository;

    @BeforeEach
    void setUp() {
        Mockito.reset(mockLocationRepository);
    }

    @Test
    public void whenSaveLocationIsSuccessful(){
        //given
        Location location = new Location();
        location.setUser("test");
        location.setLocation("London");

        when(mockLocationRepository.save(any(Location.class))).thenReturn(location);

        //when
        Location result = locationService.saveLocation(location);

        //expect
        assertNotNull(result);
//        assertEquals(Location.getUser(), result.getUser());

        verify(mockLocationRepository, times(1)).save(any(Location.class));
    }

    @Test
    public void whenSaveLocationIsCalledWithNoLocation(){
        //given
        Location location = null;

        //when
        try {
            Location result = locationService.saveLocation(location);
            fail("Expected Exception Not Thrown.");
        } catch (Exception e) {
            //expected
        }

        //check save is not called
        verify(mockLocationRepository, never()).save(any(Location.class));

    }
}