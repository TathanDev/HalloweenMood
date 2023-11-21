package fr.tathan.halloween_mood.pack;

import fr.tathan.halloween_mood.HalloweenMood;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackResources;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.metadata.MetadataSectionSerializer;
import net.minecraft.server.packs.resources.IoSupplier;
import org.jetbrains.annotations.Nullable;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Set;

public class EmptyPackResources implements PackResources {

    public static final String PACK_ID = HalloweenMood.MODID + ".extra";

    public EmptyPackResources(String s) {
    }

    @Nullable
    @Override
    public IoSupplier<InputStream> getRootResource(String... pElements) {
        return null;
    }

    @Override
    public IoSupplier<InputStream> getResource(PackType pType, ResourceLocation pLocation)  {
        try {
            throw new FileNotFoundException();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void listResources(PackType pPackType, String pNamespace, String pPath, ResourceOutput pResourceOutput) {

    }


    @Override
    public Set<String> getNamespaces(PackType pType) {
        return Collections.emptySet();
    }

    @Nullable
    @Override
    public <T> T getMetadataSection(MetadataSectionSerializer<T> pDeserializer) throws IOException {
        return null;
    }

    @Override
    public String packId() {
        return PACK_ID;
    }

    @Override
    public void close() {
        
    }

}

