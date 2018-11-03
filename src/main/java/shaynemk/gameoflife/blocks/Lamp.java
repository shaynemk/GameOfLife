package shaynemk.gameoflife.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.lwjgl.input.Keyboard;
import shaynemk.gameoflife.GameOfLife;

import static shaynemk.gameoflife.misc.CreativeTab.tabGameOfLife;

public class Lamp extends Block{
    public static final String nameRegistry = "lamp";
    public static final String nameUnlocalized = GameOfLife.MODID + "." + nameRegistry;
    public static final PropertyInteger LIT = PropertyInteger.create("lit",0,1);

    private boolean isOn;

    public Lamp(boolean isOnByDefault) {
        super(Material.ROCK);
        this.isOn = isOnByDefault;
        this.init();
    }

    public Lamp() {
        super(Material.ROCK);
        this.isOn = false;
        this.init();
    }

    private void init() {
        setRegistryName(nameRegistry);
        setUnlocalizedName(nameUnlocalized);
        setCreativeTab(tabGameOfLife);
        setHardness(10F);
        setDefaultState(this.blockState.getBaseState().withProperty(LIT, isOn ? 1 : 0));

        if(isOn) {
            this.setLightLevel(1.0F);
        } else {
            this.setLightLevel(0F);
        }
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, LIT);
    }

    /**
     * Convert the given metadata into a BlockState for this Block
     *
     * @param meta
     */
    @Override
    public IBlockState getStateFromMeta(int meta) {
        //return super.getStateFromMeta(meta);
        return this.getDefaultState().withProperty(LIT, this.isOn ? 1 : 0);
    }

    /**
     * Convert the BlockState into the correct metadata value
     *
     * @param state
     */
    @Override
    public int getMetaFromState(IBlockState state) {
        //return super.getMetaFromState(state);
        return this.isOn ? 1 : 0;
    }

    /**
     * Called when the block is right clicked by a player.
     *
     * @param worldIn
     * @param pos
     * @param state
     * @param playerIn
     * @param hand
     * @param facing
     * @param hitX
     * @param hitY
     * @param hitZ
     */
    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!worldIn.isRemote) {
            if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
                toggleLamp(worldIn, pos);
            }
        }

        return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
    }

    /** TODO
        - add in option to turn light on/off
     **/
    @Override
    public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn) {
        //toggleLamp(worldIn, pos);

        super.onBlockClicked(worldIn, pos, playerIn);
    }

    private void toggleLamp(World worldIn, BlockPos pos) {
        this.isOn = !this.isOn;
        //IBlockState newState = this.blockState.getBaseState().withProperty(LIT, (this.isOn ? 1 : 0));

        //ModBlocks.lamp.setDefaultState(this.blockState.getBaseState().withProperty(LIT, (this.isOn ? 1 : 0)));
        //worldIn.setBlockState(pos, this.blockState.getBaseState().withProperty(LIT, (this.isOn ? 1 : 0)), 3);
        //worldIn.setBlockState(pos, isOn ? getLampOnState() : getLampOffState(), 3);

        IBlockState newState = worldIn.getBlockState(pos).cycleProperty(LIT);
        worldIn.setBlockState(pos, newState, 3);

        /*if (this.isOn) {
            ModBlocks.lamp.setDefaultState(newState);
            worldIn.setBlockState(pos, ModBlocks.lamp.getDefaultState(), 3);
        } else {
            worldIn.setBlockState(pos, ModBlocks.lamp.getDefaultState(), 3);
        }*/
    }

    private IBlockState getLampOnState() {
        return this.blockState.getBaseState().withProperty(LIT,1);
    }

    private IBlockState getLampOffState() {
        return this.blockState.getBaseState().withProperty(LIT,0);
    }
}
