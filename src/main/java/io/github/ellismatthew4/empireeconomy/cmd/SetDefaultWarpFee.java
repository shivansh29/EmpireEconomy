package io.github.ellismatthew4.empireeconomy.cmd;

import io.github.ellismatthew4.empireeconomy.utils.CommandValidationHelper;

public class SetDefaultWarpFee extends PluginCommand {

    public SetDefaultWarpFee() {
        super("setdefaultwarpfee");
    }

    @Override
    public boolean onCommand(SenderContainer senderContainer, CommandCall commandCall) {
        data.defaultWarpFee = commandCall.getArg(0).asInt();
        senderContainer.getPlayer().sendMessage("Default Warp Fee set to " + commandCall.getArg(0).arg);
        return true;
    }

    public boolean validate(SenderContainer senderContainer, CommandCall commandCall) {
        CommandValidationHelper validationHelper = new CommandValidationHelper(this, senderContainer, commandCall);
        return validationHelper.isChallengeInactive(data.challengeActive) && validationHelper.isSenderPlayer() && validationHelper.isValidArgCount(1);
    }
}
