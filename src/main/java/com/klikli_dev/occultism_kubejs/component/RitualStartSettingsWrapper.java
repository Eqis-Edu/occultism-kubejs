package com.klikli_dev.occultism_kubejs.component;

import com.klikli_dev.occultism.crafting.recipe.RitualRecipe;
import dev.latvian.mods.kubejs.typings.Info;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.conditions.ICondition;
import org.jetbrains.annotations.Nullable;

@Info("Various ritual start settings related helper methods")
public interface RitualStartSettingsWrapper {

    @Info("Returns an RitualRecipe.RitualStartSettings of the input")
    static RitualRecipe.RitualStartSettings of(RitualRecipe.RitualStartSettings in) {
        return in;
    }

    @Info("Returns an RitualRecipe.RitualStartSettings of the input")
    static RitualRecipe.RitualStartSettings of(
            @Nullable RitualRecipe.EntityToSacrifice entityToSacrifice,
            @Nullable Ingredient itemToUse,
            @Nullable ICondition condition
    ) {
        return new RitualRecipe.RitualStartSettings(entityToSacrifice, itemToUse, condition);
    }
}
