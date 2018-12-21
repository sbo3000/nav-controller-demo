# nav-controller-demo

Small Android sample to demonstrate the potential of the new Android Navigation Controller.


## Working deeplinks

Use the following in the command line:
    
    '''
    adb shell am start -a android.intent.action.VIEW -d "{URL_PLACEHOLDER}" 
    '''
    
### ht<span>tp://www.</span>bosse.app/navcontroller/string/{data}
- replace {DATA} with your string
- adb shell am start -a android.intent.action.VIEW -d "http://www.bosse.app/navcontroller/string/{DATA}"


### http://www.bosse.app/navcontroller/camera/
- open the in app "camera"
- adb shell am start -a android.intent.action.VIEW -d "http://www.bosse.app/navcontroller/camera/"

