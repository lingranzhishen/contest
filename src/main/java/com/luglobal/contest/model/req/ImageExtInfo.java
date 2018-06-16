package com.luglobal.contest.model.req;

import com.luglobal.contest.utils.ConstantHelper;

/**
 * Created by fengfei754 on 7/25/16.
 */
public class ImageExtInfo {
    private String category;
    private String mark;
    private LandMark landmark_terminal;
    private QualityTerminal quality_terminal;
    private String width;
    private String height;
    private String content_type;
    private String data;
    /**
     * H model  专用
     */
    // 是否需要去网纹
    private boolean eraseMark;




    public ImageExtInfo(String category, String data) {
        this.category = category;
        this.data = data;
        this.content_type = ConstantHelper.JPG;
    }

    public ImageExtInfo(){
    }

    public ImageExtInfo(String flag){
        this.category = "2";
        if("2".equals(flag)){
            this.mark = "0";
        }else {
            this.mark = "1";
        }
        this.width = "0";
        this.height = "0";
        this.content_type = "jpeg";
        this.landmark_terminal = new LandMark("1");
        this.quality_terminal = new QualityTerminal("1");
    }



    public class LandMark{
        private ImageExtInfoXY eye_left;
        private ImageExtInfoXY eye_right;
        private ImageExtInfoXY mouth_center;

        public LandMark(String flag){
            this.eye_left = new ImageExtInfoXY("1");
            this.eye_right = new ImageExtInfoXY("1");
            this.mouth_center = new ImageExtInfoXY("1");
        }

        public ImageExtInfoXY getEye_left() {
            return eye_left;
        }

        public void setEye_left(ImageExtInfoXY eye_left) {
            this.eye_left = eye_left;
        }

        public ImageExtInfoXY getEye_right() {
            return eye_right;
        }

        public void setEye_right(ImageExtInfoXY eye_right) {
            this.eye_right = eye_right;
        }

        public ImageExtInfoXY getMouth_center() {
            return mouth_center;
        }

        public void setMouth_center(ImageExtInfoXY mouth_center) {
            this.mouth_center = mouth_center;
        }
    }

    public class ImageExtInfoXY{
        private String x;
        private String y;

        public ImageExtInfoXY(String flag){
            this.x = "0";
            this.y = "0";
        }

        public String getX() {
            return x;
        }

        public void setX(String x) {
            this.x = x;
        }

        public String getY() {
            return y;
        }

        public void setY(String y) {
            this.y = y;
        }
    }

    public class QualityTerminal{
        private String brightness;
        private String blur_motion;
        private String blur_gaussian;
        private String deflection_h;
        private String deflection_v;

        public QualityTerminal(String flag){
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public LandMark getLandmark_terminal() {
        return landmark_terminal;
    }

    public void setLandmark_terminal(LandMark landmark_terminal) {
        this.landmark_terminal = landmark_terminal;
    }

    public QualityTerminal getQuality_terminal() {
        return quality_terminal;
    }

    public void setQuality_terminal(QualityTerminal quality_terminal) {
        this.quality_terminal = quality_terminal;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getContent_type() {
        return content_type;
    }

    public void setContent_type(String content_type) {
        this.content_type = content_type;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean isEraseMark() {
        return eraseMark;
    }

    public void setEraseMark(boolean eraseMark) {
        this.eraseMark = eraseMark;
    }

}
