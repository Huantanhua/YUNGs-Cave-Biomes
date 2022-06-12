package com.yungnickyoung.minecraft.yungscavebiomes.block.entity;

import com.yungnickyoung.minecraft.yungscavebiomes.init.YCBModEntities;
import com.yungnickyoung.minecraft.yungscavebiomes.init.YCBModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class RareIceBlockEntity extends BlockEntity {
    private int timeToNextSound = 0;

    public RareIceBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(YCBModEntities.RARE_ICE, blockPos, blockState);
    }

    public static void tick(Level level, BlockPos blockPos, BlockState blockState, RareIceBlockEntity rareIceBlockEntity) {
        rareIceBlockEntity.timeToNextSound--;
        if (rareIceBlockEntity.timeToNextSound <= 0) {
            level.playSound(null, blockPos, YCBModSounds.AMBIENT_BLOCK_RARE_ICE, SoundSource.BLOCKS, 1.0F, 1.0F);
            rareIceBlockEntity.timeToNextSound = Mth.randomBetweenInclusive(level.getRandom(), 100, 160);
        }
    }
}