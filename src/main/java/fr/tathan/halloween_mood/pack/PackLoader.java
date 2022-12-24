package fr.tathan.halloween_mood.pack;

/**
import fr.tathan.halloween_mood.HalloweenMood;
import net.minecraft.SharedConstants;
import net.minecraft.client.Minecraft;
import net.minecraft.client.Options;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackResources;
import net.minecraft.server.packs.metadata.pack.PackMetadataSection;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.server.packs.repository.RepositorySource;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.forgespi.locating.IModFile;
import net.minecraftforge.resource.PathPackResources;

import java.util.function.Consumer;

public class PackLoader implements RepositorySource {

    public static final String PACK_ID = HalloweenMood.MODID + ".extra";
    
    // An empty required resource pack invisible to the user. USed to determine whether the
    // extra pack has to be enabled (on the first run)
    public static final String DISABLED_PACK_ID_MARKER = HalloweenMood.MODID + ".extra_marker";
    
    private final PackResources resources;

    public PackLoader(IModFile modFile) {
        this.resources = new PathPackResources("Halloween Mood Extra", true, modFile.findResource("extra"));
    }

    @Override
    public void loadPacks(Consumer<Pack> packConsumer, Pack factory) {
        Pack pack = Pack.create(PACK_ID, false, resources,Component.literal("Halloween Mood"), factory, Pack.Position.TOP, PackSource.BUILT_IN);
        packConsumer.accept(pack);
        
        Pack marker = factory.create(DISABLED_PACK_ID_MARKER, Component.literal("Halloween Mood Marker"), true, EmptyPackResources::new, new PackMetadataSection(Component.empty(), SharedConstants.RESOURCE_PACK_FORMAT), Pack.Position.BOTTOM, PackSource.BUILT_IN, true);
        packConsumer.accept(marker);
    }
    
    public static void loadOnInitialStartup() {
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
            Options options = Minecraft.getInstance().options;
            if (!options.resourcePacks.contains(DISABLED_PACK_ID_MARKER) && !options.incompatibleResourcePacks.contains(DISABLED_PACK_ID_MARKER)) {
                options.resourcePacks.add(PACK_ID);
            }
        });
    }

    @Override
    public void loadPacks(Consumer<Pack> pOnLoad) {
        loadPacks(pOnLoad, Pack.));
    }
}
*/