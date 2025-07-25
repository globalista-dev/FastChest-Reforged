package com.globalista.fastchest.config;

import com.globalista.fastchest.FastChest;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber(modid = FastChest.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config
{
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    private static final ForgeConfigSpec.BooleanValue SIMPLIFIED_CHEST = BUILDER
            .comment("Turn on fastchest")
            .define("simplifiedChest", true);

    public static final ForgeConfigSpec SPEC = BUILDER.build();

    public static boolean simplifiedChest;


    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        simplifiedChest = SIMPLIFIED_CHEST.get();
    }
}
