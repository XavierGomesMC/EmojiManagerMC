package com.mcemoji;

import com.vdurmont.emoji.EmojiParser;

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

}
