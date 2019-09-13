package com.mcemoji;

import com.vdurmont.emoji.EmojiParser;

import java.util.List;

public class EmojiManager {

    /**
     * Detects if the text is an emoji
     * @param text
     * @return True if the text is an emoji
     */
    public boolean isEmoji(String text) {
        return !EmojiParser.extractEmojis(text).isEmpty();
    }

    /**
     * Returns the Unicode hex representation of the emoji
     * @param text
     * @return The hex value of the emoji
     */
    public String getUnicodeHex(String text) {
        if (!isEmoji(text)) {
            return null;
        }
        String htmlHexadecimal = EmojiParser.parseToHtmlHexadecimal(text);
        if (htmlHexadecimal != null && htmlHexadecimal != "") {
            return htmlHexadecimal.substring(3, htmlHexadecimal.indexOf(';'));
        }
        return null;
    }

    /**
     * Finds and extracts all emojis in the given text
     * @param text
     * @return Emoji list
     */
    public List<String> getEmojis(String text) {
        return EmojiParser.extractEmojis(text);
    }
}
