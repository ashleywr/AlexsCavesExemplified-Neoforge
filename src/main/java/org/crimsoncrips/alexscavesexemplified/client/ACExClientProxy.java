package org.crimsoncrips.alexscavesexemplified.client;

import com.github.alexmodguy.alexscaves.client.particle.TephraParticle;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.bus.api.IEventBus;
import org.crimsoncrips.alexscavesexemplified.ACExCommonProxy;
import org.crimsoncrips.alexscavesexemplified.AlexsCavesExemplified;
import org.crimsoncrips.alexscavesexemplified.client.entity.GammaNuclearBombRenderer;
import org.crimsoncrips.alexscavesexemplified.client.particle.*;
import org.crimsoncrips.alexscavesexemplified.server.entity.ACExEntityRegistry;

public class ACExClientProxy extends ACExCommonProxy {

    public void init(IEventBus modEventBus) {
        NeoForge.EVENT_BUS.register(new ACExClientEvents());
        modEventBus.addListener(this::setupParticles);
    }


    public void setupParticles(RegisterParticleProvidersEvent registry) {
        registry.registerSpriteSet(ACExParticleRegistry.TREMORZILLA_GAMMA_EXPLOSION.get(), SmallExplosions.GammaTremorzillaFactory::new);
        registry.registerSpecial(ACExParticleRegistry.TREMORZILLA_GAMMA_PROTON.get(), new GammaTremorProton.Factory());
        registry.registerSpriteSet(ACExParticleRegistry.TREMORZILLA_GAMMA_LIGHTNING.get(), GammaTremorLightning.Factory::new);

        registry.registerSpecial(ACExParticleRegistry.GAMMA_PROTON.get(), new GammaProton.GammaFactory());

        registry.registerSpecial(ACExParticleRegistry.GAMMA_MUSHROOM_CLOUD.get(), new GammaMushroomCloud.GammaNukeFactory());

        registry.registerSpriteSet(ACExParticleRegistry.GAMMA_TEPHRA.get(), TephraParticle.Factory::new);
        registry.registerSpriteSet(ACExParticleRegistry.GAMMA_TEPHRA_SMALL.get(), TephraParticle.SmallFactory::new);
        registry.registerSpriteSet(ACExParticleRegistry.GAMMA_TEPHRA_FLAME.get(), TephraParticle.FlameFactory::new);

        registry.registerSpecial(ACExParticleRegistry.AZURE_FOCUSED_LIGHTNING.get(), new FocusedLightningParticle.AzureFactory());
        registry.registerSpecial(ACExParticleRegistry.SCARLET_FOCUSED_LIGHTNING.get(), new FocusedLightningParticle.ScarletFactory());


    }

    public void clientInit() {
        EntityRenderers.register(ACExEntityRegistry.GAMMA_NUCLEAR_BOMB.get(), GammaNuclearBombRenderer::new);
    }


}
