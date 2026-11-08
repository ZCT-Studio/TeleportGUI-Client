import gg.meza.stonecraft.mod

plugins { id("gg.meza.stonecraft") }

base { archivesName.set("TeleportGUI-Client-${mod.loader}") }
sourceSets.main { java.srcDir(rootProject.file("src/${mod.loader}/java")) }
repositories { mavenCentral() }



if (mod.isNeoforge) {
    val loom = extensions.getByType<net.fabricmc.loom.api.LoomGradleExtensionAPI>()
    loom.runs.configureEach {
        if (name == "client") mainClass.set("net.neoforged.fml.startup.Client")
    }
}

modSettings {
    variableReplacements = mapOf(
        "id" to "teleportgui_client",
        "license" to "MIT",
        "semver_mc_version_range" to (findProperty("semver_mc_version_range") ?: mod.minecraftVersion),
        "maven_mc_version_range" to (findProperty("maven_mc_version_range") ?: "[${mod.minecraftVersion}]")
    )
}