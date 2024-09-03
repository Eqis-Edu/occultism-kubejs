package com.klikli_dev.occultism_kubejs;

import com.klikli_dev.occultism.crafting.recipe.RitualRecipe;
import com.klikli_dev.occultism.crafting.recipe.result.RecipeResult;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import dev.latvian.mods.kubejs.KubeJS;
import dev.latvian.mods.kubejs.component.DataComponentWrapper;
import dev.latvian.mods.kubejs.item.ItemStackJS;
import dev.latvian.mods.kubejs.typings.Info;
import dev.latvian.mods.kubejs.util.RegistryAccessContainer;
import dev.latvian.mods.rhino.Wrapper;
import net.minecraft.core.component.DataComponentPredicate;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.Nullable;

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
