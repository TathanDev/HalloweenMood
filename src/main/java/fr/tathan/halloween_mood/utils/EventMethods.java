package fr.tathan.halloween_mood.utils;

import fr.tathan.halloween_mood.HalloweenMood;
import fr.tathan.halloween_mood.config.HalloweenConfig;
import fr.tathan.halloween_mood.events.EntityJoinWorldEvent;
import fr.tathan.halloween_mood.events.PlayerTickEvent;
import fr.tathan.halloween_mood.registries.TagsRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

import static fr.tathan.halloween_mood.registries.GameruleRegistry.IS_HALLOWEEN;

public class EventMethods {

    public static void onPlayerJoinWorld(Player player, Level level) {
        ItemStack PUMPKIN = new ItemStack(Items.CARVED_PUMPKIN);
        PUMPKIN.enchant(Enchantments.BINDING_CURSE, 1);
        boolean isHalloween = level.getGameRules().getBoolean(IS_HALLOWEEN);

        if (isHalloween) {
                if (!level.isClientSide) {
                    if (player.getSlot(103).get().isEmpty() && !player.isCreative()) {
                        if(HalloweenMood.CONFIG.pumpkinOnHead) {
                            player.setItemSlot(EquipmentSlot.HEAD, PUMPKIN);
                        }
                    }

                }
            }
    }



    public static void onPlayerTick(Player player) {
        Level level = player.level();
        BlockPos pos = player.blockPosition();
        ItemStack mainHand = player.getMainHandItem();

        ItemStack offHand = player.getOffhandItem();
        boolean isHalloween = level.getGameRules().getBoolean(IS_HALLOWEEN);

        if (isHalloween) {
             if (level.isNight()) {
                 if (!player.isCreative() &&!player.isSpectator())
                     if (player.getBlockStateOn().getLightEmission() <= 2 ) {

                         if(player.level().dimension().equals(Level.END) && !HalloweenMood.CONFIG.halloweenEnd) { return; }
                         if(player.level().dimension().equals(Level.NETHER) && !HalloweenMood.CONFIG.halloweenNether) { return; }
                         if (mainHand.is(TagsRegistry.AGAINST_FEAR)  || offHand.is(TagsRegistry.AGAINST_FEAR)) {
                             return;
                         }
                         player.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 45, 1));}}
         }
    }


    public static void initEvents() {
        EntityJoinWorldEvent.EVENT.register((player, level) -> {
            onPlayerJoinWorld(player, level);
            return InteractionResult.PASS;
        });
        PlayerTickEvent.EVENT.register((player) -> {
            onPlayerTick(player);
            return InteractionResult.PASS;
        });
    }
}
