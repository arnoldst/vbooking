#####################################################################
##
##      Created 11/8/17 by ucdpadmin. For Cloud admin@vcenter
##
#####################################################################

## REFERENCE {"Test1879-104-128-25":{"type": "reference_network"}}

terraform {
  required_version = "> 0.7.0"
}

provider "vsphere" {
  user           = "ucdbpd"
  password       = "passw0rd"
  vsphere_server = "10.164.168.112"

  # if you have a self-signed cert
  allow_unverified_ssl = true
}

provider "ucd" {
  username       = "admin"
  password       = "admin"
  ucd_server_url = "https://10.164.104.137/"
}

variable "environment_name" {
  type = "string"
  description = "Generated"
}

variable "vbookingweb-name" {
  type = "string"
  default = "vbookingweb"
  description = "virtual machine name for vbookingweb"
}

variable "vbookingweb_folder" {
  type = "string"
  default = "Urbancode/Workload"
  description = "folder containing this instance"
}

variable "vbookingweb_datacenter" {
  type = "string"
  default = "LondonDC"
  description = "data center containing this instance"
}

variable "vbookingweb_number_of_vcpu" {
  type = "string"
  default = "2"
  description = "number of virtual cpu's"
}

variable "vbookingweb_memory" {
  type = "string"
  default = "4096"
  description = "memory allocation"
}

variable "vbookingweb_cluster" {
  type = "string"
  default = "Cluster1"
  description = "member of this cluster"
}

variable "dns_suffixes" {
  # changed type to list
  type = "list"
  default = []
  description = "DNS suffixes"
}

variable "dns_servers" {
  #changed type to list
  type = "list"
  default = []
  description = "DNS servers"
}

variable "Test1879-104-128-25_network_interface_label" {
  type = "string"
  default = "Test1879-104-128-25"
  description = "Generated"
}

variable "vbookingapp-name" {
  type = "string"
  default = "vbookingapp"
  description = "virtual machine name for vbookingweb"
}

variable "vbookingapp_folder" {
  type = "string"
  default = "Urbancode/Workload"
  description = "folder containing this instance"
}

variable "vbookingapp_datacenter" {
  type = "string"
  default = "LondonDC"
  description = "data center containing this instance"
}

variable "vbookingapp_number_of_vcpu" {
  type = "string"
  default = "2"
  description = "number of virtual cpu's"
}

variable "vbookingapp_memory" {
  type = "string"
  default = "4096"
  description = "memory allocation"
}

variable "vbookingapp_cluster" {
  type = "string"
  default = "Cluster1"
  description = "member of this cluster"
}

variable "vbookingdb-name" {
  type = "string"
  default = "vbookingdb"
  description = "virtual machine name for vbookingweb"
}

variable "vbookingdb_folder" {
  type = "string"
  default = "Urbancode/Workload"
  description = "folder containing this instance"
}

variable "vbookingdb_datacenter" {
  type = "string"
  default = "LondonDC"
  description = "data center containing this instance"
}

variable "vbookingdb_number_of_vcpu" {
  type = "string"
  default = "2"
  description = "number of virtual cpu's"
}

variable "vbookingdb_memory" {
  type = "string"
  default = "4096"
  description = "memory allocation"
}

variable "vbookingdb_cluster" {
  type = "string"
  default = "Cluster1"
  description = "member of this cluster"
}



variable "agent_name" {
  type = "string"
  default = "vbooking"
  description = "Generated"
}

variable "ucd_user" {
  type = "string"
  default = "admin"
  description = "Generated"
}

variable "ucd_password" {
  type = "string"
  default = "admin"
  description = "Generated"
}

variable "ucd_server_url" {
  type = "string"
  default = "https://10.164.104.137/"
  description = "Generated"
}


resource "vsphere_virtual_machine" "vbookingweb" {
  name = "${var.environment_name}_${var.vbookingweb-name}"
  folder = "${var.vbookingweb_folder}"
  datacenter = "${var.vbookingweb_datacenter}"
  vcpu = "${var.vbookingweb_number_of_vcpu}"
  memory = "${var.vbookingweb_memory}"
  cluster = "${var.vbookingweb_cluster}"
  dns_suffixes = "${var.dns_suffixes}"
  dns_servers = "${var.dns_servers}"
  # needed to add this
  skip_customization = "true"
  
  # needed to add in the disk reference as well to pick up the template
  disk {
   datastore = "RemoteDatastore170" 
   template  = "Templates/centos_with_dhcp"
  }
  
  connection {
    # changed this to type ssh
    type = "ssh"
    user = "root"
    password = "passw0rd"
  }
  provisioner "ucd" {
    agent_name      = "${var.agent_name}"
    ucd_server_url  = "${var.ucd_server_url}"
    ucd_user        = "${var.ucd_user}"
    ucd_password    = "${var.ucd_password}"
  }
  network_interface {
    label = "${var.Test1879-104-128-25_network_interface_label}"
  }
}


resource "vsphere_virtual_machine" "vbookingapp" {
  name = "${var.environment_name}_${var.vbookingapp-name}"
  folder = "${var.vbookingapp_folder}"
  datacenter = "${var.vbookingapp_datacenter}"
  vcpu = "${var.vbookingapp_number_of_vcpu}"
  memory = "${var.vbookingapp_memory}"
  cluster = "${var.vbookingapp_cluster}"
  dns_suffixes = "${var.dns_suffixes}"
  dns_servers = "${var.dns_servers}"
  skip_customization = "true"
  
  # needed to add in the disk reference as well to pick up the template
  disk {
   datastore = "RemoteDatastore170" 
   template  = "Templates/centos_with_dhcp"
  }
  
  connection {
    # changed this to type ssh
    type = "ssh"
    user = "root"
    password = "passw0rd"
  }
  provisioner "ucd" {
    agent_name      = "${var.agent_name}"
    ucd_server_url  = "${var.ucd_server_url}"
    ucd_user        = "${var.ucd_user}"
    ucd_password    = "${var.ucd_password}"
  }
  network_interface {
    label = "${var.Test1879-104-128-25_network_interface_label}"
  }
}

resource "vsphere_virtual_machine" "vbookingdb" {
  name = "${var.environment_name}_${var.vbookingdb-name}"
  folder = "${var.vbookingdb_folder}"
  datacenter = "${var.vbookingdb_datacenter}"
  vcpu = "${var.vbookingdb_number_of_vcpu}"
  memory = "${var.vbookingdb_memory}"
  cluster = "${var.vbookingdb_cluster}"
  dns_suffixes = "${var.dns_suffixes}"
  dns_servers = "${var.dns_servers}"
  skip_customization = "true"
  
  # needed to add in the disk reference as well to pick up the template
  disk {
   datastore = "RemoteDatastore170" 
   template  = "Templates/centos_with_dhcp"
  }
  
  connection {
    # changed this to type ssh
    type = "ssh"
    user = "root"
    password = "passw0rd"
  }
  provisioner "ucd" {
    agent_name      = "${var.agent_name}"
    ucd_server_url  = "${var.ucd_server_url}"
    ucd_user        = "${var.ucd_user}"
    ucd_password    = "${var.ucd_password}"
  }
  network_interface {
    label = "${var.Test1879-104-128-25_network_interface_label}"
  }
}

resource "ucd_component_mapping" "DB2" {
  component = "DB2"
  description = "DB2 Component"
  parent_id = "${ucd_agent_mapping.vbookingdb_agent.id}"
}

resource "ucd_component_mapping" "Vacation_DBData" {
  component = "Vacation_DBData"
  description = "Vacation_DBData Component"
  parent_id = "${ucd_agent_mapping.vbookingdb_agent.id}"
}

resource "ucd_component_mapping" "Vacation_DBSchema" {
  component = "Vacation_DBSchema"
  description = "Vacation_DBSchema Component"
  parent_id = "${ucd_agent_mapping.vbookingdb_agent.id}"
}

resource "ucd_component_mapping" "Tomcat" {
  component = "Tomcat"
  description = "Tomcat Component"
  parent_id = "${ucd_agent_mapping.vbookingweb_agent.id}"
}

resource "ucd_component_mapping" "java" {
  component = "java"
  description = "java Component"
  parent_id = "${ucd_agent_mapping.vbookingweb_agent.id}"
}

resource "ucd_component_mapping" "MQ" {
  component = "MQ"
  description = "MQ Component"
  parent_id = "${ucd_agent_mapping.vbookingweb_agent.id}"
}

resource "ucd_component_mapping" "RIT_MQExits" {
  component = "RIT_MQExits"
  description = "RIT_MQExits Component"
  parent_id = "${ucd_agent_mapping.vbookingweb_agent.id}"
}

resource "ucd_component_mapping" "InstallationManager" {
  component = "InstallationManager"
  description = "InstallationManager Component"
  parent_id = "${ucd_agent_mapping.vbookingapp_agent.id}"
}

resource "ucd_component_mapping" "DB2Client" {
  component = "DB2Client"
  description = "DB2Client Component"
  parent_id = "${ucd_agent_mapping.vbookingapp_agent.id}"
}

resource "ucd_component_mapping" "ActiveMQ" {
  component = "ActiveMQ"
  description = "ActiveMQ Component"
  parent_id = "${ucd_agent_mapping.vbookingapp_agent.id}"
}

resource "ucd_component_mapping" "ActiveMQjava" {
  component = "java"
  description = "java Component"
  parent_id = "${ucd_agent_mapping.vbookingapp_agent.id}"
}

resource "ucd_component_mapping" "Vacation_AdminApp" {
  component = "Vacation_AdminApp"
  description = "Vacation_AdminApp Component"
  parent_id = "${ucd_agent_mapping.vbookingweb_agent.id}"
}

resource "ucd_component_mapping" "Vacation_BookingApp" {
  component = "Vacation_BookingApp"
  description = "Vacation_BookingApp Component"
  parent_id = "${ucd_agent_mapping.vbookingweb_agent.id}"
}

resource "ucd_component_mapping" "Vacation_BookingAppWAS" {
  component = "Vacation_BookingAppWAS"
  description = "Vacation_BookingAppWAS Component"
  parent_id = "${ucd_agent_mapping.vbookingapp_agent.id}"
}

resource "ucd_component_mapping" "Vacation_FlightsREST" {
  component = "Vacation_FlightsREST"
  description = "Vacation_FlightsREST Component"
  parent_id = "${ucd_agent_mapping.vbookingapp_agent.id}"
}

resource "ucd_component_mapping" "Vacation_FrequentFlyerApp" {
  component = "Vacation_FrequentFlyerApp"
  description = "Vacation_FrequentFlyerApp Component"
  parent_id = "${ucd_agent_mapping.vbookingapp_agent.id}"
}

resource "ucd_component_mapping" "Vacation_IntegrationTestConfig" {
  component = "Vacation_IntegrationTestConfig"
  description = "Vacation_IntegrationTestConfig Component"
  parent_id = "${ucd_agent_mapping.vbookingweb_agent.id}"
}

resource "ucd_component_mapping" "Vacation_MQ_Config" {
  component = "Vacation_MQ_Config"
  description = "Vacation_MQ_Config Component"
  parent_id = "${ucd_agent_mapping.vbookingweb_agent.id}"
}

resource "ucd_component_mapping" "Vacation_MyBookingApp" {
  component = "Vacation_MyBookingApp"
  description = "Vacation_MyBookingApp Component"
  parent_id = "${ucd_agent_mapping.vbookingapp_agent.id}"
}

resource "ucd_component_mapping" "Vacation_PaymentApp" {
  component = "Vacation_PaymentApp"
  description = "Vacation_PaymentApp Component"
  parent_id = "${ucd_agent_mapping.vbookingapp_agent.id}"
}

resource "ucd_component_mapping" "Vacation_ReservationsApp" {
  component = "Vacation_ReservationsApp"
  description = "Vacation_ReservationsApp Component"
  parent_id = "${ucd_agent_mapping.vbookingapp_agent.id}"
}

resource "ucd_component_mapping" "Vacation_Standalone_ActiveMQHotelPaymentServer" {
  component = "Vacation_Standalone_ActiveMQHotelPaymentServer"
  description = "Vacation_Standalone_ActiveMQHotelPaymentServer Component"
  parent_id = "${ucd_agent_mapping.vbookingapp_agent.id}"
}

resource "ucd_component_mapping" "Vacation_Standalone_AvailableSeatsServer" {
  component = "Vacation_Standalone_AvailableSeatsServer"
  description = "Vacation_Standalone_AvailableSeatsServer Component"
  parent_id = "${ucd_agent_mapping.vbookingapp_agent.id}"
}

resource "ucd_component_mapping" "Vacation_Standalone_CurrencyServer" {
  component = "Vacation_Standalone_CurrencyServer"
  description = "Vacation_Standalone_CurrencyServer Component"
  parent_id = "${ucd_agent_mapping.vbookingapp_agent.id}"
}

resource "ucd_component_mapping" "Vacation_Standalone_FlightConfirmationServer" {
  component = "Vacation_Standalone_FlightConfirmationServer"
  description = "Vacation_Standalone_FlightConfirmationServer Component"
  parent_id = "${ucd_agent_mapping.vbookingapp_agent.id}"
}

resource "ucd_component_mapping" "WAS" {
  component = "WAS"
  description = "WAS Component"
  parent_id = "${ucd_agent_mapping.vbookingapp_agent.id}"
}



resource "ucd_resource_tree" "resource_tree" {
  base_resource_group_name = "Base Resource for environment ${var.environment_name}"
}

resource "ucd_environment" "environment" {
  name = "${var.environment_name}"
  application = "VacationBooking"
  base_resource_group ="${ucd_resource_tree.resource_tree.id}"
  component_property {
      component = "DB2"
      name = "db2InstallLocation"
      value = "/opt/ibm/db2/V10.1"
      secure = false
  }
  # got here ok - I wonder how far before it fails
}

resource "ucd_agent_mapping" "vbookingdb_agent" {
  description = "Agent to manage the vbookingdb server"
  # had to change private_ip to lookup value
  agent_name = "${var.agent_name}.${vsphere_virtual_machine.vbookingdb.network_interface.0.ipv4_address}"
  parent_id = "${ucd_resource_tree.resource_tree.id}"
}

resource "ucd_agent_mapping" "vbookingweb_agent" {
  description = "Agent to manage the vbookingweb server"
  agent_name = "${var.agent_name}.${vsphere_virtual_machine.vbookingweb.network_interface.0.ipv4_address}"
  parent_id = "${ucd_resource_tree.resource_tree.id}"
}

resource "ucd_agent_mapping" "vbookingapp_agent" {
  description = "Agent to manage the vbookingapp server"
  agent_name = "${var.agent_name}.${vsphere_virtual_machine.vbookingapp.network_interface.0.ipv4_address}"
  parent_id = "${ucd_resource_tree.resource_tree.id}"
}


resource "ucd_application_process_request" "application_process_request" {
  depends_on = ["ucd_component_mapping.DB2","ucd_component_mapping.Vacation_DBData","ucd_component_mapping.Vacation_DBSchema","ucd_component_mapping.Tomcat","ucd_component_mapping.MQ","ucd_component_mapping.RIT_MQExits","ucd_component_mapping.InstallationManager","ucd_component_mapping.DB2Client","ucd_component_mapping.ActiveMQ","ucd_component_mapping.Vacation_AdminApp","ucd_component_mapping.Vacation_BookingApp","ucd_component_mapping.Vacation_BookingAppWAS","ucd_component_mapping.Vacation_FlightsREST","ucd_component_mapping.Vacation_FrequentFlyerApp","ucd_component_mapping.Vacation_IntegrationTestConfig","ucd_component_mapping.Vacation_MQ_Config","ucd_component_mapping.Vacation_MyBookingApp","ucd_component_mapping.Vacation_PaymentApp","ucd_component_mapping.Vacation_ReservationsApp","ucd_component_mapping.Vacation_Standalone_ActiveMQHotelPaymentServer","ucd_component_mapping.Vacation_Standalone_AvailableSeatsServer","ucd_component_mapping.Vacation_Standalone_CurrencyServer","ucd_component_mapping.Vacation_Standalone_FlightConfirmationServer","ucd_component_mapping.WAS"]
  application = "VacationBooking"
  application_process = "DeployVacationBooking"
  snapshot = "baseline"
  environment = "${ucd_environment.environment.name}"
}

output "ip" {
  value = "${vsphere_virtual_machine.vbookingweb.network_interface.0.ipv4_address}"
}
