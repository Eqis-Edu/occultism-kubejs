package com.klikli_dev.occultism_kubejs.component;

import com.klikli_dev.occultism.crafting.recipe.RitualRecipe;
import dev.latvian.mods.kubejs.typings.Info;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.List;

@Info("Various ritual requirement settings related helper methods")
public interface RitualRequirementSettingsWrapper {

    @Info("Returns an RitualRecipe.RitualRequirementSettings of the input")
    static RitualRecipe.RitualRequirementSettings of(RitualRecipe.RitualRequirementSettings in) {
        return in;
    }

    @Info("Returns an RitualRecipe.RitualRequirementSettings of the input")
    static RitualRecipe.RitualRequirementSettings of(
            ResourceLocation pentacleId,
            List<Ingredient> ingredients,
            Ingredient activationItem,
            int duration
    ) {
        return new RitualRecipe.RitualRequirementSettings(pentacleId, NonNullList.copyOf(ingredients), activationItem, duration, -1);
    }

    @Info("Returns an RitualRecipe.RitualRequirementSettings of the input")
    static RitualRecipe.RitualRequirementSettings of(
            ResourceLocation pentacleId,
            List<Ingredient> ingredients,
            Ingredient activationItem
    ) {
        return of(pentacleId, ingredients, activationItem, RitualRecipe.DEFAULT_DURATION);
    }
}
