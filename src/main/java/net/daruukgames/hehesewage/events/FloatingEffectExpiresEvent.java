package net.daruukgames.hehesewage.events;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

/*
        * For some reason, some restrictions forced me to use "Entity" instead of "LivingEntity".
         */

public class FloatingEffectExpiresEvent {
    public static void execute(Entity livingEntity) {
        if (livingEntity == null) // Check if the entity is not null, if it is null, just return.
            return;
        if (livingEntity instanceof Player) // If the entity is a player, then add back the player's gravity.
            livingEntity.setNoGravity(true);
    }
}
