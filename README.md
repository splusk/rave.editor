# Introduction

This is a small project that allows you to use a dark theme with the rave editor. 
To change the colors to something that you want then edit the RGB color values in the java class 
ColorManagerConstants.java

Note in order for this work you need to have write privelages to the CARMSYS, so I recommend setting
this up first, for example copy the CARMSYS to your local work directory. 

## Build steps
This simple uses Apache Ant, but can be easily converted to a Maven project should one want

* run ant task
> ant -f build.xml
(note you will need to edit a few properties, for example to your CARMSYS and eclipse installation directory)
> ant install

* start eclipse.

* To install the Dark theme:
In eclipse

Help > Install New Software...

https://raw.github.com/guari/eclipse-ui-theme/master/com.github.eclipseuitheme.themes.updatesite

* To fix other fonts and colors install the dws_darktheme_pref.epf
(this file is found in the resource folder)

File > Import... then select General > Preferences


