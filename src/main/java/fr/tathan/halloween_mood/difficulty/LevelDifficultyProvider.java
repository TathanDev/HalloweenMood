package fr.tathan.halloween_mood.difficulty;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LevelDifficultyProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {

    public static final Capability<LevelDifficulty> LEVEL_DIFFICULTY = CapabilityManager.get(new CapabilityToken<LevelDifficulty>() {

    });

    private LevelDifficulty levelDifficulty = null;
    private final LazyOptional<LevelDifficulty> optional = LazyOptional.of(this::createLevelDifficulty);

    private LevelDifficulty createLevelDifficulty() {
        if (levelDifficulty == null) {
            levelDifficulty = new LevelDifficulty();
        }
        return this.levelDifficulty;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(cap == LEVEL_DIFFICULTY) {
            return optional.cast();
        }

        return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        createLevelDifficulty().saveNBTData(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        createLevelDifficulty().loadNBTData(nbt);

    }
}
