# Intent
An Intent in the Android operating system is a software mechanism that allows users to coordinate the functions of different activities to achieve a task. An Intent is a messaging object which provides a facility for performing late runtime binding between the code in different applications in the Android development environment. Its most significant use is in the launching of activities, where it can be thought of as the glue between activities: Intents provide an inter-application messaging system that encourages collaboration and component reuse.

Create Intent Object:
```kotlin
val intent = Intent(applicationContext,NextActivity::class.java)
```
Creation of data held in Key-Value type and sent to other Activities:
```kotlin
intent.putExtra("name",editTextName!!.text.toString())
intent.putExtra("surname",editTextSurname!!.text.toString())
```
Start Intent:
```kotlin
startActivity(intent)
```
Get data sent from another event:
```kotlin
val intent = intent
var name : String = intent.getStringExtra("name")
var surname : String = intent.getStringExtra("surname")
textViewNameSurname!!.text = "Hello $name $surname"
```
