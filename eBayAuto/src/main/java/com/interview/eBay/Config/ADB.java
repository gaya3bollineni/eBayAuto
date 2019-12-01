package com.interview.eBay.Config;

import java.util.ArrayList;
import java.util.Arrays;

public class ADB {

    private String ID;

    public ADB(String deviceID){ID = deviceID;}

    public static String command(String command){

        if(command.startsWith("adb")) command = command.replace("adb ", ServerManager.getAndroidHome()+"/platform-tools/adb ");
        else throw new RuntimeException("This method is designed to run ADB commands only!");
        String output = ServerManager.runCommand(command);
        if(output == null) return "";
        else return output.trim();
    }

 
   
    public static boolean isAppAlradyInstalled(String Package)
    {
        Boolean appstatus=false;

        String output=command("adb shell pm list packages | grep"+ Package);
            if(output.length()==0){
            return appstatus;
        }
        else
        {
            appstatus=true;
            System.out.println("Status="+appstatus);
            return appstatus;
        }
    }
    

    public void clearAppsData(String packageID){
        command("adb -s "+ID+" shell pm clear "+packageID);
    }
   

    public void installApp(String apkPath,String packageName){
        command("adb -s "+ID+" install "+apkPath);
    }

    
}
