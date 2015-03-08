package com.dyonovan.teambrcore.utils;

import com.dyonovan.teambrcore.helpers.LogHelper;

import java.io.File;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.jar.JarEntry;

public class FileUtils {

    /**
     * Lists files in a specified Jar/Filesystem Directory
     * @param url {@link java.net.URL}
     * @param dir {@link java.lang.String} directory name to list
     * @return An {@link java.util.ArrayList} of {@link java.lang.String}
     */
    public ArrayList<String> getJarDirList(URL url, String dir) {
        ArrayList<String> files = new ArrayList<>();

        if (url.toString().substring(0,3).equalsIgnoreCase("jar")) {
            try {
                String[] urlString = url.toString().split("!");
                JarURLConnection jarCon = (JarURLConnection)new URL(urlString[0] + "!/").openConnection();
                Enumeration<JarEntry> entries = jarCon.getJarFile().entries();
                while (entries.hasMoreElements()) {
                    JarEntry entry = entries.nextElement();
                    String entryName = entry.getName();
                    if (entryName.startsWith(dir)) {
                        if (!(entryName.replaceAll(dir + "/", "").equals("")))
                            files.add(entryName.replaceAll(dir + "/", ""));
                    }
                }
            } catch (IOException e) {
                LogHelper.severe("Could not open Jar File");
            }
        } else {
            try {
                File apps = new File(url.toURI());
                for (File app : apps.listFiles()) {
                    files.add(app.getName());
                }
            } catch (URISyntaxException e) {
                LogHelper.severe("Could not open Directory");
            }

        }
        return files;
    }
}
