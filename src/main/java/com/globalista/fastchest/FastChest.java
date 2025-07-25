package com.globalista.fastchest;

import com.globalista.fastchest.config.Config;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod(FastChest.MODID)
public class FastChest
{
    public static final String MODID = "fastchest";
    public FastChest() {ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.SPEC);}

    public static final ResourceLocation RESOURCE_LOCATION = new ResourceLocation("fastchest", "compatible_chests");

    public static final TagKey<BlockEntityType<?>> COMPATIBLE_CHEST_BLOCK_ENTITIES =
            TagKey.create(Registries.BLOCK_ENTITY_TYPE, RESOURCE_LOCATION);

    public static final TagKey<Block> COMPATIBLE_CHEST_BLOCKS =
            TagKey.create(Registries.BLOCK, RESOURCE_LOCATION);

}
