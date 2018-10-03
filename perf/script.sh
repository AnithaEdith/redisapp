#!/bin/sh
#apiEndPoint='http://localhost:8080'
apiEndPoint='https://redisapp.apps.np.sdppcf.com'

while read line
do
    apiUri=$(echo "$line" | awk -F'|' '{print $1}')

        #start=`(date +'%s * 1000 + %-N / 1000000')`
        start=`date +%s`

        while read line
        do
            ip=$(echo "$line" | awk -F'|' '{print $1}')
            url=$apiEndPoint$apiUri$ip

            #echo "$url" >>output.txt
            #sleep 0.25

            curl -X GET $url

        done<iplist.txt
        #end=`(date +'%s * 1000 + %-N / 1000000')`
        end=`date +%s`
        echo "Time diff for" $apiUri " : $((end-start))" >>output.txt

done<apilist.txt
