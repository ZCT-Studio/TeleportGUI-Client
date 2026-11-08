# TeleportGUI-Client

Client-only key bindings for the commands provided by TeleportGUI on the server. Fabric requires Fabric API; NeoForge has no additional mod dependencies. The server must provide those commands.

| Action | Default key | Command |
| --- | --- | --- |
| TPA | `\` | `/gtpa` |
| TPA requests | `;` | `/gtpa req` |
| Home | Home | `/ghome` |
| Warp | Unbound | `/gwarp` |
| Back | Unbound | `/back` |
| Death location | Unbound | `/tpdeathpoint` |

The keys can be changed in Minecraft's controls settings. This project retains the original package and key translation names; do not install it alongside a TeleportGUI version that already contains the same client classes.

Build both versions with `./gradlew :26.3-fabric:build :26.3-neoforge:build`. Minecraft 26.3 and Java 25 are required.