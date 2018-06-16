package com.luglobal.contest.model;
public class QualityTerminal{
    private String brightness;
    private String blur_motion;
    private String blur_gaussian;
    private String deflection_h;
    private String deflection_v;

    public QualityTerminal(){
        this.brightness = "0";
        this.blur_motion = "0";
        this.blur_gaussian = "0";
        this.deflection_h = "0";
        this.deflection_v = "0";
    }

    public String getBrightness() {
        return brightness;
    }

    public void setBrightness(String brightness) {
        this.brightness = brightness;
    }

    public String getBlur_motion() {
        return blur_motion;
    }

    public void setBlur_motion(String blur_motion) {
        this.blur_motion = blur_motion;
    }

    public String getBlur_gaussian() {
        return blur_gaussian;
    }

    public void setBlur_gaussian(String blur_gaussian) {
        this.blur_gaussian = blur_gaussian;
    }

    public String getDeflection_h() {
        return deflection_h;
    }

    public void setDeflection_h(String deflection_h) {
        this.deflection_h = deflection_h;
    }

    public String getDeflection_v() {
        return deflection_v;
    }

    public void setDeflection_v(String deflection_v) {
        this.deflection_v = deflection_v;
    }
}