package nightVision;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.event.Listener;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.potion.Effect;

public class NightVision extends PluginBase implements Listener{
	private Effect effect;
	@Override
	public void onEnable() {
		effect = Effect.getEffect(Effect.NIGHT_VISION).setVisible(false).setDuration(20 * 60 * 10);
		getServer().getPluginManager().registerEvents(this, this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("§l§f[ §c! §f] 인게임에서만 가능합니다.");
				return true;
			}
			Player player = (Player) sender;
			player.addEffect(effect);
		return true;
	}
}
