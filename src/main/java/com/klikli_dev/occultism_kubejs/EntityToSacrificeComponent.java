package com.klikli_dev.occultism_kubejs;

import com.google.gson.JsonObject;
import com.klikli_dev.occultism.crafting.recipe.RitualRecipe;
import com.mojang.serialization.Codec;
import com.mojang.serialization.JsonOps;
import dev.latvian.mods.kubejs.recipe.KubeRecipe;
import dev.latvian.mods.kubejs.recipe.component.RecipeComponent;
import dev.latvian.mods.rhino.Context;
import dev.latvian.mods.rhino.type.TypeInfo;

public record EntityToSacrificeComponent(String name, Codec<RitualRecipe.EntityToSacrifice> codec) implements RecipeComponent<RitualRecipe.EntityToSacrifice> {
    public static final RecipeComponent<RitualRecipe.EntityToSacrifice> ENTITY_TO_SACRIFICE = new EntityToSacrificeComponent("occultism:entity_to_sacrifice", RitualRecipe.EntityToSacrifice.CODEC);

    public static final TypeInfo TYPE_INFO = TypeInfo.of(EntityToSacrificeComponent.class);

    @Override
    public TypeInfo typeInfo() {
        return TYPE_INFO;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public RitualRecipe.EntityToSacrifice wrap(Context cx, KubeRecipe recipe, Object from) {
        if (from instanceof RitualRecipe.EntityToSacrifice k) {
            return k;
        }

        if (from instanceof JsonObject json) {
            return this.codec.decode(JsonOps.INSTANCE, json).result().orElseThrow().getFirst();
        }

        return (RitualRecipe.EntityToSacrifice) cx.jsToJava(from, this.typeInfo());

    }
}
