package cofh.thermalexpansion.gui;

import cofh.core.block.TileCore;
import cofh.core.util.helpers.ItemHelper;
import cofh.thermalexpansion.gui.client.storage.GuiSatchel;
import cofh.thermalexpansion.gui.container.storage.ContainerSatchel;
import cofh.thermalexpansion.init.TEItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	public static final int TILE_ID = 0;
	public static final int SATCHEL_ID = 1;

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {

		BlockPos pos = new BlockPos(x, y, z);
		switch (id) {
			case TILE_ID:
				TileEntity tile = world.getTileEntity(pos);
				if (tile instanceof TileCore) {
					return ((TileCore) tile).getGuiClient(player.inventory);
				}
				return null;
			case SATCHEL_ID:
				if (ItemHelper.isPlayerHoldingMainhand(TEItems.itemSatchel, player)) {
					return new GuiSatchel(player.inventory, new ContainerSatchel(player.getHeldItemMainhand(), player.inventory));
				}
				return null;
			default:
				return null;
		}
	}

	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {

		BlockPos pos = new BlockPos(x, y, z);
		switch (id) {
			case TILE_ID:
				TileEntity tile = world.getTileEntity(pos);
				if (tile instanceof TileCore) {
					return ((TileCore) tile).getGuiServer(player.inventory);
				}
				return null;
			case SATCHEL_ID:
				if (ItemHelper.isPlayerHoldingMainhand(TEItems.itemSatchel, player)) {
					return new ContainerSatchel(player.getHeldItemMainhand(), player.inventory);
				}
				return null;
			default:
				return null;
		}
	}

}
