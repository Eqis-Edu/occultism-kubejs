package com.klikli_dev.occultism_kubejs.component;

import com.klikli_dev.occultism.crafting.recipe.RitualRecipe;
import dev.latvian.mods.kubejs.typings.Info;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

@Info("Various entity to sacrifice related helper methods")
public interface EntityToSacrificeWrapper {

    @Info("Returns an RitualRecipe.EntityToSacrifice of the input")
    static RitualRecipe.EntityToSacrifice of(RitualRecipe.EntityToSacrifice in) {
        return in;
    }

    @Info("Returns an RitualRecipe.EntityToSacrifice of the input")
    static RitualRecipe.EntityToSacrifice of(TagKey<EntityType<?>> tag, String displayName) {
        return new RitualRecipe.EntityToSacrifice(tag, displayName);
    }
}
