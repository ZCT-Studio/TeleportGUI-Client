package io.github.zct_studio.teleportgui.client;

import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.Identifier;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.common.NeoForge;

@Mod(value = "teleportgui_client", dist = Dist.CLIENT)
public final class NeoForgeClientEntry {
    public NeoForgeClientEntry(IEventBus modBus) {
        modBus.addListener(this::registerKeys);
        NeoForge.EVENT_BUS.addListener(this::onTick);
    }

    private void registerKeys(RegisterKeyMappingsEvent event) {
        var category = new KeyMapping.Category(Identifier.fromNamespaceAndPath("teleportgui", "shortcuts"));
        event.registerCategory(category);
        ClientMain.register(category, event::register);
    }

    private void onTick(ClientTickEvent.Post event) {
        ClientMain.tick(Minecraft.getInstance());
    }
}