package com.example.swplanetapi.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;
import static com.example.swplanetapi.common.PlanetConstants.PLANET;
import static com.example.swplanetapi.common.PlanetConstants.INVALID_PLANET;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class) // utlizando somente mockito sem spring boot para teste unitário
// @SpringBootTest(classes = PlanetService.class)
class PlanetServiceTest {

    // @Autowired
    @InjectMocks // utlizando somente mockito sem spring boot
    private PlanetService planetService;

    // @MockBean
    @Mock // utlizando somente mockito sem spring boot
    private PlanetRepository planetRepository;

    // operacao_estado_retorno
    @Test
    void createPlanet_WithValidData_ReturnsPlanet(){
        // AAA
        // Arrange
        when(planetRepository.save(PLANET)).thenReturn(PLANET);

        //Act
        // system under test - sut
        Planet sut = planetService.create(PLANET);

        //Assert
        assertThat(sut).isEqualTo(PLANET);
    }

    @Test
    void createPlanet_WithInvalidData_ThrowsException() {

        when(planetRepository.save(INVALID_PLANET)).thenThrow(RuntimeException.class);

        assertThatThrownBy(() -> planetService.create(INVALID_PLANET)).isInstanceOf(RuntimeException.class);

    }
}
