package com.example.swplanetapi.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

import java.util.Optional;

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

    @Test
    void getPlanet_ByExistingId_ReturnsPlanet(){
        when(planetRepository.findById(1L)).thenReturn(Optional.of(PLANET));

        Optional<Planet> sut = planetService.get(1L);

        assertThat(sut).isNotEmpty();
        assertThat(sut.get()).isEqualTo(PLANET);
    }

    @Test
    void getPlanet_ByUnexistingId_ReturnsEmpty(){
        when(planetRepository.findById(1L)).thenReturn(Optional.empty());

        Optional<Planet> sut = planetService.get(1L);

        assertThat(sut).isEmpty();
    }

    @Test
    void getPlanet_ByExistingName_ReturnsPlanet() {

        when(planetRepository.findByName("name")).thenReturn(Optional.of(PLANET));
        Optional<Planet> sut = planetService.getByName("name");

       assertThat(sut).isNotEmpty();
       assertThat(sut.get()).isEqualTo(PLANET);
    }

    @Test
    void getPlanet_ByUnexistingName_ReturnsPlanet() {
        final String name = "Unexisting name";
        when(planetRepository.findByName(name)).thenReturn(Optional.empty());
        Optional<Planet> sut = planetService.getByName("name");

        assertThat(sut).isEmpty();
    }
}
