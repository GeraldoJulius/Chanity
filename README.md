# Chanity

Bangkit Academy 2022 CAPSTONE PROJECT

Chanity is a personality test in the form of Android application that can help users to find out about their personality traits based on the personality test taken. The result will be displayed after users done the test, and they can find out which personality they tend to have from all five traits and also read the details of their traits, strengths, and also weaknesses of their personality traits.

# Chanity-BangkitCapstone-MobileDevelopment
![chanity](https://user-images.githubusercontent.com/105622910/173272809-3faed106-6946-4ad5-98d2-68d4a3ae0ac0.png)


## App Description
Chanity is a personality test in the form of Android application that can help users to find out about their personality traits based on the personality test taken. The result will be displayed after users done the test, and they can find out which personality they tend to have from all five traits and also read the details of their traits, strengths, and also weaknesses of their personality traits.

Download Apk : https://drive.google.com/file/d/1emAEFacoB-A3g8t40ZbYAxD2YmRlbpvs/view?usp=sharing

### Screenshots
![Screenshots](https://user-images.githubusercontent.com/105622910/173273269-d2f50bfe-b326-4ec6-9c63-c772d6e63769.jpg)

## Development

#### Requirements
* A Mac or Windows computer.
* Android Studio
* Android Virtual Device (AVD) > API 21

#### Dependencies
```Gradle
dependencies {
    // Firebase
    implementation platform('com.google.firebase:firebase-bom:30.0.2')
    implementation 'com.google.firebase:firebase-analytics-ktx'
    implementation 'com.google.firebase:firebase-auth-ktx'

    // Tensorflow
    implementation 'org.tensorflow:tensorflow-lite:0.1.100'
    implementation 'org.tensorflow:tensorflow-lite-support:0.1.0'
    implementation 'org.tensorflow:tensorflow-lite-metadata:0.1.0'
}
```

#### Plugins
```Gradle
plugins {
    id 'com.android.application'
    id 'org.jetbrains.kotlin.android'
    id 'com.google.gms.google-services'
}
```
### Clone this App

**Clone**
```bash
$ git clone https://github.com/GeraldoJulius/Chanity.git
```

**Open in Android Studio**
* `File -> Open -> Navigate to folder that you clone this repo -> Open`

**Run this project on AVD**
* `Start AVD -> Run 'app'`

**Build this app**
* `Build -> Build Bundle(s)/APK(s) -> Build APK(s)`
