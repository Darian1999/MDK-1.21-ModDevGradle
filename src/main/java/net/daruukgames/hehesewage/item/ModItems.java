package net.daruukgames.hehesewage.item;

import net.daruukgames.hehesewage.HeheSewageMod;
import net.daruukgames.hehesewage.item.custom.HeheSewageItem;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(HeheSewageMod.MOD_ID);

    // Define the food properties for the item
    private static final FoodProperties DEBATE_FOOD_PROPERTIES = new FoodProperties.Builder()
            .nutrition(4) // Amount of hunger restored
            .build();

    private static final FoodProperties HEHE_SEWAGE_FOOD_PROPERTIES = new FoodProperties.Builder()
            .nutrition(5)
            .alwaysEdible() // Fun fact: this makes an item always edible, so you can eat it, EVEN if your hunger bar is full!
            .build();

    public static final DeferredItem<Item> DEBATE = ITEMS.register("debate",
            () -> new Item(new Item.Properties().food(DEBATE_FOOD_PROPERTIES)));

    // Register the custom HeheSewageItem
    public static final DeferredItem<Item> HEHESEWAGE = ITEMS.register("hehe_sewage",
            () -> new HeheSewageItem(new Item.Properties().food(HEHE_SEWAGE_FOOD_PROPERTIES)));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }


}
