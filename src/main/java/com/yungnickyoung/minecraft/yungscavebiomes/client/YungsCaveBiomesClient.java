package com.yungnickyoung.minecraft.yungscavebiomes.client;

import com.yungnickyoung.minecraft.yungscavebiomes.client.model.IceCubeModel;
import com.yungnickyoung.minecraft.yungscavebiomes.client.render.IceCubeRenderer;
import com.yungnickyoung.minecraft.yungscavebiomes.init.YCBModBlocks;
import com.yungnickyoung.minecraft.yungscavebiomes.init.YCBModEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.renderer.RenderType;

public class YungsCaveBiomesClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(YCBModBlocks.ICICLE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(YCBModBlocks.FROST_LILY, RenderType.cutout());
        EntityRendererRegistry.register(YCBModEntities.ICE_CUBE, IceCubeRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(IceCubeRenderer.LAYER_LOCATION, IceCubeModel::createBodyLayer);
    }
}
