/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.time.*  ;

/**
 *
 * @author mtiro
 */
public class ModelDataTidur {
    
    
    public long HitungDurasi(LocalDateTime mulai,LocalDateTime selesai ){
        Duration duration = Duration.between(mulai, selesai);
        return (long)duration.toMinutes();
    }
    
    public float HitungSkor(long durasi, int umur){
        if (umur > 5 && umur < 14){
            return durasi/(11 * 60) *100;
        } else if (umur > 13 && umur < 18) {
            return durasi/(10 * 60) *100;
        } else {
            return durasi/(9 * 60) *100;
        }
    }
}
