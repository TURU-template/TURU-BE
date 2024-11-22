/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.time.LocalTime;
/**
 *
 * @author mtiro
 */
public class ModelPlayer {
    private LocalTime cutTime;
    private long durasi = 0;
    
    public void Timer(long durasi){
        cutTime = LocalTime.now();
        cutTime = cutTime.plusSeconds(durasi);
              
    }
}
