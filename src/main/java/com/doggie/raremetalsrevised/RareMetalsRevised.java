package com.doggie.raremetalsrevised;

import com.doggie.raremetalsrevised.init.Init;

import com.doggie.raremetalsrevised.world.gen.CaliforniumGen;
import com.doggie.raremetalsrevised.world.gen.RhodiumGen;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod("rmr")
public class RareMetalsRevised {
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "rmr";
    public static RareMetalsRevised instance;
    public RareMetalsRevised() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);
        Init.ITEMS.register(modEventBus);
        Init.BLOCKS.register(modEventBus);

        instance = this;
        MinecraftForge.EVENT_BUS.register(this);
    }
    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
        final IForgeRegistry<Item> registry = event.getRegistry();


            final Item.Properties properties = new Item.Properties().group(RareMetalsRevised.TAB);

        }


    private void setup(final FMLCommonSetupEvent event) {
        RhodiumGen.generateOre();
        CaliforniumGen.generateOre();

    }

    @SubscribeEvent
    public static void onServerStarting(FMLServerStartingEvent event) {

    }

    @SubscribeEvent
    public static void loadCompleteEvent(FMLLoadCompleteEvent event) {

    }





        // Custom ItemGroup TAB





            public static final ItemGroup TAB = new ItemGroup("Rare Metals Revised Tab") {
                @Override
                public ItemStack createIcon() {
                    return new ItemStack(Init.RHODIUM_INGOT.get());
                }
            };

}







