package com.wayne.rule2_builder_pattern;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by wayne on 2015. 11. 21..
 */
public class NutritionFactsTest {
	@Test
	public void testBuilderConstruct() {
		NutritionFacts nutritionFacts = new NutritionFacts.Builder(240, 8)
				.calories(100)
				.sodium(35)
				.carbohydrate(27)
				.build();

		assertThat(nutritionFacts.getServings(), is(8));
		assertThat(nutritionFacts.getServingSize(), is(240));
		assertThat(nutritionFacts.getCalories(), is(100));
		assertThat(nutritionFacts.getSodium(), is(35));
		assertThat(nutritionFacts.getCarbohydrate(), is(27));
		assertThat(nutritionFacts.getFat(), is(0));
	}
}