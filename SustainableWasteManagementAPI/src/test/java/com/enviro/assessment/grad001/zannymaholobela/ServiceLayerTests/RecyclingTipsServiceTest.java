package com.enviro.assessment.grad001.zannymaholobela.ServiceLayerTests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import com.enviro.assessment.grad001.zannymaholobela.model.RecyclingTip;
import com.enviro.assessment.grad001.zannymaholobela.repository.RecyclingTipRepository;
import com.enviro.assessment.grad001.zannymaholobela.service.RecyclingTipService;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

class RecyclingTipServiceTest {

    @Mock
    private RecyclingTipRepository recyclingTipRepository;

    @InjectMocks
    private RecyclingTipService recyclingTipService;

    public RecyclingTipServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveRecyclingTip() {
        RecyclingTip recyclingTip = new RecyclingTip();
        recyclingTip.setRecyclingTips("Reuse glass jars.");

        when(recyclingTipRepository.save(recyclingTip)).thenReturn(recyclingTip);

        RecyclingTip savedTip = recyclingTipService.saveRecyclingTip(recyclingTip);

        assertThat(savedTip).isNotNull();
        assertThat(savedTip.getTip()).isEqualTo("Reuse glass jars.");

        verify(recyclingTipRepository, times(1)).save(recyclingTip);
    }
}