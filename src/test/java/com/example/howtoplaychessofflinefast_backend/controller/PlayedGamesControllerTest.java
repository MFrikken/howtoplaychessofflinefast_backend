package com.example.howtoplaychessofflinefast_backend.controller;

import com.example.howtoplaychessofflinefast_backend.entity.PlayedGamesEntity;
import com.example.howtoplaychessofflinefast_backend.service.PlayedGamesService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class PlayedGamesControllerTest {

    @Mock
    private PlayedGamesService service;
    private PlayedGamesController underTest;

    @BeforeEach
    void setUp() {
        underTest = new PlayedGamesController(service);
    }

    @Nested
    class TestGetCountEP {
        @Test
        @DisplayName("Should return given count")
        void getCount() {
            // given
            Integer givenCount = 3;

            // when
            when(service.getCount()).thenReturn(givenCount);
            Integer expected = givenCount;
            Integer result = underTest.getCount();

            // then
            assertThat(result).isEqualTo(expected);
        }

        @Test
        @DisplayName("Should throw runtime exception")
        void throwError() {
            // given
            // when
            when(service.getCount()).thenThrow(new RuntimeException("No count found."));

            // then
            assertThatThrownBy(() -> underTest.getCount())
                    .isInstanceOf(RuntimeException.class)
                    .hasMessageContaining("No count found.");
        }
    }


    @Nested
    class TestIncreaseCountEP {

        @Test
        @DisplayName("Should return given count increased by one")
        void increaseCount() {
            // given
            Integer givenCount = 5;

            // when
            when(service.increaseCount()).thenReturn(givenCount);
            Integer expected = givenCount;
            Integer result = underTest.increaseCount();

            // then
            assertThat(result).isEqualTo(expected);
        }

        @Test
        @DisplayName("Should throw runtime exception")
        void throwError() {
            // given
            // when
            when(service.increaseCount()).thenThrow(new RuntimeException("No count found."));

            // then
            assertThatThrownBy(() -> underTest.increaseCount())
                    .isInstanceOf(RuntimeException.class)
                    .hasMessageContaining("No count found.");
        }
    }


    @Nested
    class TestGetAllEP {
        @Test
        @DisplayName("Should return given list")
        void getAll() {
            // given
            List<PlayedGamesEntity> givenList = new ArrayList();
            givenList.add(new PlayedGamesEntity());

            // when
            when(service.getAll()).thenReturn(givenList);
            List<PlayedGamesEntity> expected = givenList;
            List<PlayedGamesEntity> result = underTest.getAll();

            // then
            assertThat(result).isEqualTo(expected);
        }
    }

}