# Alex's Caves Exemplified — NeoForge 1.21.1

This branch ports Alex's Caves Exemplified to Minecraft 1.21.1 / NeoForge and targets Ashley's Alex's Caves fork. That fork includes Alex's Caves Tweak (TACT), and the addon has been tested with both mods active.

The addon expands every Alex's Caves biome with new creature behavior, item and block interactions, progression, effects, advancements, and several deliberately chaotic optional features. See [FEATURES.md](FEATURES.md) for the complete feature and setting inventory.

## Requirements

- Minecraft 1.21.1
- NeoForge 21.1.219 or newer 21.1.x
- Java 21
- Ashley's Alex's Caves fork 2.0.10.1 or newer
- Citadel 2.7.1 or newer

TACT 1.5.3 is embedded in the targeted Alex's Caves fork. It is declared as an optional companion so the addon remains usable if that packaging changes.

Optional integrations are detected at runtime: Alex's Mobs, Biomes O' Plenty, Create, Curious Lanterns/Curios, Farmer's Delight, Patchouli, and Supplementaries. Optional Alex's Mobs and Create mixins are skipped cleanly when those mods are absent.

## Configuration

The project already used NeoForge's native `ModConfigSpec`, which is a better fit here than adding Cloth Config: common settings load on both dedicated servers and clients, retain comments and validation, and require no additional dependency. The port fixes the category nesting and registers all three specs:

- `config/alexscavesexemplified-general.toml` — 86 gameplay settings, including bounded numeric values
- `config/alexscavesexemplified-targets.toml` — five independently controlled AI-target additions
- `config/alexscavesexemplified-client.toml` — two client-only presentation settings

All normal gameplay additions default to enabled. Hardcore Magnerip and the nine Goofy Mode options default to disabled.

## Building

The build intentionally compiles against the sibling local fork:

```text
Minecraft Mods/
├─ AlexsCaves/
└─ AlexsCavesExemplified-Neoforge/
   └─ repo/
```

Build Alex's Caves first so `AlexsCaves/build/libs/alexscaves-2.0.10.1.jar` exists, then run:

```powershell
./gradlew build
```

The addon JAR is written to `build/libs/`.

## In-game guide

With Patchouli installed, the ACE Wiki documents the additions in game. The starter-book grant and the reminder can be disabled independently.

Please report addon-specific issues to the [Alex's Caves Exemplified issue tracker](https://github.com/CrimsonCrips/AlexsCavesExemplified/issues), not to the Alex's Caves team.

## Credits

- Reimnop and Drullkus for development help
- AlexModGuy and Noonyeyz for Alex's Caves
- Reimnop's Patchouli data-generation work
- The original Gamma Tremorzilla resource-pack artist
- Crafting Theories for feature inspiration

<!-- ashley-release-information -->

## Ashley's builds

This is an unofficial maintenance fork. Original authors retain ownership and credit. See the [upstream project](https://github.com/CrimsonCrips/AlexsCavesExemplified) for the original mod. Local changes do not imply upstream endorsement.

Licensing: **MIT**. Existing license files, copyright notices, attribution and any separate asset terms remain in force. This fork does not relicense upstream work.

Provided **AS IS**, without warranty of any kind. Maintenance, updates and support are best effort; compatibility with every modpack is not guaranteed.

### Downloads and installation

Download a runtime `.jar` from [GitHub Releases](https://github.com/ashleywr/AlexsCavesExemplified-Neoforge/releases). Use the Minecraft version and loader named in that release and install its required dependencies. Do not install `-sources`, `-dev`, `-slim`, `-common` or test JARs as the mod.

Close Minecraft, back up your world, and place the matching runtime JAR in the instance's `mods/` directory. Replace older versions of this same mod rather than loading duplicates. For content mods, install matching versions on the server and its clients unless the release explicitly says client-only or server-only.

### Building and reporting problems

Use Java 21 and the checked-in Gradle wrapper:

```powershell
.\gradlew.bat build
```

Build outputs are under `build/libs/` or each loader subproject's `build/libs/`. Some projects require the local development dependencies described above; those dependencies are not included in the download.

For a problem report, include the exact release filename, Minecraft and loader versions, relevant mod versions, `logs/latest.log`, and a crash report if one was written. Remove private information before sharing logs. Remove the JAR to uninstall; worlds containing this mod's blocks, entities or world generation may require restoring a backup.
