#!/bin/bash

XVFB=`which Xvfb`
if [ "$?" -eq 1 ];
then
    echo "Xvfb not found."
    exit 1
fi

for ((i=60;i<=80;i++))
do

kill `cat temp/PIDNODE$i`
echo `cat temp/PIDNODE$i`

done

kill `cat temp/PIDHUB`

killall $XVFB      # shut down xvfb

rm -R temp
echo "Done."