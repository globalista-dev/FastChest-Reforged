package com.globalista.fastchest;

import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod(FastChest.MODID)
public class FastChest
{
    public static final String MODID = "fastchest";

    public FastChest()
    {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }
}
