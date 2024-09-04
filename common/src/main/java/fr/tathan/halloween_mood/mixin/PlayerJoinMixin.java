package fr.tathan.halloween_mood.mixin;

import fr.tathan.halloween_mood.common.config.CustomConfig;
import fr.tathan.halloween_mood.common.registries.GameruleRegistry;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.Connection;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.CommonListenerCookie;
import net.minecraft.server.players.PlayerList;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Optional;

@Mixin(PlayerList.class)
public class PlayerJoinMixin {

    @Inject(method = "placeNewPlayer", at = @At("RETURN"))
    private void placeNewPlayer(Connection pConnection, ServerPlayer pPlayer, CommonListenerCookie pCookie, CallbackInfo ci) {
        Level level = pPlayer.level();
        ItemStack PUMPKIN = new ItemStack(Items.CARVED_PUMPKIN);
        Optional<Holder.Reference<Enchantment>> enchantmentHolder = level.holderLookup(Registries.ENCHANTMENT).get(ResourceKey.create(Registries.ENCHANTMENT, Enchantments.BINDING_CURSE.registry()));

        enchantmentHolder.ifPresent(enchantmentReference -> PUMPKIN.enchant(enchantmentReference, 1));

        if(level.getGameRules().getBoolean(GameruleRegistry.HALLOWEEN_GAMERULE)) {

            if (level.isClientSide) return;

            if (pPlayer.getItemBySlot(EquipmentSlot.HEAD).isEmpty() && !pPlayer.isCreative()) {

                if((boolean) CustomConfig.getValue("pumpkinOnHead")) {
                    pPlayer.setItemSlot(EquipmentSlot.HEAD, PUMPKIN);
                }
            }
        }

    }

}
