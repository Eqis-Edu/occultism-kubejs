package com.klikli_dev.occultism_kubejs.component;

import com.google.gson.JsonObject;
import com.klikli_dev.occultism.crafting.recipe.RitualRecipe;
import com.mojang.serialization.Codec;
import com.mojang.serialization.JsonOps;
import dev.latvian.mods.kubejs.recipe.KubeRecipe;
import dev.latvian.mods.kubejs.recipe.component.RecipeComponent;
import dev.latvian.mods.rhino.Context;
import dev.latvian.mods.rhino.type.TypeInfo;

public record RitualRequirementSettingsComponent(String name, Codec<RitualRecipe.RitualRequirementSettings> codec) implements RecipeComponent<RitualRecipe.RitualRequirementSettings> {
    public static final RecipeComponent<RitualRecipe.RitualRequirementSettings> RITUAL_REQUIREMENT_SETTINGS = new RitualRequirementSettingsComponent("occultism:ritual_requirement_settings", RitualRecipe.RitualRequirementSettings.CODEC);

    public static final TypeInfo TYPE_INFO = TypeInfo.of(RitualRequirementSettingsComponent.class);

    @Override
    public TypeInfo typeInfo() {
        return TYPE_INFO;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public RitualRecipe.RitualRequirementSettings wrap(Context cx, KubeRecipe recipe, Object from) {
        if (from instanceof RitualRecipe.RitualRequirementSettings k) {
            return k;
        }

        if (from instanceof JsonObject json) {
            return this.codec.decode(JsonOps.INSTANCE, json).result().orElseThrow().getFirst();
        }

        return (RitualRecipe.RitualRequirementSettings) cx.jsToJava(from, this.typeInfo());

    }
}
