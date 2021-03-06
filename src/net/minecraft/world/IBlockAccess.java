package net.minecraft.world;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;

public interface IBlockAccess
{
    Block getBlock(int p_147439_1_, int p_147439_2_, int p_147439_3_);

    TileEntity getTileEntity(int p_147438_1_, int p_147438_2_, int p_147438_3_);

    /**
     * Returns the block metadata at coords x,y,z
     */
    int getBlockMetadata(int p_72805_1_, int p_72805_2_, int p_72805_3_);

    /**
     * Is this block powering in the specified direction Args: x, y, z, direction
     */
    int isBlockProvidingPowerTo(int p_72879_1_, int p_72879_2_, int p_72879_3_, int p_72879_4_);
}
