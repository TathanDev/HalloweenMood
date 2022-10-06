package fr.tathan.halloween_mood.difficulty;

import net.minecraft.nbt.CompoundTag;

public class LevelDifficulty {

    private boolean isHalloween = false;

    public boolean isHalloween() {
        return isHalloween;
    }

    public void setHalloween() {
        this.isHalloween = true;
    }

    /** Don't mind the name of the variable, it's just for fun */

    public void removeHalloween() {
        this.isHalloween = false;
    }

    public void copy(LevelDifficulty levelDifficulty) {
        this.isHalloween = levelDifficulty.isHalloween;
    }

    public void saveNBTData(CompoundTag nbt) {
        nbt.putBoolean("isHalloween", isHalloween);
    }

    public void loadNBTData(CompoundTag nbt) {
        this.isHalloween = nbt.getBoolean("isHalloween");
    }


}
