package com.klikli_dev.occultism_kubejs.component;

import com.klikli_dev.occultism.crafting.recipe.conditionextension.condition.IsInDimensionTypeCondition;
import dev.latvian.mods.kubejs.typings.Info;
import net.minecraft.core.Holder;
import net.minecraft.world.level.dimension.DimensionType;

@Info("Various IsInDimensionTypeCondition related helper methods")
public interface IsInDimensionTypeConditionWrapper {

    @Info("Returns an IsInDimensionTypeCondition of the input")
    static IsInDimensionTypeCondition of(IsInDimensionTypeCondition in) {
        return in;
    }

    @Info("Returns an IsInDimensionTypeCondition of the input")
    static IsInDimensionTypeCondition of(Holder<DimensionType> dimensionType) {
        return new IsInDimensionTypeCondition(dimensionType);
    }
}
