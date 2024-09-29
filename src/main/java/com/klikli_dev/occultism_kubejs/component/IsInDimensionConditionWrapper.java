package com.klikli_dev.occultism_kubejs.component;

import com.klikli_dev.occultism.crafting.recipe.conditionextension.condition.IsInDimensionCondition;
import dev.latvian.mods.kubejs.typings.Info;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;

@Info("Various IsInDimensionCondition related helper methods")
public interface IsInDimensionConditionWrapper {

    @Info("Returns an IsInDimensionCondition of the input")
    static IsInDimensionCondition of(IsInDimensionCondition in) {
        return in;
    }

    @Info("Returns an IsInDimensionCondition of the input")
    static IsInDimensionCondition of(ResourceKey<Level> dimension) {
        return new IsInDimensionCondition(dimension);
    }
}
