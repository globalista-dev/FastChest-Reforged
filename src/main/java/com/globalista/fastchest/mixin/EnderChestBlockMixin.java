package com.globalista.fastchest.mixin;

import com.globalista.fastchest.Config;
import net.minecraft.world.level.block.EnderChestBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EnderChestBlock.class)
public class EnderChestBlockMixin {

    @Inject(method = "getRenderShape", at = @At("HEAD"), cancellable = true)
    private void fastchest_getRenderShape(BlockState state, CallbackInfoReturnable<RenderShape> cir) {

        if(Config.simplifiedChest){
            cir.setReturnValue(RenderShape.MODEL);
        }

    }

}
