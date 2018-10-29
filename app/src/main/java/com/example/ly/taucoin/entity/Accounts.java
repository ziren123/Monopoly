package com.example.ly.taucoin.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Accounts {

    @Id(autoincrement = true)
    private Long id;
    private int user_id;
    private int fb_id;
    private String prikey;
    private String pubkey;
    private String address;
    private int execuated;
    private int txid;
    private int status;
    private String time;
    @Generated(hash = 1722876322)
    public Accounts(Long id, int user_id, int fb_id, String prikey, String pubkey,
            String address, int execuated, int txid, int status, String time) {
        this.id = id;
        this.user_id = user_id;
        this.fb_id = fb_id;
        this.prikey = prikey;
        this.pubkey = pubkey;
        this.address = address;
        this.execuated = execuated;
        this.txid = txid;
        this.status = status;
        this.time = time;
    }
    @Generated(hash = 1756363702)
    public Accounts() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getUser_id() {
        return this.user_id;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    public int getFb_id() {
        return this.fb_id;
    }
    public void setFb_id(int fb_id) {
        this.fb_id = fb_id;
    }
    public String getPrikey() {
        return this.prikey;
    }
    public void setPrikey(String prikey) {
        this.prikey = prikey;
    }
    public String getPubkey() {
        return this.pubkey;
    }
    public void setPubkey(String pubkey) {
        this.pubkey = pubkey;
    }
    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public int getExecuated() {
        return this.execuated;
    }
    public void setExecuated(int execuated) {
        this.execuated = execuated;
    }
    public int getTxid() {
        return this.txid;
    }
    public void setTxid(int txid) {
        this.txid = txid;
    }
    public int getStatus() {
        return this.status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public String getTime() {
        return this.time;
    }
    public void setTime(String time) {
        this.time = time;
    }
}

