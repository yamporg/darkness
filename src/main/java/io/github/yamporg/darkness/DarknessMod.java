package io.github.yamporg.darkness;

import net.minecraftforge.fml.common.Mod;

@Mod(
        modid = DarknessMod.MOD_ID,
        name = DarknessMod.NAME,
        version = DarknessMod.VERSION,
        guiFactory = DarknessMod.GUI_FACTORY,
        clientSideOnly = true)
public class DarknessMod {
    static final String MOD_ID = "darkness";
    static final String NAME = "Darkness";
    static final String VERSION = "@VERSION@";

    static final String GUI_FACTORY = "io.github.yamporg.darkness.GuiFactory";
}
