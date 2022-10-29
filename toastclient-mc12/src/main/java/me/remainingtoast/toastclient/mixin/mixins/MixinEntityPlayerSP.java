package me.remainingtoast.toastclient.mixin.mixins;

import me.remainingtoast.toastclient.ToastClient;
import me.remainingtoast.toastclient.api.events.PlayerTickEvent;
import net.minecraft.client.entity.EntityPlayerSP;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityPlayerSP.class)
public class MixinEntityPlayerSP {
    @Inject(method = "onUpdate", at = @At("HEAD"))
    public void preUpdate(CallbackInfo ci) {
        PlayerTickEvent.Pre event = new PlayerTickEvent.Pre();
        ToastClient.eventBus.post(event);
    }

    @Inject(method = "onUpdate", at = @At("TAIL"))
    public void postUpdate(CallbackInfo ci) {
        PlayerTickEvent.Post event = new PlayerTickEvent.Post();
        ToastClient.eventBus.post(event);
    }
}