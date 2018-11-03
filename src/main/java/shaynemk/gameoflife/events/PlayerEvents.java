package shaynemk.gameoflife.events;

import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

@Mod.EventBusSubscriber
public class PlayerEvents {

    @SubscribeEvent()
    public static void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
        event.player.sendMessage(new TextComponentString(ChatFormatting.DARK_RED + "Life. The cruelest game of all..." + ChatFormatting.GREEN + "Welcome to the Game of Life."));
    }
}
