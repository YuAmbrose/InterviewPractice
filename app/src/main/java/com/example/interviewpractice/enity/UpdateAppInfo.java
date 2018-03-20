package com.example.interviewpractice.enity;


/**
 * Created by ccc on 2017/10/30.
 */

public class UpdateAppInfo {

    /**
     * name : A-Sniff
     * version : 2
     * changelog : null
     * updated_at : 1521533344
     * versionShort : 1.0.2
     * build : 2
     * installUrl : http://download.fir.im/v2/app/install/5aa409d0ca87a87c64766e8b?download_token=54c51ae4a4784bd5166d77885cd3b4f6&source=update
     * install_url : http://download.fir.im/v2/app/install/5aa409d0ca87a87c64766e8b?download_token=54c51ae4a4784bd5166d77885cd3b4f6&source=update
     * direct_install_url : http://download.fir.im/v2/app/install/5aa409d0ca87a87c64766e8b?download_token=54c51ae4a4784bd5166d77885cd3b4f6&source=update
     * update_url : http://fir.im/yuj4
     * binary : {"fsize":4872044}
     */

    private String name;
    private String version;
    private Object changelog;
    private int updated_at;
    private String versionShort;
    private String build;
    private String installUrl;
    private String install_url;
    private String direct_install_url;
    private String update_url;
    private BinaryBean binary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Object getChangelog() {
        return changelog;
    }

    public void setChangelog(Object changelog) {
        this.changelog = changelog;
    }

    public int getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(int updated_at) {
        this.updated_at = updated_at;
    }

    public String getVersionShort() {
        return versionShort;
    }

    public void setVersionShort(String versionShort) {
        this.versionShort = versionShort;
    }

    public String getBuild() {
        return build;
    }

    public void setBuild(String build) {
        this.build = build;
    }

    public String getInstallUrl() {
        return installUrl;
    }

    public void setInstallUrl(String installUrl) {
        this.installUrl = installUrl;
    }

    public String getInstall_url() {
        return install_url;
    }

    public void setInstall_url(String install_url) {
        this.install_url = install_url;
    }

    public String getDirect_install_url() {
        return direct_install_url;
    }

    public void setDirect_install_url(String direct_install_url) {
        this.direct_install_url = direct_install_url;
    }

    public String getUpdate_url() {
        return update_url;
    }

    public void setUpdate_url(String update_url) {
        this.update_url = update_url;
    }

    public BinaryBean getBinary() {
        return binary;
    }

    public void setBinary(BinaryBean binary) {
        this.binary = binary;
    }

    public static class BinaryBean {
        /**
         * fsize : 4872044
         */

        private int fsize;

        public int getFsize() {
            return fsize;
        }

        public void setFsize(int fsize) {
            this.fsize = fsize;
        }
    }
}
