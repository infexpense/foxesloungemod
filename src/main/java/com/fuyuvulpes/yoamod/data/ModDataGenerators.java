package com.fuyuvulpes.yoamod.data;


import com.fuyuvulpes.yoamod.data.generators.*;
import com.fuyuvulpes.yoamod.data.generators.advancement.YoaCoreAdvancements;
import com.klikli_dev.modonomicon.api.datagen.LanguageProviderCache;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static com.fuyuvulpes.yoamod.YOAMod.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModDataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event){
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeServer(),new AdvancementGen(packOutput,lookupProvider,existingFileHelper,
                        List.of(new YoaCoreAdvancements())
                )
        );
        generator.addProvider(event.includeServer(), new RecipeGen(packOutput));
        generator.addProvider(event.includeServer(), LootTablesGen.create(packOutput));

        generator.addProvider(event.includeClient(), new BlockStateGen(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new ItemModelGen(packOutput, existingFileHelper));

        BlockTagsGen blockTagGenerator = generator.addProvider(event.includeServer(),
                new BlockTagsGen(packOutput, lookupProvider, existingFileHelper));

        generator.addProvider(event.includeServer(),
                new ItemTagsGen(packOutput, lookupProvider, blockTagGenerator.contentsGetter(), existingFileHelper));


        generator.addProvider(event.includeServer(),
                new BiomeTagsGen(packOutput, lookupProvider, existingFileHelper));

        generator.addProvider(event.includeServer(),
                new WorldGenDataGen(packOutput, lookupProvider));

        var enUsCache = new LanguageProviderCache("en_us");
        var esEsCache = new LanguageProviderCache("es_es");;

        generator.addProvider(event.includeServer(), new YoaGuideBookProvider(generator.getPackOutput(), MODID,
                enUsCache
        ));



    }
}
