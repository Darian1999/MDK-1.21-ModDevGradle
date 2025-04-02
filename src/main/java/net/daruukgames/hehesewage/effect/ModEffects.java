package net.daruukgames.hehesewage.effect;

import net.daruukgames.hehesewage.HeheSewageMod;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

    /*
    Register all the custom effects that are added.
    there is only 1 effect for now.
    the effect is called "floating", and it makes the player have no gravity until the effect runs out.
     */

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, HeheSewageMod.MOD_ID);

    public static final Holder<MobEffect> FLOATING_EFFECT = MOB_EFFECTS.register("floating", () -> new FloatingEffect(MobEffectCategory.NEUTRAL, 0x808080).addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath(HeheSewageMod.MOD_ID, "floating"), 0.25f, AttributeModifier.Operation.ADD_VALUE));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }

}
