package com.klikli_dev.occultism_kubejs.component;

import com.google.gson.JsonObject;
import com.klikli_dev.occultism.crafting.recipe.RitualRecipe;
import com.mojang.serialization.Codec;
import com.mojang.serialization.JsonOps;
import dev.latvian.mods.kubejs.recipe.KubeRecipe;
import dev.latvian.mods.kubejs.recipe.component.RecipeComponent;
import dev.latvian.mods.rhino.Context;
import dev.latvian.mods.rhino.type.TypeInfo;

public record EntityToSummonSettingsComponent(String name, Codec<RitualRecipe.EntityToSummonSettings> codec) implements RecipeComponent<RitualRecipe.EntityToSummonSettings> {
    public static final RecipeComponent<RitualRecipe.EntityToSummonSettings> ENTITY_TO_SUMMON_SETTINGS = new EntityToSummonSettingsComponent("occultism:entity_to_summon_settings", RitualRecipe.EntityToSummonSettings.CODEC);

    public static final TypeInfo TYPE_INFO = TypeInfo.of(EntityToSummonSettingsComponent.class);

    @Override
    public TypeInfo typeInfo() {
        return TYPE_INFO;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public RitualRecipe.EntityToSummonSettings wrap(Context cx, KubeRecipe recipe, Object from) {
        if (from instanceof RitualRecipe.EntityToSummonSettings k) {
            return k;
        }

        if (from instanceof JsonObject json) {
            return this.codec.decode(JsonOps.INSTANCE, json).result().orElseThrow().getFirst();
        }

        return (RitualRecipe.EntityToSummonSettings) cx.jsToJava(from, this.typeInfo());

    }
}
