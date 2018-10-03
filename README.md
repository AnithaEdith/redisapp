# Redis application 

This is to study the response of Redis Cache vs Database for storing IPs

## Redis Cache

ips.caching package contains the required configurations for Redis cache.
Based on the profile, the respective configuration is loaded

## Database 

ips.databaseCaching package contains the required configurations for storing and retrieving IPs from databse (postgresql).

## Performance Study

script is available in perf folder
Run the script using command

`sh script.sh`

`iplist.txt` has the list of IPs to be stored
`apilist.txt` has the list of APIs to be tracked

`Output.txt` file contains the time taken for specific api


