package com.klikli_dev.occultism_kubejs.component;

import com.google.gson.JsonObject;
import com.klikli_dev.occultism.crafting.recipe.RitualRecipe;
import com.mojang.serialization.Codec;
import com.mojang.serialization.JsonOps;
import dev.latvian.mods.kubejs.recipe.KubeRecipe;
import dev.latvian.mods.kubejs.recipe.component.RecipeComponent;
import dev.latvian.mods.rhino.Context;
import dev.latvian.mods.rhino.type.TypeInfo;
import net.neoforged.neoforge.common.conditions.ICondition;

public record ConditionComponent(String name, Codec<ICondition> codec) implements RecipeComponent<ICondition> {
    public static final RecipeComponent<ICondition> CONDITION = new ConditionComponent("occultism:condition", ICondition.CODEC);

    public static final TypeInfo TYPE_INFO = TypeInfo.of(ConditionComponent.class);

    @Override
    public TypeInfo typeInfo() {
        return TYPE_INFO;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public ICondition wrap(Context cx, KubeRecipe recipe, Object from) {
        if (from instanceof ICondition k) {
            return k;
        }

        if (from instanceof JsonObject json) {
            return this.codec.decode(JsonOps.INSTANCE, json).result().orElseThrow().getFirst();
        }

        return (ICondition) cx.jsToJava(from, this.typeInfo());
    }
}
