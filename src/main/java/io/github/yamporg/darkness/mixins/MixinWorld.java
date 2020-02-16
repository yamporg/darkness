package io.github.yamporg.darkness.mixins;

import io.github.yamporg.darkness.DarknessConfig;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.Slice;

@Mixin(World.class)
public abstract class MixinWorld {
    @ModifyConstant(
            method = "getSunBrightnessBody",
            remap = false,
            constant = @Constant(floatValue = 0.8F),
            allow = 1)
    public float sunBrightnessWeight(float f) {
        if (!DarknessConfig.general.enable) {
            return f;
        }
        if (!DarknessConfig.general.hardcore) {
            return f;
        }
        return 1 - DarknessConfig.constants.minWorldSunBrightness;
    }

    @ModifyConstant(
            method = "getSunBrightnessBody",
            remap = false,
            constant = @Constant(floatValue = 0.2F),
            allow = 1,
            slice = @Slice(from = @At(value = "CONSTANT", args = "floatValue=0.8")))
    public float sunBrightnessMinimum(float f) {
        if (!DarknessConfig.general.enable) {
            return f;
        }
        if (!DarknessConfig.general.hardcore) {
            return f;
        }
        return DarknessConfig.constants.minWorldSunBrightness;
    }
}
