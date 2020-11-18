import requests
import json

print("Cloud Automation Manager APIs - Demo Python Script")

protocol='https://'
host='10.164.104.141'
camPort='30000'
icpPort='8443'
user='admin'
pw='admin'
#user='camuser0@localtest.com'
#pw='passw0rd'


cam=protocol + host + ":" + camPort
icp=protocol + host + ":" + icpPort

#GET access_token from ICP
postdata = "grant_type=password&username=" + user + "&password=" + pw + "&scope=openid"
head = {'Content-Type':'application/x-www-form-urlencoded', 'Accept':'application/json', "charset" : "UTF-8"}
ret = requests.post(icp + "/idprovider/v1/auth/identitytoken",
                     data=postdata,
                     headers=head,
                     verify=False)
access_token=ret.json()["access_token"]
print("access_token", access_token)

#GET tenantId, team and namespace from CAM
head = {"Authorization": "bearer " + access_token}
ret = requests.get(cam + "/cam/tenant/api/v1/tenants/getTenantOnPrem",
                     headers=head,
                     verify=False)
tenantId=ret.json()["id"]
namespace=ret.json()["namespaces"][0]["uid"]
if user != 'admin':
    team=ret.json()["namespaces"][0]["teamId"]
else:
    team='all'
print("tenantId", tenantId)
print("team", team)
print("namespace", namespace)

#GET cloudconnections from CAM
parameters={"tenantId":tenantId, "ace_orgGuid":team}
head = {"Authorization": "bearer " + access_token, 'Accept':'application/json'}
ret = requests.get(cam + "/cam/api/v1/cloudconnections",
                     headers=head,
                     params=parameters,
                     verify=False)
cloudConnections=json.dumps(ret.json())
print("cloudConnections", cloudConnections)

#GET stacks from CAM
parameters={"tenantId":tenantId, "ace_orgGuid":team, "cloudOE_spaceGuid":namespace}
head = {"Authorization": "bearer " + access_token, 'Accept':'application/json'}
ret = requests.get(cam + "/cam/api/v1/stacks",
                     headers=head,
                     params=parameters,
                     verify=False)
stacks=json.dumps(ret.json())
print("stacks", stacks)

#GET templates from CAM
parameters={"tenantId":tenantId, "ace_orgGuid":team}
head = {"Authorization": "bearer " + access_token, 'Accept':'application/json'}
ret = requests.get(cam + "/cam/api/v1/templates",
                     headers=head,
                     params=parameters,
                     verify=False)
templates=json.dumps(ret.json())
print("templates", templates)

#GET templates from CAM with name filter
parameters={"tenantId":tenantId, "ace_orgGuid":team, "filter":'{"where": {"name": "SingleVirtualMachine" }}'}
head = {"Authorization": "bearer " + access_token, 'Accept':'application/json'}
ret = requests.get(cam + "/cam/api/v1/templates",
                     headers=head,
                     params=parameters,
                     verify=False)
templates=json.dumps(ret.json())
#templateId=json.dumps(ret.json().id)
print("templates", templates)
print("templateId", templateId)

#GET sharedruntimeinstances from CAM
parameters={"tenantId":tenantId, "ace_orgGuid":team, "cloudOE_spaceGuid":namespace}
head = {"Authorization": "bearer " + access_token, 'Accept':'application/json'}
ret = requests.get(cam + "/cam/api/v1/sharedruntimeinstances",
                     headers=head,
                     params=parameters,
                     verify=False)
sharedruntimeinstances=json.dumps(ret.json())
print("sharedruntimeinstances", sharedruntimeinstances)

#GET order from CAM
parameters={"tenantId":tenantId, "ace_orgGuid":team, "cloudOE_spaceGuid":namespace}
head = {"Authorization": "bearer " + access_token, 'Accept':'application/json'}
ret = requests.get(cam + "/cam/portal/api/v1/order",
                     headers=head,
                     params=parameters,
                     verify=False)
order=json.dumps(ret.json())
print("order", order)