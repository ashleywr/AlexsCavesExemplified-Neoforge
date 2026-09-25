package org.crimsoncrips.alexscavesexemplified.misc.interfaces;

import net.minecraft.world.entity.Entity;

public interface LaunchedSeeking {

    int getLaunchedTargetID();

    void setLaunchedTargetID(int var);

    float getSpinAngle();

    void setSpinAngle(float var);

    void setStopSeeking(boolean var);

    void resetForLaunch();

    boolean canLaunchAt(Entity entity);

}
