package artifacts.mixins.item.drinkinghat;

import artifacts.common.item.DrinkingHatItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.UseAction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import top.theillusivec4.curios.api.CuriosApi;

@Mixin(LivingEntity.class)
public abstract class MixinLivingEntity {

	@Shadow protected int itemUseTimeLeft;

	@Inject(method = "setCurrentHand", cancellable = true, at = @At(value = "INVOKE_ASSIGN", shift = At.Shift.AFTER, target = "Lnet/minecraft/item/ItemStack;getMaxUseTime()I"))
	private void decreaseDrinkingDuration(Hand hand, CallbackInfo info) {
		CuriosApi.getCuriosHelper().findEquippedCurio(stack -> stack.getItem() instanceof DrinkingHatItem, (LivingEntity)(Object) this).ifPresent(curio -> {
			if (((LivingEntity)(Object) this).getActiveItem().getUseAction() == UseAction.DRINK) {
				this.itemUseTimeLeft /= 4;
			}
		});
	}
}