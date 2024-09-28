package com.klikli_dev.occultism_kubejs.component;

import com.klikli_dev.occultism.crafting.recipe.RitualRecipe;
import dev.latvian.mods.kubejs.typings.Info;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import org.jetbrains.annotations.Nullable;

@Info("Various entity to sacrifice related helper methods")
public interface EntityToSummonSettingsWrapper {

    @Info("Returns an RitualRecipe.EntityToSummonSettings of the input")
    static RitualRecipe.EntityToSummonSettings of(RitualRecipe.EntityToSummonSettings in) {
        return in;
    }

    @Info("Returns an RitualRecipe.EntityToSummonSettings of the input")
    static RitualRecipe.EntityToSummonSettings of(@Nullable EntityType<?> entityToSummon,
                                                  @Nullable TagKey<EntityType<?>> entityTagToSummon,
                                                  @Nullable CompoundTag entityNbt,
                                                  @Nullable ResourceLocation spiritJobType,
                                                  int spiritMaxAge,
                                                  int summonNumber) {
        return new RitualRecipe.EntityToSummonSettings(entityToSummon, entityTagToSummon, entityNbt, spiritJobType, spiritMaxAge, summonNumber);
    }

    @Info("Returns an RitualRecipe.EntityToSummonSettings of the input")
    static RitualRecipe.EntityToSummonSettings ofEntity(@Nullable EntityType<?> entityToSummon,
                                                        @Nullable CompoundTag entityNbt,
                                                        @Nullable ResourceLocation spiritJobType,
                                                        int spiritMaxAge,
                                                        int summonNumber
    ) {
        return new RitualRecipe.EntityToSummonSettings(entityToSummon, null, entityNbt, spiritJobType, spiritMaxAge, summonNumber);
    }

    @Info("Returns an RitualRecipe.EntityToSummonSettings of the input")
    static RitualRecipe.EntityToSummonSettings ofTag(@Nullable TagKey<EntityType<?>> entityTagToSummon,
                                                     @Nullable CompoundTag entityNbt,
                                                     @Nullable ResourceLocation spiritJobType,
                                                     int spiritMaxAge,
                                                     int summonNumber
    ) {
        return new RitualRecipe.EntityToSummonSettings(null, entityTagToSummon, entityNbt, spiritJobType, spiritMaxAge, summonNumber);
    }
}
