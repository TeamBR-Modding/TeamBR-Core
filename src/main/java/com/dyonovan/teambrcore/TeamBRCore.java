package com.dyonovan.teambrcore;

import com.dyonovan.teambrcore.lib.Constants;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(name = Constants.MODNAME, modid = Constants.MODID, version = Constants.VERSION)

@SuppressWarnings("unused")
public class TeamBRCore {

    @Instance(Constants.MODID)
    public static TeamBRCore instance;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event){

    }

    @EventHandler
    public void init(FMLInitializationEvent event) {

    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }
}
