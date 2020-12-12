package com.pugac.managers;

import com.pugac.Main;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;


public class PacketManager {
  private Main instance;
  private ProtocolManager pm;
  
  public PacketManager(Main instance, ProtocolManager pm){
    this.instance = instance;
    this.pm = pm;
    RegisterListeners();
    
  }
  
  private void RegisterListeners() {
    pm.addPacketListener(new PacketAdapter(instance, ListenerPriority.MONITOR, new PacketType[] { PacketType.Play.Client.USE ENTITY}) {
      @Override
      public void onPacketReceiving(PacketEvent e) {
        
      } 
    });
  }
}