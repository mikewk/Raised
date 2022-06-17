package com.yurisuika.raised.mixin.mods;

import com.yurisuika.raised.Raised;
import me.lizardofoz.inventorio.client.ui.HotbarHUDRenderer;
import net.minecraft.client.MainWindow;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(HotbarHUDRenderer.class)
public class InventorioMixin {

    @Redirect(method = "renderSegmentedHotbar", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/MainWindow;getGuiScaledHeight()I"))
    private int modifyScaledHeightA(MainWindow instance) {
        return instance.getGuiScaledHeight() - Raised.getDistance();
    }

    @Redirect(method = "renderHotbarAddons", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/MainWindow;getGuiScaledHeight()I"))
    private int modifyScaledHeightB(MainWindow instance) {
        return instance.getGuiScaledHeight() - Raised.getDistance();
    }

}