package bedrockcombat;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;

public class BedrockCombatMod implements ModInitializer {
    @Override
    public void onInitialize() {
        // Remove attack cooldown for Bedrock-style combat
        AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
            if (!world.isClient && player instanceof PlayerEntity) {
                player.resetLastAttackedTicks();
            }
            return ActionResult.PASS;
        });
    }
}

