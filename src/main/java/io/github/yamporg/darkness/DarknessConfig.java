package io.github.yamporg.darkness;

import net.minecraftforge.common.config.Config;

@Config(modid = DarknessMod.MODID, category = "")
public class DarknessConfig {
    public static GeneralCategory general = new GeneralCategory();

    public static class GeneralCategory {
        public boolean enable = true;
        public boolean enableDarkNether = true;
        public boolean enableDarkEnd = true;
        public boolean hardcore = false;
    }

    public static ConstantsCategory constants = new ConstantsCategory();

    public static class ConstantsCategory {
        @Config.RangeDouble(min = 0, max = 1)
        public float minWorldSunBrightness = Math.ulp(0);

        @Config.RangeDouble(min = 0, max = 1)
        public float minBlockSunBrightness = 0.05F;

        @Config.RangeDouble(min = 0, max = 1)
        public float minBlockBrightness = 0;

        public float gammaOverride = -1;
    }
}
