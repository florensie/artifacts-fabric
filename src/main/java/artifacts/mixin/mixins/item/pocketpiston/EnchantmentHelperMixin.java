package artifacts.mixin.mixins.item.pocketpiston;

import artifacts.init.Items;
import artifacts.trinkets.TrinketsHelper;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EnchantmentHelper.class)
public abstract class EnchantmentHelperMixin {

	@Inject(method = "getKnockback", at = @At("RETURN"), cancellable = true)
	private static void increaseKnockback(LivingEntity entity, CallbackInfoReturnable<Integer> info) {
		// Add 1 level of knockback with a minimum of 2
		if (TrinketsHelper.isEquipped(Items.POCKET_PISTON, entity)) {
			info.setReturnValue(Math.max(info.getReturnValueI() + 1, 2));
		}
	}
}
