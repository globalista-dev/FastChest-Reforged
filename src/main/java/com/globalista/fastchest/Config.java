package com.globalista.fastchest;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Forge's config APIs
@Mod.EventBusSubscriber(modid = FastChest.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config
{
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    private static final ForgeConfigSpec.BooleanValue SIMPLIFIED_CHEST = BUILDER
            .comment("Turn on fastchest")
            .define("simplifiedChest", true);

    static final ForgeConfigSpec SPEC = BUILDER.build();

    public static boolean simplifiedChest;


    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        simplifiedChest = SIMPLIFIED_CHEST.get();
    }
}
