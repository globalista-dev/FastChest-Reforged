package com.globalista.fastchest.mixin;

import com.globalista.fastchest.FastChest;
import com.globalista.fastchest.config.Config;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.entity.EnderChestBlockEntity;
import net.minecraft.world.level.block.entity.TrappedChestBlockEntity;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockEntityRenderDispatcher.class)
public class BlockEntityRenderDispatcherMixin {

    @Inject(method = "getRenderer", at = @At("HEAD"), cancellable = true)
    private <E extends BlockEntity> void fastchest_getRenderer(E blockEntity, CallbackInfoReturnable<@Nullable BlockEntityRenderer<E>> cir) {
        Class<?> beClass = blockEntity.getClass();

        if(Config.simplifiedChest){

            if(blockEntity instanceof ChestBlockEntity
                    || blockEntity instanceof TrappedChestBlockEntity
                    || blockEntity instanceof EnderChestBlockEntity
                    || blockEntity.getType().builtInRegistryHolder().is(FastChest.COMPATIBLE_CHEST_BLOCK_ENTITIES)) {
                cir.setReturnValue(null);
            }

        }

    }

}
