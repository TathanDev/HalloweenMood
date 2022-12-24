package fr.tathan.halloween_mood.items;
/**
import fr.tathan.halloween_mood.HalloweenMood;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.ModList;

public class CandiesBook extends Item {


    public static final Component PATCHOULI_ERROR = tl("patchouli");

    public CandiesBook(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player playerIn, InteractionHand handIn) {
        if (ModList.get().isLoaded("patchouli")) {
            if (level.isClientSide) {
                vazkii.patchouli.api.PatchouliAPI.get().openBookGUI(new ResourceLocation("halloween_mood:candies"));
            }
        } else {
            if (level.isClientSide) {
                playerIn.displayClientMessage(PATCHOULI_ERROR, true);
            }
        }

        return new InteractionResultHolder<>(InteractionResult.SUCCESS, playerIn.getItemInHand(handIn));

    }

    public static Component tl(String text) {
        return Component.translatable("message." + HalloweenMood.MODID + ".error." + text);
    }




}
*/