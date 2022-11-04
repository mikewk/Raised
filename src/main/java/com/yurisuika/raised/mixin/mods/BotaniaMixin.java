package com.yurisuika.raised.mixin.mods;

import com.mojang.blaze3d.platform.Window;
import com.yurisuika.raised.Raised;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import vazkii.botania.client.gui.HUDHandler;
import vazkii.botania.common.item.equipment.bauble.ItemFlightTiara;

public class BotaniaMixin {

    @Mixin(HUDHandler.class)
    public static class HUDHandlerMixin {

        @Redirect(method = "renderManaInvBar", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/platform/Window;getGuiScaledHeight()I"))
        private static int modifyRenderManaInvBar(Window instance) {
            return instance.getGuiScaledHeight() - Raised.getDistance();
        }

    }

    @Mixin(ItemFlightTiara.ClientLogic.class)
    public static class ItemFlightTiaraMixin {

        @Redirect(method = "renderHUD", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/platform/Window;getGuiScaledHeight()I"))
        private static int modifyRenderHUD(Window instance) {
            return instance.getGuiScaledHeight() - Raised.getDistance();
        }

    }

}
