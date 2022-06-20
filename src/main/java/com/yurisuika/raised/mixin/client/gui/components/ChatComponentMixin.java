package com.yurisuika.raised.mixin.client.gui.components;

import com.yurisuika.raised.Raised;
import net.minecraft.client.gui.components.ChatComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(value = ChatComponent.class, priority = -1)
public class ChatComponentMixin {

    @ModifyVariable(method = "handleChatQueueClicked", at = @At(value = "HEAD"), ordinal = 1, argsOnly = true)
    private double modifyMouseClick(double value) {
        return value + (double)Raised.getDistance() + (double)Raised.getOffset();
    }

    @ModifyVariable(method = "getClickedComponentStyleAt", at = @At(value = "HEAD"), ordinal = 1, argsOnly = true)
    private double modifyChatTooltip(double value) {
        return value + (double)Raised.getDistance() + (double)Raised.getOffset();
    }

}