package org.crimsoncrips.alexscavesexemplified.mixins;

import net.neoforged.fml.loading.LoadingModList;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Set;

/** Keeps optional compatibility mixins from targeting classes that are not installed. */
public final class ACExMixinConfigPlugin implements IMixinConfigPlugin {
    private static Boolean alexsMobsLoaded;
    private static Boolean createLoaded;

    /**
     * Mixin config plugins run before the game classpath is safe to resolve. Loading an
     * optional mod's class here also resolves its Entity/LivingEntity superclasses, which
     * makes other mods' Entity mixins fail as already loaded. Consult NeoForge's discovered
     * mod list instead; it is available during mixin selection and does not load game classes.
     */
    private static boolean isModLoaded(String modId) {
        try {
            return LoadingModList.get().getModFileById(modId) != null;
        } catch (Throwable ignored) {
            return false;
        }
    }

    private static boolean isAlexsMobsLoaded() {
        if (alexsMobsLoaded == null) {
            alexsMobsLoaded = isModLoaded("alexsmobs");
        }
        return alexsMobsLoaded;
    }

    private static boolean isCreateLoaded() {
        if (createLoaded == null) {
            createLoaded = isModLoaded("create");
        }
        return createLoaded;
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        if (mixinClassName.endsWith("ACExFlyMixin")
                || mixinClassName.endsWith("ACExModelFlyMixin")
                || mixinClassName.endsWith("ACExModelCockroachMixin")) {
            return isAlexsMobsLoaded();
        }
        if (mixinClassName.endsWith("ACExVanillaFluidTargetsMixin")) {
            return isCreateLoaded();
        }
        return true;
    }

    @Override public void onLoad(String mixinPackage) { }
    @Override public String getRefMapperConfig() { return null; }
    @Override public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) { }
    @Override public List<String> getMixins() { return null; }
    @Override public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) { }
    @Override public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) { }
}
