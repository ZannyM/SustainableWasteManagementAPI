package com.enviro.assessment.grad001.zannymaholobela.ServiceLayerTests;

import com.enviro.assessment.grad001.zannymaholobela.model.DisposalGuideline;
import com.enviro.assessment.grad001.zannymaholobela.repository.DisposalGuidelineRepository;
import com.enviro.assessment.grad001.zannymaholobela.service.DisposalGuidelineService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class DisposalGuidelineServiceTest {

    @Mock
    private DisposalGuidelineRepository repository;

    @InjectMocks
    private DisposalGuidelineService service;

    public DisposalGuidelineServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetDisposalGuidelineById() {
        DisposalGuideline guideline = new DisposalGuideline();
        guideline.setId(1L);
        guideline.setWasteType("Electronic Waste");

        when(repository.findById(1L)).thenReturn(Optional.of(guideline));

        Optional<DisposalGuideline> result = service.getDisposalGuidelineById(1L);

        assertNotNull(result);
        assertEquals("Electronic Waste", result.get().getWasteType());
        verify(repository, times(1)).findById(1L);
    }

    @Test
    public void testAddDisposalGuideline() {
        DisposalGuideline guideline = new DisposalGuideline();
        guideline.setWasteType("Organic Waste");

        when(repository.save(guideline)).thenReturn(guideline);

        DisposalGuideline result = service.addDisposalGuideline(guideline);

        assertNotNull(result);
        assertEquals("Organic Waste", result.getWasteType());
        verify(repository, times(1)).save(guideline);
    }

//    @Test
//    public void testDeleteDisposalGuideline() {
//        doNothing().when(repository).deleteById(1L);
//
//        service.deleteDisposalGuideline(1L);
//
//        verify(repository, times(1)).deleteById(1L);
//    }
}
