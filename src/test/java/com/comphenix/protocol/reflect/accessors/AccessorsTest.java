package com.comphenix.protocol.reflect.accessors;

import java.lang.reflect.Field;

import com.comphenix.protocol.reflect.ExactReflection;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AccessorsTest {

    @Test
    void testField() {
        Player player = new Player(123, "ABC");

        Field id = assertDoesNotThrow(() -> ExactReflection.fromClass(Player.class, true).getField("id"));
        Field name = assertDoesNotThrow(() -> ExactReflection.fromClass(Player.class, true).getField("name"));

        assertDoesNotThrow(() -> Accessors.getFieldAccessor(id).set(player, 15));
        assertDoesNotThrow(() -> Accessors.getFieldAccessor(name).set(player, "MODIFIED"));

        assertEquals(15, player.getId());
        assertEquals("MODIFIED", player.getName());
    }

    @Test
    void testMethod() {
        Player player = new Player(123, "ABC");

        assertDoesNotThrow(() -> Accessors.getMethodAccessor(player.getClass(), "setId", int.class).invoke(player, 0));
        assertEquals(0, player.getId());
    }

    @Test
    void testConstructor() {
        Player player = (Player) assertDoesNotThrow(() -> Accessors
                .getConstructorAccessor(Player.class, int.class, String.class)
                .invoke(12, "hi"));
        assertEquals(12, player.getId());
        assertEquals("hi", player.getName());
    }

    // --- Some classes we can use for testing ---
    private static class Entity {

        private int id;

        public Entity(int id) {
            this.id = id;
        }

        public int getId() {
            return this.id;
        }

        @SuppressWarnings("unused")
        private void setId(int value) {
            this.id = value;
        }
    }

    private static class Player extends Entity {

        private final String name;

        public Player(int id, String name) {
            super(id);
            this.name = name;
        }

        public String getName() {
            return this.name;
        }
    }
}
