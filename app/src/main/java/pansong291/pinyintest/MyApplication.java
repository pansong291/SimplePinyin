package pansong291.pinyintest;

import pansong291.pinyintest.ui.CrashActivity;
import pansong291.crash.CrashApplication;

public class MyApplication extends CrashApplication
{
 @Override
 public Class<?> getPackageActivity()
 {
  setShouldShowDeviceInfo(false);
  return CrashActivity.class;
 }

}
