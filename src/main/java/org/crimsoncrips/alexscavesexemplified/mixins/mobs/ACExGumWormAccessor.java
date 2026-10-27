package org.crimsoncrips.alexscavesexemplified.mixins.mobs;
import com.github.alexmodguy.alexscaves.server.entity.living.GumWormEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
@Mixin(GumWormEntity.class)
public interface ACExGumWormAccessor {
    @Accessor("surfaceY") double alexscavesexemplified$getSurfaceY();
}
