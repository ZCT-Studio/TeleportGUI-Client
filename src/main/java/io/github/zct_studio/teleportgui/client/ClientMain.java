package io.github.zct_studio.teleportgui.client;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import java.util.function.Consumer;

public final class ClientMain {
    private static KeyMapping[] keys;
    private static final String[] COMMANDS = {"gtpa", "gtpa req", "ghome", "gwarp", "back", "tpdeathpoint"};

    private ClientMain() {}

    public static void register(KeyMapping.Category category, Consumer<KeyMapping> register) {
        keys = new KeyMapping[] {
                key("tpa", InputConstants.KEY_BACKSLASH, category),
                key("tpaRequest", InputConstants.KEY_SEMICOLON, category),
                key("home", InputConstants.KEY_HOME, category),
                key("warp", InputConstants.UNKNOWN.getValue(), category),
                key("back", InputConstants.UNKNOWN.getValue(), category),
                key("deathLocation", InputConstants.UNKNOWN.getValue(), category)
        };
        for (KeyMapping key : keys) register.accept(key);
    }

    private static KeyMapping key(String name, int code, KeyMapping.Category category) {
        return new KeyMapping("key.teleportgui." + name, code, category);
    }

    public static void tick(Minecraft client) {
        if (keys == null) return;
        for (int i = 0; i < keys.length; i++) {
            while (keys[i].consumeClick()) {
                if (client.player != null && client.getConnection() != null) {
                    client.getConnection().sendCommand(COMMANDS[i]);
                }
            }
        }
    }
}