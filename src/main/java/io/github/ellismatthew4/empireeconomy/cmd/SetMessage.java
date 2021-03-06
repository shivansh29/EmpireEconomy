package io.github.ellismatthew4.empireeconomy.cmd;

import io.github.ellismatthew4.empireeconomy.utils.CommandValidationHelper;
import io.github.ellismatthew4.empireeconomy.utils.ZoneHandler;
import org.bukkit.entity.Player;

public class SetMessage extends PluginCommand{
    private ZoneHandler zoneHandler;

    public SetMessage() {
        super("setmessage");
        this.zoneHandler = new ZoneHandler();
    }

    @Override
    public boolean onCommand(SenderContainer senderContainer, CommandCall commandCall) {
        Player p = senderContainer.getPlayer();
        int z = zoneHandler.getZone(commandCall.getArg(0).arg);
        if (z != -1 && zoneHandler.getZone(z).owner.equals(p.getDisplayName())) {
            zoneHandler.setZoneMessage(z, commandCall.getArg(1).arg);
            p.sendMessage("§e[SYSTEM] Changed message");
        } else if (z == -1) {
            p.sendMessage("§4[SYSTEM] Zone not found");
        } else {
            p.sendMessage("§4[SYSTEM] You do not own that zone");
        }
        return true;
    }

    @Override
    public boolean validate(SenderContainer senderContainer, CommandCall commandCall) {
        CommandValidationHelper validationHelper = new CommandValidationHelper(this, senderContainer, commandCall);
        return validationHelper.isSenderPlayer() && validationHelper.isValidArgCount(2);
    }
}
