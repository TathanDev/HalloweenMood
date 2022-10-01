package fr.tathan.halloween_mood.events;

import fr.tathan.halloween_mood.HalloweenMood;
import fr.tathan.halloween_mood.configs.CommonConfig;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = HalloweenMood.MODID)
public class Events {


    @SubscribeEvent
    public static void onPlayerJoinWorld(EntityJoinLevelEvent event) {

        Entity entity = event.getEntity();
        Level level = event.getLevel();

        ItemStack PUMPKIN = new ItemStack(Items.CARVED_PUMPKIN);

        PUMPKIN.enchant(Enchantments.BINDING_CURSE, 1);

        if(CommonConfig.PUMPKIN_ON_JOIN.get()) {
        if (!level.isClientSide) {
            if (entity instanceof ServerPlayer player) {

                player.setItemSlot(EquipmentSlot.HEAD, PUMPKIN);;

            }
        }
        }

    }




}
