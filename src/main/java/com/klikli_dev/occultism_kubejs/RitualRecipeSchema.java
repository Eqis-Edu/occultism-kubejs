package com.klikli_dev.occultism_kubejs;

import com.klikli_dev.occultism.crafting.recipe.RitualRecipe;
import com.klikli_dev.occultism_kubejs.component.EntityToSacrificeComponent;
import com.klikli_dev.occultism_kubejs.component.EntityToSummonSettingsComponent;
import com.klikli_dev.occultism_kubejs.component.RitualRequirementSettingsComponent;
import com.klikli_dev.occultism_kubejs.component.RitualStartSettingsComponent;
import dev.latvian.mods.kubejs.recipe.RecipeKey;
import dev.latvian.mods.kubejs.recipe.component.*;
import dev.latvian.mods.kubejs.recipe.schema.RecipeSchema;
import dev.latvian.mods.kubejs.util.TickDuration;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.List;

public interface RitualRecipeSchema {
    RecipeKey<String> RITUAL_TYPE = StringComponent.ID.inputKey("ritual_type").alt("ritualType").optional("occultism:craft").alwaysWrite();
    RecipeKey<RitualRecipe.RitualRequirementSettings> RITUAL_REQUIREMENT_SETTINGS = RitualRequirementSettingsComponent.RITUAL_REQUIREMENT_SETTINGS.inputKey("ritual_requirement_settings").alt("ritualRequirementSettings").alwaysWrite();
    RecipeKey<RitualRecipe.RitualStartSettings> RITUAL_START_SETTINGS = RitualStartSettingsComponent.RITUAL_START_SETTINGS.inputKey("ritual_start_settings").alt("ritualStartSettings").alwaysWrite();
    RecipeKey<RitualRecipe.EntityToSummonSettings> ENTITY_TO_SUMMON_SETTINGS = EntityToSummonSettingsComponent.ENTITY_TO_SUMMON_SETTINGS.outputKey("entity_to_summon_settings").alt("entityToSummonSettings")
            .defaultOptional();
    RecipeKey<ItemStack> RITUAL_DUMMY = ItemStackComponent.ITEM_STACK.outputKey("ritual_dummy").alt("ritualDummy").alt("dummyItem").alt("dummy")
            // apparently there is never any static reference to this item, so let's just hope klikli never changes this lmao
            .optional(new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse("occultism:ritual_dummy/custom_ritual"))))
            .alwaysWrite();
    RecipeKey<ItemStack> RESULT = ItemStackComponent.ITEM_STACK.outputKey("result").allowEmpty();
    RecipeKey<String> COMMAND = StringComponent.ANY.inputKey("command").defaultOptional();

    RecipeSchema SCHEMA = new RecipeSchema(
            // all the required keys first
            RESULT,
            RITUAL_REQUIREMENT_SETTINGS, RITUAL_START_SETTINGS,
            // and now all the optionals...
            ENTITY_TO_SUMMON_SETTINGS, RITUAL_DUMMY, RITUAL_TYPE, COMMAND
    ).uniqueId(RITUAL_DUMMY);

}
