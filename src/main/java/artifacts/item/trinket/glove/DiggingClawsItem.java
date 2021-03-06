package artifacts.item.trinket.glove;

import artifacts.Artifacts;
import artifacts.client.render.model.trinket.ClawsModel;
import artifacts.client.render.model.trinket.GloveModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

public class DiggingClawsItem extends GloveItem {

	public static final float MINING_SPEED_INCREASE = 3.2f;

	private static final Identifier TEXTURE_DEFAULT = Artifacts.id("textures/entity/trinket/digging_claws_default.png");
	private static final Identifier TEXTURE_SLIM = Artifacts.id("textures/entity/trinket/digging_claws_slim.png");

	@Override
	@Environment(EnvType.CLIENT)
	protected GloveModel createModel(boolean smallArms) {
		return new ClawsModel(smallArms);
	}

	@Override
	@Environment(EnvType.CLIENT)
	protected Identifier getTexture() {
		return TEXTURE_DEFAULT;
	}

	@Override
	@Environment(EnvType.CLIENT)
	protected Identifier getSlimTexture() {
		return TEXTURE_SLIM;
	}

	@Override
	protected SoundInfo getEquipSound() {
		return new SoundInfo(SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE);
	}
}
