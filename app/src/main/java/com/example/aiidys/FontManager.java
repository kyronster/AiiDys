package com.example.aiidys;

public class FontManager {
    private static String selectedFont = "default_font.ttf";

    public static String getSelectedFont() {
        return selectedFont;
    }

    public static void setSelectedFont(String font) {
        selectedFont = font;
    }
}
