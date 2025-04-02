package net.daruukgames.hehesewage.item.custom;

/*
These are the imports:
        |
 */

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class HeheSewageItem extends Item {

    private static final int EFFECT_CHANCE_PERCENT = 75; // Increased that to 75%.
    private static final double PUSH_STRENGTH = 0.75;
    private static final int EFFECT_DURATION = 200;
    private static final int EFFECT_STRENGTH = 0;
    private static final int RANDOM_BOUND = 100;

    public HeheSewageItem(Properties properties) {
        super(properties);
    }


    @Override
    /*
     * This thing makes it, so when you drink the thing, it gives you poison AND pushes you.
     */
    public ItemStack finishUsingItem(ItemStack stack, Level level,  LivingEntity livingEntity) {
        /*
         * Reminder: THIS IS ONLY SERVER-SIDE! THIS WORKS WITH MULTIPLAYER SERVERS!
         */
        ItemStack resultingStack = super.finishUsingItem(stack, level, livingEntity);

        if (!level.isClientSide) {
            if (level.random.nextInt(RANDOM_BOUND) < EFFECT_CHANCE_PERCENT) {
                /*
                 * Reminder: THIS IS ONLY SERVER-SIDE! WORKS WITH MULTIPLAYER SERVERS!
                 */
                /*
                 * This thing makes it, so when you drink the thing, it gives you poison AND pushes you.
                 * How cool is it?
                 */
                if (livingEntity instanceof Player) {
                    // Apply some kind of poison effect
                    livingEntity.addEffect(new MobEffectInstance(MobEffects.POISON, EFFECT_DURATION, EFFECT_STRENGTH));
                    // Then, push the player with force of 0.75
                    Vec3 lookDirection = livingEntity.getLookAngle();
                    Vec3 pushVec = lookDirection.scale(PUSH_STRENGTH);
                    livingEntity.setDeltaMovement(livingEntity.getDeltaMovement().add(pushVec));
                    livingEntity.hurtMarked = true;
                }
            }
        }
        return resultingStack;
    }
}
