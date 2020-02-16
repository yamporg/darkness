package io.github.yamporg.darkness.mixins;

import io.github.yamporg.darkness.DarknessConfig;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldProviderHell;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WorldProviderHell.class)
public abstract class MixinWorldProviderHell extends WorldProvider {
    @Inject(method = "generateLightBrightnessTable", at = @At("HEAD"), cancellable = true)
    public void onGenerateLightBrightnessTable(CallbackInfo cir) {
        if (!DarknessConfig.general.enable) {
            return;
        }
        if (!DarknessConfig.general.enableDarkNether) {
            return;
        }
        cir.cancel();
        super.generateLightBrightnessTable();
    }
}
