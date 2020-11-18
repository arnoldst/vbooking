#!/bin/bash
curl -k -X POST -H "Content-Type: application/x-www-form-urlencoded;charset=UTF-8" -d "grant_type=password&username=admin&password=admin&scope=openid" https://10.164.104.140:8443/idprovider/v1/auth/identitytoken > ./response.txt 
cat response.txt  | sed -n 's/.*\(:".*}\).*/\1/p' | sed 's/.$//' | sed 's/^.//' | sed 's/.$//' | sed 's/^.//' > token.txt
token = 'cat ./token.txt'
curl -k -X GET -H "Authorization: Bearer ${token}" "https://10.164.104.141:30000/cam/composer/api/v1/service?tenantId=${CAM_TENANT_ID}&ace_orgGuid=${ICP_TEAM}&cloudOE_spaceGuid=default"
