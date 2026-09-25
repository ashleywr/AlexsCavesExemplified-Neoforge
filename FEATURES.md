# Feature inventory

This is the complete player-facing inventory for the 1.21.1 port. The setting name shown in backticks is the exact TOML key. Unless stated otherwise, each switch defaults to `true`.

## Added content

- Metal Cauldron, with Acid Cauldron and Purple Soda Cauldron filled states used for renewable cave liquids and candy processing.
- Gamma Nuclear Bomb block, item, primed entity, explosion behavior, dispenser behavior, model, renderer, particles, and sounds.
- Ice Cream Cone food and Dinosaur Eggs utility item.
- Nine volcanic-sacrifice cave paintings.
- Magneticism enchantment for the Resistor Shield and Galena Gauntlet.
- Sugar Crash, Rabial Infection, and Serened status effects, including associated damage types and brewing support.
- Primordial bonemeal world-generation feature.
- A large advancement tree covering the new mechanics, plus an optional Patchouli ACE Wiki.

## General

- `ACE_WIKI_ENABLED` — give new players the ACE Wiki when Patchouli is installed.
- `REDOABLE_SPELUNKY_ENABLED` — return the cave tablet when leaving a Spelunkery Table.
- `SPELUNKY_ATTEMPTS_AMOUNT` — attempts per cave tablet; defaults to `5`, minimum `1`.
- `CHARGED_CAVE_CREEPER_CHANCE` — chance that cave creepers spawn charged; defaults to `0.2`, range `0.0–1.0`.
- `ADDITIONAL_FLAMMABILITY_ENABLED` — make appropriate Alex's Caves blocks flammable.
- `FORGIVING_SPELUKING_ENABLED` — lose a level instead of immediately losing the Spelunkery minigame.
- `CAVIAL_BONEMEAL_ENABLED` — add bonemeal interactions for Alex's Caves flora.
- `LIQUID_REPLICATION_ENABLED` — make supported Alex's Caves liquids renewable through metal cauldrons.
- `POWERED_LOCATORS_ENABLED` — empower biome locators with a Nether Star so protected caves can be found.

## Candy Cavity

- `GLUTTONY_ENABLED` — eat edible candy blocks directly and enable related food interactions.
- `STICKY_SODA_ENABLED` — make Purple Soda sticky to entities moving through it.
- `RADIANT_WRATH_ENABLED` — amplify Sugar Staff attacks while Radiant Essence is held.
- `TUNED_SATING_ENABLED` — let a dropped Sack of Sating consume nearby dropped food.
- `SUGAR_CRASH_ENABLED` — apply damaging slowness after Sugar Rush expires.
- `ICED_CREAM_ENABLED` — thrown ice cream partially freezes struck entities.
- `BREAKING_CANDY_ENABLED` — produce gelatin by heating a filled cauldron with bone and dye ingredients.
- `ICE_CREAM_CONE_ENABLED` — enable craftable Ice Cream Cones.
- `OVERDRIVED_CONVERSION_ENABLED` — overdrive Conversion Crucibles with Radiant Essence.
- `PURPLE_LEATHERED_ENABLED` — dye dyeable armor purple in Purple Soda, including compatible modded armor.
- `AMPLIFIED_FROSTMINT_ENABLED` — expand Frostmint item interactions, including compatible Create and Biomes O' Plenty fluids/blocks.
- `CANIAC_MANIAC_ENABLED` — give Caniacs additional unhinged behavior.
- `CANDICORN_HEAL_ENABLED` — allow caramel apples to heal Candicorns.
- `STICKY_CARAMEL_ENABLED` — apply Caramel Cube stickiness through its attacks.
- `AMPUTATION_ENABLED` — allow axes to amputate Gingerbread Men.
- `HIVE_MIND_ENABLED` — make nearby Gingerbread Men retaliate when one is attacked.
- `JELLYBEAN_CHANGES_ENABLED` — scale Gummy Bear jellybean harvests with hibernation duration.
- `SWEETISH_SPEEDUP_ENABLED` — matching-color Sweetish Fish accelerate Gummy Bear hibernation.
- `PRESSURED_HOOKS_ENABLED` — Candy Hooks wear down over time while riding a Gum Worm.

## Forlorn Hollows

- `FORLORN_LIGHT_EFFECT_ENABLED` — make most Forlorn mammals react to carried light; Curious Lanterns are supported.
- `BURST_OUT_ENABLED` — sometimes release Underzealots or Corrodents when Forlorn blocks are broken.
- `RABIES_ENABLED` — enable contagious Rabial Infection behavior in the Hollows.
- `GUASLOWPOKE_ENABLED` — make guano slow entities.
- `BEHOLDENT_STALKING_ENABLED` — make idle Beholders stalk nearby players.
- `DREAD_ADDAPTIONS_ENABLED` — adapt relevant vanilla enchantments to the Dreadbow.
- `KNAWING_ENABLED` — let Corrodents gnaw dropped items.
- `CORRODENT_CONVERSION_ENABLED` — allow Corrodents to be offered and converted to Underzealots.
- `UNDERZEALOT_RESPECT_ENABLED` — make Underzealots respect players wearing the darkness-themed equipment.
- `DARK_OFFERING_ENABLED` — allow neutral Underzealots to accept leashed sacrifices; Alex's Mobs vine lassos are supported.
- `ANTI_SACRIFICE_ENABLED` — make Vespers attack Underzealots that are sacrificing Vespers.
- `VESPER_SHOTDOWN_ENABLED` — arrows ground Vespers for an extended period.
- `SOLIDIFIED_ENABLED` — allow long-idle Watchers to solidify into totems.

## Toxic Caves

- `EXEMPLIFIED_IRRADIATION_AMOUNT` — irradiation level that triggers the deadly extra effects; defaults to `5`, minimum `1`.
- `KIROV_REPORTING_ENABLED` — light carried explosives with an off-hand flint and steel while flying.
- `ARMORED_LIQUIDATORS_ENABLED` — make Hazmat armor reduce received irradiation.
- `REARAYNGEMENT_ENABLED` — amplify Raygun effects, including block destruction.
- `IRRADIATION_WASHOFF_ENABLED` — wash irradiation off faster in water; Supplementaries soap is supported.
- `GEOTHERMAL_EFFECTS_ENABLED` — apply smoke-dependent effects above Geothermal Vents.
- `WASTE_PICKUP_ENABLED` — let unladen Brainiacs pick up Waste Drums.
- `ROACH_FEEDING_ENABLED` — make Gammaroaches seek dropped food.
- `NUCLEAR_CHAIN_ENABLED` — make Nucleepers killed by explosions detonate in a chain reaction.
- `DEFUSION_ENABLED` — allow Nucleepers to be defused.
- `FISH_MUTATION_ENABLED` — acid can mutate fish into Radgills.
- `CAT_MUTATION_ENABLED` — acid can mutate cats into Raycats.
- `GAMMA_TREMORZILLA_ENABLED` — a gamma nuclear blast can create the stronger Gamma Tremorzilla variant.

## Primordial Caves

- `SERENED_ENABLED` — Serene Salad can apply Serened, calming non-player mobs until attacked.
- `EGG_ANGER_ENABLED` — untamed dinosaurs attack entities visibly carrying their eggs.
- `SCAVENGING_ENABLED` — carnivorous dinosaurs scavenge placed meat; Farmer's Delight feast blocks are supported.
- `STOMPING_ENABLED` — Atlatitan and Luxtructosaurus stomps damage nearby entities.
- `PRESERVED_AMBER_ENABLED` — generated amber may preserve trapped mobs; Alex's Mobs adds extra candidates.
- `FLY_TRAPPED_ENABLED` — Flytraps close around Alex's Mobs flies when that mod is installed.
- `VOLCANIC_SACRIFICE_ENABLED` — sacrifice Atlatitan eggs or babies to refresh a volcano's Luxtructosaurus cooldown.
- `SEETHED_TAMING_ENABLED` — alternatively tame a Tremorsaurus by feeding it enough meat; requires Scavenging.

## Magnetic Caves

- `MAGNETICISM_ENABLED` — enable the Magneticism enchantment and its Resistor Shield/Galena Gauntlet bonuses.
- `SHOCKING_THERAPY_ENABLED` — let Tesla Bulbs occasionally shock nearby intruders and play added effects.
- `SCALABLE_HOLOGRAM_ENABLED` — resize Hologram Projector displays with Azurite and Scarlet Neodymium ingots.
- `MAGNERIP_ENABLED` — Weakness can pull magnetic items out of held slots.
- `HARDCORE_MAGNERIP_ENABLED` — pull magnetic items from the entire inventory; defaults to `false` and depends on Magnerip.
- `BOUNDED_MAGNETISM_ENABLED` — let Boundroids attract magnetic items and alter attacks against magnetizable players.
- `TELETOR_ARMORY_ENABLED` — let unarmed Teletors rearm themselves from nearby magnetic weapons.
- `SELF_DESTRUCT_ENABLED` — make attacked Notors self-destruct.

## Abyssal Chasm

- `ABYSSAL_CRUSH_ENABLED` — deep water inflicts crushing damage and reduces usable breath; Create diving equipment is supported.
- `ECOLOGICAL_REPUTATION_ENABLED` — player actions in the Chasm raise or lower ecological reputation and affect reactions.
- `SUBMARINE_BUMP_ENABLED` — moving Submarines damage entities they collide with.
- `REMINEDING_ENABLED` — allow Mine Guardians to be constructed and owned.
- `NOON_GUARDIAN_ENABLED` — enable the special Mine Guardian variant obtained by naming one “Noon”.
- `NAVAL_NUCLEARITY_ENABLED` — arm Mine Guardians with nuclear bombs to create nuclear variants.
- `POISONOUS_SKIN_ENABLED` — nearby contact with Sea Pigs can poison mobs.

## Goofy Mode

Every option in this intentionally unbalanced category defaults to `false`.

- `RATATATATATA_ENABLED` — give the Dreadbow extreme rapid fire.
- `NUCLEAR_PISTONATION_ENABLED` — make nuclear bombs piston-movable and consequently duplicable.
- `BRAINDEAD_MODE_ENABLED` — enable Spelunkery X-ray behavior.
- `COOKIE_CRUMBLE_ENABLED` — make parrots explode when given a Cookie Block.
- `SWEET_PUNISHMENT_ENABLED` — punish excessive sweet consumption.
- `IP_ENABLED` — enable the Notor “IP leak” joke behavior.
- `CATTASTROPHE_ENABLED` — enable the Alex's Mobs cat-call catastrophe interaction.
- `TOUGH_ROACHES_ENABLED` — make Alex's Mobs cockroaches immune to nuclear blasts.
- `SHOTNUKE_ENABLED` — make the Shotgum fire nuclear bombs.

## Additional AI targets

These switches live in `alexscavesexemplified-targets.toml` so pack makers can independently opt out of the extra ecological/immersive hostility.

- `LICOWITCH_ENABLED` — Licowitches target villagers and entities in the `licowitch_hate` entity-type tag.
- `DEEP_ONES_ENABLED` — Deep Ones, Deep One Knights, and Deep One Mages hunt Lanternfish and Tripodfish.
- `GROTTOCERATOPS_ENABLED` — untamed Grottoceratops target entities holding Limestone Spears.
- `VESPER_ENABLED` — Vespers hunt entities in the `vesper_hunt` entity-type tag.
- `RELICHERIRUS_ENABLED` — untamed Relicheirus target entities holding Limestone Spears.

## Client presentation

- `MAGNETIC_MOVEMENT_ENABLED` — visually move magnetic items around inventory and hotbar slots in Magnetic Caves.
- `PATCHOULI_REMINDER_ENABLED` — show the reminder that the optional Patchouli guide is available.

## Compatibility status

- Ashley's Alex's Caves fork 2.0.10.1 and its embedded TACT module: server world creation and client startup tested.
- Alex's Mobs and Create: optional mixins are applied only when their target classes exist.
- Curios/Curious Lanterns, Farmer's Delight, Biomes O' Plenty, Patchouli, and Supplementaries: optional runtime integrations retained.
- Alex's Caves Enriched: its old integration is omitted because there is no compatible 1.21.1 build to compile or test against.
