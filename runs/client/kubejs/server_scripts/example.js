// priority: 0

// Visit the wiki for more info - https://kubejs.com/

console.info('Hello, World! (Loaded server scripts)')

ServerEvents.recipes((event) => {
    //Some examples of how to add recipes:

    // event.recipes.occultism.spirit_trade('minecraft:rotten_flesh', 'minecraft:bone') //Note that a trade recipe alone is not enough, it needs a corresponding spirit job that is set to perform this trade.
    event.recipes.occultism.spirit_fire('minecraft:emerald_ore', '#c:gems/emerald')
    event.recipes.occultism.crushing(
        RecipeResult.of("#c:ores/iron", 2),
        '#minecraft:swords'
    )
    event.recipes.occultism.miner(
        //item, count, weight
        WeightedRecipeResult.of('minecraft:wooden_pickaxe', 1, 100),
        '#occultism:miners/master'
    )
    event.recipes.occultism.ritual(
        'occultism:spirit_lantern', //result
        RitualRequirementSettings.of(
            'occultism:craft_afrit', //pentacleId
            [
                "lapis_lazuli",
                "#c:raw_materials",
                "minecraft:coal"
            ], //ingredients
            '#c:stones', //activationItem
            10, //optional, duration
        ),
        RitualStartSettings.of(
            EntityToSacrifice.of(
                "minecraft:cows", //the tag of entities to sacrifice
                "Cows"
                //the text to show in recipe viewers such as JEI/EMI/...
                //it would be better to use a translation key instead of "Cows" to allow translating to other languages. E.g. "tags.entities.cows" -> but that also needs a corresponding translation in en_us.json and other lang files.
            ), //optional entity to sacrifice (use null if none)
            'minecraft:egg', //optional item to use (use null if none)
            IsInBiomeCondition.of("minecraft:plains"), //optional condition (use null if none). Wrappers provided by OccultismKubeJS: IsInBiomeCondition, IsInBiomeWithTagCondition, IsInDimensionCondition, IsInDimensionTypeCondition. Also supports neoforge default conditions, but there is no kubejs wrapper for them yet.
        ),
    ).dummy("kubejs:dummy_ritual_thing") //the ritual dummy, used to allow viewing recipes in JEI/EMI/...
        .ritualType("occultism:craft") //the ritual type. If omitted, it will default to "occultism:craft"
        .entityToSummonSettings(
            EntityToSummonSettings.of(
                "minecraft:zombie", //the id of the entity to summon. Use null if you want to use a tag instead.
                null, //"minecraft:cows", the tag of entities to summon. Use null if you want to use an id instead.
                null, //the nbt of the entity to summon. Use null if you don't want to specify nbt.
                "occultism:crush_tier1", //the spirit job type. Use null if you don't want to summon a spirit. Works only on occultism spirit entities.
                -1, //the max age of the spirit. Use -1 if want the spirit to last forever. Works only on occultism spirit entities (ignored for other entities).
                1 //the number of entities to summon. Use 1 if you want to summon only one entity.
            )
        );
})
