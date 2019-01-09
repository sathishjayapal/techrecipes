#include "F:\\MySyncs\\SKMINFOTECH Dropbox\\SKMINFOTECH's shared workspace\\Projects Team Folder\\techrecipes\\techrecipes-core\\src\\main\\java\\org\\techrecipes\\online\\jniutils\\org_techrecipes_online_jniutils_SystemDateUtility.h"
#include <iostream>

JNIEXPORT jstring JNICALL Java_org_techrecipes_online_jniutils_SystemDateUtility_getSystemTime
  (JNIEnv* env, jobject thisObject) {
      std::string fullName = "Hello from C++ !!";
      return env->NewStringUTF(fullName.c_str());
}