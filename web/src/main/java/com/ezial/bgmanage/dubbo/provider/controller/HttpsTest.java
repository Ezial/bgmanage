package com.ezial.bgmanage.dubbo.provider.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.util.Enumeration;

public class HttpsTest {

    public static void main(String[] args)
    {
        final String KEYSTORE_FILE = "C:/Users/lishu/Documents/keystore.p12";
        final String KEYSTORE_PASSWORD = "123456";
        final String KEYSTORE_ALIAS    = "alias";

        try
        {
            KeyStore ks = KeyStore.getInstance("PKCS12");
            FileInputStream fis = new FileInputStream(KEYSTORE_FILE);

            // If the keystore password is empty(""), then we have to set
            // to null, otherwise it won't work!!!
            char[] nPassword = null;
            if ((KEYSTORE_PASSWORD == null) || KEYSTORE_PASSWORD.trim().equals(""))
            {
                nPassword = null;
            }
            else
            {
                nPassword = KEYSTORE_PASSWORD.toCharArray();
            }
            ks.load(fis, nPassword);
            fis.close();

            System.out.println("keystore type=" + ks.getType());

            // Now we loop all the aliases, we need the alias to get keys.
            // It seems that this value is the "Friendly name" field in the
            // detals tab <-- Certificate window <-- view <-- Certificate
            // Button <-- Content tab <-- Internet Options <-- Tools menu
            // In MS IE 6.
            Enumeration enumeration = ks.aliases();
            String keyAlias = null;
            if (enumeration.hasMoreElements()) // we are readin just one certificate.
            {
                keyAlias = (String)enumeration.nextElement();
                System.out.println("alias=[" + keyAlias + "]");
            }

            // Now once we know the alias, we could get the keys.
            System.out.println("is key entry=" + ks.isKeyEntry(keyAlias));
            PrivateKey prikey = (PrivateKey) ks.getKey(keyAlias, nPassword);
            Certificate cert = ks.getCertificate(keyAlias);
            PublicKey pubkey = cert.getPublicKey();

            System.out.println("cert class = " + cert.getClass().getName());
            System.out.println("cert = " + cert);
            System.out.println("public key = " + pubkey);
            System.out.println("private key = " + prikey);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void exportFile() throws Exception{
    // 1:使用File类创建一个要操作的文件路径
    File file = new File("C:" + File.separator + "Users" + File.separator + "lishu" + File.separator + "test.txt");
        if(!file.getParentFile().exists()){ //如果文件的目录不存在
            file.getParentFile().mkdirs(); //创建目录

        }

        //2: 实例化OutputString 对象
        OutputStream output = new FileOutputStream(file);

        //3: 准备好实现内容的输出

        String msg = "HelloWorld";
        //将字符串变为字节数组
        byte data[] = msg.getBytes();
        output.write(data);
        //4: 资源操作的最后必须关闭
        output.close();
    }

}
