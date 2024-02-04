package com.example.howtoplaychessofflinefast_backend.service;

import com.example.howtoplaychessofflinefast_backend.entity.PlayedGamesEntity;
import com.example.howtoplaychessofflinefast_backend.repository.PlayedGamesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PlayedGamesServiceTest {

    @Mock
    private PlayedGamesRepository playedGamesRepository;
    private PlayedGamesService underTest;

    @BeforeEach
    void setUp() {
        underTest = new PlayedGamesService(playedGamesRepository);
    }


    @Test
    @DisplayName("Should return all played games")
    void getAll() {
        // when
        List<PlayedGamesEntity> result = underTest.getAll();

        // then
        verify(playedGamesRepository).findAll();
    }

    @Nested
    class TestGetCountMethod {

        @Test
        @DisplayName("Should return given number")
        void getCount() {
            // given
            Integer givenCount = 1;
            PlayedGamesEntity givenEntity = new PlayedGamesEntity();
            givenEntity.setCount(givenCount);

            // when
            when(playedGamesRepository.findById(1)).thenReturn(Optional.of(givenEntity));
            Integer result = underTest.getCount();
            Integer expected = givenCount;

            // then
            assertThat(result).isEqualTo(expected);
        }

        @Test
        @DisplayName("Should throw runtime exception")
        void throwError() {
            //given
            //when
            when(playedGamesRepository.findById(1)).thenReturn(Optional.empty());

            //then
            assertThatThrownBy(() -> underTest.getCount())
                    .isInstanceOf(RuntimeException.class)
                    .hasMessageContaining("No count found.");
        }

    }

    @Nested
    class TestIncreaseCountMethod {

        @Test
        @DisplayName("Should return given count increased by one")
        void increaseCount() {
            // given
            Integer givenCount = 2;
            PlayedGamesEntity givenEntity = new PlayedGamesEntity();
            givenEntity.setCount(givenCount);

            // when
            when(playedGamesRepository.findById(1)).thenReturn(Optional.of(givenEntity));
            Integer expected = givenCount + 1;
            Integer result = underTest.increaseCount();

            // then
            assertThat(result).isEqualTo(expected);
        }

        @Test
        @DisplayName("Should throw runtime exception")
        void throwError() {
            // given
            // when
            when(playedGamesRepository.findById(1)).thenReturn(Optional.empty());

            // then
            assertThatThrownBy(() -> underTest.increaseCount())
                    .isInstanceOf(RuntimeException.class)
                    .hasMessageContaining("No count found.");
        }

    }
}