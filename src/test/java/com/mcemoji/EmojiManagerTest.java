package com.mcemoji;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmojiManagerTest {

    @Test
    void getUnicodeHex() {
        EmojiManager manager = new EmojiManager();
        assertEquals("1f600", manager.getUnicodeHex("\ud83d\ude00"));
        assertEquals("1f5a5", manager.getUnicodeHex("\ud83d\udda5\ufe0f"));
        assertEquals("2328", manager.getUnicodeHex("\u2328\ufe0f"));
        assertEquals(null, manager.getUnicodeHex("123"));
    }

    @Test
    void isEmoji() {
        EmojiManager manager = new EmojiManager();
        assertTrue(manager.isEmoji("\ud83d\ude00"));
        assertTrue(manager.isEmoji("\ud83d\udda5\ufe0f"));
        assertTrue(manager.isEmoji("\u2328\ufe0f"));
        assertFalse(manager.isEmoji("123"));
        assertFalse(manager.isEmoji("\ufffc"));
    }
}
