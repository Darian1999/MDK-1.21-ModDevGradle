package net.daruukgames.hehesewage.effect;

import net.daruukgames.hehesewage.HeheSewageMod;
import net.daruukgames.hehesewage.events.FloatingEffectExpiresEvent;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

    /*
    Register all the custom effects that are added.
    there is only 1 effect for now.
    the effect is called "floating", and it makes the player have no gravity until the effect runs out.
     */
@EventBusSubscriber
public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, HeheSewageMod.MOD_ID);
    public static final Holder<MobEffect> FLOATING_EFFECT = MOB_EFFECTS.register("floating", () -> new FloatingEffect(MobEffectCategory.NEUTRAL, 0x808080).addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath(HeheSewageMod.MOD_ID, "floating"), 0.25f, AttributeModifier.Operation.ADD_VALUE));

    @SubscribeEvent
    public static void onEffectRemoved(MobEffectEvent.Remove event) {
        MobEffectInstance effectInstance = event.getEffectInstance();
        if (effectInstance != null) {
            expireEffects(event.getEntity(), effectInstance);
        }
    }

    @SubscribeEvent
    public static void onEffectExpired(MobEffectEvent.Expired event) {
        MobEffectInstance effectInstance = event.getEffectInstance();
        if (effectInstance != null) {
            expireEffects(event.getEntity(), effectInstance);
        }
    }

    private static void expireEffects(Entity entity, MobEffectInstance effectInstance) {
        if (effectInstance.getEffect().value() == (FLOATING_EFFECT)) {
            FloatingEffectExpiresEvent.execute(entity);
        }
    }
    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }

}
