/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package j1.s.p0071;

/**
 *
 * @author PiPi
 */
public class Validation {

    public boolean checkPlanTime(float planFrom, float planTo) {
        return (planFrom < planTo) && (planFrom >= 8.0 && planFrom <= 17.5) && (planTo >= 8.0 && planTo <= 17.5)
                && (planTo % 0.5 == 0) && (planFrom % 0.5 == 0);
    }
}
