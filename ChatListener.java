package api.mcmeta.banword;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        String originalMessage = event.getMessage();

        if (WordList.containsBadWord(originalMessage)) {
            String filteredMessage = WordList.filterBadWords(originalMessage);
            event.setMessage(filteredMessage);

            player.sendMessage("§c§l[BanWord] §fНе оскорбляй других игроков!");
        }
    }
}