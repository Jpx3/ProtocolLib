/*
 *  ProtocolLib - Bukkit server library that allows access to the Minecraft protocol.
 *  Copyright (C) 2012 Kristian S. Stangeland
 *
 *  This program is free software; you can redistribute it and/or modify it under the terms of the
 *  GNU General Public License as published by the Free Software Foundation; either version 2 of
 *  the License, or (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 *  without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *  See the GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License along with this program;
 *  if not, write to the Free Software Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA
 *  02111-1307 USA
 */

package com.comphenix.protocol.wrappers.nbt;

import com.comphenix.protocol.BukkitInitialization;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NbtCompoundTest {

    @BeforeAll
    public static void initializeBukkit() {
        BukkitInitialization.initializeAll();
    }

    @Test
    public void testCustomTags() {
        NbtCustomTag<Integer> test = new NbtCustomTag<Integer>("hello", 12);

        WrappedCompound map = WrappedCompound.fromName("test");
        map.put(test);

        // Note that the custom tag will be cloned
        assertEquals(12, map.getInteger("hello"));
    }

    /**
     * Represents a custom NBT tag.
     *
     * @param <TValue> - the value of the tag.
     * @author Kristian
     */
    public static class NbtCustomTag<TValue> implements NbtBase<TValue> {

        private String name;
        private TValue value;
        private final NbtType type;

        public NbtCustomTag(String name, TValue value) {
            if (value == null) {
                throw new IllegalArgumentException("Cannot create a custom tag from NULL.");
            }
            this.value = value;
            this.name = name;
            this.type = NbtType.getTypeFromClass(value.getClass());

        }

        @Override
        public NbtType getType() {
            return this.type;
        }

        @Override
        public String getName() {
            return this.name;
        }

        @Override
        public void setName(String name) {
            this.name = name;
        }

        @Override
        public TValue getValue() {
            return this.value;
        }

        @Override
        public void setValue(TValue newValue) {
            this.value = newValue;
        }

        @Override
        public NbtBase<TValue> deepClone() {
            return new NbtCustomTag<TValue>(this.name, this.value);
        }

        @Override
        public boolean accept(NbtVisitor visitor) {
            return visitor.visit(this);
        }
    }
}
