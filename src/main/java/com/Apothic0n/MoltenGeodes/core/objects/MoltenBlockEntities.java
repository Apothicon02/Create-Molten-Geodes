package com.Apothic0n.MoltenGeodes.core.objects;

import com.Apothic0n.MoltenGeodes.MoltenGeodes;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MoltenBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, MoltenGeodes.MODID);

    public static final RegistryObject<BlockEntityType<?>> MOLTEN_ASURINE_BLOCK_ENTITY = BLOCK_ENTITIES.register("molten_asurine_block_entity", () -> BlockEntityType.Builder.of(MoltenAsurineBlockEntity::new, MoltenBlocks.MOLTEN_ASURINE.get()).build(null));
    public static final RegistryObject<BlockEntityType<?>> MOLTEN_VERIDIUM_BLOCK_ENTITY = BLOCK_ENTITIES.register("molten_veridium_block_entity", () -> BlockEntityType.Builder.of(MoltenVeridiumBlockEntity::new, MoltenBlocks.MOLTEN_VERIDIUM.get()).build(null));
    public static final RegistryObject<BlockEntityType<?>> MOLTEN_CRIMSITE_BLOCK_ENTITY = BLOCK_ENTITIES.register("molten_crimsite_block_entity", () -> BlockEntityType.Builder.of(MoltenCrimsiteBlockEntity::new, MoltenBlocks.MOLTEN_CRIMSITE.get()).build(null));
    public static final RegistryObject<BlockEntityType<?>> MOLTEN_OCHRUM_BLOCK_ENTITY = BLOCK_ENTITIES.register("molten_ochrum_block_entity", () -> BlockEntityType.Builder.of(MoltenOchrumBlockEntity::new, MoltenBlocks.MOLTEN_OCHRUM.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
