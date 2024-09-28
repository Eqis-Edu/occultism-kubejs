package com.klikli_dev.occultism_kubejs.component;

import com.klikli_dev.occultism.crafting.recipe.conditionextension.condition.IsInBiomeCondition;
import dev.latvian.mods.kubejs.typings.Info;
import net.minecraft.core.Holder;
import net.minecraft.world.level.biome.Biome;

@Info("Various IsInBiomeCondition related helper methods")
public interface IsInBiomeConditionWrapper {

    @Info("Returns an IsInBiomeCondition of the input")
    static IsInBiomeCondition of(IsInBiomeCondition in) {
        return in;
    }

    @Info("Returns an IsInBiomeCondition of the input")
    static IsInBiomeCondition of(Holder<Biome> biome) {
        return new IsInBiomeCondition(biome);
    }
}
