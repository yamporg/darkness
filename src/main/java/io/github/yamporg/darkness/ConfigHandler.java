package io.github.yamporg.darkness;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = DarknessMod.MODID)
public class ConfigHandler {
    @SubscribeEvent
    public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (!event.getModID().equals(DarknessMod.MODID)) {
            return;
        }
        ConfigManager.sync(DarknessMod.MODID, Config.Type.INSTANCE);
    }
}
