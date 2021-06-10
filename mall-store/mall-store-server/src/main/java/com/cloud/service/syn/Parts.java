package com.cloud.service.syn;

/**
 * @Author zuyunbo
 * @Date 2021/6/3  4:07 下午
 **/
public class Parts {

    Long id;

    String tax;

    String proFile;

    String zzz;

    String ssaa;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getProFile() {
        return proFile;
    }

    public void setProFile(String proFile) {
        this.proFile = proFile;
    }

    public String getZzz() {
        return zzz;
    }

    public void setZzz(String zzz) {
        this.zzz = zzz;
    }

    public String getSsaa() {
        return ssaa;
    }

    public void setSsaa(String ssaa) {
        this.ssaa = ssaa;
    }

    /**
     *
     * @param id
     * @param tax
     * @param proFile
     */
    public Parts(Long id, String tax, String proFile) {
        this(id, tax, proFile, null, null);
    }

    public Parts(Long id, String tax, String proFile, String zzz, String ssaa) {
        this.id = id;
        this.tax = tax;
        this.proFile = proFile;
        this.zzz = zzz;
        this.ssaa = ssaa;
    }




    /**
     * 存入相关
     *
     * @return
     */


}
