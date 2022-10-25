# Halloween Mood

[![CurseForge](http://cf.way2muchnoise.eu/full_687184_downloads.svg)](https://www.curseforge.com/minecraft/mc-mods/halloween_mood)


## Description
This mod adds a Halloween/Autumn mood to Minecraft !

You can trade pumpkins for candy from the villagers, but there are not "regular candies...
You can also find some stuctures around the world and see well-decorated villagers' houses !

If you are brave enough, you can turn the Halloween difficulty !
When it's activate, you will be afraid at night and have a pumkin in your head.


## Implementation
Want to implement Halloween Mood in your own mod? You can do it by adding the following to your `build.gradle`:

```gradle
repositories {

     maven { url "https://cursemaven.com" }
     
}


dependencies {
    implementation fg.deobf("curse.maven:687184:VERSIONID") 
}
```
The VERSIONID can be found in the [CurseForge page](https://www.curseforge.com/minecraft/mc-mods/halloween-mood/files) of the mod.
Exemple of integration: [Halloween Mood Integration](https://github.com/TathanDev/HalloweenMood/wiki)