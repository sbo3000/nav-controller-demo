# nav-controller-demo

Small Android sample to demonstrate the potential of the new Android Navigation Controller. You can see basics of how work with:

* `NavHostFragment`
* safeArguments
* fragment transitions
* animations
* deeplinks



## Working deeplinks

You can use the following adb command to test deep links:
    
    adb shell am start -a android.intent.action.VIEW -d "{URL_PLACEHOLDER}" 
    
* ### http://<i></i>w<i></i>ww.bosse.app/navcontroller/string/{data}
    - replace {DATA} with your string
    - adb shell am start -a android.intent.action.VIEW -d "http://<i></i>w<i></i>ww.bosse.app/navcontroller/string/{DATA}"


* ### http://<i></i>w<i></i>ww.bosse.app/navcontroller/camera/
    - open the in app "camera"
    - adb shell am start -a android.intent.action.VIEW -d "http://<i></i>w<i></i>ww.bosse.app/navcontroller/camera/"

