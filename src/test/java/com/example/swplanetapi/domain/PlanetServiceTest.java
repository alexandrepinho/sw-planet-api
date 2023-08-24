package com.example.swplanetapi.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static com.example.swplanetapi.common.PlanetConstants.PLANET;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.boot.test.mock.mockito.MockBean;

@ExtendWith(MockitoExtension.class) // utlizando somente mockito sem spring boot
// @SpringBootTest(classes = PlanetService.class)
public class PlanetServiceTest {

    //@Autowired
    @InjectMocks // utlizando somente mockito sem spring boot
    private PlanetService planetService;

    //@MockBean
    @Mock // utlizando somente mockito sem spring boot
    private PlanetRepository planetRepository;

    //operacao_estado_retorno
    @Test
    public void createPlanet_WithValidData_ReturnsPlanet(){
        // AAA
        // Arrange
        when(planetRepository.save(PLANET)).thenReturn(PLANET);

        //Act
        // system under test - sut
        Planet sut = planetService.create(PLANET);

        //Assert
        assertThat(sut).isEqualTo(PLANET);
    }
}
