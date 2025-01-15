package com.enviro.assessment.grad001.zannymaholobela.ModelLayerTests;

import static org.assertj.core.api.Assertions.assertThat;

import com.enviro.assessment.grad001.zannymaholobela.model.WasteCategory;
import org.junit.jupiter.api.Test;

class WasteCategoryTest {

    @Test
    void testWasteCategoryCreation() {
        WasteCategory wasteCategory = new WasteCategory();
        wasteCategory.setId(1L);
        wasteCategory.setName("Plastic");

        assertThat(wasteCategory.getId()).isEqualTo(1L);
        assertThat(wasteCategory.getName()).isEqualTo("Plastic");
    }
}