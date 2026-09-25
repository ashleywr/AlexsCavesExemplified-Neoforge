package org.crimsoncrips.alexscavesexemplified.server;

import net.neoforged.neoforge.common.ModConfigSpec;

public class ACExAddTargetsConfig {

    public final ModConfigSpec.BooleanValue LICOWITCH_ENABLED;
    public final ModConfigSpec.BooleanValue DEEP_ONES_ENABLED;
    public final ModConfigSpec.BooleanValue GROTTOCERATOPS_ENABLED;
    public final ModConfigSpec.BooleanValue VESPER_ENABLED;
    public final ModConfigSpec.BooleanValue RELICHERIRUS_ENABLED;


    public ACExAddTargetsConfig(final ModConfigSpec.Builder builder) {

        builder.push("Alexs Caves");
        this.LICOWITCH_ENABLED = buildMob(builder, "LICOWITCH_ENABLED", "Licowitches target villagers and entities in the licowitch_hate tag");
        this.DEEP_ONES_ENABLED = buildMob(builder, "DEEP_ONES_ENABLED", "Deep Ones, Deep One Knights, and Deep One Mages hunt lanternfish and tripodfish");
        this.GROTTOCERATOPS_ENABLED = buildMob(builder, "GROTTOCERATOPS_ENABLED", "Untamed Grottoceratops target entities holding limestone spears");
        this.VESPER_ENABLED = buildMob(builder, "VESPER_ENABLED", "Vespers hunt entities in the vesper_hunt tag");
        this.RELICHERIRUS_ENABLED = buildMob(builder, "RELICHERIRUS_ENABLED", "Untamed Relicheirus target entities holding limestone spears");
        builder.pop();

    }

    private static ModConfigSpec.BooleanValue buildMob(ModConfigSpec.Builder builder, String name, String comment){
        return builder.comment(comment).translation(name).define(name, true);
    }

}
