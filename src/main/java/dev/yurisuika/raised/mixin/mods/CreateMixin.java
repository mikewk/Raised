package dev.yurisuika.raised.mixin.mods;

import com.simibubi.create.content.equipment.armor.RemainingAirOverlay;
import com.simibubi.create.content.trains.TrainHUD;
import com.simibubi.create.content.equipment.toolbox.ToolboxHandlerClient;
import com.simibubi.create.content.schematics.client.SchematicHotbarSlotOverlay;
import com.simibubi.create.content.schematics.client.ToolSelectionScreen;
import dev.yurisuika.raised.Raised;
import net.minecraft.client.util.Window;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.*;

public class CreateMixin {

    @Pseudo
    @Mixin(RemainingAirOverlay.class)
    public static class RemainingAirOverlayMixin {

        @ModifyVariable(method = "render", at = @At("HEAD"), ordinal = 1, argsOnly = true)
        private static int modifyRender(int value) {
            return value - Raised.getHud();
        }

    }

    @Pseudo
    @Mixin(SchematicHotbarSlotOverlay.class)
    public static class SchematicHotbarSlotOverlayMixin {

        @Redirect(method = "renderOn", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/util/Window;getScaledHeight()I"))
        private int redirectRenderOn(Window instance) {
            return instance.getScaledHeight() - Raised.getHud();
        }

    }

    @Pseudo
    @Mixin(ToolboxHandlerClient.class)
    public static class ToolboxHandlerClientMixin {

        @Redirect(method = "renderOverlay", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/util/Window;getScaledHeight()I"))
        private static int redirectRenderOverlay(Window instance) {
            return instance.getScaledHeight() - Raised.getHud();
        }

    }

    @Pseudo
    @Mixin(ToolSelectionScreen.class)
    public static class ToolSelectionScreenMixin {

        @Redirect(method = "draw", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/util/Window;getScaledHeight()I"))
        private int redirectDraw(Window instance) {
            return instance.getScaledHeight() - Raised.getHud();
        }

    }

    @Pseudo
    @Mixin(TrainHUD.class)
    public static class TrainHUDMixin {

        @Redirect(method = "renderOverlay", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/util/Window;getScaledHeight()I"))
        private static int redirectRenderOverlay(Window instance) {
            return instance.getScaledHeight() - Raised.getHud();
        }

    }

}