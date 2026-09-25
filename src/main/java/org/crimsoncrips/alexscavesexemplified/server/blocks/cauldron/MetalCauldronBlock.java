package org.crimsoncrips.alexscavesexemplified.server.blocks.cauldron;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.cauldron.CauldronInteraction;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class MetalCauldronBlock extends ACExCauldron {

    public static final MapCodec<MetalCauldronBlock> CODEC = simpleCodec(MetalCauldronBlock::new);

    @Override
    protected MapCodec<? extends MetalCauldronBlock> codec() {
        return CODEC;
    }

    public MetalCauldronBlock(BlockBehaviour.Properties p_51403_) {
        super(p_51403_, CauldronInteraction.EMPTY);
    }



}
