# Introduction

This is a small project that allows you to use a dark theme with the rave editor. 
To change the colors to something that you want then edit the RGB color values in the java class 
ColorManagerConstants.java

This simple project uses Apache Ant, therefore you will need `ant` and to edit a few properties in the `build.xml` file, for example:
* Path to your $CARMSYS 
* Path to your eclipse installation, which should be the one bundled within your $CARMSYS

**Note** In order for this work properly you need to have write privelages to the $CARMSYS, 
so what I recommend is setting this up first (for example copy the $CARMSYS to your local work directory).


## Build steps

* run ant task

`ant -f build.xml`

`ant install`

* Start eclipse and install the dark theme:

`Help > Install New Software...`

`https://raw.github.com/guari/eclipse-ui-theme/master/com.github.eclipseuitheme.themes.updatesite`

* To fix other fonts and colors install the *dws_darktheme_pref.epf*

(this file is found in the resource folder of this project)

`File > Import... then select General > Preferences`


