package com.yurisuika.raised.mixin.client.gui.hud;

import com.yurisuika.raised.Raised;
import net.minecraft.client.gui.hud.ChatHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(value = ChatHud.class, priority = -1)
public class ChatHudMixin {

    @ModifyVariable(method = "mouseClicked", at = @At(value = "HEAD"), ordinal = 1, argsOnly = true)
    private double modifyMouseClick(double value) {
        return value + (double)Raised.getDistance() + (double)Raised.getOffset();
    }

    @ModifyVariable(method = "getText", at = @At(value = "HEAD"), ordinal = 1, argsOnly = true)
    private double modifyChatTooltip(double value) {
        return value + (double)Raised.getDistance() + (double)Raised.getOffset();
    }

}