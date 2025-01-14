package com.comphenix.protocol.reflect.instances;

import java.util.UUID;

import com.comphenix.protocol.BukkitInitialization;
import com.comphenix.protocol.PacketType;

import net.minecraft.core.NonNullList;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MinecraftGeneratorTest {

    @BeforeAll
    public static void beforeClass() {
        BukkitInitialization.initializeAll();
    }

    @Test
    public void testInstantiation() {
        assertNotNull(MinecraftGenerator.INSTANCE.create(UUID.class));
        assertNotNull(MinecraftGenerator.INSTANCE.create(PacketType.Protocol.class));
        assertNotNull(MinecraftGenerator.INSTANCE.create(ItemStack.class));
        assertNotNull(MinecraftGenerator.INSTANCE.create(EntityType.class));
        assertNotNull(MinecraftGenerator.INSTANCE.create(Int2ObjectMap.class));
        assertNotNull(MinecraftGenerator.INSTANCE.create(Int2ObjectOpenHashMap.class));
        assertNotNull(MinecraftGenerator.INSTANCE.create(NonNullList.class));   
    }
}
