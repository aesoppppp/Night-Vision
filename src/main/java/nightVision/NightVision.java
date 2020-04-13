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
		getServer().getPluginManager().registerEvents(this, this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("§l§f[ §c! §f] 인게임에서만 사용할 수 있습니다.");
				return true;
			}
			effect = Effect.getEffect(Effect.NIGHT_VISION).setVisible(false).setDuration(20 * 60 * 10);
			Player player = (Player) sender;
			player.addEffect(effect);
			player.sendMessage("§l§f[ §6! §f] 야간투시가 부여되었습니다.");
		return true;
	}
}
