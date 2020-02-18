package io.github.yamporg.darkness;

import net.minecraftforge.common.config.Config;

@Config(modid = DarknessMod.MODID)
public class DarknessConfig {
    public static boolean darkOverworld = true;
    public static boolean darkNether = true;
    public static boolean darkEnd = true;
    public static boolean darkDefault = true;
    public static boolean darkSkyless = true;

    public static boolean hardcore = false;
    public static float[] moonPhaseFactors = {};

    public static int[] blacklistByID = {};
    public static String[] blacklistByName = {};
}
