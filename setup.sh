#!/bin/bash

XVFB=`which Xvfb`
if [ "$?" -eq 1 ];
then
    echo "Xvfb not found."
    exit 1
fi

FIREFOX=`which firefox`
if [ "$?" -eq 1 ];
then
    echo "Firefox not found."
    exit 1
fi

mkdir temp

# run the hub
java -jar lib/selenium-server.jar -role hub &
echo "$!" > temp/PIDHUB     # take the process ID
sleep 5

for ((i=60;i<=80;i++))
do

 $XVFB :$i -ac -screen 5 1024x768x24 &    # launch virtual framebuffer into the background
 export DISPLAY=:$i.5 # set display to use that of the xvfb

 java -jar lib/selenium-server.jar -role node -hub http://localhost:4444/grid/register -port 55$i -browser browserName=firefox, maxInstances=1 &
 #PIDNODE$i=""      # take the process ID
 echo "$!" > temp/PIDNODE$i
 #echo "Pidnode equals " $PIDNODE$i
 sleep 5
done