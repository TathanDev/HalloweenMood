package fr.tathan.halloween_mood.events;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import fr.tathan.halloween_mood.HalloweenMood;
import fr.tathan.halloween_mood.commands.HalloweenRemoveDifficultyCommand;
import fr.tathan.halloween_mood.commands.HalloweenSetDifficultyCommand;
import fr.tathan.halloween_mood.configs.CommonConfig;
import fr.tathan.halloween_mood.difficulty.LevelDifficulty;
import fr.tathan.halloween_mood.difficulty.LevelDifficultyProvider;
import fr.tathan.halloween_mood.registries.ItemsRegistry;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.command.ConfigCommand;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static net.minecraft.world.entity.npc.VillagerProfession.*;

@Mod.EventBusSubscriber(modid = HalloweenMood.MODID)
public class Events {


    @SubscribeEvent
    public static void onPlayerJoinWorld(EntityJoinLevelEvent event) {

        Entity entity = event.getEntity();
        Level level = event.getLevel();

        ItemStack PUMPKIN = new ItemStack(Items.CARVED_PUMPKIN);

        PUMPKIN.enchant(Enchantments.BINDING_CURSE, 1);



        if(level.getCapability(LevelDifficultyProvider.LEVEL_DIFFICULTY).isPresent()) {
            if (!level.isClientSide) {
                if (entity instanceof ServerPlayer player) {
                    if (player.getSlot(103).get().isEmpty() && !player.isCreative()) {
                        player.setItemSlot(EquipmentSlot.HEAD, PUMPKIN);
                    }
                }

            }
        }
    }

    @SubscribeEvent
    public static void TickEvent(TickEvent.PlayerTickEvent event) {


        Player player = event.player;
        Level level = player.getLevel();
        BlockPos pos = player.blockPosition();
        LevelDifficulty difficulty = level.getCapability(LevelDifficultyProvider.LEVEL_DIFFICULTY).orElseThrow(() -> new IllegalStateException("Damn! An Error ?! This is Spooky !!"));


       if (level.getCapability(LevelDifficultyProvider.LEVEL_DIFFICULTY).isPresent()) {
           if (difficulty.isHalloween()) {
                if (level.isNight()) {
                    if (player.getBlockStateOn().isValidSpawn(level, pos, EntityType.ZOMBIE) && !player.isCreative()) {
                        if (player.getBlockStateOn().getLightEmission() <= 2) {

                            player.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 50, 1));
                        }
                    }
                }
            }

        }

    }


    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if(event.getType() == VillagerProfession.SHEPHERD || event.getType() == VillagerProfession.ARMORER || event.getType() == VillagerProfession.BUTCHER || event.getType() == VillagerProfession.BUTCHER || event.getType() == VillagerProfession.CARTOGRAPHER || event.getType() == VillagerProfession.CLERIC || event.getType() == VillagerProfession.FARMER || event.getType() == VillagerProfession.FISHERMAN || event.getType() == VillagerProfession.FLETCHER || event.getType() == VillagerProfession.LEATHERWORKER || event.getType() == VillagerProfession.LIBRARIAN || event.getType() == VillagerProfession.MASON || event.getType() == VillagerProfession.NITWIT || event.getType() == VillagerProfession.TOOLSMITH || event.getType() == VillagerProfession.WEAPONSMITH) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack HEALTH_CANDY = new ItemStack(ItemsRegistry.HEALTH_CANDY.get(), 1);
            ItemStack SPEED_CANDY = new ItemStack(ItemsRegistry.SPEED_CANDY.get(), 1);
            ItemStack FIRE_CANDY = new ItemStack(ItemsRegistry.FIRE_RESISTANCE_CANDY.get(), 1);

            int villagerLevel = 1;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.PUMPKIN, 2),
                    HEALTH_CANDY,10,2,0.02F));

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.PUMPKIN, 2),
                    SPEED_CANDY,10,2,0.02F));

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.PUMPKIN, 2),
                    SPEED_CANDY,10,2,0.02F));



        }
    }


    @SubscribeEvent
    public static void onAttachCapabilitiesLevel(AttachCapabilitiesEvent<Level> event) {
        if (!event.getObject().getCapability(LevelDifficultyProvider.LEVEL_DIFFICULTY).isPresent()) {
            event.addCapability(new ResourceLocation(HalloweenMood.MODID, "level_difficulty"), new LevelDifficultyProvider());
        }

    }
    @SubscribeEvent
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event){
        event.register(LevelDifficulty.class);
    }

    @SubscribeEvent
    public static void onCommandsRegister(RegisterCommandsEvent event) {
        new HalloweenRemoveDifficultyCommand(event.getDispatcher());
        new HalloweenSetDifficultyCommand(event.getDispatcher());

        ConfigCommand.register(event.getDispatcher());

    }




    public static Component tl(String text) {
        return Component.translatable("message." + HalloweenMood.MODID + text);
    }


}
