package com.klikli_dev.occultism_kubejs.component;

import com.google.gson.JsonObject;
import com.klikli_dev.occultism.crafting.recipe.RitualRecipe;
import com.mojang.serialization.Codec;
import com.mojang.serialization.JsonOps;
import dev.latvian.mods.kubejs.recipe.KubeRecipe;
import dev.latvian.mods.kubejs.recipe.component.RecipeComponent;
import dev.latvian.mods.rhino.Context;
import dev.latvian.mods.rhino.type.TypeInfo;

public record RitualStartSettingsComponent(String name, Codec<RitualRecipe.RitualStartSettings> codec) implements RecipeComponent<RitualRecipe.RitualStartSettings> {
    public static final RecipeComponent<RitualRecipe.RitualStartSettings> RITUAL_START_SETTINGS = new RitualStartSettingsComponent("occultism:ritual_start_settings", RitualRecipe.RitualStartSettings.CODEC);

    public static final TypeInfo TYPE_INFO = TypeInfo.of(RitualStartSettingsComponent.class);

    @Override
    public TypeInfo typeInfo() {
        return TYPE_INFO;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public RitualRecipe.RitualStartSettings wrap(Context cx, KubeRecipe recipe, Object from) {
        if (from instanceof RitualRecipe.RitualStartSettings k) {
            return k;
        }

        if (from instanceof JsonObject json) {
            return this.codec.decode(JsonOps.INSTANCE, json).result().orElseThrow().getFirst();
        }

        return (RitualRecipe.RitualStartSettings) cx.jsToJava(from, this.typeInfo());

    }
}
