package com.pugac;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.ProtocolLibrary;

// Core AC
public class Main extends JavaPlugin{
  
  static Main instance;
  static ProtocolManager procManager;
  protected PacketManager packetManager;
  
  protected boolean useProtocol = false;
  
  @Override
  public void onEnable() {
    Long start = System.currentTimeMillis();
    instance =this;
    if(Bukkit.getPluginManager().isPluginEnabled("ProtocolLib")) {
      procManager = ProtocolLibrary.getProtocolManager();
      useProtocol = true;
    }
    log("Plugin loaded in " + (System.currentTimeMillis - start) + "ms")
  }
  
  public void log(String s) {
    Bukkit.getConsoleSender().sendMessage("[PUGAC] " + s);
  }
  
  @Override
  public void onDisable() {
    if(procManager != null) {
      procManager.removePacketListeners(this);
      procManager = null;
    }
    HandlerList.unregisterAll(this);
  }
  
  public static Main getInstance() {
    return instance;
  }
  
  public static ProtocolManager getProcManager() {
    return procManager;
  }
  
  public boolean isUsingProtocol(){
    return useProtocol;
  }
}