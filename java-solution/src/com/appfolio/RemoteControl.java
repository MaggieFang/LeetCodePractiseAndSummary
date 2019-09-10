package com.appfolio;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-09-10
 **/
public class RemoteControl {
    /**
     * Clarification:
     * given two type of device:
     * class VendorLight{
     *   on();
     *   off();
     * }
     *
     * class VendorHotTub{
     * set_perfect_temperature()
     * on();
     * off();
     * clean();
     * }
     * there are 7 slot that can be assigned to devices
     * implement RemoteControl class with following method
     * 1. assign slot to device
     * 2. turn on (don't care about the current slot status on/off)
     * 3 turn off(don't care about the current slot status on/off)
     * </p>
     * Keypoints:
     *  define an interface
     *  VendorDevice{
     *      boolean turnOn();
     *      boolean turnOff();
     *  }
     *  if we are allowed to modified the VendorLight and VendorHotTub. we implement VendorDevice for the both class .
     *  e.g
     *  class VendorLight implement VendorDevice{
     *      turnOn(){
     *          on();
     *      }
     *      turnOff(){
     *          off();
     *      }
     *      off();
     *      on();
     *  }
     *  class VendorHotTub implement VendorDevice{
     *      turnOn(){
     *          set_perfect_temperature();
     *          on();
     *      }
     *      turnOff(){
     *          off();
     *          clean();
     *      }
     *  }
     *
     *  class RemoteControl{
     *      HashMap<Integer,VendorDevice> map;
     *      boolean assigned(int slotId,VendorDevice device){
     *          if(map.size() >= 7 || map.containsKey(slotId)){
     *              return false;
     *          }
     *          map.put(slotId,device);
     *      }
     *
     *      boolean turnOn(int slotId){
     *          if(map.containsKey(slotId)){
     *              return false;
     *          }
     *          return map.get(slotId).turnOn();
     *      }
     *
     *      boolean turnOff(int slotId){
     *          if(map.containsKey(slotId)){
     *              return false;
     *          }
     *          return map.get(slotId).turnOff();
     *      }
     *  }
     *
     *  but if we are not allowed to modify the two classes. we can use a wrapper/proxy for them
     *  e.g
     *  class LightWrapper implement VendorDevice{
     *      VendorLight  device;
     *      public LightWrapper(){
     *          this.device = new LightVender();
     *      }
     *      boolean turnOn(){
     *          device.turnOn();
     *      }
     *      boolean turnOff(){
     *          device.turnOff(0;
     *      }
     *  }
     *
     *  class TubWrapper implement VendorDevice{
     *      VendorHotTub device;
     *      public TubWrapper(){
     *          this.device = new VendorHotTub();
     *      }
     *      boolean turnOn(){
     *          device.set_temparate();
     *          device.on();
     *      }
     *
     *      boolean turnOff(){
     *          device.off();
     *          device.clean();
     *      }
     *  }
     *
     *
     *
     *
     * </p>
     * TIME COMPLEXITY:
     * SPACE COMPLEXITY:
     * </p>
     **/

}
