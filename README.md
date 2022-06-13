# Chanity
Bangkit Academy 2022 CAPSTONE PROJECT

![chanity](https://user-images.githubusercontent.com/105622910/173272809-3faed106-6946-4ad5-98d2-68d4a3ae0ac0.png)

Chanity is a personality test in the form of Android application that can help users to find out about their personality traits based on the personality test taken. The result will be displayed after users done the test, and they can find out which personality they tend to have from all five traits and also read the details of their traits, strengths, and also weaknesses of their personality traits.

Download Apk : https://storage.googleapis.com/chanityproject/Chanity.apk

# Chanity-BangkitCapstone-MobileDevelopment

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


# Chanity-BangkitCapstone-MachineLearning

## Dataset and model
- Dataset: https://www.kaggle.com/datasets/tunguz/big-five-personality-test
- Model: https://drive.google.com/file/d/1ABMnPy5bV0P7gYqK2gOU5et5WqyIO3cA/view?usp=sharing

## Note
- Clustering using KMeans from Scikit-Learn Library
- Modeling using ANN Model with 96% Accuracy

## Accuracy
![Accuracy](https://user-images.githubusercontent.com/105622910/173274907-d732d536-4755-43ca-b111-97618ea69d1b.jpeg)

## Result Prediction
![ResultPrediction](https://user-images.githubusercontent.com/105622910/173274920-817cefc9-b068-464b-958a-d7d7c57b1e5b.jpeg)


# Chanity-BangkitCapstone-CloudComputing

## Firebase
Link: https://console.firebase.google.com/u/1/project/chanityproject/overview
![Firebase](https://user-images.githubusercontent.com/105622910/173275720-4beaa453-c8c3-4628-b39b-4a139f94c326.jpg)

## Authentication
Link: https://console.firebase.google.com/u/1/project/chanityproject/authentication/users
![Authentication](https://user-images.githubusercontent.com/105622910/173275783-58b266b2-4ac1-4462-ba2a-dde1ee5a8313.jpg)
