package com.teampotato.whoisthepotato;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod(WhoIsThePotato.MOD_ID)
public class WhoIsThePotato {
    public static final String MOD_ID = "whoisthepotato";

    public WhoIsThePotato() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, CONFIG);
    }

    private static final ForgeConfigSpec CONFIG;
    public static final ForgeConfigSpec.BooleanValue SHOW_NAME_IN_GUI;

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
        builder.push("WhoIsThePotato");
        SHOW_NAME_IN_GUI = builder.define("ShowNameInGui", true);
        builder.pop();
        CONFIG = builder.build();
    }
}
