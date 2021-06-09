## Intent
An intent is an abstract description of an operation to be performed. It can be used with startActivity to launch an Activity, broadcastIntent to send it to any interested BroadcastReceiver components, and Context.startService(Intent) or Context.bindService(Intent, ServiceConnection, int) to communicate with a background Service.

An Intent provides a facility for performing late runtime binding between the code in different applications. Its most significant use is in the launching of activities, where it can be thought of as the glue between activities. It is basically a passive data structure holding an abstract description of an action to be performed.

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
