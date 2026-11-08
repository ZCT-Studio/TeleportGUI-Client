package io.github.zct_studio.teleportgui.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.KeyMapping;
import net.minecraft.resources.Identifier;

public final class FabricClientEntry implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        var category = KeyMapping.Category.register(Identifier.fromNamespaceAndPath("teleportgui", "shortcuts"));
        ClientMain.register(category, KeyMappingHelper::registerKeyMapping);
        ClientTickEvents.END_CLIENT_TICK.register(ClientMain::tick);
    }
}