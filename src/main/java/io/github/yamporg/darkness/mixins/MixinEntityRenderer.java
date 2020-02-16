package io.github.yamporg.darkness.mixins;

import io.github.yamporg.darkness.DarknessConfig;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.world.DimensionType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(EntityRenderer.class)
public abstract class MixinEntityRenderer {
    @ModifyConstant(method = "updateLightmap", constant = @Constant(floatValue = 0.95F), allow = 1)
    public float blockSunBrightnessWeight(float f) {
        if (!DarknessConfig.general.enable) {
            return f;
        }
        return 1 - DarknessConfig.constants.minBlockSunBrightness;
    }

    @ModifyConstant(method = "updateLightmap", constant = @Constant(floatValue = 0.05F), allow = 1)
    public float blockSunBrightnessMinimum(float f) {
        if (!DarknessConfig.general.enable) {
            return f;
        }
        return DarknessConfig.constants.minBlockSunBrightness;
    }

    @ModifyConstant(method = "updateLightmap", constant = @Constant(floatValue = 0.96F), allow = 6)
    public float blockBrightnessWeight(float f) {
        if (!DarknessConfig.general.enable) {
            return f;
        }
        return 1 - DarknessConfig.constants.minBlockBrightness;
    }

    @ModifyConstant(method = "updateLightmap", constant = @Constant(floatValue = 0.03F), allow = 6)
    public float blockBrightnessMinimum(float f) {
        if (!DarknessConfig.general.enable) {
            return f;
        }
        return DarknessConfig.constants.minBlockBrightness;
    }

    @Redirect(
            method = "updateLightmap",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/DimensionType;getId()I"),
            allow = 1)
    public int getIdProxy(DimensionType type) {
        int id = type.getId();
        if (id != 1) {
            return id;
        }
        if (!DarknessConfig.general.enable) {
            return id;
        }
        if (!DarknessConfig.general.enableDarkEnd) {
            return id;
        }
        return 0;
    }

    @Redirect(
            method = "updateLightmap",
            at =
                    @At(
                            value = "FIELD",
                            target = "Lnet/minecraft/client/settings/GameSettings;gammaSetting:F"),
            allow = 1)
    public float gammaSettingProxy(GameSettings s) {
        float gamma = DarknessConfig.constants.gammaOverride;
        if (gamma < 0) {
            return s.gammaSetting;
        }
        if (!DarknessConfig.general.enable) {
            return s.gammaSetting;
        }
        return gamma;
    }
}
