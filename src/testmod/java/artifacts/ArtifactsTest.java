package artifacts;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricMaterialBuilder;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ArtifactsTest implements ModInitializer {

	public static final Block LVL2_BLOCK = new Block(FabricBlockSettings.of(new FabricMaterialBuilder(MapColor.OAK_TAN).burnable().build()).requiresTool().breakByTool(FabricToolTags.AXES, 2).strength(3));
	public static final Block LVL3_BLOCK = new Block(FabricBlockSettings.of(new FabricMaterialBuilder(MapColor.OAK_TAN).burnable().build()).requiresTool().breakByTool(FabricToolTags.AXES, 3).strength(3));
	private static final String MOD_ID = "artifacts-testmod";
	public static ToolItem LVL1_PICKAXE = new CustomPickaxeItem(ToolMaterials.STONE, 1, -2.8F, new Item.Settings().group(Artifacts.ITEM_GROUP));

	@Override
	public void onInitialize() {
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "lvl2_block"), LVL2_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "lvl3_block"), LVL3_BLOCK);

		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "lvl2_block"), new BlockItem(LVL2_BLOCK, new Item.Settings().group(Artifacts.ITEM_GROUP)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "lvl3_block"), new BlockItem(LVL3_BLOCK, new Item.Settings().group(Artifacts.ITEM_GROUP)));

		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "lvl1_pickaxe"), LVL1_PICKAXE);
	}

	/**
	 * PickaxeItem has a protected constructor
	 */
	static class CustomPickaxeItem extends PickaxeItem {

		public CustomPickaxeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
			super(material, attackDamage, attackSpeed, settings);
		}
	}
}
