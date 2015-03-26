package cofh.thermalexpansion.item;

import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class TEAugments {

	private TEAugments() {

	}

	public static void preInit() {

		itemAugment = (ItemAugment) new ItemAugment().setUnlocalizedName("augment");
	}

	public static void initialize() {

		generalAutoTransfer = itemAugment.addItem(0, GENERAL_AUTO_TRANSFER);
		generalReconfigSides = itemAugment.addItem(16, GENERAL_RECONFIG_SIDES);
		generalRedstoneControl = itemAugment.addItem(32, GENERAL_REDSTONE_CONTROL);

		itemAugment.addAugmentData(0, GENERAL_AUTO_TRANSFER, 1);
		itemAugment.addAugmentData(16, GENERAL_RECONFIG_SIDES, 1);
		itemAugment.addAugmentData(32, GENERAL_REDSTONE_CONTROL, 1);

		dynamoCoilDuct = itemAugment.addItem(48, DYNAMO_COIL_DUCT);
		itemAugment.addAugmentData(48, DYNAMO_COIL_DUCT, 1);

		dynamoThrottle = itemAugment.addItem(49, DYNAMO_THROTTLE);
		itemAugment.addAugmentData(49, DYNAMO_THROTTLE, 2);

		for (int i = 0; i < NUM_DYNAMO_EFFICIENCY; i++) {
			dynamoEfficiency[i] = itemAugment.addItem(64 + i, DYNAMO_EFFICIENCY + i);
			itemAugment.addAugmentData(64 + i, DYNAMO_EFFICIENCY, 1 + i);
		}
		for (int i = 0; i < NUM_DYNAMO_OUTPUT; i++) {
			dynamoOutput[i] = itemAugment.addItem(80 + i, DYNAMO_OUTPUT + i);
			itemAugment.addAugmentData(80 + i, DYNAMO_OUTPUT, 1 + i);
		}

		for (int i = 0; i < NUM_MACHINE_SECONDARY; i++) {
			machineSecondary[i] = itemAugment.addItem(112 + i, MACHINE_SECONDARY + i);
			itemAugment.addAugmentData(112 + i, MACHINE_SECONDARY, 1 + i);
		}
		for (int i = 0; i < NUM_MACHINE_SPEED; i++) {
			machineSpeed[i] = itemAugment.addItem(128 + i, MACHINE_SPEED + i);
			itemAugment.addAugmentData(128 + i, MACHINE_SPEED, 1 + i);
		}

		machineFurnaceFood = itemAugment.addItem(256, MACHINE_FURNACE_FOOD);
		itemAugment.addAugmentData(256, MACHINE_FURNACE_FOOD, 1);

		for (int i = 0; i < NUM_MACHINE_EXTRUDER; i++) {
			machineExtruderBoost[i] = itemAugment.addItem(312 + i, MACHINE_EXTRUDER_BOOST + i);
			itemAugment.addAugmentData(312 + i, MACHINE_EXTRUDER_BOOST, 1 + i);
		}
	}

	public static void postInit() {

		/* GENERAL */
		GameRegistry.addRecipe(new ShapedOreRecipe(generalAutoTransfer, new Object[] { " I ", "IXI", " I ", 'I', "nuggetTin", 'X', TEItems.pneumaticServo }));
		GameRegistry.addRecipe(new ShapedOreRecipe(generalReconfigSides, new Object[] { " I ", "IXI", " I ", 'I', "nuggetTin", 'X', "ingotGold" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(generalRedstoneControl, new Object[] { " I ", "IXI", " I ", 'I', "nuggetTin", 'X', "dustRedstone" }));

		/* DYNAMO */
		GameRegistry.addRecipe(new ShapedOreRecipe(dynamoCoilDuct, new Object[] { " I ", "IXI", " I ", 'I', "nuggetLead", 'X', "ingotCopper" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(dynamoThrottle, new Object[] { " I ", "IXI", "YIY", 'I', "nuggetLead", 'X', "ingotElectrum", 'Y',
				"dustRedstone" }));

		GameRegistry.addRecipe(new ShapedOreRecipe(dynamoEfficiency[0], new Object[] { " N ", "NXN", "YNY", 'N', "ingotLead", 'X', TEItems.powerCoilSilver,
				'Y', "ingotTin", 'Y', "dustRedstone" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(dynamoEfficiency[1], new Object[] { " I ", "NXN", "YIY", 'N', "ingotLead", 'I', "ingotElectrum", 'X',
				TEItems.powerCoilSilver, 'Y', "dustGlowstone" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(dynamoEfficiency[2], new Object[] { " I ", "IXI", "YIY", 'I', "ingotElectrum", 'X', TEItems.powerCoilSilver,
				'Y', "dustCryotheum" }));

		GameRegistry.addRecipe(new ShapedOreRecipe(dynamoOutput[0], new Object[] { " N ", "NXN", "YNY", 'N', "ingotCopper", 'X', TEItems.powerCoilSilver, 'Y',
				"dustRedstone" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(dynamoOutput[1], new Object[] { " I ", "NXN", "YIY", 'N', "ingotCopper", 'I', "ingotSilver", 'X',
				TEItems.powerCoilSilver, 'Y', "dustGlowstone" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(dynamoOutput[2], new Object[] { " I ", "IXI", "YIY", 'I', "ingotSilver", 'X', TEItems.powerCoilSilver, 'Y',
				"dustCryotheum" }));

		/* ENDER */

		/* ENERGY */

		/* MACHINE */
		GameRegistry.addRecipe(new ShapedOreRecipe(machineSecondary[0], new Object[] { " N ", "NXN", "YNY", 'N', "ingotBronze", 'X', "blockCloth", 'Y',
				"blockCloth" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(machineSecondary[1], new Object[] { " I ", "NXN", "YIY", 'N', "ingotBronze", 'I', "blockGlassHardened", 'X',
				"blockClothRock", 'Y', "dustGlowstone" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(machineSecondary[2], new Object[] { " I ", "IXI", "YIY", 'I', "blockGlassHardened", 'X',
				TEItems.pneumaticServo, 'Y', "dustCryotheum" }));

		GameRegistry.addRecipe(new ShapedOreRecipe(machineSpeed[0], new Object[] { " N ", "NXN", "YNY", 'N', "ingotBronze", 'X', TEItems.powerCoilGold, 'Y',
				"dustRedstone" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(machineSpeed[1], new Object[] { " I ", "NXN", "YIY", 'N', "ingotBronze", 'I', "ingotGold", 'X',
				TEItems.powerCoilGold, 'Y', "dustPyrotheum" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(machineSpeed[2], new Object[] { " I ", "IXI", "YIY", 'I', "ingotGold", 'X', TEItems.powerCoilGold, 'Y',
				Items.ender_pearl }));

		/* MACHINE SPECIFIC */
		GameRegistry.addRecipe(new ShapedOreRecipe(machineFurnaceFood, new Object[] { " I ", "NXN", "YIY", 'N', "dustRedstone", 'I', "ingotSilver", 'X',
				TEItems.powerCoilGold, 'Y', Blocks.brick_block }));

		GameRegistry.addRecipe(new ShapedOreRecipe(machineExtruderBoost[0], new Object[] { " N ", "NXN", "YNY", 'N', "ingotBronze", 'X',
				TEItems.pneumaticServo, 'Y', Blocks.cobblestone }));
		GameRegistry.addRecipe(new ShapedOreRecipe(machineExtruderBoost[1], new Object[] { " I ", "NXN", "YIY", 'N', "ingotBronze", 'I', "ingotGold", 'X',
				TEItems.pneumaticServo, 'Y', Blocks.stone }));
		GameRegistry.addRecipe(new ShapedOreRecipe(machineExtruderBoost[2], new Object[] { " I ", "IXI", "YIY", 'I', "ingotGold", 'X', TEItems.pneumaticServo,
				'Y', Blocks.obsidian }));
	}

	public static byte NUM_DYNAMO_EFFICIENCY = 3;
	public static byte NUM_DYNAMO_OUTPUT = 3;

	public static byte NUM_ENERGY_STORAGE = 3;

	public static byte NUM_MACHINE_SECONDARY = 3;
	public static byte NUM_MACHINE_SPEED = 3;

	public static byte NUM_MACHINE_EXTRUDER = 3;

	public static final int[] DYNAMO_EFFICIENCY_MOD = { 0, 100, 250, 500 };
	public static final int[] DYNAMO_EFFICIENCY_MOD_SUM = { 0, 100, 350, 850 };
	public static final int[] DYNAMO_OUTPUT_MOD = { 1, 2, 4, 8 };
	public static final int[] DYNAMO_OUTPUT_EFFICIENCY_MOD = { 0, 150, 100, 50 };
	public static final int[] DYNAMO_OUTPUT_EFFICIENCY_SUM = { 0, 150, 250, 300 };

	public static final int[] ENERGY_STORAGE_MOD = { 1, 2, 4, 8 };

	public static final int[] MACHINE_SPEED_PROCESS_MOD = { 1, 2, 4, 8 };
	public static final int[] MACHINE_SPEED_ENERGY_MOD = { 1, 3, 8, 20 };
	public static final int[] MACHINE_SPEED_ENERGY_MOD_TOOLTIP = { 1, 50, 100, 150 };
	// public static final int[] MACHINE_SPEED_SECONDARY_MOD = { 0, 5, 10, 15 }; TODO: May bring this back; not sure.
	// public static final int[] MACHINE_SPEED_SECONDARY_MOD_TOOLTIP = { 0, 5, 15, 25 };
	public static final int[] MACHINE_SECONDARY_MOD = { 0, 10, 15, 20 };
	public static final int[] MACHINE_SECONDARY_MOD_TOOLTIP = { 0, 11, 33, 81 };

	public static final int[][] MACHINE_EXTRUDER_PROCESS_MOD = { { 1, 16, 32, 64 }, { 1, 8, 16, 32 }, { 1, 4, 8, 16 } };
	public static final int[] MACHINE_EXTRUDER_WATER_MOD = { 1000, 500, 250, 125 };

	public static ItemAugment itemAugment;

	public static ItemStack dynamoCoilDuct;
	public static ItemStack[] dynamoEfficiency = new ItemStack[NUM_DYNAMO_EFFICIENCY];
	public static ItemStack[] dynamoOutput = new ItemStack[NUM_DYNAMO_OUTPUT];
	public static ItemStack dynamoThrottle;

	public static ItemStack enderEnergy;
	public static ItemStack enderFluid;
	public static ItemStack enderItem;

	public static ItemStack generalAutoTransfer;
	public static ItemStack generalAutoInput;
	public static ItemStack generalReconfigSides;
	public static ItemStack generalRedstoneControl;

	public static ItemStack[] machineSecondary = new ItemStack[NUM_MACHINE_SECONDARY];
	public static ItemStack[] machineSpeed = new ItemStack[NUM_MACHINE_SPEED];

	public static ItemStack machineFurnaceFood;
	public static ItemStack[] machineExtruderBoost = new ItemStack[NUM_MACHINE_EXTRUDER];

	/* Augment Helpers */
	public static String DYNAMO_COIL_DUCT = "dynamoCoilDuct";
	public static String DYNAMO_EFFICIENCY = "dynamoEfficiency";
	public static String DYNAMO_OUTPUT = "dynamoOutput";
	public static String DYNAMO_THROTTLE = "dynamoThrottle";

	public static String ENDER_ENERGY = "enderEnergy";
	public static String ENDER_FLUID = "enderFluid";
	public static String ENDER_ITEM = "enderItem";

	public static String ENERGY_STORAGE = "energyStorage";

	public static String GENERAL_AUTO_TRANSFER = "generalAutoTransfer";
	public static String GENERAL_AUTO_INPUT = "generalAutoInput";
	public static String GENERAL_RECONFIG_SIDES = "generalReconfigSides";
	public static String GENERAL_REDSTONE_CONTROL = "generalRedstoneControl";

	public static String MACHINE_SECONDARY = "machineSecondary";
	public static String MACHINE_SPEED = "machineSpeed";

	public static String MACHINE_FURNACE_FOOD = "machineFurnaceFood";
	public static String MACHINE_EXTRUDER_BOOST = "machineExtruderBoost";

}
