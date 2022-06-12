package cn.agree.pojo;

public class BaoZi {

    String pier;
    String xianer;
    boolean flag = false;

    public BaoZi() {
    }

    public BaoZi(String pier, String xianer, boolean flag) {
        this.pier = pier;
        this.xianer = xianer;
        this.flag = flag;
    }

    public String getPier() {
        return pier;
    }

    public void setPier(String pier) {
        this.pier = pier;
    }

    public String getXianer() {
        return xianer;
    }

    public void setXianer(String xianer) {
        this.xianer = xianer;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "BaoZi{" +
                "pier='" + pier + '\'' +
                ", xianer='" + xianer + '\'' +
                ", flag=" + flag +
                '}';
    }


}
