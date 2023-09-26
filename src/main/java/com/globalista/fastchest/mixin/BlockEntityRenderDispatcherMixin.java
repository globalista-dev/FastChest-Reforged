package com.globalista.fastchest.mixin;

import com.globalista.fastchest.Config;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
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
    private <E extends BlockEntity> void fastchest_get(E blockEntity, CallbackInfoReturnable<@Nullable BlockEntityRenderer<E>> cir) {
        Class<?> beClass = blockEntity.getClass();

        if(Config.simplifiedChest){
            if (beClass == ChestBlockEntity.class ||
                    beClass == TrappedChestBlockEntity.class ||
                    beClass == EnderChestBlockEntity.class ||
                    beClass.getSuperclass().getName().equals("io.github.cyberanner.ironchests.blocks.blockentities.GenericChestEntity"))
            { cir.setReturnValue(null);}
        }

    }

}
