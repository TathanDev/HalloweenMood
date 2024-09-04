package fr.tathan.halloween_mood.mixin;

import fr.tathan.halloween_mood.HalloweenMoodCommon;
import fr.tathan.halloween_mood.common.config.CustomConfig;
import fr.tathan.halloween_mood.common.registries.ParticleRegistry;
import fr.tathan.halloween_mood.common.registries.TagsRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ParticleUtils;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CherryLeavesBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(LeavesBlock.class)
public abstract class LeavesBlockMixin extends Block implements SimpleWaterloggedBlock {
    public LeavesBlockMixin(Properties properties) {
        super(properties);
    }

    @Inject(method = "animateTick", at = @At(value = "RETURN"))
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom, CallbackInfo ci) {

        if(pLevel.getBlockState(pPos).is(TagsRegistry.NO_FALLING_LEAVES)) return;

        Random random = new Random();
        int addLeave = random.nextInt(0, 11);

        if(pLevel.getBlockState(pPos.below()).is(BlockTags.AIR) && addLeave == 10) {
            ParticleUtils.spawnParticleBelow(pLevel, pPos, pRandom, ParticleRegistry.FALLING_LEAVES.get());
        }

    }
}
