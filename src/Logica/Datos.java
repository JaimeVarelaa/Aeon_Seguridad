/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.io.File;
import java.security.PrivateKey;

/**
 *
 * @author jaime
 */
public class Datos {

    private String ip;
    private String mac;
    private String publicKey;
    private String sha384;
    private String mssgEncrypt;
    private File archivo;
    private long archivoSize;
    private String Blake2;
    private PrivateKey PrivateKey;

    public void setPrivateKey(PrivateKey PrivateKey) {
        this.PrivateKey = PrivateKey;
    }

    public PrivateKey getPrivateKey() {
        return PrivateKey;
    }

    public void setBlake2(String Blake2) {
        this.Blake2 = Blake2;
    }

    public String getBlake2() {
        return Blake2;
    }
    

    public File getArchivo() {
        return archivo;
    }

    public void setMssgEncrypt(String mssgEncrypt) {
        this.mssgEncrypt = mssgEncrypt;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public void setArchivoSize(long archivoSize) {
        this.archivoSize = archivoSize;
    }

    public long getArchivoSize() {
        return archivoSize;
    }

    public String getMssgEncrypt() {
        return mssgEncrypt;
    }
    private String sha512;

    public void setSha512(String sha512) {
        this.sha512 = sha512;
    }

    public String getSha512() {
        return sha512;
    }

    public void setSha384(String sha384) {
        this.sha384 = sha384;
    }

    public String getSha384() {
        return sha384;
    }

    public Datos() {
    }

    public String getIp() {
        return ip;
    }

    public String getMac() {
        return mac;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

}
