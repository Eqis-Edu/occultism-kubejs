package com.klikli_dev.occultism_kubejs.component;

import com.klikli_dev.occultism.crafting.recipe.conditionextension.condition.IsInBiomeWithTagCondition;
import dev.latvian.mods.kubejs.typings.Info;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

@Info("Various IsInBiomeWithTagCondition related helper methods")
public interface IsInBiomeWithTagConditionWrapper {

    @Info("Returns an IsInBiomeWithTagCondition of the input")
    static IsInBiomeWithTagCondition of(IsInBiomeWithTagCondition in) {
        return in;
    }

    @Info("Returns an IsInBiomeWithTagCondition of the input")
    static IsInBiomeWithTagCondition of(TagKey<Biome> tag) {
        return new IsInBiomeWithTagCondition(tag);
    }
}
