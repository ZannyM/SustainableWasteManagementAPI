package com.enviro.assessment.grad001.zannymaholobela.ServiceLayerTests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import com.enviro.assessment.grad001.zannymaholobela.model.WasteCategory;
import com.enviro.assessment.grad001.zannymaholobela.repository.WasteCategoryRepository;
import com.enviro.assessment.grad001.zannymaholobela.service.WasteCategoryService;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

class WasteCategoryServiceTest {

    @Mock
    private WasteCategoryRepository wasteCategoryRepository;

    @InjectMocks
    private WasteCategoryService wasteCategoryService;

    public WasteCategoryServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindWasteCategoryById() {
        WasteCategory wasteCategory = new WasteCategory();
        wasteCategory.setId(1L);
        wasteCategory.setName("Plastic");

        when(wasteCategoryRepository.findById(1L)).thenReturn(Optional.of(wasteCategory));

        Optional<WasteCategory> found = wasteCategoryService.getWasteCategoryById(1L);

        assertThat(found).isNotNull();
        assertThat(found.get().getName()).isEqualTo("Plastic");

        verify(wasteCategoryRepository, times(1)).findById(1L);
    }
}