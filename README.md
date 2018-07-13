# Android-Room-Demo
Using Android Room persistent library to store data in the local database. Developed Words application using the Room library.

# Libraries used in this project?
- Android Room Persistent Library
- Android Data Binding
- Constraint Layout
- Recycler View and its Adapter

# Gradle file Changes

  Project level gradle file
    ext{
        roomVersion = '1.0.0'
        archLifecycleVersion = '1.1.0'
    }


   App Module level gradle file
   android {
        //other configuration
        defaultConfig {
        //other configuration
           javaCompileOptions {
               annotationProcessorOptions {
                    arguments = ["room.schemaLocation": "$projectDir/schemas".toString()]
               }
           }
        }
       dataBinding {
           enabled = true
       }
   }
   dependencies {
        //other required dependencies

       // Room components
       implementation "android.arch.persistence.room:runtime:$rootProject.roomVersion"
       annotationProcessor "android.arch.persistence.room:compiler:$rootProject.roomVersion"
       androidTestImplementation "android.arch.persistence.room:testing:$rootProject.roomVersion"

   // Lifecycle components
       implementation "android.arch.lifecycle:extensions:$rootProject.archLifecycleVersion"
       annotationProcessor "android.arch.lifecycle:compiler:$rootProject.archLifecycleVersion"

   }

# Download the Apk
<a target="_blank" download="WordsApp.apk" href="https://github.com/sathishmepco/Android-Room-Demo/blob/master/app/release/Android%20Room%20Demo%20Words%20App.apk"> Click here to download the apk file </a>

<img src="Android Room Demo Words App.png" />
